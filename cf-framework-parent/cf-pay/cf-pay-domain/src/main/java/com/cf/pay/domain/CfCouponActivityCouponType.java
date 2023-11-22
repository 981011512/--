package com.cf.pay.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfCouponActivityCouponType implements Serializable {
    private String id;

    private String couponActivityId;

    private Long fixedExtensionTime;

    private BigDecimal denomination;

    private Byte couponType;

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