package com.cf.pay.domain.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class RechargeToCouponActivity implements Serializable {

    @ApiModelProperty(value = "活动id", required = true)
    private String couponActivityId;
    @ApiModelProperty(value = "充值金额", required = true)
    private BigDecimal amountOfMoney;
    @ApiModelProperty(value = "使用场景(wx_web微信网页/wx_mp微信小程序/app/ali_web阿里网页/web-网页通用)", required = true)
    private String useScenes;
    @ApiModelProperty(value = "优惠券类型(1-次数券/2-金额券/3-时长券)", required = false)
    private Byte couponType;

    public String getCouponActivityId() {
        return couponActivityId;
    }

    public void setCouponActivityId(String couponActivityId) {
        this.couponActivityId = couponActivityId;
    }

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(BigDecimal amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public String getUseScenes() {
        return useScenes;
    }

    public void setUseScenes(String useScenes) {
        this.useScenes = useScenes;
    }

    public Byte getCouponType() {
        return couponType;
    }

    public void setCouponType(Byte couponType) {
        this.couponType = couponType;
    }
}
