package com.cf.pay.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CfQrCode implements Serializable {
    private String id;

    private String codeType;

    private String sourceId;

    private String createrId;

    private String fromUid;

    private String toUid;

    private String image;

    private Long createTime;

    private Long effectiveTime;

    private String couponActivityTypeId;

    private Byte sourceType;

    @ApiModelProperty(value = "创建优惠券二维码时请传入，优惠券类型(1-次数券/2-金额券/3-时长券)", required = false)
    private Byte couponType;
    @ApiModelProperty(value = "创建优惠券二维码时请传入，数量，发送时长表示小时数，次数券表示次数", required = false)
    private Long quantity;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public String getFromUid() {
        return fromUid;
    }

    public void setFromUid(String fromUid) {
        this.fromUid = fromUid;
    }

    public String getToUid() {
        return toUid;
    }

    public void setToUid(String toUid) {
        this.toUid = toUid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Long effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public String getCouponActivityTypeId() {
        return couponActivityTypeId;
    }

    public void setCouponActivityTypeId(String couponActivityTypeId) {
        this.couponActivityTypeId = couponActivityTypeId;
    }

    public Byte getSourceType() {
        return sourceType;
    }

    public void setSourceType(Byte sourceType) {
        this.sourceType = sourceType;
    }

    public Byte getCouponType() {
        return couponType;
    }

    public void setCouponType(Byte couponType) {
        this.couponType = couponType;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}