package com.hrt.cloud.app.device;

import com.hrt.cloud.common.web.provider.user.UserFeignProvider;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan(basePackages = "com.hrt.cloud.app.device.mapper")
@EnableFeignClients(basePackageClasses = {UserFeignProvider.class})
@SpringCloudApplication
public class DeviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeviceApplication.class, args);
    }

}
