package com.cf.carpark.domain.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class CfCountCarParkUseLogQuery implements Serializable {
    @ApiModelProperty(value = "字符串日期", required = false)
    private String date;
    @ApiModelProperty(value = "字符串结束日期", required = false)
    private String endDate;
    @ApiModelProperty(value = "年份", required = false)
    private Integer year;
    @ApiModelProperty(value = "月份", required = false)
    private Integer month;
    @ApiModelProperty(value = "前N天", required = false)
    private Integer day;
    @ApiModelProperty(value = "停车场id", required = false)
    private String carparkId;
    @ApiModelProperty(value = "车牌号", required = false)
    private String numberPlate;
    @ApiModelProperty(value = "国家id", required = false)
    private String countryId;
    @ApiModelProperty(value = "省份id", required = false)
    private String provinceId;
    @ApiModelProperty(value = "州或市id", required = false)
    private String stateOrCityId;
    @ApiModelProperty(value = "区县id", required = false)
    private String zoneOrCountyId;
    @ApiModelProperty(value = "乡镇id", required = false)
    private String townshipId;
    @ApiModelProperty(value = "统计方式(before_day_count_by_day-前N天每天停车数,month_count_by_day-某年月每天停车数,year_count_by_month-某年每月的停车数)", required = true)
    private String countType;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getCarparkId() {
        return carparkId;
    }

    public void setCarparkId(String carparkId) {
        this.carparkId = carparkId;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
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

    public String getCountType() {
        return countType;
    }

    public void setCountType(String countType) {
        this.countType = countType;
    }
}