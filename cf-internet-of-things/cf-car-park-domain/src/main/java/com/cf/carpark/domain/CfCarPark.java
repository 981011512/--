package com.cf.carpark.domain;

import java.io.Serializable;
import java.math.BigDecimal;

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
}