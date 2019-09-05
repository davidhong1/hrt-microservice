package com.hrt.cloud.common.web.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: Spring Security 配置类
 * @Author: gradual
 * @Date: 2019-04-08 11:55
 */
@Data
@Configuration
@ConfigurationProperties("custom.uri")
public class CustomUriPermitProperties {

    private String[] permit;

}
