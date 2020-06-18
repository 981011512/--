package com.cf.carpark.request;

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
    @Max(value = 172800000, message = "开始营业时间<=172800000")
    private Long startBusinessHours;

    @ApiModelProperty(value = "结束营业时间", example = "true", required = true)
    @Min(value = 0, message = "结束营业时间>=0")
    @Max(value = 172800000, message = "结束营业时间<=172800000")
    private Long endBusinessHours;

    @ApiModelProperty(value = "总车位数", example = "true", required = true)
    @Min(value = 1, message = "总车位数>=1")
    private Integer parkingSpaceNumber;

    @ApiModelProperty(value = "已使用车位数", example = "true", required = true)
    @Max(value = 1, message = "总车位数>=0")
    private Integer usedParkingSpaceNumber;

    @ApiModelProperty(value = "停车场地址", example = "true", required = true)
    private String address;

    @ApiModelProperty(value = "停车场负责人手机号", example = "true", required = true)
    @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))[0-9]{8}$", message = "手机号不合法")
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
}