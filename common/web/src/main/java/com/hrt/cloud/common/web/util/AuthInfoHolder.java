package com.hrt.cloud.common.web.util;

import java.util.Map;

/**
 * @author David Hong
 * @version 1.0
 * @description 存储认证信息ThreadLocal holder
 */
public class AuthInfoHolder {

    /**
     * 存储上下文
     * 使用InheritableThreadLocal类让主线程类传递内容给子线程类 Feign调用都是新建了一个线程
     */
    private final static ThreadLocal<Map<String, Object>> authInfo = new InheritableThreadLocal<>();

    /**
     * 设置上下文
     *
     * @param input
     * @return void
     * @author David Hong
     */
    public static void setAuthInfo(Map<String, Object> input) {
        authInfo.set(input);
    }

    /**
     * 获取上下文
     *
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @author David Hong
     */
    public static Map<String, Object> getAuthInfo() {
        return authInfo.get();
    }

    /**
     * 清空上下文
     *
     * @return void
     * @author David Hong
     */
    public static void removeAuthInfo() {
        authInfo.remove();
    }

}
