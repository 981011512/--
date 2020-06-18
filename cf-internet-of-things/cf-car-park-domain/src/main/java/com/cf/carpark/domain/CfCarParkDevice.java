package com.cf.carpark.domain;

import java.io.Serializable;

public class CfCarParkDevice implements Serializable {
    private String id;

    private String carParkId;

    private String deviceBrandId;

    private String barCode;

    private String model;

    private String vendorId;

    private Byte status;

    private Long lastOnlineTime;

    private String linkMode;

    private Byte type;

    private String checkpointId;

    private String productId;

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

    public String getDeviceBrandId() {
        return deviceBrandId;
    }

    public void setDeviceBrandId(String deviceBrandId) {
        this.deviceBrandId = deviceBrandId == null ? null : deviceBrandId.trim();
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId == null ? null : vendorId.trim();
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
}