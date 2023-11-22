package com.cf.charging.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfChargingStationRules implements Serializable {
    private String id;

    private String chargingStationId;

    private Long startTime;

    private Long endTime;

    private BigDecimal fee;

    private Long createTime;

    private Long updateTime;

    private Byte status;

    private String chargingDeviceType;

    private String type;

    private String groupFlag;

    private BigDecimal feeUpperLimit;

    private BigDecimal serviceFee;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getChargingStationId() {
        return chargingStationId;
    }

    public void setChargingStationId(String chargingStationId) {
        this.chargingStationId = chargingStationId == null ? null : chargingStationId.trim();
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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getChargingDeviceType() {
        return chargingDeviceType;
    }

    public void setChargingDeviceType(String chargingDeviceType) {
        this.chargingDeviceType = chargingDeviceType == null ? null : chargingDeviceType.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getGroupFlag() {
        return groupFlag;
    }

    public void setGroupFlag(String groupFlag) {
        this.groupFlag = groupFlag == null ? null : groupFlag.trim();
    }

    public BigDecimal getFeeUpperLimit() {
        return feeUpperLimit;
    }

    public void setFeeUpperLimit(BigDecimal feeUpperLimit) {
        this.feeUpperLimit = feeUpperLimit;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }
}