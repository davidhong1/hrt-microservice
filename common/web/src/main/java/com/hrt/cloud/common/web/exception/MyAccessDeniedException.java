package com.hrt.cloud.common.web.exception;

import com.hrt.cloud.common.core.entity.BRStatus;

/**
 * @author David Hong
 * @version 1.0
 * @description 自定义异常类
 */
public class MyAccessDeniedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final BRStatus brStatus;

    public MyAccessDeniedException() {
        this.brStatus = BRStatus.PERMISSION_NO_EXIST;
    }

    @Override
    public String getMessage() {
        return brStatus.getMsg();
    }

    public BRStatus getBrStatus() {
        return this.brStatus;
    }

}
