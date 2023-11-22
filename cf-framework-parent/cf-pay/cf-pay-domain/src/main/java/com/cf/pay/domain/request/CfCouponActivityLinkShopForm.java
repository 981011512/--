package com.cf.pay.domain.request;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CfCouponActivityLinkShopForm implements Serializable {
    @ApiModelProperty(value = "数据id", required = false)
    private String id;
    @ApiModelProperty(value = "优惠券活动id", required = false)
    private String couponActivityId;
    @ApiModelProperty(value = "店铺id(停车场/商店等)", required = false)
    private String shopId;
    @ApiModelProperty(value = "场景(carpark-停车场/shop-商店)", required = false)
    private String scene;
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