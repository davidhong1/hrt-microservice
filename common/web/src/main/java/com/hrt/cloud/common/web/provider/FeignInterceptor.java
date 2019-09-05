package com.hrt.cloud.common.web.provider;

import com.hrt.cloud.common.web.constants.CommonConstants;
import com.hrt.cloud.common.web.util.AuthInfoHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

/**
 * @author David Hong
 * @version 1.0
 * @description feign拦截器
 */
@Slf4j
public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("FeignInterceptor.apply");
        //feign从AuthHolder获取token信息
        if (!ObjectUtils.isEmpty(AuthInfoHolder.getAuthInfo())) {
            String token = (String) AuthInfoHolder.getAuthInfo().get(CommonConstants.AUTHORIZATION);
            if (!ObjectUtils.isEmpty(token)) {
                // 设置Authorization
                requestTemplate.header(CommonConstants.AUTHORIZATION, token);
            }
        }
        //设置内部调用token
        requestTemplate.header(CommonConstants.INSIDE_TOKEN, CommonConstants.INSIDE_TOKEN_KEY);
    }

}
