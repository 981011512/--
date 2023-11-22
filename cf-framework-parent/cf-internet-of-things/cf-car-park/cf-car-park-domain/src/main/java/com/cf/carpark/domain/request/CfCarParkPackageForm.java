package com.cf.carpark.domain.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class CfCarParkPackageForm implements Serializable {
    private String id;

    private String carParkId;

    private String carParkIds;

    private String typeKey;

    private Long startTime;

    private Long endTime;

    private Long createTime;

    private String uid;

    @ApiModelProperty(value = "车牌号", required = true)
    @Pattern(regexp = "^[\\u0391-\\uFFE5A-Za-z]{1}[A-Z0-9]{5,6}[\\u0391-\\uFFE5A-Z0-9]{1,2}$", message = "车牌号不合法")
    private String numberPlate;

    private Byte specialGive;

    private String packagePriceId;

    private Byte transRegional;

    private String mainCarParkId;

    private String phone;

    private String parentId;

    private String remarks;

    private String carOwnerName;

    private String groupFlag;

    private Byte status;

    private Byte issuedWhitelist;

    private Long issuedWhitelistTime;

    private Byte noticeExpiringSoon;

    private Byte noticeExpired;

    private String specialCarId;

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
        this.packagePriceId = packagePriceId;
    }

    public Byte getTransRegional() {
        return transRegional;
    }

    public void setTransRegional(Byte transRegional) {
        this.transRegional = transRegional;
    }

    public String getPhone() {
        return phone;
    }

    public String getMainCarParkId() {
        return mainCarParkId;
    }

    public void setMainCarParkId(String mainCarParkId) {
        this.mainCarParkId = mainCarParkId;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCarParkIds() {
        return carParkIds;
    }

    public void setCarParkIds(String carParkIds) {
        this.carParkIds = carParkIds;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}