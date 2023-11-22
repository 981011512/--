package com.cf.carpark.domain.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;

public class CfCarParkCarForm implements Serializable {
    private String id;
    @ApiModelProperty(value = "车牌号", required = true)
    @Pattern(regexp = "^[\\u0391-\\uFFE5A-Za-z]{1}[A-Z0-9]{5,6}[\\u0391-\\uFFE5A-Z0-9]{1,2}$", message = "车牌号不合法")
    private String numberPlate;

    private String uid;

    private String image;

    private String brand;

    private String model;

    private Long purchaseTime;

    private BigDecimal price;

    private Long createTime;

    private Long updateTime;
    @ApiModelProperty(value = "类型(0-已删除/1-审核中/2-正常)", required = false)
    private Byte status;

    private String identityImage;

    private String identityNumber;

    private String carTypeKey;

    private Long carTypeStartTime;

    private Long carTypeEndTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate == null ? null : numberPlate.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Long getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Long purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getIdentityImage() {
        return identityImage;
    }

    public void setIdentityImage(String identityImage) {
        this.identityImage = identityImage == null ? null : identityImage.trim();
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber == null ? null : identityNumber.trim();
    }

    public String getCarTypeKey() {
        return carTypeKey;
    }

    public void setCarTypeKey(String carTypeKey) {
        this.carTypeKey = carTypeKey;
    }

    public Long getCarTypeStartTime() {
        return carTypeStartTime;
    }

    public void setCarTypeStartTime(Long carTypeStartTime) {
        this.carTypeStartTime = carTypeStartTime;
    }

    public Long getCarTypeEndTime() {
        return carTypeEndTime;
    }

    public void setCarTypeEndTime(Long carTypeEndTime) {
        this.carTypeEndTime = carTypeEndTime;
    }
}