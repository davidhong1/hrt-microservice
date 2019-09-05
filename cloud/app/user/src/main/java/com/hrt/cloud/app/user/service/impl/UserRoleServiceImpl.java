package com.hrt.cloud.app.user.service.impl;

import com.hrt.cloud.app.user.domain.entity.UserRole;
import com.hrt.cloud.app.user.mapper.UserRoleMapper;
import com.hrt.cloud.app.user.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hrt.cloud.common.web.domain.entity.RoleEnum;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户-角色表 服务实现类
 * </p>
 *
 * @author David Hong
 * @since 2019-09-05
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    /**
     * 通过用户ID获取所有角色名
     *
     * @param userId
     * @return java.util.List<java.lang.String>
     * @author David Hong
     */
    @Override
    public List<String> getRoleNamesByUserId(Long userId) {
        return lambdaQuery()
                .eq(UserRole::getUserId, userId).list()
                .stream().map(UserRole::getRoleName)
                .collect(Collectors.toList());
    }

    /**
     * 获取
     *
     * @param userId
     * @return java.lang.String
     * @author David Hong
     */
    @Override
    public String getTopRoleByUserId(Long userId) {
        List<String> roles = getRoleNamesByUserId(userId);
        if (CollectionUtils.isEmpty(roles)) {
            return null;
        }
        if (roles.contains(RoleEnum.ROLE_ADMIN.name())) {
            return RoleEnum.ROLE_ADMIN.name();
        }
        if (roles.contains(RoleEnum.ROLE_BRAND.name())) {
            return RoleEnum.ROLE_BRAND.name();
        }
        if (roles.contains(RoleEnum.ROLE_PROXY.name())) {
            return RoleEnum.ROLE_PROXY.name();
        }
        if (roles.contains(RoleEnum.ROLE_MAINTAIN.name())) {
            return RoleEnum.ROLE_MAINTAIN.name();
        }
        if (roles.contains(RoleEnum.ROLE_REPAIR.name())) {
            return RoleEnum.ROLE_REPAIR.name();
        }
        return RoleEnum.ROLE_USER.name();
    }
}
