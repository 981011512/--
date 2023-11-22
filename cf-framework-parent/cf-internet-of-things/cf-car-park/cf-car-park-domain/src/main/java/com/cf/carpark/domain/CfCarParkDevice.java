package com.cf.carpark.domain;

import java.io.Serializable;

public class CfCarParkDevice implements Serializable {
    private String id;

    private String carParkId;

    private String barCode;

    private String brand;

    private String model;

    private Byte status;

    private Long lastOnlineTime;

    private String linkMode;

    private Byte type;

    private String checkpointId;

    private String productId;

    private String direction;

    private CfCarPark cfCarPark;

    private CfCarParkCheckpoint cfCarParkCheckpoint;

    private String playContents;

    private String ip;

    private String videoAddress;

    private String historyVideoAddress;

    private String username;

    private String password;

    private Byte indexNo;

    private Byte noticed;

    private String videoMode;

    private Byte rows;

    private String macAddress;

    private String deviceName;

    private String deviceNo;

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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
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

    public String getPlayContents() {
        return playContents;
    }

    public void setPlayContents(String playContents) {
        this.playContents = playContents;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getVideoAddress() {
        return videoAddress;
    }

    public void setVideoAddress(String videoAddress) {
        this.videoAddress = videoAddress;
    }

    public String getHistoryVideoAddress() {
        return historyVideoAddress;
    }

    public void setHistoryVideoAddress(String historyVideoAddress) {
        this.historyVideoAddress = historyVideoAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getVideoMode() {
        return videoMode;
    }

    public void setVideoMode(String videoMode) {
        this.videoMode = videoMode;
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
        this.macAddress = macAddress;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }
}