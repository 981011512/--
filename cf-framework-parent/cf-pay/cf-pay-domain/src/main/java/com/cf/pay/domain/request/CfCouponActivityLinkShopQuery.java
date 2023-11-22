package com.cf.pay.domain.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CfCouponActivityLinkShopQuery implements Serializable {
    @ApiModelProperty(value = "数据id", required = false)
    private String id;
    @ApiModelProperty(value = "优惠券活动id", required = false)
    private String couponActivityId;
    @ApiModelProperty(value = "店铺id(停车场/商店等)", required = false)
    private String shopId;
    @ApiModelProperty(value = "场景(carpark-停车场/shop-商店)", required = false)
    private String scene;
    @ApiModelProperty(value = "页码", required = false)
    private Integer page;
    @ApiModelProperty(value = "每页请求数", required = false)
    private Integer size;
    @ApiModelProperty(value = "资源表名(例如停车场表,商城表等，该字段不能前端传入，只能后端控制和使用)", required = false)
    private String tableName;   //注意：此成员属性只能后端代码赋值，不能前端控制
    @ApiModelProperty(value = "资源表资源名字段(例如停车场表中的停车场名字段,商城表中店铺名称字段等，该字段不能前端传入，只能后端控制和使用)", required = false)
    private String shopNameField;   //注意：此成员属性只能后端代码赋值，不能前端控制
    @ApiModelProperty(value = "是否为主店铺(0-否/1-是)", required = false)
    private Byte mainShop;
    @ApiModelProperty(value = "是否为要求服务中", required = false)
    private Byte requireUsing;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCouponActivityId() {
        return couponActivityId;
    }

    public void setCouponActivityId(String couponActivityId) {
        this.couponActivityId = couponActivityId == null ? null : couponActivityId.trim();
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene == null ? null : scene.trim();
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

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getShopNameField() {
        return shopNameField;
    }

    public void setShopNameField(String shopNameField) {
        this.shopNameField = shopNameField;
    }

    public Byte getMainShop() {
        return mainShop;
    }

    public void setMainShop(Byte mainShop) {
        this.mainShop = mainShop;
    }

    public Byte getRequireUsing() {
        return requireUsing;
    }

    public void setRequireUsing(Byte requireUsing) {
        this.requireUsing = requireUsing;
    }
}