package com.cf.charging.domain;

import com.cf.charging.domain.customize.CfChargingState;
import com.cf.pay.domain.CfOrder;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfChargingUseLog implements Serializable {
    private String id;

    private String chargingStationId;

    private String chargingDeviceId;

    private String chargingPort;

    private Long startTime;

    private Long endTime;

    private String uid;

    private BigDecimal chargingFee;

    private BigDecimal serviceFee;

    private BigDecimal planChargingFee;

    private Float chargingedKwh;

    private Float planChargingKwh;

    private BigDecimal chargingPrice;

    private Byte chargingStatus;

    private String endReason;

    private BigDecimal servicePrice;

    private Integer chargingPower;

    private Long planChargingTime;

    private Byte chargingType;

    private CfChargingStation cfChargingStation;

    private CfChargingStationDevice cfChargingStationDevice;

    private CfChargingPort cfChargingPort;

    private CfOrder cfOrder;

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

    public String getChargingDeviceId() {
        return chargingDeviceId;
    }

    public void setChargingDeviceId(String chargingDeviceId) {
        this.chargingDeviceId = chargingDeviceId == null ? null : chargingDeviceId.trim();
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public String getChargingPort() {
        return chargingPort;
    }

    public void setChargingPort(String chargingPort) {
        this.chargingPort = chargingPort;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public BigDecimal getChargingFee() {
        return chargingFee;
    }

    public void setChargingFee(BigDecimal chargingFee) {
        this.chargingFee = chargingFee;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getPlanChargingFee() {
        return planChargingFee;
    }

    public void setPlanChargingFee(BigDecimal planChargingFee) {
        this.planChargingFee = planChargingFee;
    }

    public Float getChargingedKwh() {
        return chargingedKwh;
    }

    public void setChargingedKwh(Float chargingedKwh) {
        this.chargingedKwh = chargingedKwh;
    }

    public Float getPlanChargingKwh() {
        return planChargingKwh;
    }

    public void setPlanChargingKwh(Float planChargingKwh) {
        this.planChargingKwh = planChargingKwh;
    }

    public BigDecimal getChargingPrice() {
        return chargingPrice;
    }

    public void setChargingPrice(BigDecimal chargingPrice) {
        this.chargingPrice = chargingPrice;
    }

    public Byte getChargingStatus() {
        return chargingStatus;
    }

    public void setChargingStatus(Byte chargingStatus) {
        this.chargingStatus = chargingStatus;
    }

    public String getEndReason() {
        return endReason;
    }

    public void setEndReason(String endReason) {
        this.endReason = endReason;
    }

    public BigDecimal getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(BigDecimal servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Integer getChargingPower() {
        return chargingPower;
    }

    public void setChargingPower(Integer chargingPower) {
        this.chargingPower = chargingPower;
    }

    public Long getPlanChargingTime() {
        return planChargingTime;
    }

    public void setPlanChargingTime(Long planChargingTime) {
        this.planChargingTime = planChargingTime;
    }

    public Byte getChargingType() {
        return chargingType;
    }

    public void setChargingType(Byte chargingType) {
        this.chargingType = chargingType;
    }

    public CfChargingStation getCfChargingStation() {
        return cfChargingStation;
    }

    public void setCfChargingStation(CfChargingStation cfChargingStation) {
        this.cfChargingStation = cfChargingStation;
    }

    public CfChargingStationDevice getCfChargingStationDevice() {
        return cfChargingStationDevice;
    }

    public void setCfChargingStationDevice(CfChargingStationDevice cfChargingStationDevice) {
        this.cfChargingStationDevice = cfChargingStationDevice;
    }

    public CfChargingPort getCfChargingPort() {
        return cfChargingPort;
    }

    public void setCfChargingPort(CfChargingPort cfChargingPort) {
        this.cfChargingPort = cfChargingPort;
    }

    public CfOrder getCfOrder() {
        return cfOrder;
    }

    public void setCfOrder(CfOrder cfOrder) {
        this.cfOrder = cfOrder;
    }
}