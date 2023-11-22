package com.cf.carpark.domain.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

public class CfCarParkCarLimitQuery implements Serializable {
    private String id;

    private String carParkId;

    private String carTypeKey;

    private Long freeTime;

    private Byte giveFreeTime;

    private Byte autoOpenDoor;

    private Byte forbidIn;

    private Byte freeRelease;

    @ApiModelProperty(value = "页码数(1-1000)", required = true)
    @Min(value = 1, message = "最小页码数1")
    @Max(value = 1000, message = "最大页码数1000")
    private Integer page;
    @ApiModelProperty(value = "每页请求数(3-30)", required = true)
    @Min(value = 3, message = "最小每页请求数3")
    @Max(value = 30, message = "最大每页请求数30")
    private Integer size;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCarParkId() {
        return carParkId;
    }

    public void setCarParkId(String carParkId) {
        this.carParkId = carParkId == null ? null : carParkId.trim();
    }

    public String getCarTypeKey() {
        return carTypeKey;
    }

    public void setCarTypeKey(String carTypeKey) {
        this.carTypeKey = carTypeKey == null ? null : carTypeKey.trim();
    }

    public Long getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(Long freeTime) {
        this.freeTime = freeTime;
    }

    public Byte getGiveFreeTime() {
        return giveFreeTime;
    }

    public void setGiveFreeTime(Byte giveFreeTime) {
        this.giveFreeTime = giveFreeTime;
    }

    public Byte getAutoOpenDoor() {
        return autoOpenDoor;
    }

    public void setAutoOpenDoor(Byte autoOpenDoor) {
        this.autoOpenDoor = autoOpenDoor;
    }

    public Byte getForbidIn() {
        return forbidIn;
    }

    public void setForbidIn(Byte forbidIn) {
        this.forbidIn = forbidIn;
    }

    public Byte getFreeRelease() {
        return freeRelease;
    }

    public void setFreeRelease(Byte freeRelease) {
        this.freeRelease = freeRelease;
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