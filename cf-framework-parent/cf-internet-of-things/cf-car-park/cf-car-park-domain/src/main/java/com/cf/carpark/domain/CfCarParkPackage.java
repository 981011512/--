package com.cf.carpark.domain;

import java.io.Serializable;

public class CfCarParkPackage implements Serializable {
    private String id;

    private String carParkId;

    private String carParkIds;

    private String typeKey;

    private Long startTime;

    private Long endTime;

    private Long createTime;

    private String uid;

    private String numberPlate;

    private Byte specialGive;

    private String packagePriceId;

    private Byte transRegional;

    private String mainCarParkId;

    private String phone;

    private String carParkName;

    private String parentId;

    private String userName;

    private String name;

    private String remarks;

    private String carOwnerName;

    private CfCarParkCarType cfCarParkCarType;

    private String groupFlag;

    private Byte status;

    private Byte issuedWhitelist;

    private Long issuedWhitelistTime;

    private Byte noticeExpiringSoon;

    private Byte noticeExpired;

    private String specialCarId;

    private CfCarParkPackagePrice cfCarParkPackagePrice;

    private Integer quantity;   //数量，并非真实数据库字段,方便后台现金续费时按月计费

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCarParkId() {
        return carParkId;
    }

    public void setCarParkId(String carParkId) {
        this.carParkId = carParkId == null ? null : carParkId.trim();
    }

    public String getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey == null ? null : typeKey.trim();
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate == null ? null : numberPlate.trim();
    }

    public Byte getSpecialGive() {
        return specialGive;
    }

    public void setSpecialGive(Byte specialGive) {
        this.specialGive = specialGive;
    }

    public String getPackagePriceId() {
        return packagePriceId;
    }

    public void setPackagePriceId(String packagePriceId) {
        this.packagePriceId = packagePriceId == null ? null : packagePriceId.trim();
    }

    public Byte getTransRegional() {
        return transRegional;
    }

    public void setTransRegional(Byte transRegional) {
        this.transRegional = transRegional;
    }

    public String getMainCarParkId() {
        return mainCarParkId;
    }

    public void setMainCarParkId(String mainCarParkId) {
        this.mainCarParkId = mainCarParkId == null ? null : mainCarParkId.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCarParkName() {
        return carParkName;
    }

    public void setCarParkName(String carParkName) {
        this.carParkName = carParkName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCarParkIds() {
        return carParkIds;
    }

    public void setCarParkIds(String carParkIds) {
        this.carParkIds = carParkIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCarOwnerName() {
        return carOwnerName;
    }

    public void setCarOwnerName(String carOwnerName) {
        this.carOwnerName = carOwnerName;
    }

    public CfCarParkCarType getCfCarParkCarType() {
        return cfCarParkCarType;
    }

    public void setCfCarParkCarType(CfCarParkCarType cfCarParkCarType) {
        this.cfCarParkCarType = cfCarParkCarType;
    }

    public String getGroupFlag() {
        return groupFlag;
    }

    public void setGroupFlag(String groupFlag) {
        this.groupFlag = groupFlag;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getIssuedWhitelist() {
        return issuedWhitelist;
    }

    public void setIssuedWhitelist(Byte issuedWhitelist) {
        this.issuedWhitelist = issuedWhitelist;
    }

    public Long getIssuedWhitelistTime() {
        return issuedWhitelistTime;
    }

    public void setIssuedWhitelistTime(Long issuedWhitelistTime) {
        this.issuedWhitelistTime = issuedWhitelistTime;
    }

    public Byte getNoticeExpiringSoon() {
        return noticeExpiringSoon;
    }

    public void setNoticeExpiringSoon(Byte noticeExpiringSoon) {
        this.noticeExpiringSoon = noticeExpiringSoon;
    }

    public Byte getNoticeExpired() {
        return noticeExpired;
    }

    public void setNoticeExpired(Byte noticeExpired) {
        this.noticeExpired = noticeExpired;
    }

    public String getSpecialCarId() {
        return specialCarId;
    }

    public void setSpecialCarId(String specialCarId) {
        this.specialCarId = specialCarId;
    }

    public CfCarParkPackagePrice getCfCarParkPackagePrice() {
        return cfCarParkPackagePrice;
    }

    public void setCfCarParkPackagePrice(CfCarParkPackagePrice cfCarParkPackagePrice) {
        this.cfCarParkPackagePrice = cfCarParkPackagePrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}