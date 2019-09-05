package com.hrt.cloud.app.user.service.impl;

import com.hrt.cloud.app.user.domain.entity.UserProduct;
import com.hrt.cloud.app.user.mapper.UserProductMapper;
import com.hrt.cloud.app.user.service.UserProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户-产品对应表 服务实现类
 * </p>
 *
 * @author David Hong
 * @since 2019-09-05
 */
@Service
public class UserProductServiceImpl extends ServiceImpl<UserProductMapper, UserProduct> implements UserProductService {

    /**
     * 通过userId获取所有产品Id
     *
     * @param userId
     * @return java.util.List<java.lang.Long>
     * @author David Hong
     */
    @Override
    public List<Long> getProductIdsByUserId(Long userId) {
        return lambdaQuery()
                .eq(UserProduct::getUserId, userId).list()
                .stream().map(UserProduct::getProductId)
                .collect(Collectors.toList());
    }

}
