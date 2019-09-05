package com.hrt.cloud.app.device.config;

import com.hrt.cloud.common.web.interceptor.HttpInterceptor;
import com.hrt.cloud.common.web.properties.CustomUriPermitProperties;
import com.hrt.cloud.common.web.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author David Hong
 * @version 1.0
 * @description mvc配置
 */
@Slf4j
@Configuration
@ComponentScan(basePackageClasses = {
        HttpInterceptor.class,
        CustomUriPermitProperties.class,
        JwtService.class
})
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private HttpInterceptor httpInterceptor;

    @Autowired
    private CustomUriPermitProperties customUriPermitProperties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //FIXME 添加拦截器权限接口和取消拦截器接口，注意异常跳转的时候，是否有多次进入interceptor的情况
        //过滤登录接口
        List<String> excludePaths = new ArrayList<>(1);
        if (!ArrayUtils.isEmpty(customUriPermitProperties.getPermit())) {
            excludePaths= Arrays.asList(customUriPermitProperties.getPermit());
        }
        registry.addInterceptor(httpInterceptor).addPathPatterns("/**").excludePathPatterns(excludePaths);
    }

}
