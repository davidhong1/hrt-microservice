package com.hrt.cloud.app.user.config;

import lombok.extern.slf4j.Slf4j;

/**
 * @author David Hong
 * @version 1.0
 * @description spring security配置
 */
@Slf4j
// @Configuration
// @ComponentScan(basePackageClasses = CustomUriPermitProperties.class)
// public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
public class WebSecurityConfig {


//    @Autowired
//    private CustomUriPermitProperties customUriPermitProperties;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // Disable CSRF (cross site request forgery)
//        http.csrf().disable();
//
//        http.cors();
//
//        // No session will be created or used by spring security
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        // Entry points
//        http.authorizeRequests()
//                //配合@CrossOrigin 解决跨域问题
//                .antMatchers(HttpMethod.OPTIONS).permitAll()
//                .antMatchers(customUriPermitProperties.getPermit()).permitAll()
//                .anyRequest().authenticated();
//    }

}
