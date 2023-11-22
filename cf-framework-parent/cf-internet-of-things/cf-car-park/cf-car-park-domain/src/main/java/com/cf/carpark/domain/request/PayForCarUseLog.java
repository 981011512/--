package com.cf.carpark.domain.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 为指定停车记录缴纳停车费
 */
public class PayForCarUseLog implements Serializable {

    @ApiModelProperty(value = "停车记录id", required = true)
    private String id;

    @ApiModelProperty(value = "支付账号id", required = true)
    private String payTypeId;

    @ApiModelProperty(value = "优惠券id", required = false)
    private String couponId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayTypeId() {
        return payTypeId;
    }

    public void setPayTypeId(String payTypeId) {
        this.payTypeId = payTypeId;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }
}
