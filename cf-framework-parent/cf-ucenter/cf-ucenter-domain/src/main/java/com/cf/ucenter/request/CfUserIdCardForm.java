package com.cf.ucenter.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CfUserIdCardForm implements Serializable {

    private Long id;
    @ApiModelProperty(value = "", example = "无需提供，系统会自动维护", required = false)
    private String uid;
    @ApiModelProperty(value = "", example = "用户姓名", required = true)
    @Size(min=2, max=20, message = "用户姓名长度2-20位数")
    private String userName;
    @ApiModelProperty(value = "", example = "性别0-女/1-男/2-未知", required = true)
    @Min(value = 0, message = "性别最小值0")
    @Max(value = 2, message = "性别最大值2")
    private Byte sex;
    @ApiModelProperty(value = "", example = "民族", required = true)
    private String nationality;
    @ApiModelProperty(value = "", example = "出生日期-年，请提供例如 2022的数字", required = true)
    @Min(value = 1940, message = "年龄最小值1940年")
    @Max(value = 2050, message = "年龄最大值2050年")
    private Short birthdayYear;
    @ApiModelProperty(value = "", example = "出生日期-月，请提供1-12的数字", required = true)
    @Min(value = 1, message = "年龄月份最小值1月")
    @Max(value = 12, message = "年龄月份最大值12月")
    private Byte birthdayMonth;
    @ApiModelProperty(value = "", example = "出生日期-日，请提供1-31的数字", required = true)
    @Min(value = 1, message = "年龄日份最小值1号")
    @Max(value = 31, message = "年龄日份最大值31号")
    private Byte birthdayDay;
    @ApiModelProperty(value = "", example = "地址", required = true)
    private String address;
    @ApiModelProperty(value = "", example = "身份证号", required = true)
    @Size(min=16, max=20, message = "身份证号长度16-20位数")
    private String identityNumber;
    @ApiModelProperty(value = "", example = "签发机关", required = true)
    private String issuingAuthority;
    @ApiModelProperty(value = "", example = "证件生效时间", required = true)
    private Long startTime;
    @ApiModelProperty(value = "", example = "证件到期时间", required = true)
    private Long endTime;
    @ApiModelProperty(value = "", example = "身份证正反面图片，请用英文逗号隔开，例如 111.jpg,222.jpg", required = false)
    private String images;
    @ApiModelProperty(value = "", example = "审核状态(0-待审核/1-已审核)", required = true)
    @Min(value = 0, message = "性别最小值0")
    @Max(value = 1, message = "性别最大值1")
    private Byte checkStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public Short getBirthdayYear() {
        return birthdayYear;
    }

    public void setBirthdayYear(Short birthdayYear) {
        this.birthdayYear = birthdayYear;
    }

    public Byte getBirthdayMonth() {
        return birthdayMonth;
    }

    public void setBirthdayMonth(Byte birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }

    public Byte getBirthdayDay() {
        return birthdayDay;
    }

    public void setBirthdayDay(Byte birthdayDay) {
        this.birthdayDay = birthdayDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber == null ? null : identityNumber.trim();
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority == null ? null : issuingAuthority.trim();
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

    public Byte getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Byte checkStatus) {
        this.checkStatus = checkStatus;
    }
}