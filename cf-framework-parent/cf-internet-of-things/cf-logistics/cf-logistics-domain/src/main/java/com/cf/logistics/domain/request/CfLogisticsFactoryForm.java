package com.cf.logistics.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfLogisticsFactoryForm implements Serializable {
    private Long id;

    private String factoryName;

    private BigDecimal positionX;

    private BigDecimal positionY;

    private String address;

    private String principal;

    private String phone;

    private Integer signInRange;

    private String wxMpAppid;

    private String wxPubAppid;

    private String carParkIds;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getSignInRange() {
        return signInRange;
    }

    public void setSignInRange(Integer signInRange) {
        this.signInRange = signInRange;
    }

    public String getWxMpAppid() {
        return wxMpAppid;
    }

    public void setWxMpAppid(String wxMpAppid) {
        this.wxMpAppid = wxMpAppid;
    }

    public String getWxPubAppid() {
        return wxPubAppid;
    }

    public void setWxPubAppid(String wxPubAppid) {
        this.wxPubAppid = wxPubAppid;
    }

    public String getCarParkIds() {
        return carParkIds;
    }

    public void setCarParkIds(String carParkIds) {
        this.carParkIds = carParkIds;
    }
}