package com.hrt.cloud.common.web.provider.user;

import com.hrt.cloud.common.core.entity.BRStatus;
import com.hrt.cloud.common.core.entity.BaseResponse;
import com.hrt.cloud.common.web.domain.form.UserBaseForm;
import com.hrt.cloud.common.web.provider.FeignInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author David Hong
 * @version 1.0
 * @description user feign provider
 */
@FeignClient(name = "user", configuration = FeignInterceptor.class, fallbackFactory = UserFeignProvider.UserFeignProviderFallback.class)
public interface UserFeignProvider {

    @PostMapping("/user/findByContact")
    BaseResponse findByContact(@RequestBody UserBaseForm userBaseForm);

    @Slf4j
    @Component
    class UserFeignProviderFallback implements UserFeignProvider {
        @Override
        public BaseResponse findByContact(UserBaseForm userBaseForm) {
            log.info("findByUsername.userFeignProvider");
            return BaseResponse.error(BRStatus.PARAS_ERROR);
        }
    }

}
