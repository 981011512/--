package com.cf.pay.domain.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfStaffCouponLogForm implements Serializable {
    @ApiModelProperty(value = "数据id", required = false)
    private String id;
    @ApiModelProperty(value = "优惠券id", required = false)
    private String couponId;
    @ApiModelProperty(value = "优惠券活动id", required = false)
    private String couponActivityId;
    @ApiModelProperty(value = "员工id", required = false)
    private String staffId;
    @ApiModelProperty(value = "受赠人id", required = false)
    private String toUid;
    @ApiModelProperty(value = "优惠券面额", required = false)
    private BigDecimal denomination;
    @ApiModelProperty(value = "创建时间", required = false)
    private Long createTime;
    @ApiModelProperty(value = "受赠体(商品id/车牌号等)", required = false)
    private String recipientBody;
    @ApiModelProperty(value = "优惠券类型(1-次数券/2-金额券/3-时长券)", required = false)
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
        this.recipientBody = recipientBody;
    }

    public Byte getCouponType() {
        return couponType;
    }

    public void setCouponType(Byte couponType) {
        this.couponType = couponType;
    }
}