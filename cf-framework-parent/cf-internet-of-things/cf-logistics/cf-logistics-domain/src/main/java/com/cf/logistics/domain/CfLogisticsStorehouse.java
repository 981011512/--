package com.cf.logistics.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfLogisticsStorehouse implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String storehouseName;

    private String countryId;

    private String provinceId;

    private String stateOrCityId;

    private String zoneOrCountyId;

    private String townshipId;

    private BigDecimal positionX;

    private BigDecimal positionY;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long startBusinessHours;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long endBusinessHours;

    private String address;

    private String phone;

    private String image;

    private String wxAppid;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long factoryId;

    private String principal;

    private CfLogisticsFactory cfLogisticsFactory;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStorehouseName() {
        return storehouseName;
    }

    public void setStorehouseName(String storehouseName) {
        this.storehouseName = storehouseName == null ? null : storehouseName.trim();
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getWxAppid() {
        return wxAppid;
    }

    public void setWxAppid(String wxAppid) {
        this.wxAppid = wxAppid;
    }

    public Long getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Long factoryId) {
        this.factoryId = factoryId;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public CfLogisticsFactory getCfLogisticsFactory() {
        return cfLogisticsFactory;
    }

    public void setCfLogisticsFactory(CfLogisticsFactory cfLogisticsFactory) {
        this.cfLogisticsFactory = cfLogisticsFactory;
    }
}