package com.hrt.cloud.app.user.rest;

import com.hrt.cloud.app.user.domain.entity.User;
import com.hrt.cloud.app.user.service.AuthService;
import com.hrt.cloud.app.user.domain.form.LoginForm;
import com.hrt.cloud.app.user.domain.form.SignUpForm;
import com.hrt.cloud.common.core.entity.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author David Hong
 * @version 1.0
 * @description controller
 */
@RestController
@RequestMapping("/auth")
public class AuthRest {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public BaseResponse login(@RequestBody LoginForm loginForm) {
        Map<String, Object> ret = authService.login(loginForm.getContact(), loginForm.getPw());
        return BaseResponse.ok(ret);
    }

    @PostMapping("/signUp")
    public BaseResponse signUp(@RequestBody SignUpForm signUpForm) {
        User user = authService.signUp(signUpForm.getContact(), signUpForm.getUsername(), signUpForm.getPw());
        return BaseResponse.ok(user);
    }

}
