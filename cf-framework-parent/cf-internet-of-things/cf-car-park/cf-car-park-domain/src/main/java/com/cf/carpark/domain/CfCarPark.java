package com.cf.carpark.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CfCarPark implements Serializable {
    private String id;

    private String name;

    private String image;

    private BigDecimal positionX;

    private BigDecimal positionY;

    private Long startBusinessHours;

    private Long endBusinessHours;

    private Integer parkingSpaceNumber;

    private Integer usedParkingSpaceNumber;

    private String address;

    private String phone;

    private String landline;

    private Byte status;

    private String countryId;

    private String provinceId;

    private String stateOrCityId;

    private String zoneOrCountyId;

    private String townshipId;

    private Long freeTime;

    private BigDecimal score;

    private Integer numberOfComments;

    private BigDecimal feeUpperLimit;

    private BigDecimal startingPrice;

    private Long unitDuration;

    private String billingModel;

    private BigDecimal distance;

    private Integer checkPointCounts;

    private Long minAdvanceSubscribeTime;

    private Long maxAdvanceSubscribeTime;

    private Long subscribeFreeTime;

    private BigDecimal subscribeFee;

    private Byte subscribeTimeoutFee;

    private String createrId;

    private Byte specialFeeExpiredCar;

    private Byte showExpiredCarType;

    private List<CfCarParkChargingRules> cfCarParkChargingRules;

    private List<CfCarParkCheckpoint> cfCarParkCheckpointList;

    private BigDecimal currentPrice;

    private String currentGroupFlag;

    private BigDecimal currentFeeUpperLimit;

    private BigDecimal activityDenomination;

    private Long expiredCarFreeTime;

    private Byte showRemarks;

    private String collectionCarparkId;

    private Byte limitParkingSpaceNumber;

    private Byte allowEditUseLog;

    private Byte abnormalAutoRelease;

    private Byte autoIssuedWhitelist;

    private String adminer;

    private Byte forbidGroupFlagSameTimeIn;

    private String chargingStationId;

    private String dataReportPlatform;

    private Long leaveTimeLimit;

    private String specialNumberPlate;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long storehouseId;

    private Byte numberPlateColorToCarType;

    private Byte packageGroupFlagFreeTimeChange;

    private Byte visitProcessMode;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public BigDecimal getPositionX() {
        return positionX;
    }

    public void setPositionX(BigDecimal positionX) {
        this.positionX = positionX;
    }

    public BigDecimal getPositionY() {
        return positionY;
    }

    public void setPositionY(BigDecimal positionY) {
        this.positionY = positionY;
    }

    public Long getStartBusinessHours() {
        return startBusinessHours;
    }

    public void setStartBusinessHours(Long startBusinessHours) {
        this.startBusinessHours = startBusinessHours;
    }

    public Long getEndBusinessHours() {
        return endBusinessHours;
    }

    public void setEndBusinessHours(Long endBusinessHours) {
        this.endBusinessHours = endBusinessHours;
    }

    public Integer getParkingSpaceNumber() {
        return parkingSpaceNumber;
    }

    public void setParkingSpaceNumber(Integer parkingSpaceNumber) {
        this.parkingSpaceNumber = parkingSpaceNumber;
    }

    public Integer getUsedParkingSpaceNumber() {
        return usedParkingSpaceNumber;
    }

    public void setUsedParkingSpaceNumber(Integer usedParkingSpaceNumber) {
        this.usedParkingSpaceNumber = usedParkingSpaceNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline == null ? null : landline.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId == null ? null : countryId.trim();
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    public String getStateOrCityId() {
        return stateOrCityId;
    }

    public void setStateOrCityId(String stateOrCityId) {
        this.stateOrCityId = stateOrCityId == null ? null : stateOrCityId.trim();
    }

    public String getZoneOrCountyId() {
        return zoneOrCountyId;
    }

    public void setZoneOrCountyId(String zoneOrCountyId) {
        this.zoneOrCountyId = zoneOrCountyId == null ? null : zoneOrCountyId.trim();
    }

    public String getTownshipId() {
        return townshipId;
    }

    public void setTownshipId(String townshipId) {
        this.townshipId = townshipId == null ? null : townshipId.trim();
    }

    public Long getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(Long freeTime) {
        this.freeTime = freeTime;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(Integer numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public BigDecimal getFeeUpperLimit() {
        return feeUpperLimit;
    }

    public void setFeeUpperLimit(BigDecimal feeUpperLimit) {
        this.feeUpperLimit = feeUpperLimit;
    }

    public Long getUnitDuration() {
        return unitDuration;
    }

    public void setUnitDuration(Long unitDuration) {
        this.unitDuration = unitDuration;
    }

    public String getBillingModel() {
        return billingModel;
    }

    public void setBillingModel(String billingModel) {
        this.billingModel = billingModel == null ? null : billingModel.trim();
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Integer getCheckPointCounts() {
        return checkPointCounts;
    }

    public void setCheckPointCounts(Integer checkPointCounts) {
        this.checkPointCounts = checkPointCounts;
    }

    public Long getMinAdvanceSubscribeTime() {
        return minAdvanceSubscribeTime;
    }

    public void setMinAdvanceSubscribeTime(Long minAdvanceSubscribeTime) {
        this.minAdvanceSubscribeTime = minAdvanceSubscribeTime;
    }

    public Long getMaxAdvanceSubscribeTime() {
        return maxAdvanceSubscribeTime;
    }

    public void setMaxAdvanceSubscribeTime(Long maxAdvanceSubscribeTime) {
        this.maxAdvanceSubscribeTime = maxAdvanceSubscribeTime;
    }

    public Long getSubscribeFreeTime() {
        return subscribeFreeTime;
    }

    public void setSubscribeFreeTime(Long subscribeFreeTime) {
        this.subscribeFreeTime = subscribeFreeTime;
    }

    public BigDecimal getSubscribeFee() {
        return subscribeFee;
    }

    public void setSubscribeFee(BigDecimal subscribeFee) {
        this.subscribeFee = subscribeFee;
    }

    public Byte getSubscribeTimeoutFee() {
        return subscribeTimeoutFee;
    }

    public void setSubscribeTimeoutFee(Byte subscribeTimeoutFee) {
        this.subscribeTimeoutFee = subscribeTimeoutFee;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    public List<CfCarParkChargingRules> getCfCarParkChargingRules() {
        return cfCarParkChargingRules;
    }

    public void setCfCarParkChargingRules(List<CfCarParkChargingRules> cfCarParkChargingRules) {
        this.cfCarParkChargingRules = cfCarParkChargingRules;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public BigDecimal getActivityDenomination() {
        return activityDenomination;
    }

    public void setActivityDenomination(BigDecimal activityDenomination) {
        this.activityDenomination = activityDenomination;
    }

    public BigDecimal getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(BigDecimal startingPrice) {
        this.startingPrice = startingPrice;
    }

    public List<CfCarParkCheckpoint> getCfCarParkCheckpointList() {
        return cfCarParkCheckpointList;
    }

    public void setCfCarParkCheckpointList(List<CfCarParkCheckpoint> cfCarParkCheckpointList) {
        this.cfCarParkCheckpointList = cfCarParkCheckpointList;
    }

    public Byte getSpecialFeeExpiredCar() {
        return specialFeeExpiredCar;
    }

    public void setSpecialFeeExpiredCar(Byte specialFeeExpiredCar) {
        this.specialFeeExpiredCar = specialFeeExpiredCar;
    }

    public Byte getShowExpiredCarType() {
        return showExpiredCarType;
    }

    public void setShowExpiredCarType(Byte showExpiredCarType) {
        this.showExpiredCarType = showExpiredCarType;
    }

    public Long getExpiredCarFreeTime() {
        return expiredCarFreeTime;
    }

    public void setExpiredCarFreeTime(Long expiredCarFreeTime) {
        this.expiredCarFreeTime = expiredCarFreeTime;
    }

    public Byte getShowRemarks() {
        return showRemarks;
    }

    public void setShowRemarks(Byte showRemarks) {
        this.showRemarks = showRemarks;
    }

    public String getCollectionCarparkId() {
        return collectionCarparkId;
    }

    public void setCollectionCarparkId(String collectionCarparkId) {
        this.collectionCarparkId = collectionCarparkId == null ? null : collectionCarparkId.trim();
    }

    public Byte getLimitParkingSpaceNumber() {
        return limitParkingSpaceNumber;
    }

    public void setLimitParkingSpaceNumber(Byte limitParkingSpaceNumber) {
        this.limitParkingSpaceNumber = limitParkingSpaceNumber;
    }

    public String getCurrentGroupFlag() {
        return currentGroupFlag;
    }

    public void setCurrentGroupFlag(String currentGroupFlag) {
        this.currentGroupFlag = currentGroupFlag;
    }

    public BigDecimal getCurrentFeeUpperLimit() {
        return currentFeeUpperLimit;
    }

    public void setCurrentFeeUpperLimit(BigDecimal currentFeeUpperLimit) {
        this.currentFeeUpperLimit = currentFeeUpperLimit;
    }

    public Byte getAllowEditUseLog() {
        return allowEditUseLog;
    }

    public void setAllowEditUseLog(Byte allowEditUseLog) {
        this.allowEditUseLog = allowEditUseLog;
    }

    public Byte getAbnormalAutoRelease() {
        return abnormalAutoRelease;
    }

    public void setAbnormalAutoRelease(Byte abnormalAutoRelease) {
        this.abnormalAutoRelease = abnormalAutoRelease;
    }

    public Byte getAutoIssuedWhitelist() {
        return autoIssuedWhitelist;
    }

    public void setAutoIssuedWhitelist(Byte autoIssuedWhitelist) {
        this.autoIssuedWhitelist = autoIssuedWhitelist;
    }

    public String getAdminer() {
        return adminer;
    }

    public void setAdminer(String adminer) {
        this.adminer = adminer;
    }

    public Byte getForbidGroupFlagSameTimeIn() {
        return forbidGroupFlagSameTimeIn;
    }

    public void setForbidGroupFlagSameTimeIn(Byte forbidGroupFlagSameTimeIn) {
        this.forbidGroupFlagSameTimeIn = forbidGroupFlagSameTimeIn;
    }

    public String getChargingStationId() {
        return chargingStationId;
    }

    public void setChargingStationId(String chargingStationId) {
        this.chargingStationId = chargingStationId;
    }

    public String getDataReportPlatform() {
        return dataReportPlatform;
    }

    public void setDataReportPlatform(String dataReportPlatform) {
        this.dataReportPlatform = dataReportPlatform;
    }

    public Long getLeaveTimeLimit() {
        return leaveTimeLimit;
    }

    public void setLeaveTimeLimit(Long leaveTimeLimit) {
        this.leaveTimeLimit = leaveTimeLimit;
    }

    public String getSpecialNumberPlate() {
        return specialNumberPlate;
    }

    public void setSpecialNumberPlate(String specialNumberPlate) {
        this.specialNumberPlate = specialNumberPlate;
    }

    public Long getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(Long storehouseId) {
        this.storehouseId = storehouseId;
    }

    public Byte getNumberPlateColorToCarType() {
        return numberPlateColorToCarType;
    }

    public void setNumberPlateColorToCarType(Byte numberPlateColorToCarType) {
        this.numberPlateColorToCarType = numberPlateColorToCarType;
    }

    public Byte getPackageGroupFlagFreeTimeChange() {
        return packageGroupFlagFreeTimeChange;
    }

    public void setPackageGroupFlagFreeTimeChange(Byte packageGroupFlagFreeTimeChange) {
        this.packageGroupFlagFreeTimeChange = packageGroupFlagFreeTimeChange;
    }

    public Byte getVisitProcessMode() {
        return visitProcessMode;
    }

    public void setVisitProcessMode(Byte visitProcessMode) {
        this.visitProcessMode = visitProcessMode;
    }
}