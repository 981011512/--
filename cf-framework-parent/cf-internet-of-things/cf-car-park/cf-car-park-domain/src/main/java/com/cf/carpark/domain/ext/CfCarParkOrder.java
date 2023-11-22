package com.cf.carpark.domain.ext;

import com.cf.carpark.domain.*;
import com.cf.pay.domain.CfCoupon;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.response.ResultMap;

import java.io.Serializable;
import java.util.List;

/**
 * 停车场订单
 *
 * @ClassName CfCarParkOrder
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/7/007 7:34
 * @Version 1.0
 **/
public class CfCarParkOrder implements Serializable {
    private CfCarParkUseLog cfCarParkUseLog;

    private CfCarPark cfCarPark;

    private CfOrder cfOrder;

    private CfCarParkCheckpoint inCheckpoint;

    private CfCarParkCheckpoint outCheckpoint;

    private List<CfCoupon> cfCouponList;

    private ResultMap resultMap;

    private String qrCode;

    private CfCarParkPackage cfCarParkPackage;

    private CfCarParkSpecialCar cfCarParkSpecialCar;

    private CfCarParkCarType cfCarParkCarType;

    public CfCarParkUseLog getCfCarParkUseLog() {
        return cfCarParkUseLog;
    }

    public void setCfCarParkUseLog(CfCarParkUseLog cfCarParkUseLog) {
        this.cfCarParkUseLog = cfCarParkUseLog;
    }

    public CfCarPark getCfCarPark() {
        return cfCarPark;
    }

    public void setCfCarPark(CfCarPark cfCarPark) {
        this.cfCarPark = cfCarPark;
    }

    public CfOrder getCfOrder() {
        return cfOrder;
    }

    public void setCfOrder(CfOrder cfOrder) {
        this.cfOrder = cfOrder;
    }

    public CfCarParkCheckpoint getInCheckpoint() {
        return inCheckpoint;
    }

    public void setInCheckpoint(CfCarParkCheckpoint inCheckpoint) {
        this.inCheckpoint = inCheckpoint;
    }

    public CfCarParkCheckpoint getOutCheckpoint() {
        return outCheckpoint;
    }

    public void setOutCheckpoint(CfCarParkCheckpoint outCheckpoint) {
        this.outCheckpoint = outCheckpoint;
    }

    public ResultMap getResultMap() {
        return resultMap;
    }

    public void setResultMap(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    public List<CfCoupon> getCfCouponList() {
        return cfCouponList;
    }

    public void setCfCouponList(List<CfCoupon> cfCouponList) {
        this.cfCouponList = cfCouponList;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public CfCarParkPackage getCfCarParkPackage() {
        return cfCarParkPackage;
    }

    public void setCfCarParkPackage(CfCarParkPackage cfCarParkPackage) {
        this.cfCarParkPackage = cfCarParkPackage;
    }

    public CfCarParkSpecialCar getCfCarParkSpecialCar() {
        return cfCarParkSpecialCar;
    }

    public void setCfCarParkSpecialCar(CfCarParkSpecialCar cfCarParkSpecialCar) {
        this.cfCarParkSpecialCar = cfCarParkSpecialCar;
    }

    public CfCarParkCarType getCfCarParkCarType() {
        return cfCarParkCarType;
    }

    public void setCfCarParkCarType(CfCarParkCarType cfCarParkCarType) {
        this.cfCarParkCarType = cfCarParkCarType;
    }
}
