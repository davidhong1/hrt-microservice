package com.hrt.cloud.common.web.service.impl;

import com.hrt.cloud.common.web.constants.CommonConstants;
import com.hrt.cloud.common.web.domain.entity.JwtUser;
import com.hrt.cloud.common.web.exception.MyAccessDeniedException;
import com.hrt.cloud.common.web.service.JwtService;
import com.hrt.cloud.common.web.service.RedisService;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;

/***
 * @author David Hong
 * @version 1.0
 * @description jwt工具类
 */
@Slf4j
@Service
public class JwtServiceImpl implements JwtService {

    @Autowired
    private RedisService redisService;

    /**
     * 生成JWT
     * 存储<uuidStr, jwtUser>到Redis中
     *
     * @param jwtUser
     * @return java.lang.String
     * @author David Hong
     */
    @Override
    public String generateToken(JwtUser jwtUser) {
        String uuidStr = CommonConstants.JWT_USER + jwtUser.getUuid();
        jwtUser.setUuid(uuidStr);
        redisService.set(uuidStr, jwtUser, CommonConstants.JWT_EXPIRE_TIME / 1000);
        String token = Jwts.builder().setSubject(uuidStr)
                .claim(CommonConstants.CONTEXT_CONTACT, jwtUser.getContact())
                .claim(CommonConstants.CONTEXT_USER_ID, jwtUser.getUserId())
                .claim(CommonConstants.CONTEXT_NAME, jwtUser.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + CommonConstants.JWT_EXPIRE_TIME))
                .signWith(SignatureAlgorithm.HS256, CommonConstants.JWT_PRIVATE_KEY)
                .compact();
        return token;
    }

    /**
     * 校验token，根据token返回user
     *
     * @param token
     * @return com.hrt.could.common.domain.entity.User
     * @author David Hong
     */
    @Override
    public JwtUser checkToken(String token) throws Exception {
        String jwt = getJwt(token);
        if (jwt == null) {
            throw new MyAccessDeniedException();
        }
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(CommonConstants.JWT_PRIVATE_KEY).parseClaimsJws(jwt).getBody();
        } catch (SignatureException e) {
            // 在解析jwt字符串时，如果密钥不正确，将会解析失败，抛出SignatureException异常，说明该jwt是伪造的
            log.info("TAG=logException, e={}, msg={}", e.getClass().getName(), "jwt解析失败，签名异常");
            throw new MyAccessDeniedException();
        } catch (ExpiredJwtException e) {
            // 在解析JWT字符串时，如果‘过期时间字段’已经早于当前时间，将会抛出ExpiredJwtException异常，说明本次请求已经失效
            log.info("TAG=logException, e={}, msg={}", e.getClass().getName(), "请求失效");
            throw new MyAccessDeniedException();
        } catch (Exception e) {
            log.info("TAG=logException, e={}, msg={}", e.getClass().getName(), "checkFeignToken异常");
            throw new MyAccessDeniedException();
        }
        if (ObjectUtils.isEmpty(claims)) {
            throw new MyAccessDeniedException();
        }
        JwtUser jwtUser = new JwtUser();
        jwtUser.setUuid(claims.getSubject());
        jwtUser.setContact(claims.get(CommonConstants.CONTEXT_CONTACT).toString());
        jwtUser.setUserId(Long.parseLong(claims.get(CommonConstants.CONTEXT_USER_ID).toString()));
        jwtUser.setUsername(claims.get(CommonConstants.CONTEXT_NAME).toString());
        return jwtUser;
    }

    /**
     * 从token中获取jwt
     *
     * @param token
     * @return java.lang.String
     * @author David Hong
     */
    @Override
    public String getJwt(String token) {
        if (!token.startsWith(CommonConstants.TOKEN_BEARER)) {
            return null;
        }
        return token.substring(CommonConstants.TOKEN_BEARER.length());
    }

}
