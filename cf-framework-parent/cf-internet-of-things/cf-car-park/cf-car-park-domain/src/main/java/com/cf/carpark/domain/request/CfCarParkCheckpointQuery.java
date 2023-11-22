package com.cf.carpark.domain.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CfCarParkCheckpointQuery implements Serializable {
    private String id;

    private List<String> ids;

    private String name;

    @ApiModelProperty(value = "停车场id", example = "true")
    private String carParkId;

    private BigDecimal positionX;

    private BigDecimal positionY;

    private String positionDescribe;

    private Byte floor;

    private Byte mode;

    private Byte status;

    private String dutyUid;

    private String direction;

    @ApiModelProperty(value = "N米以内(范围1-1000)", example = "true")
    @Min(value = 1, message = "距离最小值1米")
    @Max(value = 1000, message = "距离最大值1000米")
    private Integer distance;

    @ApiModelProperty(value = "页码(范围1-20)", example = "true", required = true)
    @Min(value = 1, message = "页码最小值1")
    @Max(value = 10, message = "页码最大值10")
    private Integer page;

    @ApiModelProperty(value = "每页条数(范围3-100)", example = "true", required = true)
    @Min(value = 3, message = "每页条数最小值3")
    @Max(value = 100, message = "每页条数最大值100")
    private Integer size;

    private Byte allowTemporaryCar;

    private Byte allowUnconditionalOpen;

    private Byte defaultCheckPoint;

    private String orderBy;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCarParkId() {
        return carParkId;
    }

    public void setCarParkId(String carParkId) {
        this.carParkId = carParkId == null ? null : carParkId.trim();
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

    public String getPositionDescribe() {
        return positionDescribe;
    }

    public void setPositionDescribe(String positionDescribe) {
        this.positionDescribe = positionDescribe == null ? null : positionDescribe.trim();
    }

    public Byte getFloor() {
        return floor;
    }

    public void setFloor(Byte floor) {
        this.floor = floor;
    }

    public Byte getMode() {
        return mode;
    }

    public void setMode(Byte mode) {
        this.mode = mode;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getDutyUid() {
        return dutyUid;
    }

    public void setDutyUid(String dutyUid) {
        this.dutyUid = dutyUid;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public Byte getAllowTemporaryCar() {
        return allowTemporaryCar;
    }

    public void setAllowTemporaryCar(Byte allowTemporaryCar) {
        this.allowTemporaryCar = allowTemporaryCar;
    }

    public Byte getAllowUnconditionalOpen() {
        return allowUnconditionalOpen;
    }

    public void setAllowUnconditionalOpen(Byte allowUnconditionalOpen) {
        this.allowUnconditionalOpen = allowUnconditionalOpen;
    }

    public Byte getDefaultCheckPoint() {
        return defaultCheckPoint;
    }

    public void setDefaultCheckPoint(Byte defaultCheckPoint) {
        this.defaultCheckPoint = defaultCheckPoint;
    }
}