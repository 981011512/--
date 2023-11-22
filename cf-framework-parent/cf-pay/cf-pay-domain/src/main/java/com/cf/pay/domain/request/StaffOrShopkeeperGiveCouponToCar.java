package com.cf.pay.domain.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class StaffOrShopkeeperGiveCouponToCar implements Serializable {

    @ApiModelProperty(value = "优惠活动id", required = true)
    private String cfCouponActivityId;
    @ApiModelProperty(value = "优惠券类型id", required = false)
    private String couponActivityCouponTypeId;
    @ApiModelProperty(value = "车牌号", required = false)
    private String numberPlate;
    @ApiModelProperty(value = "手机号", required = false)
    private String phone;
    @ApiModelProperty(value = "优惠券类型(1-次数券/2-金额券/3-时长券)", required = false)
    private Byte couponType;
    @ApiModelProperty(value = "数量，发送时长表示小时数，次数券表示次数", required = false)
    private Integer quantity;

    public String getCfCouponActivityId() {
        return cfCouponActivityId;
    }

    public void setCfCouponActivityId(String cfCouponActivityId) {
        this.cfCouponActivityId = cfCouponActivityId;
    }

    public String getCouponActivityCouponTypeId() {
        return couponActivityCouponTypeId;
    }

    public void setCouponActivityCouponTypeId(String couponActivityCouponTypeId) {
        this.couponActivityCouponTypeId = couponActivityCouponTypeId;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Byte getCouponType() {
        return couponType;
    }

    public void setCouponType(Byte couponType) {
        this.couponType = couponType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
