package com.cf.ad.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class CfAdLinks implements Serializable {
    private String id;
    @ApiModelProperty(value = "广告id", required = false)
    private String adId;
    @ApiModelProperty(value = "场景(carpark-bind-car 车牌绑定页面/carpark-order 停车账单结算页面/pay-success 支付成功页面)", required = false)
    private String scenes;
    @ApiModelProperty(value = "平台(web-网页/wxmp-微信小程序/app-手机应用)", required = false)
    private String platform;
    @ApiModelProperty(value = "载体id(例如停车场id，商场id，店铺id等)", required = false)
    private String carrierId;
    @ApiModelProperty(value = "排序", required = false)
    private Short sortIndex;
    @ApiModelProperty(value = "开始投放时间，单位毫秒", required = false)
    private Long startTime;
    @ApiModelProperty(value = "结束投放时间，单位毫秒", required = false)
    private Long endTime;

    private Integer showCounts;

    private Integer clickCounts;

    private Long createTime;
    @ApiModelProperty(value = "载体id串，半角逗号隔开", required = false)
    private List<String> carrierIds;

    private CfAd cfAd;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId == null ? null : adId.trim();
    }

    public String getScenes() {
        return scenes;
    }

    public void setScenes(String scenes) {
        this.scenes = scenes == null ? null : scenes.trim();
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public String getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }

    public Short getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Short sortIndex) {
        this.sortIndex = sortIndex;
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

    public Integer getShowCounts() {
        return showCounts;
    }

    public void setShowCounts(Integer showCounts) {
        this.showCounts = showCounts;
    }

    public Integer getClickCounts() {
        return clickCounts;
    }

    public void setClickCounts(Integer clickCounts) {
        this.clickCounts = clickCounts;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public List<String> getCarrierIds() {
        return carrierIds;
    }

    public void setCarrierIds(List<String> carrierIds) {
        this.carrierIds = carrierIds;
    }

    public CfAd getCfAd() {
        return cfAd;
    }

    public void setCfAd(CfAd cfAd) {
        this.cfAd = cfAd;
    }
}