package com.cf.carpark.domain.request;

import java.io.Serializable;
import java.util.List;

public class CfCarParkUseLogQuery implements Serializable {

    private List<String> ids;

    private String numberPlate;

    private String numberPlateLK;

    private String uid;

    private List<String> numberPlates;

    private String carParkId;

    private List<String> carParkIds;

    private Long subscribeTime;

    private Long minSubscribeTime;

    private Long maxSubscribeTime;

    private Long cancelSubscribeTime;

    private Long minCancelSubscribeTime;

    private Long maxCancelSubscribeTime;

    private Long inTime;

    private Long minInTime;

    private Long maxInTime;

    private Long outTime;

    private Long minOutTime;

    private Long maxOutTime;

    private Byte inReleaseType;

    private Byte outReleaseType;

    private String inCheckPointId;

    private String outCheckPointId;

    private Long createTime;

    private Long minCreateTime;

    private Long maxCreateTime;

    private String createPosition;

    private Long payTime;

    private Long minPayTime;

    private Long MaxPayTime;

    private String inHandleUid;

    private String outHandleUid;

    private String orderBy;

    private Integer page;

    private Integer size;

    private Byte countFeeStatus;

    private String remarks;

    private Long totalTime;

    private String carType;

    private String countField;

    private Byte carNumberPlateColor;

    private String visitUnit;

    private static final long serialVersionUID = 1L;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate == null ? null : numberPlate.trim();
    }

    public String getNumberPlateLK() {
        return numberPlateLK;
    }

    public void setNumberPlateLK(String numberPlateLK) {
        this.numberPlateLK = numberPlateLK;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<String> getNumberPlates() {
        return numberPlates;
    }

    public void setNumberPlates(List<String> numberPlates) {
        this.numberPlates = numberPlates;
    }

    public String getCarParkId() {
        return carParkId;
    }

    public void setCarParkId(String carParkId) {
        this.carParkId = carParkId == null ? null : carParkId.trim();
    }

    public Long getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Long subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public Long getCancelSubscribeTime() {
        return cancelSubscribeTime;
    }

    public void setCancelSubscribeTime(Long cancelSubscribeTime) {
        this.cancelSubscribeTime = cancelSubscribeTime;
    }

    public Long getMinSubscribeTime() {
        return minSubscribeTime;
    }

    public void setMinSubscribeTime(Long minSubscribeTime) {
        this.minSubscribeTime = minSubscribeTime;
    }

    public Long getMaxSubscribeTime() {
        return maxSubscribeTime;
    }

    public void setMaxSubscribeTime(Long maxSubscribeTime) {
        this.maxSubscribeTime = maxSubscribeTime;
    }

    public Long getMinCancelSubscribeTime() {
        return minCancelSubscribeTime;
    }

    public void setMinCancelSubscribeTime(Long minCancelSubscribeTime) {
        this.minCancelSubscribeTime = minCancelSubscribeTime;
    }

    public Long getMaxCancelSubscribeTime() {
        return maxCancelSubscribeTime;
    }

    public void setMaxCancelSubscribeTime(Long maxCancelSubscribeTime) {
        this.maxCancelSubscribeTime = maxCancelSubscribeTime;
    }

    public Long getInTime() {
        return inTime;
    }

    public void setInTime(Long inTime) {
        this.inTime = inTime;
    }

    public Long getOutTime() {
        return outTime;
    }

    public void setOutTime(Long outTime) {
        this.outTime = outTime;
    }

    public Byte getInReleaseType() {
        return inReleaseType;
    }

    public void setInReleaseType(Byte inReleaseType) {
        this.inReleaseType = inReleaseType;
    }

    public Byte getOutReleaseType() {
        return outReleaseType;
    }

    public void setOutReleaseType(Byte outReleaseType) {
        this.outReleaseType = outReleaseType;
    }

    public String getInCheckPointId() {
        return inCheckPointId;
    }

    public void setInCheckPointId(String inCheckPointId) {
        this.inCheckPointId = inCheckPointId == null ? null : inCheckPointId.trim();
    }

    public String getOutCheckPointId() {
        return outCheckPointId;
    }

    public void setOutCheckPointId(String outCheckPointId) {
        this.outCheckPointId = outCheckPointId == null ? null : outCheckPointId.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getMinInTime() {
        return minInTime;
    }

    public void setMinInTime(Long minInTime) {
        this.minInTime = minInTime;
    }

    public Long getMaxInTime() {
        return maxInTime;
    }

    public void setMaxInTime(Long maxInTime) {
        this.maxInTime = maxInTime;
    }

    public Long getMinOutTime() {
        return minOutTime;
    }

    public void setMinOutTime(Long minOutTime) {
        this.minOutTime = minOutTime;
    }

    public Long getMaxOutTime() {
        return maxOutTime;
    }

    public void setMaxOutTime(Long maxOutTime) {
        this.maxOutTime = maxOutTime;
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

    public String getCreatePosition() {
        return createPosition;
    }

    public void setCreatePosition(String createPosition) {
        this.createPosition = createPosition;
    }

    public Long getPayTime() {
        return payTime;
    }

    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    public Long getMinPayTime() {
        return minPayTime;
    }

    public void setMinPayTime(Long minPayTime) {
        this.minPayTime = minPayTime;
    }

    public Long getMaxPayTime() {
        return MaxPayTime;
    }

    public void setMaxPayTime(Long maxPayTime) {
        MaxPayTime = maxPayTime;
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

    public List<String> getCarParkIds() {
        return carParkIds;
    }

    public void setCarParkIds(List<String> carParkIds) {
        this.carParkIds = carParkIds;
    }

    public String getInHandleUid() {
        return inHandleUid;
    }

    public void setInHandleUid(String inHandleUid) {
        this.inHandleUid = inHandleUid;
    }

    public String getOutHandleUid() {
        return outHandleUid;
    }

    public void setOutHandleUid(String outHandleUid) {
        this.outHandleUid = outHandleUid;
    }

    public Byte getCountFeeStatus() {
        return countFeeStatus;
    }

    public void setCountFeeStatus(Byte countFeeStatus) {
        this.countFeeStatus = countFeeStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Long totalTime) {
        this.totalTime = totalTime;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCountField() {
        return countField;
    }

    public void setCountField(String countField) {
        this.countField = countField;
    }

    public Byte getCarNumberPlateColor() {
        return carNumberPlateColor;
    }

    public void setCarNumberPlateColor(Byte carNumberPlateColor) {
        this.carNumberPlateColor = carNumberPlateColor;
    }

    public String getVisitUnit() {
        return visitUnit;
    }

    public void setVisitUnit(String visitUnit) {
        this.visitUnit = visitUnit;
    }
}