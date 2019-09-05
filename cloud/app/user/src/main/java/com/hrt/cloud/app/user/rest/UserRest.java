package com.hrt.cloud.app.user.rest;

import com.hrt.cloud.app.user.domain.entity.User;
import com.hrt.cloud.app.user.service.UserService;
import com.hrt.cloud.common.core.entity.BaseResponse;
import com.hrt.cloud.common.web.domain.form.UserBaseForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author David Hong
 * @version 1.0
 * @description 用户controller
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserRest {

    @Autowired
    private UserService userService;

    @PostMapping("/findByContact")
    public BaseResponse findByContact(@RequestBody UserBaseForm userBaseForm) {
        log.info(userBaseForm.toString());
        User user = userService.selectByContact(userBaseForm.getContact());
        user.setPw("");
        return BaseResponse.ok(user);
    }

}
