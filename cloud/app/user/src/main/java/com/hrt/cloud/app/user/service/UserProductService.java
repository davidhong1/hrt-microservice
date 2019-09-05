package com.hrt.cloud.app.user.service;

import com.hrt.cloud.app.user.domain.entity.UserProduct;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户-产品对应表 服务类
 * </p>
 *
 * @author David Hong
 * @since 2019-09-05
 */
public interface UserProductService extends IService<UserProduct> {

    /**
     * 通过userId获取所有产品Id
     *
     * @param userId
     * @return java.util.List<java.lang.Long>
     * @author David Hong
     */
    List<Long> getProductIdsByUserId(Long userId);

}
