package com.cf.pay.domain.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;

public class CfCouponActivityCouponTypeForm implements Serializable {
    @ApiModelProperty(value = "数据id", required = false)
    private String id;
    @ApiModelProperty(value = "优惠券活动id", required = false)
    private String couponActivityId;
    @ApiModelProperty(value = "有效时长(单位:毫秒)", required = false)
    @Min(message = "有效时长>=600000", value = 600000)
    private Long fixedExtensionTime;
    @ApiModelProperty(value = "优惠券面额", required = false)
    private BigDecimal denomination;

    private Byte couponType;
    @ApiModelProperty(value = "是否要求在服务中领取(0-否/1-是)", required = false)
    private Byte requireUsing;

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

    public Byte getCouponType() {
        return couponType;
    }

    public void setCouponType(Byte couponType) {
        this.couponType = couponType;
    }

    public Byte getRequireUsing() {
        return requireUsing;
    }

    public void setRequireUsing(Byte requireUsing) {
        this.requireUsing = requireUsing;
    }
}