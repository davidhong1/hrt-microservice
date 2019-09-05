package com.hrt.cloud.common.core.entity;

import lombok.Getter;

public enum BRStatus {

    SUCCESS(200, "SUCCESS"),

    SERVER_ERROR(700, "服务器异常"),
    orderNotExist(701, "订单不存在"),
    getOpenIdFailed(702, "获取openid出错"),
    understock(703, "库存不足"),
    incorrectFbLen(704, "数据长度不正确"),
    METHOD_NOT_ALLOWED(705, "请求方法不允许"),


    refundFailed(708, "退款失败"),
    errorOrderNo(709, "订单号有误"),
    phoneDecipheringFailed(710, "获取电话号码失败"),

    machineIsBusying(712, "机器忙"),
    userNotExist(713, "用户不存在"),
    incorrectPassword(714, "密码不正确"),


    paramsIsError(717, "参数有误"),
    machineNotExist(718, "机器不存在"),
    getQrCodeFailed(719, "获取二维码失败"),

    savePicFailed(721, "保存图片失败"),
    fileIsBig(722, "文件过大"),
    notDevicePermission(723, "不能操作该设备"),
    GET_ERROR(724, "并未获取到信息"),
    machineOutline(725, "机器不在线"),
    codeerror(726, "验证码错误或已失效"),
    serExist(727, "该ser存在"),
    //FIXME 支付发生网络异常，需通知管理员处理
    wcPayNetError(728, "微信支付时，发生网络异常"),
    wcPayCreateSignError(729, "微信支付时，生成签名失败"),
    redeemcodeLack(730, "饮杯券不足"),
    USERNAME_EXIST(731, "该用户名已存在"),
    getJSSdkPermissionsFailed(732, "获取微信jsSdk权限失败"),
    USER_NOT_EXIST(733, "用户不存在"),
    exception(734, "发生服务器异常"),
    MAINTAIN_EXIST(735, "该用户已经是维护人员"),
    PERMISSION_NO_EXIST(736, "当前用户权限不足"),
    pleaseWait(737, "请稍后购买"),
    userHadParticipatedPromotion(738, "用户已参加过该活动"),
    DEVICE_BIND_ERROR(739, "绑定设备部分失败"),
    orderStatusSure(740, "订单状态确定"),
    orderStatusNoSure(741, "订单状态不确定"),
    sensorBreakdown(742, "传感器故障"),
    wcOrderFailed(743, "微信下单失败"),
    USER_AUTH_INFO_INVILID(744, "用户授权信息无效"),
    USER_DISCOUNT_EXIST(745, "用户享受过该优惠"),
    DISCOUNT_GET_ERROR(746, "优惠领取失败"),
    urlNotNormalized(747, "请求url不正常"),
    COMMAND_HAS_RESPONSE(748, "指令正常响应"),
    PLEASE_RETRY(749, "请重试"),
    DEVICE_LOCKED(750, "设备已锁定"),
    DEVICE_NOT_EXIST(751, "设备不存在"),
    FEIGN_MSG(752, "feign服务降级"),
    SEND_SMS_FAILED(753, "发送短信失败"),
    SpEL_EXCEPTION(754, "解析SqEL异常"),

    CODEERROE(726, "验证码错误或已失效"),
    FORM_ERROR(721, "字段验证异常"),
    USER_LOGIN_INFO_EXCEPTION(722, "用户登录信息异常"),
    SYSTEM_MSG_TYPE_ERROR(723, "系统消息获取类型错误！"),
    INSERT_ERROR(723, "添加失败"),
    DELETE_ERROR(725, "删除操作无效"),
    USER_UNEXIST(726, "负责人手机号不存在"),
    UPDATE_ERROR(727, "修改操作无效"),
    DOWNLOAD_ERROR(728, "获取下载路径失败"),
    INVITE_CODE_ERROR(729, "邀请码错误或已失效"),
    PHONE_EXIST(730, "该手机号已存在"),
    PARAS_ERROR(732, "参数有误"),
    PW_ERROR(734, "密码错误"),
    PRODUCT_NULL(737, "当前产品不存在"),
    GOOD_NOT_EXIST(738, "商品不存在"),
    GOOD_ON_SALE(740, "此商品在售卖中"),
    ROLE_CLASH(741, "该用户存在别的角色");

    @Getter
    private final int status;
    @Getter
    private final String msg;

    BRStatus(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

}
