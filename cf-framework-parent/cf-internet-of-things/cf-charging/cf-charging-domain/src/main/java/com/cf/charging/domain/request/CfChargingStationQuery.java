package com.cf.charging.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CfChargingStationQuery implements Serializable {
    private String id;

    private List<String> ids;

    private String stationName;

    private String image;

    private Byte stationType;

    private Long freeParkTime;

    private BigDecimal startPrice;

    private Byte hasBathroom;

    private Byte hasLounge;

    private Byte hasDinningRoom;

    private Byte hasShop;

    private Byte slowChargeNumber;

    private Byte fastChargeNumber;

    private Byte superFastChargeNumber;

    private Short usedSlowChargeNumber;

    private Short usedFastChargeNumber;

    private Short usedSuperFastChargeNumber;

    private Byte floor;

    private Byte indoorOrOutdoor;

    private BigDecimal positionX;

    private BigDecimal minPositionX;

    private BigDecimal maxPositionX;

    private BigDecimal positionY;

    private BigDecimal minPositionY;

    private BigDecimal maxPositionY;

    private String countryId;

    private String provinceId;

    private String stateOrCityId;

    private String zoneOrCountyId;

    private String townshipId;

    private String address;

    private Long startBusinessTime;

    private Long minStartBusinessTime;

    private Long maxStartBusinessTime;

    private Long endBusinessTime;

    private Long minEndBusinessTime;

    private Long maxEndBusinessTime;

    private Byte stationStatus;

    private String phone;

    private Integer page;

    private Integer size;

    private String orderBy;

    private BigDecimal distance;

    private BigDecimal serviceFee;

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

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Byte getStationType() {
        return stationType;
    }

    public void setStationType(Byte stationType) {
        this.stationType = stationType;
    }

    public Long getFreeParkTime() {
        return freeParkTime;
    }

    public void setFreeParkTime(Long freeParkTime) {
        this.freeParkTime = freeParkTime;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public Byte getHasBathroom() {
        return hasBathroom;
    }

    public void setHasBathroom(Byte hasBathroom) {
        this.hasBathroom = hasBathroom;
    }

    public Byte getHasLounge() {
        return hasLounge;
    }

    public void setHasLounge(Byte hasLounge) {
        this.hasLounge = hasLounge;
    }

    public Byte getHasDinningRoom() {
        return hasDinningRoom;
    }

    public void setHasDinningRoom(Byte hasDinningRoom) {
        this.hasDinningRoom = hasDinningRoom;
    }

    public Byte getHasShop() {
        return hasShop;
    }

    public void setHasShop(Byte hasShop) {
        this.hasShop = hasShop;
    }

    public Byte getSlowChargeNumber() {
        return slowChargeNumber;
    }

    public void setSlowChargeNumber(Byte slowChargeNumber) {
        this.slowChargeNumber = slowChargeNumber;
    }

    public Byte getFastChargeNumber() {
        return fastChargeNumber;
    }

    public void setFastChargeNumber(Byte fastChargeNumber) {
        this.fastChargeNumber = fastChargeNumber;
    }

    public Byte getSuperFastChargeNumber() {
        return superFastChargeNumber;
    }

    public void setSuperFastChargeNumber(Byte superFastChargeNumber) {
        this.superFastChargeNumber = superFastChargeNumber;
    }

    public Short getUsedSlowChargeNumber() {
        return usedSlowChargeNumber;
    }

    public void setUsedSlowChargeNumber(Short usedSlowChargeNumber) {
        this.usedSlowChargeNumber = usedSlowChargeNumber;
    }

    public Short getUsedFastChargeNumber() {
        return usedFastChargeNumber;
    }

    public void setUsedFastChargeNumber(Short usedFastChargeNumber) {
        this.usedFastChargeNumber = usedFastChargeNumber;
    }

    public Short getUsedSuperFastChargeNumber() {
        return usedSuperFastChargeNumber;
    }

    public void setUsedSuperFastChargeNumber(Short usedSuperFastChargeNumber) {
        this.usedSuperFastChargeNumber = usedSuperFastChargeNumber;
    }

    public Byte getFloor() {
        return floor;
    }

    public void setFloor(Byte floor) {
        this.floor = floor;
    }

    public Byte getIndoorOrOutdoor() {
        return indoorOrOutdoor;
    }

    public void setIndoorOrOutdoor(Byte indoorOrOutdoor) {
        this.indoorOrOutdoor = indoorOrOutdoor;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getStartBusinessTime() {
        return startBusinessTime;
    }

    public void setStartBusinessTime(Long startBusinessTime) {
        this.startBusinessTime = startBusinessTime;
    }

    public Long getEndBusinessTime() {
        return endBusinessTime;
    }

    public void setEndBusinessTime(Long endBusinessTime) {
        this.endBusinessTime = endBusinessTime;
    }

    public Byte getStationStatus() {
        return stationStatus;
    }

    public void setStationStatus(Byte stationStatus) {
        this.stationStatus = stationStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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

    public Long getMinStartBusinessTime() {
        return minStartBusinessTime;
    }

    public void setMinStartBusinessTime(Long minStartBusinessTime) {
        this.minStartBusinessTime = minStartBusinessTime;
    }

    public Long getMaxStartBusinessTime() {
        return maxStartBusinessTime;
    }

    public void setMaxStartBusinessTime(Long maxStartBusinessTime) {
        this.maxStartBusinessTime = maxStartBusinessTime;
    }

    public Long getMinEndBusinessTime() {
        return minEndBusinessTime;
    }

    public void setMinEndBusinessTime(Long minEndBusinessTime) {
        this.minEndBusinessTime = minEndBusinessTime;
    }

    public Long getMaxEndBusinessTime() {
        return maxEndBusinessTime;
    }

    public void setMaxEndBusinessTime(Long maxEndBusinessTime) {
        this.maxEndBusinessTime = maxEndBusinessTime;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }
}