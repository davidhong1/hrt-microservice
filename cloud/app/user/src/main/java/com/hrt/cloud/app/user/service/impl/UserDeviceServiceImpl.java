package com.hrt.cloud.app.user.service.impl;

import com.hrt.cloud.app.user.domain.entity.UserDevice;
import com.hrt.cloud.app.user.mapper.UserDeviceMapper;
import com.hrt.cloud.app.user.service.UserDeviceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-设备表 服务实现类
 * </p>
 *
 * @author David Hong
 * @since 2019-09-05
 */
@Service
public class UserDeviceServiceImpl extends ServiceImpl<UserDeviceMapper, UserDevice> implements UserDeviceService {

}
