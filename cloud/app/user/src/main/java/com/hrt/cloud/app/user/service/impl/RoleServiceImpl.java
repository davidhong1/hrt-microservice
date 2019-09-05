package com.hrt.cloud.app.user.service.impl;

import com.hrt.cloud.app.user.domain.entity.Role;
import com.hrt.cloud.app.user.mapper.RoleMapper;
import com.hrt.cloud.app.user.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author David Hong
 * @since 2019-09-05
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
