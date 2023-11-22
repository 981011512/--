package com.cf.pay.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfOrder implements Serializable {
    private String id;

    private String randomId;

    private String uid;

    private String userName;

    private String goodsName;

    private String goodsId;

    private String goodsImage;

    private Byte goodsType;

    private String shopId;

    private BigDecimal amountsPayable;

    private BigDecimal amountActuallyPaid;

    private BigDecimal refundAmount;

    private String couponId;

    private Byte status;

    private Long createTime;

    private Long updateTime;

    private Long payTime;

    private Long refundTime;

    private Long cancelTime;

    private String paymentAgencyShortName;

    private String userPaymentAgencyId;

    private String thirdPartyOrderId;

    private String effectObject;

    private BigDecimal scorePaid;

    private String scoreKeyFlag;

    private BigDecimal couponPaid;

    private BigDecimal scoreMoney;

    private String RefundReason;

    private BigDecimal manualOffer;

    private Long manualOfferSetTime;

    private Integer purchaseQuantity;

    private String handleUid;

    private String handleUidUserName;

    private String collectionShopId;

    private String collectionOrderId;

    private BigDecimal collectionAmount;

    private String openId;  //app支付时需要前端自行传入

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRandomId() {
        return randomId;
    }

    public void setRandomId(String randomId) {
        this.randomId = randomId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage == null ? null : goodsImage.trim();
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
        this.shopId = shopId == null ? null : shopId.trim();
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
        this.couponId = couponId == null ? null : couponId.trim();
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
        this.paymentAgencyShortName = paymentAgencyShortName == null ? null : paymentAgencyShortName.trim();
    }

    public String getUserPaymentAgencyId() {
        return userPaymentAgencyId;
    }

    public void setUserPaymentAgencyId(String userPaymentAgencyId) {
        this.userPaymentAgencyId = userPaymentAgencyId == null ? null : userPaymentAgencyId.trim();
    }

    public String getThirdPartyOrderId() {
        return thirdPartyOrderId;
    }

    public void setThirdPartyOrderId(String thirdPartyOrderId) {
        this.thirdPartyOrderId = thirdPartyOrderId == null ? null : thirdPartyOrderId.trim();
    }

    public String getEffectObject() {
        return effectObject;
    }

    public void setEffectObject(String effectObject) {
        this.effectObject = effectObject == null ? null : effectObject.trim();
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
        this.scoreKeyFlag = scoreKeyFlag == null ? null : scoreKeyFlag.trim();
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHandleUidUserName() {
        return handleUidUserName;
    }

    public void setHandleUidUserName(String handleUidUserName) {
        this.handleUidUserName = handleUidUserName;
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

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}