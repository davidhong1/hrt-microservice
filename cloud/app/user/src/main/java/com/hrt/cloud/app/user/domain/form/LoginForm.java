package com.hrt.cloud.app.user.domain.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author David Hong
 * @version 1.0
 * @description 登录相关参数form
 */
@ApiModel
@Data
public class LoginForm {

    @NotBlank(message = "手机号不能为空")
    @ApiModelProperty(value = "登录手机号")
    private String contact;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "登录密码")
    private String pw;

}
