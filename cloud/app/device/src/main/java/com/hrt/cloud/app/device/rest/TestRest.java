package com.hrt.cloud.app.device.rest;

import com.hrt.cloud.common.core.entity.BaseResponse;
import com.hrt.cloud.common.web.domain.form.UserBaseForm;
import com.hrt.cloud.common.web.provider.user.UserFeignProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author David Hong
 * @version 1.0
 * @description 测试控制器
 */
@Slf4j
@RestController
public class TestRest {

    @Autowired
    private UserFeignProvider userFeignProvider;

    @GetMapping("/test/{contact}")
    public BaseResponse test(@PathVariable String contact) {
        log.info("hello world!");
        UserBaseForm userBaseForm = new UserBaseForm();
        userBaseForm.setContact(contact);
        return userFeignProvider.findByContact(userBaseForm);
    }

}
