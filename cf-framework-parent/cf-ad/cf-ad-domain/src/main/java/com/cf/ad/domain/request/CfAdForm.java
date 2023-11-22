package com.cf.ad.domain.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CfAdForm implements Serializable {

    @ApiModelProperty(value = "广告id", required = false)
    private String id;
    @ApiModelProperty(value = "标题", required = true)
    private String title;
    @ApiModelProperty(value = "广告副标题", required = false)
    private String subtitle;
    @ApiModelProperty(value = "封面", required = true)
    private String cover;
    @ApiModelProperty(value = "平台(web-网页/wxmp-微信小程序/app-手机应用)", required = true)
    private String platform;
    @ApiModelProperty(value = "素材类型(image-图片/video-视频)", required = true)
    private String materialType;
    @ApiModelProperty(value = "排序序号", required = true)
    private Short sortIndex;
    @ApiModelProperty(value = "资源地址", required = true)
    private String sourceAddress;
    @ApiModelProperty(value = "应用id(例如跳转到某个小程序给其appid)", required = false)
    private String appid;
    @ApiModelProperty(value = "展现次数", required = false)
    private Integer showCounts;
    @ApiModelProperty(value = "点击次数", required = false)
    private Integer clickCounts;
    @ApiModelProperty(value = "开始投放时间", required = false)
    private Long startTime;
    @ApiModelProperty(value = "结束投放日期", required = false)
    private Long endTime;
    @ApiModelProperty(value = "创建时间", required = false)
    private Long createTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType == null ? null : materialType.trim();
    }

    public Short getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Short sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress == null ? null : sourceAddress.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
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

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}