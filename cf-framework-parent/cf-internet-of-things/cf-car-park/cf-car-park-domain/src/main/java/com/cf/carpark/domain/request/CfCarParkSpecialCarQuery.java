package com.cf.carpark.domain.request;

import java.io.Serializable;
import java.util.List;

public class CfCarParkSpecialCarQuery implements Serializable {
    private String id;

    private String carParkId;

    private List<String> carParkIds;

    private String typeKey;

    private Long minStartTime;

    private Long maxStartTime;

    private Long minEndTime;

    private Long maxEndTime;

    private Long minCreateTime;

    private Long maxCreateTime;

    private String uid;

    private String numberPlate;

    private String phone;

    private String remarks;

    private String carOwnerName;

    private String groupFlag;

    private Byte status;

    private String autoGiveAwayDate;

    private Byte autoGiveAway;

    private Long maxAutoGiveAwayTime;

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

    public List<String> getCarParkIds() {
        return carParkIds;
    }

    public void setCarParkIds(List<String> carParkIds) {
        this.carParkIds = carParkIds;
    }

    public String getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey == null ? null : typeKey.trim();
    }

    public Long getMinStartTime() {
        return minStartTime;
    }

    public void setMinStartTime(Long minStartTime) {
        this.minStartTime = minStartTime;
    }

    public Long getMaxStartTime() {
        return maxStartTime;
    }

    public void setMaxStartTime(Long maxStartTime) {
        this.maxStartTime = maxStartTime;
    }

    public Long getMinEndTime() {
        return minEndTime;
    }

    public void setMinEndTime(Long minEndTime) {
        this.minEndTime = minEndTime;
    }

    public Long getMaxEndTime() {
        return maxEndTime;
    }

    public void setMaxEndTime(Long maxEndTime) {
        this.maxEndTime = maxEndTime;
    }

    public Long getMinCreateTime() {
        return minCreateTime;
    }

    public void setMinCreateTime(Long minCreateTime) {
        this.minCreateTime = minCreateTime;
    }

    public Long getMaxCreateTime() {
        return maxCreateTime;
    }

    public void setMaxCreateTime(Long maxCreateTime) {
        this.maxCreateTime = maxCreateTime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate == null ? null : numberPlate.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getCarOwnerName() {
        return carOwnerName;
    }

    public void setCarOwnerName(String carOwnerName) {
        this.carOwnerName = carOwnerName == null ? null : carOwnerName.trim();
    }

    public String getGroupFlag() {
        return groupFlag;
    }

    public void setGroupFlag(String groupFlag) {
        this.groupFlag = groupFlag == null ? null : groupFlag.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getAutoGiveAwayDate() {
        return autoGiveAwayDate;
    }

    public void setAutoGiveAwayDate(String autoGiveAwayDate) {
        this.autoGiveAwayDate = autoGiveAwayDate;
    }

    public Byte getAutoGiveAway() {
        return autoGiveAway;
    }

    public void setAutoGiveAway(Byte autoGiveAway) {
        this.autoGiveAway = autoGiveAway;
    }

    public Long getMaxAutoGiveAwayTime() {
        return maxAutoGiveAwayTime;
    }

    public void setMaxAutoGiveAwayTime(Long maxAutoGiveAwayTime) {
        this.maxAutoGiveAwayTime = maxAutoGiveAwayTime;
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