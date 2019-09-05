package com.hrt.cloud.app.user.service.impl;

import com.hrt.cloud.app.user.service.*;

import com.hrt.cloud.app.user.domain.entity.User;
import com.hrt.cloud.common.web.domain.entity.JwtUser;
import com.hrt.cloud.common.web.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

/**
 * @author David Hong
 * @version 1.0
 * @description AuthService服务实现类
 */
@Service
public class AuthServiceImpl implements AuthService {

    /**
     * 加密密码和解密密码类
     */
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserProductService userProductService;

    @Override
    public Map<String, Object> login(String contact, String password) {
        Map<String, Object> ret = new HashMap<>(10);
        User user = userService.selectByContact(contact);
        if (ObjectUtils.isEmpty(user)) {
            return null;
        }
        boolean match = passwordEncoder.matches(password, user.getPw());
        if (!match) {
            //密码不正确，验证不通过
            return null;
        }
        // 准备JwtUser
        JwtUser jwtUser = new JwtUser();
        jwtUser.setUuid(UUID.randomUUID().toString());
        jwtUser.setContact(user.getContact());
        jwtUser.setUserId(user.getId());
        jwtUser.setUsername(user.getUsername());
        jwtUser.setTopRole(userRoleService.getTopRoleByUserId(user.getId()));
        jwtUser.setRoles(userRoleService.getRoleNamesByUserId(user.getId()));
        // 准备productIds
        List<Long> productIds = userProductService.getProductIdsByUserId(user.getId());
        jwtUser.setProductIds(productIds);

        ret.put("token", jwtService.generateToken(jwtUser));
        ret.put("role", jwtUser.getTopRole());
        user.setPw("");
        ret.put("user", user);
        return ret;
    }

    @Override
    public User signUp(String contact, String username, String pw) {
        pw = passwordEncoder.encode(pw);
        User user = new User();
        user.setContact(contact);
        user.setUsername(username);
        user.setPw(pw);
        user.insert();
        user.setPw("");
        return user;
    }

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
    @Override
    public User changePw(String contact, String newPw, String oldPw, String authCode) {
        return null;
    }

    /**
     * 找回密码
     *
     * @param contact
     * @param newPw
     * @param authCode
     * @return User
     * @author David Hong
     */
    @Override
    public User findPw(String contact, String newPw, String authCode) {
        return null;
    }

}
