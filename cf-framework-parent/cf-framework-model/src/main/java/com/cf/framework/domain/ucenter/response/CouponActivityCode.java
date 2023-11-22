package com.cf.framework.domain.ucenter.response;

import com.cf.framework.domain.response.ResultCode;
import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;


/**
 * Created by admin on 2020/3/5.
 */
@ToString
public enum CouponActivityCode implements ResultCode {
    COUPONACTIVITY_DOES_NOT_EXIST(false,27001,"指定的优惠券活动不存在！"),
    ACTIVITY_NOT_MATCH_USER(false,27002,"指定的优惠券活动与用户不匹配！"),
    ACTIVITY_NOT_MATCH_COUPON_TYPE(false,27003,"该优惠券类型与优惠券活动不匹配！"),
    ACTIVITY_COUPON_BALANCE_INSUFFICIENT(false,27004,"活动优惠券余额不足！"),
    ACTIVITY_TO_BE_OPENED(false,27005,"活动暂未开放，敬请期待！"),
    YOU_ACTIVITY_COUPON_BALANCE_INSUFFICIENT(false,27006,"您的活动优惠券余额不足！"),
    REPEATED_COLLECTION(false,27007,"重复领取！"),
    MISSING_GIFT_GOAL(false,27008,"缺少赠送目标！"),
    MISSING_QUANTITY(false,27009,"缺少数量！"),
    COUPON_REACHED_UPPER_LIMIT(false,27010,"优惠券已达上限！"),
    ;

    //操作代码
    @ApiModelProperty(value = "操作是否成功", example = "true", required = true)
    boolean success;

    //操作代码
    @ApiModelProperty(value = "操作代码", example = "22001", required = true)
    int code;
    //提示信息
    @ApiModelProperty(value = "操作提示", example = "操作过于频繁！", required = true)
    String message;
    private CouponActivityCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }
    private static final ImmutableMap<Integer, CouponActivityCode> CACHE;

    static {
        final ImmutableMap.Builder<Integer, CouponActivityCode> builder = ImmutableMap.builder();
        for (CouponActivityCode commonCode : values()) {
            builder.put(commonCode.code(), commonCode);
        }
        CACHE = builder.build();
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public void setMessage(String _message) {
        this.message = _message;
    }

    String mixMessage;
    @Override
    public String mixMessage() {
        return mixMessage;
    }

    @Override
    public void setMixMessage(String _mixMessage) {
        this.mixMessage = _mixMessage;
    }
}
