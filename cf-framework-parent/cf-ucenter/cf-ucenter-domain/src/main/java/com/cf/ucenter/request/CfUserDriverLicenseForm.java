package com.cf.ucenter.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CfUserDriverLicenseForm implements Serializable {
    private Long id;
    @ApiModelProperty(value = "", example = "无需提供，系统会自动维护", required = false)
    private String uid;
    @ApiModelProperty(value = "", example = "用户姓名", required = true)
    @Size(min=2, max=20, message = "用户姓名长度2-20位数")
    private String userName;
    @ApiModelProperty(value = "", example = "性别0-女/1-男/2-未知", required = false)
    @Min(value = 0, message = "性别最小值0")
    @Max(value = 2, message = "性别最大值2")
    private Byte sex;
    @ApiModelProperty(value = "", example = "国籍", required = false)
    private String nationality;
    @ApiModelProperty(value = "", example = "地址", required = false)
    private String address;
    @ApiModelProperty(value = "", example = "出生日期-年，请提供例如 2022的数字", required = false)
    @Min(value = 1940, message = "年龄最小值1940年")
    @Max(value = 2050, message = "年龄最大值2050年")
    private Short birthdayYear;
    @ApiModelProperty(value = "", example = "出生日期-月，请提供1-12的数字", required = false)
    @Min(value = 1, message = "年龄月份最小值1月")
    @Max(value = 12, message = "年龄月份最大值12月")
    private Byte birthdayMonth;
    @ApiModelProperty(value = "", example = "出生日期-日，请提供1-31的数字", required = false)
    @Min(value = 1, message = "年龄日份最小值1号")
    @Max(value = 31, message = "年龄日份最大值31号")
    private Byte birthdayDay;
    @ApiModelProperty(value = "", example = "初次领证日期-年，请提供例如 2022的数字", required = false)
    @Min(value = 1940, message = "年最小值1940年")
    @Max(value = 2050, message = "年最大值2050年")
    private Short firstIssueYear;
    @ApiModelProperty(value = "", example = "初次领证日期-月，请提供1-12的数字", required = false)
    @Min(value = 1, message = "月份最小值1月")
    @Max(value = 12, message = "月份最大值12月")
    private Byte firstIssueMonth;
    @ApiModelProperty(value = "", example = "初次领证日期-日，请提供1-31的数字", required = false)
    @Min(value = 1, message = "日期最小值1号")
    @Max(value = 31, message = "日期最大值31号")
    private Byte firstIssueDay;
    @ApiModelProperty(value = "", example = "准驾车型", required = true)
    @Size(min=2, max=30, message = "准驾车型长度2-30位数")
    private String carClass;
    @ApiModelProperty(value = "", example = "证件生效时间", required = false)
    private Long startTime;
    @ApiModelProperty(value = "", example = "证件到期时间", required = false)
    private Long endTime;
    @ApiModelProperty(value = "", example = "身份证号", required = true)
    @Size(min=16, max=20, message = "身份证号长度16-20位数")
    private String certificateNumber;
    @ApiModelProperty(value = "", example = "签发机关", required = false)
    private String issuingAuthority;
    @ApiModelProperty(value = "", example = "档案编号", required = false)
    @Size(min=0, max=20, message = "档案编号长度10-20位数")
    private String fileNumber;
    @ApiModelProperty(value = "", example = "实习期截至", required = false)
    private Long internshipPeriodEnds;
    @ApiModelProperty(value = "", example = "身份证正反面图片，请用英文逗号隔开，例如 111.jpg,222.jpg", required = false)
    private String images;
    @ApiModelProperty(value = "", example = "审核状态(0-待审核/1-已审核)", required = true)
    @Min(value = 0, message = "性别最小值0")
    @Max(value = 1, message = "性别最大值1")
    private Byte checkStatus;

    private String phone;

    private String qualificationCertificateNumber;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public Short getFirstIssueYear() {
        return firstIssueYear;
    }

    public void setFirstIssueYear(Short firstIssueYear) {
        this.firstIssueYear = firstIssueYear;
    }

    public Byte getFirstIssueMonth() {
        return firstIssueMonth;
    }

    public void setFirstIssueMonth(Byte firstIssueMonth) {
        this.firstIssueMonth = firstIssueMonth;
    }

    public Byte getFirstIssueDay() {
        return firstIssueDay;
    }

    public void setFirstIssueDay(Byte firstIssueDay) {
        this.firstIssueDay = firstIssueDay;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass == null ? null : carClass.trim();
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

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber == null ? null : certificateNumber.trim();
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority == null ? null : issuingAuthority.trim();
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber == null ? null : fileNumber.trim();
    }

    public Long getInternshipPeriodEnds() {
        return internshipPeriodEnds;
    }

    public void setInternshipPeriodEnds(Long internshipPeriodEnds) {
        this.internshipPeriodEnds = internshipPeriodEnds;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQualificationCertificateNumber() {
        return qualificationCertificateNumber;
    }

    public void setQualificationCertificateNumber(String qualificationCertificateNumber) {
        this.qualificationCertificateNumber = qualificationCertificateNumber;
    }
}