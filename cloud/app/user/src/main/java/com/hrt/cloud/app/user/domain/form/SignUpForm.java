package com.hrt.cloud.app.user.domain.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author David Hong
 * @version 1.0
 * @description 注册相关参数form
 */
@ApiModel
@Data
public class SignUpForm {

    @NotBlank(message = "手机号不能为空")
    @ApiModelProperty(value = "注册手机号")
    private String contact;

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "注册用户名")
    private String username;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "登录密码")
    private String pw;

}
