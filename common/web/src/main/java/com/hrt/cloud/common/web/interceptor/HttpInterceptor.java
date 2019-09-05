package com.hrt.cloud.common.web.interceptor;

import com.hrt.cloud.common.web.constants.CommonConstants;
import com.hrt.cloud.common.web.domain.entity.JwtUser;
import com.hrt.cloud.common.web.service.JwtService;
import com.hrt.cloud.common.web.service.RedisService;
import com.hrt.cloud.common.web.util.AuthInfoHolder;
import com.hrt.cloud.common.web.exception.MyAccessDeniedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author David Hong
 * @version 1.0
 * @description http拦截器 检测jwt, 设置Redis userSecurity, 准备ThreadLocal 清除最后的ThreadLocal
 */
@Slf4j
@Component
public class HttpInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisService redisService;

    @Autowired
    private JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 检查jwt
        // 从Redis中获取UserSecurity
        // 准备ThreadLocal
        log.info("preHandle, uri={}", request.getRequestURI());

        String token = request.getHeader(CommonConstants.AUTHORIZATION);
        if (!ObjectUtils.isEmpty(token)) {
            JwtUser jwtUser = jwtService.checkToken(token);
            jwtUser = (JwtUser) redisService.get(jwtUser.getUuid());
            if (ObjectUtils.isEmpty(jwtUser)) {
                log.error("preHandle, jwtUser为空, token={}", token);
                throw new MyAccessDeniedException();
            }
            //设置ThreadLocal
            Map<String, Object> authInfo = new HashMap<>(10);
            authInfo.put(CommonConstants.AUTHORIZATION, token);
            authInfo.put(CommonConstants.JWT_USER, jwtUser);
            AuthInfoHolder.setAuthInfo(authInfo);
        }

        String insideToken = request.getHeader(CommonConstants.INSIDE_TOKEN);
        if (CommonConstants.INSIDE_TOKEN_KEY.equals(insideToken)) {
            log.info("内部调用");
            return true;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清除ThreadLocal内容
        log.info("afterCompletion, uri={}", request.getRequestURI());
        Map<String, Object> map = AuthInfoHolder.getAuthInfo();
        if (ObjectUtils.isEmpty(map)) {
            return;
        }
        // 清除ThreadLocal内容
        AuthInfoHolder.removeAuthInfo();
    }

}
