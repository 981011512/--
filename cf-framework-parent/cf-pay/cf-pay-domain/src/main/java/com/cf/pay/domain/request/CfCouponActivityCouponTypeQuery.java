package com.cf.pay.domain.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfCouponActivityCouponTypeQuery implements Serializable {
    private String id;

    @ApiModelProperty(value = "优惠券活动id", required = true)
    private String couponActivityId;

    private Long fixedExtensionTime;

    private BigDecimal denomination;

    @ApiModelProperty(value = "优惠券类型(1-次数券/2-金额券/3-时长券)", required = false)
    private Byte couponType;

    @ApiModelProperty(value = "排序条件", required = false)
    private String orderBy;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCouponActivityId() {
        return couponActivityId;
    }

    public void setCouponActivityId(String couponActivityId) {
        this.couponActivityId = couponActivityId == null ? null : couponActivityId.trim();
    }

    public Long getFixedExtensionTime() {
        return fixedExtensionTime;
    }

    public void setFixedExtensionTime(Long fixedExtensionTime) {
        this.fixedExtensionTime = fixedExtensionTime;
    }

    public BigDecimal getDenomination() {
        return denomination;
    }

    public void setDenomination(BigDecimal denomination) {
        this.denomination = denomination;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Byte getCouponType() {
        return couponType;
    }

    public void setCouponType(Byte couponType) {
        this.couponType = couponType;
    }
}