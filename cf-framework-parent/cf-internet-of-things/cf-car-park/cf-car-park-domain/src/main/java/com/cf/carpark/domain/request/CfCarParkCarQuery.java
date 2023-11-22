package com.cf.carpark.domain.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;

public class CfCarParkCarQuery implements Serializable {
    private String id;
    @ApiModelProperty(value = "车牌号", required = false)
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

    private String orderBy;
    @ApiModelProperty(value = "页码数(1-100)", required = true)
    @Min(value = 1, message = "最小页码数1")
    @Max(value = 100, message = "最大页码数100")
    private Integer page;
    @ApiModelProperty(value = "每页请求数(3-30)", required = true)
    @Min(value = 3, message = "最小每页请求数3")
    @Max(value = 30, message = "最大每页请求数30")
    private Integer size;

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

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
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