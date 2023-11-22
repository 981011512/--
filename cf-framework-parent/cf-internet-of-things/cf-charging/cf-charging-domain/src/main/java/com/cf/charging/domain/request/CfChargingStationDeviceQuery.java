package com.cf.charging.domain.request;

import java.io.Serializable;
import java.util.List;

public class CfChargingStationDeviceQuery implements Serializable {
    private String id;

    private List<String> ids;

    private String chargingStationId;

    private String barCode;

    private List<String> barCodes;

    private String brand;

    private String model;

    private Byte status;

    private Long lastOnlineTime;

    private Long minLastOnlineTime;

    private Long maxLastOnlineTime;

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

    private Integer page;

    private Integer size;

    private String orderBy;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
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

    public List<String> getBarCodes() {
        return barCodes;
    }

    public void setBarCodes(List<String> barCodes) {
        this.barCodes = barCodes;
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

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}