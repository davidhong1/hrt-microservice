package com.hrt.cloud.app.device.service.impl;

import com.hrt.cloud.app.device.domain.entity.Good;
import com.hrt.cloud.app.device.mapper.GoodMapper;
import com.hrt.cloud.app.device.service.GoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author David Hong
 * @since 2019-09-05
 */
@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good> implements GoodService {

}
