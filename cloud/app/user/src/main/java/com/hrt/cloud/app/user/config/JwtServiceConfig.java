package com.hrt.cloud.app.user.config;

import com.hrt.cloud.common.web.service.JwtService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author David Hong
 * @version 1.0
 * @description JwtService注入配置类
 */
@Configuration
@ComponentScan(basePackageClasses = JwtService.class)
public class JwtServiceConfig {

}
