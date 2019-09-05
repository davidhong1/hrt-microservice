package com.hrt.cloud.common.web.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author David Hong
 * @version 1.0
 * @description jwt携带的用户信息
 */
@Data
public class JwtUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户基本信息存储key
     */
    private String uuid;

    private String contact;

    private Long userId;

    private String username;

    /**
     * 用户最高级别角色
     */
    private String topRole;

    /**
     * 用户拥有的所有角色列表
     */
    private List<String> roles;

    /**
     * 和用户关联的所有产品
     */
    private List<Long> productIds;

    public JwtUser(String uuidStr, String contact, Long userId, String username) {
        this.uuid = uuidStr;
        this.contact = contact;
        this.userId = userId;
        this.username = username;
    }

    public JwtUser() {}

}
