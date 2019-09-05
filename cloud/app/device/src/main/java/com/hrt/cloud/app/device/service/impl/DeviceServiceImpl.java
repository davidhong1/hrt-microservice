package com.hrt.cloud.app.device.service.impl;

import com.hrt.cloud.app.device.domain.entity.Device;
import com.hrt.cloud.app.device.mapper.DeviceMapper;
import com.hrt.cloud.app.device.service.DeviceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 设备表 服务实现类
 * </p>
 *
 * @author David Hong
 * @since 2019-09-05
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {

}
