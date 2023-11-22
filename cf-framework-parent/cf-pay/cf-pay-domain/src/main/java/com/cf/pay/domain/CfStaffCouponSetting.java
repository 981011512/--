package com.cf.pay.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfStaffCouponSetting implements Serializable {
    private String id;

    private BigDecimal sameDayQuota;

    private String staffId;

    private String couponActivityId;

    private Byte couponType;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public BigDecimal getSameDayQuota() {
        return sameDayQuota;
    }

    public void setSameDayQuota(BigDecimal sameDayQuota) {
        this.sameDayQuota = sameDayQuota;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    public String getCouponActivityId() {
        return couponActivityId;
    }

    public void setCouponActivityId(String couponActivityId) {
        this.couponActivityId = couponActivityId == null ? null : couponActivityId.trim();
    }

    public Byte getCouponType() {
        return couponType;
    }

    public void setCouponType(Byte couponType) {
        this.couponType = couponType;
    }
}