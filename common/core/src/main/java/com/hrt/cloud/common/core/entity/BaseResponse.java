package com.hrt.cloud.common.core.entity;

import com.hrt.cloud.common.core.util.LocalDateFormatUtil;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 返回类
 *
 * @author Administrator
 */
@Data
public class BaseResponse {

    /**
     * 状态
     */
    private Integer status;
    /**
     * 消息
     */
    private String msg;
    /**
     * 内容
     */
    private Object content;
    /**
     * 时间
     */
    private String timestamp;

    private BaseResponse(BRStatus brStatus, Object content) {
        this.status = brStatus.getStatus();
        this.msg = brStatus.getMsg();
        this.content = content;
        this.timestamp = LocalDateFormatUtil.viewFormat2(LocalDateTime.now());
    }

    private BaseResponse(BRStatus brStatus) {
        this.status =  brStatus.getStatus();
        this.msg = brStatus.getMsg();
        this.timestamp = LocalDateFormatUtil.viewFormat2(LocalDateTime.now());
    }

    public static BaseResponse error() {
        return new BaseResponse(BRStatus.SERVER_ERROR);
    }

    public static BaseResponse error(BRStatus brStatus) {
        return new BaseResponse(brStatus);
    }

    public static BaseResponse ok() {
        return new BaseResponse(BRStatus.SUCCESS);
    }

    public static BaseResponse ok(Object content) {
        return new BaseResponse(BRStatus.SUCCESS, content);
    }

    public BaseResponse() {}

    /**
     * 为了便于管理
     * 尽量使用BRStatus替代自定义的status、msg
     * 现在小程序和公众号用到一部分
     *
     * @param status
     * @param msg
     * @return
     * @author David Hong
     */
    @Deprecated
    public static BaseResponse ok(Integer status, String msg) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.status = status;
        baseResponse.msg = msg;
        baseResponse.timestamp = LocalDateFormatUtil.viewFormat2(LocalDateTime.now());
        return baseResponse;
    }

    @Deprecated
    public static BaseResponse ok(Integer status, String msg, Object content) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.status = status;
        baseResponse.msg = msg;
        baseResponse.content = content;
        baseResponse.timestamp = LocalDateFormatUtil.viewFormat2(LocalDateTime.now());
        return baseResponse;
    }

    @Deprecated
    public static BaseResponse error(BRStatus brStatus, Object content) {
        return new BaseResponse(brStatus, content);
    }

}
