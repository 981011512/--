package com.cf.carpark.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfCarParkSpecialCarForm implements Serializable {
    private String id;

    private String carParkId;

    private String typeKey;

    private Long startTime;

    private Long endTime;

    private Long createTime;

    private String uid;

    private String numberPlate;

    private String phone;

    private String remarks;

    private String carOwnerName;

    private String groupFlag;

    private Byte status;

    private Long remainingParkTime;

    private Byte autoGiveAway;

    private Byte autoCleared;

    private String autoGiveAwayDate;

    private BigDecimal autoGiveAwayAmount;

    private Long autoGiveAwayTime;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getCarOwnerName() {
        return carOwnerName;
    }

    public void setCarOwnerName(String carOwnerName) {
        this.carOwnerName = carOwnerName == null ? null : carOwnerName.trim();
    }

    public String getGroupFlag() {
        return groupFlag;
    }

    public void setGroupFlag(String groupFlag) {
        this.groupFlag = groupFlag == null ? null : groupFlag.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getRemainingParkTime() {
        return remainingParkTime;
    }

    public void setRemainingParkTime(Long remainingParkTime) {
        this.remainingParkTime = remainingParkTime;
    }

    public Byte getAutoGiveAway() {
        return autoGiveAway;
    }

    public void setAutoGiveAway(Byte autoGiveAway) {
        this.autoGiveAway = autoGiveAway;
    }

    public Byte getAutoCleared() {
        return autoCleared;
    }

    public void setAutoCleared(Byte autoCleared) {
        this.autoCleared = autoCleared;
    }

    public String getAutoGiveAwayDate() {
        return autoGiveAwayDate;
    }

    public void setAutoGiveAwayDate(String autoGiveAwayDate) {
        this.autoGiveAwayDate = autoGiveAwayDate;
    }

    public BigDecimal getAutoGiveAwayAmount() {
        return autoGiveAwayAmount;
    }

    public void setAutoGiveAwayAmount(BigDecimal autoGiveAwayAmount) {
        this.autoGiveAwayAmount = autoGiveAwayAmount;
    }

    public Long getAutoGiveAwayTime() {
        return autoGiveAwayTime;
    }

    public void setAutoGiveAwayTime(Long autoGiveAwayTime) {
        this.autoGiveAwayTime = autoGiveAwayTime;
    }
}