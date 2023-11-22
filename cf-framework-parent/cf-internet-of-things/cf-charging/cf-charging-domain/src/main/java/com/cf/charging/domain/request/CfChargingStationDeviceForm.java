package com.cf.charging.domain.request;

import com.cf.charging.domain.customize.CfChargingDeviceSetting;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfChargingStationDeviceForm implements Serializable {
    private String id;

    private String chargingStationId;

    private String barCode;

    private String brand;

    private String model;

    private Byte status;

    private Long lastOnlineTime;

    private String linkMode;

    private Byte type;

    private String checkpointId;

    private String productId;

    private String playContents;

    private String ip;

    private String videoAddress;

    private String historyVideoAddress;

    private String username;

    private String password;

    private Byte indexNo;

    private Byte noticed;

    private Byte rows;

    private String macAddress;

    private Integer power;

    private Byte chargingPort;    //充电口(开始充电或者结束充电时，该字段要传)

    private BigDecimal chargingFee;    //充电金额(开始充电或者结束充电时，该字段要传)

    private String uid; //用户id

    private CfChargingDeviceSetting cfChargingDeviceSetting;    //设置充电设备配置的时候需要传入

    private Byte powerType;

    private String aliasName;

    private String chargingUseLogId;    //结束充电时需要传入

    private Long planChargingTime;  //计划充电时间

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

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getLastOnlineTime() {
        return lastOnlineTime;
    }

    public void setLastOnlineTime(Long lastOnlineTime) {
        this.lastOnlineTime = lastOnlineTime;
    }

    public String getLinkMode() {
        return linkMode;
    }

    public void setLinkMode(String linkMode) {
        this.linkMode = linkMode == null ? null : linkMode.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getCheckpointId() {
        return checkpointId;
    }

    public void setCheckpointId(String checkpointId) {
        this.checkpointId = checkpointId == null ? null : checkpointId.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getPlayContents() {
        return playContents;
    }

    public void setPlayContents(String playContents) {
        this.playContents = playContents == null ? null : playContents.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getVideoAddress() {
        return videoAddress;
    }

    public void setVideoAddress(String videoAddress) {
        this.videoAddress = videoAddress == null ? null : videoAddress.trim();
    }

    public String getHistoryVideoAddress() {
        return historyVideoAddress;
    }

    public void setHistoryVideoAddress(String historyVideoAddress) {
        this.historyVideoAddress = historyVideoAddress == null ? null : historyVideoAddress.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(Byte indexNo) {
        this.indexNo = indexNo;
    }

    public Byte getNoticed() {
        return noticed;
    }

    public void setNoticed(Byte noticed) {
        this.noticed = noticed;
    }

    public Byte getRows() {
        return rows;
    }

    public void setRows(Byte rows) {
        this.rows = rows;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress == null ? null : macAddress.trim();
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Byte getChargingPort() {
        return chargingPort;
    }

    public void setChargingPort(Byte chargingPort) {
        this.chargingPort = chargingPort;
    }

    public CfChargingDeviceSetting getCfChargingDeviceSetting() {
        return cfChargingDeviceSetting;
    }

    public void setCfChargingDeviceSetting(CfChargingDeviceSetting cfChargingDeviceSetting) {
        this.cfChargingDeviceSetting = cfChargingDeviceSetting;
    }

    public BigDecimal getChargingFee() {
        return chargingFee;
    }

    public void setChargingFee(BigDecimal chargingFee) {
        this.chargingFee = chargingFee;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Byte getPowerType() {
        return powerType;
    }

    public void setPowerType(Byte powerType) {
        this.powerType = powerType;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getChargingUseLogId() {
        return chargingUseLogId;
    }

    public void setChargingUseLogId(String chargingUseLogId) {
        this.chargingUseLogId = chargingUseLogId;
    }

    public Long getPlanChargingTime() {
        return planChargingTime;
    }

    public void setPlanChargingTime(Long planChargingTime) {
        this.planChargingTime = planChargingTime;
    }
}