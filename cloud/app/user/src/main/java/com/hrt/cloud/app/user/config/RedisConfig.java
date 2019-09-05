package com.hrt.cloud.app.user.config;

import com.hrt.cloud.common.web.service.RedisService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author David Hong
 * @version 1.0
 * @description Redis配置 让RedisService注入到项目中
 */
@Configuration
@ComponentScan(basePackageClasses = RedisService.class)
public class RedisConfig {

}
