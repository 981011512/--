package com.cf.pay.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfStaffCouponLog implements Serializable {
    private String id;

    private String couponId;

    private String couponActivityId;

    private String staffId;

    private String toUid;

    private BigDecimal denomination;

    private Long createTime;

    private String staffName;

    private String staffAvatar;

    private String toUidName;

    private String toUidAvatar;

    private String recipientBody;

    private Byte couponType;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    public String getCouponActivityId() {
        return couponActivityId;
    }

    public void setCouponActivityId(String couponActivityId) {
        this.couponActivityId = couponActivityId == null ? null : couponActivityId.trim();
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    public String getToUid() {
        return toUid;
    }

    public void setToUid(String toUid) {
        this.toUid = toUid == null ? null : toUid.trim();
    }

    public BigDecimal getDenomination() {
        return denomination;
    }

    public void setDenomination(BigDecimal denomination) {
        this.denomination = denomination;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getRecipientBody() {
        return recipientBody;
    }

    public void setRecipientBody(String recipientBody) {
        this.recipientBody = recipientBody == null ? null : recipientBody.trim();
    }

    public Byte getCouponType() {
        return couponType;
    }

    public void setCouponType(Byte couponType) {
        this.couponType = couponType;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffAvatar() {
        return staffAvatar;
    }

    public void setStaffAvatar(String staffAvatar) {
        this.staffAvatar = staffAvatar;
    }

    public String getToUidName() {
        return toUidName;
    }

    public void setToUidName(String toUidName) {
        this.toUidName = toUidName;
    }

    public String getToUidAvatar() {
        return toUidAvatar;
    }

    public void setToUidAvatar(String toUidAvatar) {
        this.toUidAvatar = toUidAvatar;
    }
}