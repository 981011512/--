package com.cf.pay.domain.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;

public class CfCouponQuery implements Serializable {
    @ApiModelProperty(value = "优惠券id", required = false)
    private String id;

    private String toUid;

    private String fromUid;
    @ApiModelProperty(value = "使用场景(0-通用/1-停车场/2-传统商城)", required = false)
    private Byte scenes;
    @ApiModelProperty(value = "店铺id/停车场id", required = false)
    private String shopId;
    @ApiModelProperty(value = "商品id/车辆id", required = false)
    private String goodsId;
    @ApiModelProperty(value = "优惠券面值", required = false)
    private BigDecimal denomination;
    @ApiModelProperty(value = "优惠券面值>=", required = false)
    private BigDecimal minDenomination;
    @ApiModelProperty(value = "优惠券面值>=", required = false)
    private BigDecimal maxDenomination;
    @ApiModelProperty(value = "优惠券门槛价", required = false)
    private BigDecimal thresholdPrice;
    @ApiModelProperty(value = "生效时间>=", required = false)
    private Long minEffectiveTime;
    @ApiModelProperty(value = "生效时间<=", required = false)
    private Long maxEffectiveTime;
    @ApiModelProperty(value = "过期时间>=", required = false)
    private Long minExpireTime;
    @ApiModelProperty(value = "过期时间<=", required = false)
    private Long maxExpireTime;
    @ApiModelProperty(value = "状态(0-已使用/1-未使用)", required = false)
    private Byte status;
    @ApiModelProperty(value = "优惠券类型(1-次数券/2-金额券/3-时长券)", required = true)
    @Pattern(regexp = "^[1-3]$", message = "优惠券类型(1-次数券/2-金额券/3-时长券)")
    private Byte couponType;
    @ApiModelProperty(value = "统计字段", required = false)
    private String countField;
    @ApiModelProperty(value = "页码", required = true)
    @Min(value = 1, message = "页码最小值1")
    @Max(value = 200, message = "页码最大值200")
    private Integer page;
    @ApiModelProperty(value = "每页条数", required = true)
    @Min(value = 3, message = "页码最小值3")
    @Max(value = 30, message = "页码最大值30")
    private Integer size;

    private String orderBy;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getToUid() {
        return toUid;
    }

    public void setToUid(String toUid) {
        this.toUid = toUid == null ? null : toUid.trim();
    }

    public String getFromUid() {
        return fromUid;
    }

    public void setFromUid(String fromUid) {
        this.fromUid = fromUid == null ? null : fromUid.trim();
    }

    public Byte getScenes() {
        return scenes;
    }

    public void setScenes(Byte scenes) {
        this.scenes = scenes;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public BigDecimal getMinDenomination() {
        return minDenomination;
    }

    public void setMinDenomination(BigDecimal minDenomination) {
        this.minDenomination = minDenomination;
    }

    public BigDecimal getMaxDenomination() {
        return maxDenomination;
    }

    public void setMaxDenomination(BigDecimal maxDenomination) {
        this.maxDenomination = maxDenomination;
    }

    public Long getMinEffectiveTime() {
        return minEffectiveTime;
    }

    public void setMinEffectiveTime(Long minEffectiveTime) {
        this.minEffectiveTime = minEffectiveTime;
    }

    public Long getMaxEffectiveTime() {
        return maxEffectiveTime;
    }

    public void setMaxEffectiveTime(Long maxEffectiveTime) {
        this.maxEffectiveTime = maxEffectiveTime;
    }

    public Long getMinExpireTime() {
        return minExpireTime;
    }

    public void setMinExpireTime(Long minExpireTime) {
        this.minExpireTime = minExpireTime;
    }

    public Long getMaxExpireTime() {
        return maxExpireTime;
    }

    public void setMaxExpireTime(Long maxExpireTime) {
        this.maxExpireTime = maxExpireTime;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public BigDecimal getThresholdPrice() {
        return thresholdPrice;
    }

    public void setThresholdPrice(BigDecimal thresholdPrice) {
        this.thresholdPrice = thresholdPrice;
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

    public String getCountField() {
        return countField;
    }

    public void setCountField(String countField) {
        this.countField = countField;
    }

    public BigDecimal getDenomination() {
        return denomination;
    }

    public void setDenomination(BigDecimal denomination) {
        this.denomination = denomination;
    }
}