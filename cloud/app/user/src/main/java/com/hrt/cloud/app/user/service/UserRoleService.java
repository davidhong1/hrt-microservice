package com.hrt.cloud.app.user.service;

import com.hrt.cloud.app.user.domain.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户-角色表 服务类
 * </p>
 *
 * @author David Hong
 * @since 2019-09-05
 */
public interface UserRoleService extends IService<UserRole> {

    /**
     * 通过用户ID获取所有角色名
     *
     * @param userId
     * @return java.util.List<java.lang.String>
     * @author David Hong
     */
    List<String> getRoleNamesByUserId(Long userId);

    /**
     * 获取
     *
     * @param userId
     * @return java.lang.String
     * @author David Hong
     */
    String getTopRoleByUserId(Long userId);

}
