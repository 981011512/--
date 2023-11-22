package com.cf.carpark.domain.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CfCarParkQuery implements Serializable {
    private String id;

    private List<String> ids;

    private String name;

    private String image;

    private BigDecimal positionX;

    private BigDecimal positionY;

    private BigDecimal minPositionX;

    private BigDecimal maxPositionX;

    private BigDecimal minPositionY;

    private BigDecimal maxPositionY;

    private Long minStartBusinessHours;

    private Long maxStartBusinessHours;

    private Long minEndBusinessHours;

    private Long maxEndBusinessHours;

    private Integer minParkingSpaceNumber;

    private Integer maxParkingSpaceNumber;

    private Integer minUsedParkingSpaceNumber;

    private Integer maxUsedParkingSpaceNumber;

    private String address;

    private String phone;

    private String landline;

    private Byte status;

    private String countryId;

    private String provinceId;

    private String stateOrCityId;

    private String zoneOrCountyId;

    private String townshipId;

    private Long minFreeTime;

    private Long maxFreeTime;

    private BigDecimal minScore;

    private BigDecimal maxScore;

    private Integer minNumberOfComments;

    private Integer maxNumberOfComments;

    private BigDecimal minFeeUpperLimit;

    private BigDecimal maxFeeUpperLimit;

    private BigDecimal minStartingPrice;

    private BigDecimal maxStartingPrice;

    private Long minUnitDuration;

    private Long maxUnitDuration;

    private String billingModel;

    private Long minAdvanceSubscribeTime;

    private Long maxAdvanceSubscribeTime;

    private Long subscribeFreeTime;

    private BigDecimal subscribeFee;

    private Byte subscribeTimeoutFee;

    private Short showDistance;

    private String orderBy;
    @ApiModelProperty(value = "页码数(1-100)", required = true)
    @Min(value = 1, message = "最小页码数1")
    @Max(value = 100, message = "最大页码数100")
    private Integer page;
    @ApiModelProperty(value = "每页请求数(3-30)", required = true)
    @Min(value = 3, message = "最小每页请求数3")
    @Max(value = 30, message = "最大每页请求数30")
    private Integer size;

    private String createrId;

    private Byte specialFeeExpiredCar;

    private Byte showExpiredCarType;

    private Integer distance;

    private Long currentHourTime;

    private Long currentTimeStamp;

    private String chargingStationId;

    private String countField;

    private Byte visitProcessMode;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public BigDecimal getMinPositionX() {
        return minPositionX;
    }

    public void setMinPositionX(BigDecimal minPositionX) {
        this.minPositionX = minPositionX;
    }

    public BigDecimal getMaxPositionX() {
        return maxPositionX;
    }

    public void setMaxPositionX(BigDecimal maxPositionX) {
        this.maxPositionX = maxPositionX;
    }

    public BigDecimal getMinPositionY() {
        return minPositionY;
    }

    public void setMinPositionY(BigDecimal minPositionY) {
        this.minPositionY = minPositionY;
    }

    public BigDecimal getMaxPositionY() {
        return maxPositionY;
    }

    public void setMaxPositionY(BigDecimal maxPositionY) {
        this.maxPositionY = maxPositionY;
    }

    public Integer getMinParkingSpaceNumber() {
        return minParkingSpaceNumber;
    }

    public void setMinParkingSpaceNumber(Integer minParkingSpaceNumber) {
        this.minParkingSpaceNumber = minParkingSpaceNumber;
    }

    public Integer getMaxParkingSpaceNumber() {
        return maxParkingSpaceNumber;
    }

    public void setMaxParkingSpaceNumber(Integer maxParkingSpaceNumber) {
        this.maxParkingSpaceNumber = maxParkingSpaceNumber;
    }

    public Integer getMinUsedParkingSpaceNumber() {
        return minUsedParkingSpaceNumber;
    }

    public void setMinUsedParkingSpaceNumber(Integer minUsedParkingSpaceNumber) {
        this.minUsedParkingSpaceNumber = minUsedParkingSpaceNumber;
    }

    public Integer getMaxUsedParkingSpaceNumber() {
        return maxUsedParkingSpaceNumber;
    }

    public void setMaxUsedParkingSpaceNumber(Integer maxUsedParkingSpaceNumber) {
        this.maxUsedParkingSpaceNumber = maxUsedParkingSpaceNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
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

    public Long getMinFreeTime() {
        return minFreeTime;
    }

    public void setMinFreeTime(Long minFreeTime) {
        this.minFreeTime = minFreeTime;
    }

    public Long getMaxFreeTime() {
        return maxFreeTime;
    }

    public void setMaxFreeTime(Long maxFreeTime) {
        this.maxFreeTime = maxFreeTime;
    }

    public BigDecimal getMinScore() {
        return minScore;
    }

    public void setMinScore(BigDecimal minScore) {
        this.minScore = minScore;
    }

    public BigDecimal getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(BigDecimal maxScore) {
        this.maxScore = maxScore;
    }

    public Integer getMinNumberOfComments() {
        return minNumberOfComments;
    }

    public void setMinNumberOfComments(Integer minNumberOfComments) {
        this.minNumberOfComments = minNumberOfComments;
    }

    public Integer getMaxNumberOfComments() {
        return maxNumberOfComments;
    }

    public void setMaxNumberOfComments(Integer maxNumberOfComments) {
        this.maxNumberOfComments = maxNumberOfComments;
    }

    public BigDecimal getMinFeeUpperLimit() {
        return minFeeUpperLimit;
    }

    public void setMinFeeUpperLimit(BigDecimal minFeeUpperLimit) {
        this.minFeeUpperLimit = minFeeUpperLimit;
    }

    public BigDecimal getMaxFeeUpperLimit() {
        return maxFeeUpperLimit;
    }

    public void setMaxFeeUpperLimit(BigDecimal maxFeeUpperLimit) {
        this.maxFeeUpperLimit = maxFeeUpperLimit;
    }

    public Long getMinUnitDuration() {
        return minUnitDuration;
    }

    public void setMinUnitDuration(Long minUnitDuration) {
        this.minUnitDuration = minUnitDuration;
    }

    public Long getMaxUnitDuration() {
        return maxUnitDuration;
    }

    public void setMaxUnitDuration(Long maxUnitDuration) {
        this.maxUnitDuration = maxUnitDuration;
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

    public Long getMinStartBusinessHours() {
        return minStartBusinessHours;
    }

    public void setMinStartBusinessHours(Long minStartBusinessHours) {
        this.minStartBusinessHours = minStartBusinessHours;
    }

    public Long getMaxStartBusinessHours() {
        return maxStartBusinessHours;
    }

    public void setMaxStartBusinessHours(Long maxStartBusinessHours) {
        this.maxStartBusinessHours = maxStartBusinessHours;
    }

    public Long getMinEndBusinessHours() {
        return minEndBusinessHours;
    }

    public void setMinEndBusinessHours(Long minEndBusinessHours) {
        this.minEndBusinessHours = minEndBusinessHours;
    }

    public Long getMaxEndBusinessHours() {
        return maxEndBusinessHours;
    }

    public void setMaxEndBusinessHours(Long maxEndBusinessHours) {
        this.maxEndBusinessHours = maxEndBusinessHours;
    }

    public Short getShowDistance() {
        return showDistance;
    }

    public void setShowDistance(Short showDistance) {
        this.showDistance = showDistance;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Long getCurrentHourTime() {
        return currentHourTime;
    }

    public void setCurrentHourTime(Long currentHourTime) {
        this.currentHourTime = currentHourTime;
    }

    public Long getCurrentTimeStamp() {
        return currentTimeStamp;
    }

    public void setCurrentTimeStamp(Long currentTimeStamp) {
        this.currentTimeStamp = currentTimeStamp;
    }

    public BigDecimal getMinStartingPrice() {
        return minStartingPrice;
    }

    public void setMinStartingPrice(BigDecimal minStartingPrice) {
        this.minStartingPrice = minStartingPrice;
    }

    public BigDecimal getMaxStartingPrice() {
        return maxStartingPrice;
    }

    public void setMaxStartingPrice(BigDecimal maxStartingPrice) {
        this.maxStartingPrice = maxStartingPrice;
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

    public String getChargingStationId() {
        return chargingStationId;
    }

    public void setChargingStationId(String chargingStationId) {
        this.chargingStationId = chargingStationId;
    }

    public String getCountField() {
        return countField;
    }

    public void setCountField(String countField) {
        this.countField = countField;
    }

    public Byte getVisitProcessMode() {
        return visitProcessMode;
    }

    public void setVisitProcessMode(Byte visitProcessMode) {
        this.visitProcessMode = visitProcessMode;
    }
}