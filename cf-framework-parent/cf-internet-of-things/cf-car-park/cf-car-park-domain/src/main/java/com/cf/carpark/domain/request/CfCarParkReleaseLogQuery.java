package com.cf.carpark.domain.request;

import java.io.Serializable;

public class CfCarParkReleaseLogQuery implements Serializable {

    private String id;

    private String carparkId;

    private String carparkUseLogId;

    private String numberPlate;

    private String uid;

    private String deviceSerialNumber;

    private Long minApplicationTime;

    private Long maxApplicationTime;

    private String applicationReason;

    private Long minExecutionTime;

    private Long maxExecutionTime;

    private Byte status;

    private Byte type;

    private String orderBy;

    private Integer page;

    private Integer size;

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

    public String getApplicationReason() {
        return applicationReason;
    }

    public void setApplicationReason(String applicationReason) {
        this.applicationReason = applicationReason == null ? null : applicationReason.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getMinApplicationTime() {
        return minApplicationTime;
    }

    public void setMinApplicationTime(Long minApplicationTime) {
        this.minApplicationTime = minApplicationTime;
    }

    public Long getMaxApplicationTime() {
        return maxApplicationTime;
    }

    public void setMaxApplicationTime(Long maxApplicationTime) {
        this.maxApplicationTime = maxApplicationTime;
    }

    public Long getMinExecutionTime() {
        return minExecutionTime;
    }

    public void setMinExecutionTime(Long minExecutionTime) {
        this.minExecutionTime = minExecutionTime;
    }

    public Long getMaxExecutionTime() {
        return maxExecutionTime;
    }

    public void setMaxExecutionTime(Long maxExecutionTime) {
        this.maxExecutionTime = maxExecutionTime;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}