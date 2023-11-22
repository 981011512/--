package com.cf.ad.domain.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class CfAdLinksForm implements Serializable {
    private String id;
    @ApiModelProperty(value = "广告id", required = false)
    private String adId;
    @ApiModelProperty(value = "场景(carpark-bind-car 车牌绑定页面/carpark-order 停车账单结算页面/pay-success 支付成功页面)", required = true)
    private String scenes;
    @ApiModelProperty(value = "平台(web-网页/wxmp-微信小程序/app-手机应用)", required = true)
    private String platform;
    @ApiModelProperty(value = "载体id", required = false)
    private String carrierId;
    @ApiModelProperty(value = "排序", required = false)
    private Short sortIndex;
    @ApiModelProperty(value = "开始投放时间", required = true)
    private Long startTime;
    @ApiModelProperty(value = "结束投放时间", required = true)
    private Long endTime;
    @ApiModelProperty(value = "展示次数", required = false)
    private Integer showCounts;
    @ApiModelProperty(value = "点击次数", required = false)
    private Integer clickCounts;
    @ApiModelProperty(value = "创建时间", required = false)
    private Long createTime;
    @ApiModelProperty(value = "载体id串(例如商店或者停车场 多个id请用英文逗号隔开)", required = false)
    private List<String> carrierIds;

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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public List<String> getCarrierIds() {
        return carrierIds;
    }

    public void setCarrierIds(List<String> carrierIds) {
        this.carrierIds = carrierIds;
    }
}