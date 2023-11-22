package com.cf.ucenter.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderForm implements Serializable {

    @ApiModelProperty(value = "账单id", required = false)
    private String id;
    @ApiModelProperty(value = "用户id", required = false)
    private String uid;
    @ApiModelProperty(value = "商品名称", required = false)
    private String goodsName;
    @ApiModelProperty(value = "商品id", required = false)
    private String goodsId;
    @ApiModelProperty(value = "商品图片", required = false)
    private String goodsImage;
    @ApiModelProperty(value = "商品类型(1-停车/2-充值或提现/3-商城/4-转账或收款/5-停车套餐/6-车位预订/7-优惠券活动充值/8-新能源充电)", required = false)
    private Byte goodsType;
    @ApiModelProperty(value = "店铺id", required = false)
    private String shopId;
    @ApiModelProperty(value = "应付金额", required = false)
    private BigDecimal amountsPayable;
    @ApiModelProperty(value = "实付金额", required = false)
    private BigDecimal amountActuallyPaid;
    @ApiModelProperty(value = "退款金额", required = false)
    private BigDecimal refundAmount;
    @ApiModelProperty(value = "优惠券id", required = false)
    private String couponId;
    @ApiModelProperty(value = "状态(0-待支付/1-已支付/2-已发货/3-已取消/4-一退款中/5-已退款/6-退货中/7-已退货/8-交易成功/9-售后中/10-售后已结束)", required = false)
    private Byte status;
    @ApiModelProperty(value = "创建时间", required = false)
    private Long createTime;
    @ApiModelProperty(value = "更新时间", required = false)
    private Long updateTime;
    @ApiModelProperty(value = "支付时间", required = false)
    private Long payTime;
    @ApiModelProperty(value = "退款时间", required = false)
    private Long refundTime;
    @ApiModelProperty(value = "取消时间", required = false)
    private Long cancelTime;
    @ApiModelProperty(value = "支付机构", required = false)
    private String paymentAgencyShortName;
    @ApiModelProperty(value = "支付账号id", required = false)
    private String userPaymentAgencyId;
    @ApiModelProperty(value = "第三方账单id", required = false)
    private String thirdPartyOrderId;
    @ApiModelProperty(value = "作用对象(例如给手机1888**充值花费，改字段为1888**)", required = false)
    private String effectObject;
    @ApiModelProperty(value = "积分抵扣额度", required = false)
    private BigDecimal scorePaid;
    @ApiModelProperty(value = "积分标识符", required = false)
    private String scoreKeyFlag;
    @ApiModelProperty(value = "优惠券抵扣金额", required = false)
    private BigDecimal couponPaid;
    @ApiModelProperty(value = "积分抵扣金额", required = false)
    private BigDecimal scoreMoney;
    @ApiModelProperty(value = "退款原因", required = false)
    private String RefundReason;
    @ApiModelProperty(value = "手动设置的优惠金额", required = false)
    private BigDecimal manualOffer;
    @ApiModelProperty(value = "手动设置优惠金额时间", required = false)
    private Long manualOfferSetTime;
    @ApiModelProperty(value = "购买数量", required = false)
    private Integer purchaseQuantity;
    @ApiModelProperty(value = "操作员", required = false)
    private String handleUid;
    @ApiModelProperty(value = "代收店铺id", required = false)
    private String collectionShopId;
    @ApiModelProperty(value = "代收账单id", required = false)
    private String collectionOrderId;
    @ApiModelProperty(value = "收到金额", required = false)
    private BigDecimal collectionAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public Byte getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Byte goodsType) {
        this.goodsType = goodsType;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public BigDecimal getAmountsPayable() {
        return amountsPayable;
    }

    public void setAmountsPayable(BigDecimal amountsPayable) {
        this.amountsPayable = amountsPayable;
    }

    public BigDecimal getAmountActuallyPaid() {
        return amountActuallyPaid;
    }

    public void setAmountActuallyPaid(BigDecimal amountActuallyPaid) {
        this.amountActuallyPaid = amountActuallyPaid;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public Long getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Long refundTime) {
        this.refundTime = refundTime;
    }

    public Long getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Long cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getPaymentAgencyShortName() {
        return paymentAgencyShortName;
    }

    public void setPaymentAgencyShortName(String paymentAgencyShortName) {
        this.paymentAgencyShortName = paymentAgencyShortName;
    }

    public String getUserPaymentAgencyId() {
        return userPaymentAgencyId;
    }

    public void setUserPaymentAgencyId(String userPaymentAgencyId) {
        this.userPaymentAgencyId = userPaymentAgencyId;
    }

    public String getThirdPartyOrderId() {
        return thirdPartyOrderId;
    }

    public void setThirdPartyOrderId(String thirdPartyOrderId) {
        this.thirdPartyOrderId = thirdPartyOrderId;
    }

    public String getEffectObject() {
        return effectObject;
    }

    public void setEffectObject(String effectObject) {
        this.effectObject = effectObject;
    }

    public BigDecimal getScorePaid() {
        return scorePaid;
    }

    public void setScorePaid(BigDecimal scorePaid) {
        this.scorePaid = scorePaid;
    }

    public String getScoreKeyFlag() {
        return scoreKeyFlag;
    }

    public void setScoreKeyFlag(String scoreKeyFlag) {
        this.scoreKeyFlag = scoreKeyFlag;
    }

    public BigDecimal getCouponPaid() {
        return couponPaid;
    }

    public void setCouponPaid(BigDecimal couponPaid) {
        this.couponPaid = couponPaid;
    }

    public BigDecimal getScoreMoney() {
        return scoreMoney;
    }

    public void setScoreMoney(BigDecimal scoreMoney) {
        this.scoreMoney = scoreMoney;
    }

    public String getRefundReason() {
        return RefundReason;
    }

    public void setRefundReason(String refundReason) {
        RefundReason = refundReason;
    }

    public BigDecimal getManualOffer() {
        return manualOffer;
    }

    public void setManualOffer(BigDecimal manualOffer) {
        this.manualOffer = manualOffer;
    }

    public Long getManualOfferSetTime() {
        return manualOfferSetTime;
    }

    public void setManualOfferSetTime(Long manualOfferSetTime) {
        this.manualOfferSetTime = manualOfferSetTime;
    }

    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Integer purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public String getHandleUid() {
        return handleUid;
    }

    public void setHandleUid(String handleUid) {
        this.handleUid = handleUid;
    }

    public String getCollectionShopId() {
        return collectionShopId;
    }

    public void setCollectionShopId(String collectionShopId) {
        this.collectionShopId = collectionShopId;
    }

    public String getCollectionOrderId() {
        return collectionOrderId;
    }

    public void setCollectionOrderId(String collectionOrderId) {
        this.collectionOrderId = collectionOrderId;
    }

    public BigDecimal getCollectionAmount() {
        return collectionAmount;
    }

    public void setCollectionAmount(BigDecimal collectionAmount) {
        this.collectionAmount = collectionAmount;
    }
}
