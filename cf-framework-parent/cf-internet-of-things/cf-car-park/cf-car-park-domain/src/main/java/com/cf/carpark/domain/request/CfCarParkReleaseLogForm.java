package com.cf.carpark.domain.request;

import java.io.Serializable;

public class CfCarParkReleaseLogForm implements Serializable {
    private String id;

    private String carparkId;

    private String carparkUseLogId;

    private String numberPlate;

    private String uid;

    private String deviceSerialNumber;

    private Long applicationTime;

    private String applicationReason;

    private Long executionTime;

    private Byte status;

    private Byte type;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCarparkId() {
        return carparkId;
    }

    public void setCarparkId(String carparkId) {
        this.carparkId = carparkId == null ? null : carparkId.trim();
    }

    public String getCarparkUseLogId() {
        return carparkUseLogId;
    }

    public void setCarparkUseLogId(String carparkUseLogId) {
        this.carparkUseLogId = carparkUseLogId == null ? null : carparkUseLogId.trim();
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getDeviceSerialNumber() {
        return deviceSerialNumber;
    }

    public void setDeviceSerialNumber(String deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber == null ? null : deviceSerialNumber.trim();
    }

    public Long getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Long applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getApplicationReason() {
        return applicationReason;
    }

    public void setApplicationReason(String applicationReason) {
        this.applicationReason = applicationReason == null ? null : applicationReason.trim();
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}