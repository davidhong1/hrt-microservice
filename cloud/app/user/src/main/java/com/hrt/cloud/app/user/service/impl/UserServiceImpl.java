package com.hrt.cloud.app.user.service.impl;

import com.hrt.cloud.app.user.domain.entity.User;
import com.hrt.cloud.app.user.mapper.UserMapper;
import com.hrt.cloud.app.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author David Hong
 * @since 2019-09-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * 通过手机获取用户信息
     *
     * @param contact
     * @return com.hrt.cloud.app.user.domain.entity.User
     * @author David Hong
     */
    @Override
    public User selectByContact(String contact) {
        return lambdaQuery()
                .eq(User::getContact, contact)
                .one();
    }

}
