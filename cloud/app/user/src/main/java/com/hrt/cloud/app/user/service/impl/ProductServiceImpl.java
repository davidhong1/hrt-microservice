package com.hrt.cloud.app.user.service.impl;

import com.hrt.cloud.app.user.domain.entity.Product;
import com.hrt.cloud.app.user.mapper.ProductMapper;
import com.hrt.cloud.app.user.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品表 服务实现类
 * </p>
 *
 * @author David Hong
 * @since 2019-09-05
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
