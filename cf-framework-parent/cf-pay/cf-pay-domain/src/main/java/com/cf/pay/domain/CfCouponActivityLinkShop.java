package com.cf.pay.domain;

import java.io.Serializable;

public class CfCouponActivityLinkShop implements Serializable {
    private String id;

    private String couponActivityId;

    private String shopId;

    private String scene;

    private Byte mainShop;

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