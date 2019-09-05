package com.hrt.cloud.app.user.service;

import com.hrt.cloud.app.user.domain.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author David Hong
 * @since 2019-09-05
 */
public interface UserService extends IService<User> {

    /**
     * 通过手机获取用户信息
     *
     * @param contact
     * @return com.hrt.cloud.app.user.domain.entity.User
     * @author David Hong
     */
    User selectByContact(String contact);

}
