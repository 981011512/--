package com.cf.ucenter.request;

import java.io.Serializable;

public class CfUserDriverLicenseQuery implements Serializable {
    private Long id;

    private String uid;

    private String userName;

    private Byte sex;

    private String nationality;

    private String address;

    private Short birthdayYear;

    private Byte birthdayMonth;

    private Byte birthdayDay;

    private Short firstIssueYear;

    private Byte firstIssueMonth;

    private Byte firstIssueDay;

    private String carClass;

    private Long startTime;

    private Long endTime;

    private String certificateNumber;

    private String issuingAuthority;

    private String fileNumber;

    private Long internshipPeriodEnds;

    private String images;

    private Byte checkStatus;

    private String phone;

    private String qualificationCertificateNumber;

    private Integer page;

    private Integer size;

    private String orderBy;

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