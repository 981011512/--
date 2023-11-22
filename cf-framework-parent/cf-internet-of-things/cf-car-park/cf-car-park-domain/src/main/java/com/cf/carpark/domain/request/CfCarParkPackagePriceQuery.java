package com.cf.carpark.domain.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CfCarParkPackagePriceQuery implements Serializable {
    private String id;

    private String flagKey;
    @ApiModelProperty(value = "停车场id", required = false)
    private String carParkId;

    private List<String> carParkIds;

    private String title;

    private BigDecimal price;

    private Integer sortIndex;

    private Long timeQuota;

    private String orderBy;

    private Byte specialGive;

    private Byte specialCarPackage;

    private Integer page;

    private Integer size;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public List<String> getCarParkIds() {
        return carParkIds;
    }

    public void setCarParkIds(List<String> carParkIds) {
        this.carParkIds = carParkIds;
    }

    public String getFlagKey() {
        return flagKey;
    }

    public void setFlagKey(String flagKey) {
        this.flagKey = flagKey == null ? null : flagKey.trim();
    }

    public String getCarParkId() {
        return carParkId;
    }

    public void setCarParkId(String carParkId) {
        this.carParkId = carParkId == null ? null : carParkId.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Long getTimeQuota() {
        return timeQuota;
    }

    public void setTimeQuota(Long timeQuota) {
        this.timeQuota = timeQuota;
    }

    public Byte getSpecialCarPackage() {
        return specialCarPackage;
    }

    public void setSpecialCarPackage(Byte specialCarPackage) {
        this.specialCarPackage = specialCarPackage;
    }

    public Byte getSpecialGive() {
        return specialGive;
    }

    public void setSpecialGive(Byte specialGive) {
        this.specialGive = specialGive;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}