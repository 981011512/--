package com.cf.carpark.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CfCarParkPackagePrice implements Serializable {
    private String id;

    private String title;

    private String subtitle;

    private String image;

    private String flagKey;

    private String carParkId;

    private BigDecimal originalPrice;

    private BigDecimal currentPrice;

    private Long timeQuota;

    private Integer sortIndex;

    private String carParkName;

    private String carTypeName;

    private Byte specialGive;

    private Long gracePeriod;

    private Byte useGracePeriod;

    private Byte specialCarPackage;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
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

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Long getTimeQuota() {
        return timeQuota;
    }

    public void setTimeQuota(Long timeQuota) {
        this.timeQuota = timeQuota;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getCarParkName() {
        return carParkName;
    }

    public void setCarParkName(String carParkName) {
        this.carParkName = carParkName;
    }

    public String getCarTypeName() {
        return carTypeName;
    }

    public void setCarTypeName(String carTypeName) {
        this.carTypeName = carTypeName;
    }

    public Byte getSpecialGive() {
        return specialGive;
    }

    public void setSpecialGive(Byte specialGive) {
        this.specialGive = specialGive;
    }

    public Long getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(Long gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    public Byte getUseGracePeriod() {
        return useGracePeriod;
    }

    public void setUseGracePeriod(Byte useGracePeriod) {
        this.useGracePeriod = useGracePeriod;
    }

    public Byte getSpecialCarPackage() {
        return specialCarPackage;
    }

    public void setSpecialCarPackage(Byte specialCarPackage) {
        this.specialCarPackage = specialCarPackage;
    }
}