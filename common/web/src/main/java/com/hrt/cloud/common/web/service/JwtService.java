package com.hrt.cloud.common.web.service;

import com.hrt.cloud.common.web.domain.entity.JwtUser;

/***
 * @author David Hong
 * @version 1.0
 * @description jwt工具类
 */
public interface JwtService {

    /**
     * 生成JWT
     * 存储<uuidStr, jwtUser>到Redis中
     *
     * @param jwtUser
     * @return java.lang.String
     * @author David Hong
     */
    String generateToken(JwtUser jwtUser);

    /**
     * 校验token，根据token返回user
     *
     * @param token
     * @return com.hrt.cloud.common.domain.entity.User
     * @author David Hong
     */
    JwtUser checkToken(String token) throws Exception;

    /**
     * 从token中获取jwt
     *
     * @param token
     * @return java.lang.String
     * @author David Hong
     */
    String getJwt(String token);

}
