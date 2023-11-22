package com.cf.logistics.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

public class CfLogisticsLedDevice implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long queuingAreaId;

    private String serialNumber;

    private String brand;

    private String model;

    private Byte status;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long lastOnlineTime;

    private String linkMode;

    private Byte type;

    private String productId;

    private String playContents;

    private String ip;

    private String username;

    private String password;

    private Byte indexNo;

    private Byte noticed;

    private Byte rows;

    private String macAddress;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQueuingAreaId() {
        return queuingAreaId;
    }

    public void setQueuingAreaId(Long queuingAreaId) {
        this.queuingAreaId = queuingAreaId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
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
}