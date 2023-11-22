package com.cf.carpark.domain.request;

import java.io.Serializable;
import java.util.List;

public class CfCarParkDeviceQuery implements Serializable {
    private String id;

    private List<String> ids;

    private String carParkId;

    private String barCode;

    private List<String> barCodes;

    private String model;

    private String brand;

    private Byte status;

    private Long minLastOnlineTime;

    private Long maxLastOnlineTime;

    private String linkMode;

    private Byte type;

    private String checkpointId;

    private List<String> checkpointIds;

    private String productId;

    private String direction;

    private Byte noticed;

    private String username;

    private String password;

    private String macAddress;

    private String deviceName;

    private String deviceNo;

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getMinLastOnlineTime() {
        return minLastOnlineTime;
    }

    public void setMinLastOnlineTime(Long minLastOnlineTime) {
        this.minLastOnlineTime = minLastOnlineTime;
    }

    public Long getMaxLastOnlineTime() {
        return maxLastOnlineTime;
    }

    public void setMaxLastOnlineTime(Long maxLastOnlineTime) {
        this.maxLastOnlineTime = maxLastOnlineTime;
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

    public List<String> getCheckpointIds() {
        return checkpointIds;
    }

    public void setCheckpointIds(List<String> checkpointIds) {
        this.checkpointIds = checkpointIds;
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

    public Byte getNoticed() {
        return noticed;
    }

    public void setNoticed(Byte noticed) {
        this.noticed = noticed;
    }

    public List<String> getBarCodes() {
        return barCodes;
    }

    public void setBarCodes(List<String> barCodes) {
        this.barCodes = barCodes;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
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