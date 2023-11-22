package com.cf.carpark.domain;

import java.io.Serializable;

public class CfCarParkReleaseLog implements Serializable {
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

    private CfCarPark cfCarPark;

    protected CfCarParkCheckpoint cfCarParkCheckpoint;

    protected CfCarParkDevice cfCarParkDevice;

    private CfCarParkUseLog cfCarParkUseLog;

    private static final long serialVersionUID = 1L;

    public CfCarParkReleaseLog() {
    }

    public CfCarParkReleaseLog(String id, String carparkId, String carparkUseLogId, String numberPlate, String uid, String deviceSerialNumber, Long applicationTime, String applicationReason, Long executionTime, Byte status, Byte type) {
        this.id = id;
        this.carparkId = carparkId;
        this.carparkUseLogId = carparkUseLogId;
        this.numberPlate = numberPlate;
        this.uid = uid;
        this.deviceSerialNumber = deviceSerialNumber;
        this.applicationTime = applicationTime;
        this.applicationReason = applicationReason;
        this.executionTime = executionTime;
        this.status = status;
        this.type = type;
    }

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
        this.numberPlate = numberPlate == null ? null : numberPlate.trim();
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

    public CfCarPark getCfCarPark() {
        return cfCarPark;
    }

    public void setCfCarPark(CfCarPark cfCarPark) {
        this.cfCarPark = cfCarPark;
    }

    public CfCarParkCheckpoint getCfCarParkCheckpoint() {
        return cfCarParkCheckpoint;
    }

    public void setCfCarParkCheckpoint(CfCarParkCheckpoint cfCarParkCheckpoint) {
        this.cfCarParkCheckpoint = cfCarParkCheckpoint;
    }

    public CfCarParkDevice getCfCarParkDevice() {
        return cfCarParkDevice;
    }

    public void setCfCarParkDevice(CfCarParkDevice cfCarParkDevice) {
        this.cfCarParkDevice = cfCarParkDevice;
    }

    public CfCarParkUseLog getCfCarParkUseLog() {
        return cfCarParkUseLog;
    }

    public void setCfCarParkUseLog(CfCarParkUseLog cfCarParkUseLog) {
        this.cfCarParkUseLog = cfCarParkUseLog;
    }
}