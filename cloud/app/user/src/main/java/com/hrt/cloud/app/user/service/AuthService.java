package com.hrt.cloud.app.user.service;

import com.hrt.cloud.app.user.domain.entity.User;

import java.util.Map;

/**
 * @author David Hong
 * @version 1.0
 * @description 登录授权服务类
 */
public interface AuthService {

    /**
     * 登录
     *
     * @param contact
     * @param password
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @author David Hong
     */
    Map<String, Object> login(String contact, String password);

    /**
     * 注册
     *
     * @param contact
     * @param username
     * @param pw
     * @return User
     * @author David Hong
     */
    User signUp(String contact, String username, String pw);

    /**
     * 修改密码
     *
     * @param contact
     * @param newPw
     * @param oldPw
     * @param authCode
     * @return User
     * @author David Hong
     */
    User changePw(String contact, String newPw, String oldPw, String authCode);

    /**
     * 找回密码
     *
     * @param contact
     * @param newPw
     * @param authCode
     * @return User
     * @author David Hong
     */
    User findPw(String contact, String newPw, String authCode);

}
