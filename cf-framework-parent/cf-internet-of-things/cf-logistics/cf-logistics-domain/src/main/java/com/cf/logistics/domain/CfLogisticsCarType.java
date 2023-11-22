package com.cf.logistics.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

public class CfLogisticsCarType implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String carName;

    private String flagKey;

    private Short sortIndex;

    private String image;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName == null ? null : carName.trim();
    }

    public String getFlagKey() {
        return flagKey;
    }

    public void setFlagKey(String flagKey) {
        this.flagKey = flagKey == null ? null : flagKey.trim();
    }

    public Short getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Short sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}