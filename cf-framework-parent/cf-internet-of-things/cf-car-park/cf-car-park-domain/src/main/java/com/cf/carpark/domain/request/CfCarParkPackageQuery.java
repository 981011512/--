package com.cf.carpark.domain.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

public class CfCarParkPackageQuery implements Serializable {

    private String id;
    private List<String> ids;
    @ApiModelProperty(value = "停车场id", required = false)
    private String carParkId;
    @ApiModelProperty(value = "套餐类型(例如 month_card =>临时车)", required = false)
    private String typeKey;
    @ApiModelProperty(value = "套餐开始生效时间>=(单位毫秒)", required = false)
    @Min(value = 0, message = "套餐开始生效时间最小值必须>=0")
    private Long minStartTime;
    @ApiModelProperty(value = "套餐开始生效时间<=(单位毫秒)", required = false)
    @Min(value = 0, message = "套餐开始生效时间最小值必须>=0")
    private Long maxStartTime;
    @ApiModelProperty(value = "套餐结束失效时间>=(单位毫秒)", required = false)
    @Min(value = 0, message = "套餐开始失效时间最小值必须>=0")
    private Long minEndTime;
    @ApiModelProperty(value = "套餐结束失效时间<=(单位毫秒)", required = false)
    @Min(value = 0, message = "套餐开始失效时间最小值必须>=0")
    private Long maxEndTime;

    private String uid;
    @ApiModelProperty(value = "车牌号", required = false)
    private String numberPlate;

    private List<String> numberPlates;

    private List<String> numberPlateNotIn;

    @ApiModelProperty(value = "车牌号(模糊搜索)", required = false)
    private String numberPlateLike;

    private String orderBy;
    @ApiModelProperty(value = "页码数(1-100)", required = true)
    @Min(value = 1, message = "最小页码数1")
    @Max(value = 100, message = "最大页码数100")
    private Integer page;
    @ApiModelProperty(value = "每页请求数(3-30)", required = true)
    @Min(value = 3, message = "最小每页请求数3")
    @Max(value = 30, message = "最大每页请求数30")
    private Integer size;

    private Byte specialGive;

    private String packagePriceId;

    private Byte transRegional;

    private String mainCarParkId;

    private String phone;

    private String parentId;

    private String groupFlag;

    private boolean groupFlagNotEmpty; //如果该字段为真，条件会增加 家庭组不为空

    private Byte status;

    private Byte minStatus;

    private String carOwnerName;

    private Byte issuedWhitelist;

    private Long issuedWhitelistTime;

    private Byte noticeExpiringSoon;

    private Byte noticeExpired;

    private static final long serialVersionUID = 1L;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarParkId() {
        return carParkId;
    }

    public void setCarParkId(String carParkId) {
        this.carParkId = carParkId;
    }

    public String getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey;
    }

    public Long getMinStartTime() {
        return minStartTime;
    }

    public void setMinStartTime(Long minStartTime) {
        this.minStartTime = minStartTime;
    }

    public Long getMaxStartTime() {
        return maxStartTime;
    }

    public void setMaxStartTime(Long maxStartTime) {
        this.maxStartTime = maxStartTime;
    }

    public Long getMinEndTime() {
        return minEndTime;
    }

    public void setMinEndTime(Long minEndTime) {
        this.minEndTime = minEndTime;
    }

    public Long getMaxEndTime() {
        return maxEndTime;
    }

    public void setMaxEndTime(Long maxEndTime) {
        this.maxEndTime = maxEndTime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getNumberPlateLike() {
        return numberPlateLike;
    }

    public void setNumberPlateLike(String numberPlateLike) {
        this.numberPlateLike = numberPlateLike;
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

    public Byte getSpecialGive() {
        return specialGive;
    }

    public void setSpecialGive(Byte specialGive) {
        this.specialGive = specialGive;
    }

    public String getPackagePriceId() {
        return packagePriceId;
    }

    public void setPackagePriceId(String packagePriceId) {
        this.packagePriceId = packagePriceId;
    }

    public Byte getTransRegional() {
        return transRegional;
    }

    public void setTransRegional(Byte transRegional) {
        this.transRegional = transRegional;
    }

    public String getPhone() {
        return phone;
    }

    public String getMainCarParkId() {
        return mainCarParkId;
    }

    public void setMainCarParkId(String mainCarParkId) {
        this.mainCarParkId = mainCarParkId;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getGroupFlag() {
        return groupFlag;
    }

    public void setGroupFlag(String groupFlag) {
        this.groupFlag = groupFlag;
    }

    public boolean isGroupFlagNotEmpty() {
        return groupFlagNotEmpty;
    }

    public void setGroupFlagNotEmpty(boolean groupFlagNotEmpty) {
        this.groupFlagNotEmpty = groupFlagNotEmpty;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getMinStatus() {
        return minStatus;
    }

    public void setMinStatus(Byte minStatus) {
        this.minStatus = minStatus;
    }

    public String getCarOwnerName() {
        return carOwnerName;
    }

    public void setCarOwnerName(String carOwnerName) {
        this.carOwnerName = carOwnerName;
    }

    public Byte getIssuedWhitelist() {
        return issuedWhitelist;
    }

    public void setIssuedWhitelist(Byte issuedWhitelist) {
        this.issuedWhitelist = issuedWhitelist;
    }

    public Long getIssuedWhitelistTime() {
        return issuedWhitelistTime;
    }

    public void setIssuedWhitelistTime(Long issuedWhitelistTime) {
        this.issuedWhitelistTime = issuedWhitelistTime;
    }

    public List<String> getNumberPlateNotIn() {
        return numberPlateNotIn;
    }

    public void setNumberPlateNotIn(List<String> numberPlateNotIn) {
        this.numberPlateNotIn = numberPlateNotIn;
    }

    public List<String> getNumberPlates() {
        return numberPlates;
    }

    public void setNumberPlates(List<String> numberPlates) {
        this.numberPlates = numberPlates;
    }

    public Byte getNoticeExpiringSoon() {
        return noticeExpiringSoon;
    }

    public void setNoticeExpiringSoon(Byte noticeExpiringSoon) {
        this.noticeExpiringSoon = noticeExpiringSoon;
    }

    public Byte getNoticeExpired() {
        return noticeExpired;
    }

    public void setNoticeExpired(Byte noticeExpired) {
        this.noticeExpired = noticeExpired;
    }
}