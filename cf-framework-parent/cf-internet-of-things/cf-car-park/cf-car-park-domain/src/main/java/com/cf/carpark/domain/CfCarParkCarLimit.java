package com.cf.carpark.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfCarParkCarLimit implements Serializable {
    private String id;

    private String carParkId;

    private String carTypeKey;

    private Long freeTime;

    private Byte giveFreeTime;

    private Byte autoOpenDoor;

    private Byte forbidIn;

    private Byte freeRelease;

    private String billingModel;

    private Long upperLimitTime;

    private BigDecimal feeUpperLimit;

    private Long leaveTimeLimit;

    private CfCarParkSpecialCar cfCarParkSpecialCar;

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

    public String getCarTypeKey() {
        return carTypeKey;
    }

    public void setCarTypeKey(String carTypeKey) {
        this.carTypeKey = carTypeKey == null ? null : carTypeKey.trim();
    }

    public Long getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(Long freeTime) {
        this.freeTime = freeTime;
    }

    public Byte getGiveFreeTime() {
        return giveFreeTime;
    }

    public void setGiveFreeTime(Byte giveFreeTime) {
        this.giveFreeTime = giveFreeTime;
    }

    public Byte getAutoOpenDoor() {
        return autoOpenDoor;
    }

    public void setAutoOpenDoor(Byte autoOpenDoor) {
        this.autoOpenDoor = autoOpenDoor;
    }

    public Byte getForbidIn() {
        return forbidIn;
    }

    public void setForbidIn(Byte forbidIn) {
        this.forbidIn = forbidIn;
    }

    public Byte getFreeRelease() {
        return freeRelease;
    }

    public void setFreeRelease(Byte freeRelease) {
        this.freeRelease = freeRelease;
    }

    public String getBillingModel() {
        return billingModel;
    }

    public void setBillingModel(String billingModel) {
        this.billingModel = billingModel == null ? null : billingModel.trim();
    }

    public Long getUpperLimitTime() {
        return upperLimitTime;
    }

    public void setUpperLimitTime(Long upperLimitTime) {
        this.upperLimitTime = upperLimitTime;
    }

    public BigDecimal getFeeUpperLimit() {
        return feeUpperLimit;
    }

    public void setFeeUpperLimit(BigDecimal feeUpperLimit) {
        this.feeUpperLimit = feeUpperLimit;
    }

    public Long getLeaveTimeLimit() {
        return leaveTimeLimit;
    }

    public void setLeaveTimeLimit(Long leaveTimeLimit) {
        this.leaveTimeLimit = leaveTimeLimit;
    }

    public CfCarParkSpecialCar getCfCarParkSpecialCar() {
        return cfCarParkSpecialCar;
    }

    public void setCfCarParkSpecialCar(CfCarParkSpecialCar cfCarParkSpecialCar) {
        this.cfCarParkSpecialCar = cfCarParkSpecialCar;
    }
}