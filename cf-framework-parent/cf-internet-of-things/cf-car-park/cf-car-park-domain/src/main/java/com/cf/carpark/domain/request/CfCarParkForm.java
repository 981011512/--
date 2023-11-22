package com.cf.carpark.domain.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

public class CfCarParkForm implements Serializable {
    private String id;

    @ApiModelProperty(value = "停车场名", required = true)
    private String name;

    @ApiModelProperty(value = "图片", required = true)
    private String image;

    @ApiModelProperty(value = "经度", example = "123.521457412475", required = true, notes = "保留12位小数")
    @Digits(integer = 4,fraction = 12, message = "经度最多保留12位小数")
    @Min(value = -180, message = "经度最小值-180")
    @Max(value = 180, message = "经度最大值180")
    private BigDecimal positionX;

    @ApiModelProperty(value = "纬度", example = "56.587451245896", required = true, notes = "保留12位小数")
    @Digits(integer = 3,fraction = 12, message = "纬度最多保留12位小数")
    @Min(value = -90, message = "纬度最小值-90")
    @Max(value = 90, message = "纬度最大值90")
    private BigDecimal positionY;

    @ApiModelProperty(value = "开始营业时间", example = "true", required = true)
    @Min(value = 0, message = "开始营业时间>=0")
    private Long startBusinessHours;

    @ApiModelProperty(value = "结束营业时间", example = "true", required = true)
    @Min(value = 0, message = "结束营业时间>=0")
    private Long endBusinessHours;

    @ApiModelProperty(value = "总车位数", example = "true", required = true)
    @Min(value = 1, message = "总车位数>=1")
    private Integer parkingSpaceNumber;

    @ApiModelProperty(value = "已使用车位数", example = "true", required = true)
    @Min(value = 0, message = "已使用车位数>=0")
    private Integer usedParkingSpaceNumber;

    @ApiModelProperty(value = "停车场地址", example = "true", required = true)
    private String address;

    @ApiModelProperty(value = "停车场负责人手机号", example = "true", required = true)
    @Pattern(regexp = "^(1[3-9])[0-9]{9}$", message = "手机号不合法")
    private String phone;

    @ApiModelProperty(value = "停车场座机号码", example = "true", required = true)
    private String landline;

    @ApiModelProperty(value = "停车场状态(0-正常/1-车位已满/2-暂停营业)", example = "true", required = true, allowableValues = "0,1,2")
    private Byte status;

    @ApiModelProperty(value = "国家id", example = "true", required = true)
    private String countryId;

    @ApiModelProperty(value = "省id", example = "true", required = true)
    private String provinceId;

    @ApiModelProperty(value = "州或市id", example = "true", required = true)
    private String stateOrCityId;

    @ApiModelProperty(value = "区或县id", example = "true", required = true)
    private String zoneOrCountyId;

    @ApiModelProperty(value = "乡镇id", example = "true", required = true)
    private String townshipId;

    private Long freeTime;

    private BigDecimal score;

    private Integer numberOfComments;

    private BigDecimal feeUpperLimit;

    private BigDecimal startingPrice;

    private Long unitDuration;

    private String billingModel;

    private Long minAdvanceSubscribeTime;

    private Long maxAdvanceSubscribeTime;

    private Long subscribeFreeTime;

    private BigDecimal subscribeFee;

    private Byte subscribeTimeoutFee;

    private String createrId;

    private Byte specialFeeExpiredCar;

    private Byte showExpiredCarType;

    private Long expiredCarFreeTime;

    private Byte showRemarks;

    private String collectionCarparkId;

    private Byte limitParkingSpaceNumber;

    private Byte allowEditUseLog;

    private Byte abnormalAutoRelease;

    private Byte autoIssuedWhitelist;

    private String adminer;

    private Byte forbidGroupFlagSameTimeIn;

    private BigDecimal currentPrice;

    private String chargingStationId;

    private String dataReportPlatform;

    private Long leaveTimeLimit;

    private String specialNumberPlate;

    private Long storehouseId;

    private Byte numberPlateColorToCarType;

    private Byte packageGroupFlagFreeTimeChange;

    private Byte visitProcessMode;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        this.countryId = countryId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getStateOrCityId() {
        return stateOrCityId;
    }

    public void setStateOrCityId(String stateOrCityId) {
        this.stateOrCityId = stateOrCityId;
    }

    public String getZoneOrCountyId() {
        return zoneOrCountyId;
    }

    public void setZoneOrCountyId(String zoneOrCountyId) {
        this.zoneOrCountyId = zoneOrCountyId;
    }

    public String getTownshipId() {
        return townshipId;
    }

    public void setTownshipId(String townshipId) {
        this.townshipId = townshipId;
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
        this.billingModel = billingModel;
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
        this.createrId = createrId;
    }

    public BigDecimal getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(BigDecimal startingPrice) {
        this.startingPrice = startingPrice;
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
        this.collectionCarparkId = collectionCarparkId;
    }

    public Byte getLimitParkingSpaceNumber() {
        return limitParkingSpaceNumber;
    }

    public void setLimitParkingSpaceNumber(Byte limitParkingSpaceNumber) {
        this.limitParkingSpaceNumber = limitParkingSpaceNumber;
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

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
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