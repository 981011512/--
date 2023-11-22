package com.cf.ucenter.request;

import java.io.Serializable;

public class CfUserIdCardQuery implements Serializable {
    private Long id;

    private String uid;

    private String userName;

    private Byte sex;

    private String nationality;

    private Short birthdayYear;

    private Byte birthdayMonth;

    private Byte birthdayDay;

    private String address;

    private String identityNumber;

    private String issuingAuthority;

    private Long startTime;

    private Long endTime;

    private String images;

    private Byte checkStatus;

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
}