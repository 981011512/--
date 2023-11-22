package com.cf.carpark.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

public class CfCarParkFinanceReport implements Serializable {

    private static final long serialVersionUID = 1L;

    private String carParkId;

    private String carParkName;

    private byte goodsType;

    private Double totalAmountsPayable;  //总应付金额

    private Double totalAmountActuallyPaid;  //总实付金额

    private Double parkingTotalAmountsPayable;  //停车费总应付金额

    private Double parkingTotalAmountActuallyPaid;  //停车费总实付金额

    private Double parkingPackageTotalAmountsPayable;   //车辆套餐总应付金额

    private Double parkingPackageTotalAmountActuallyPaid;    //车辆套餐总实付金额

    private Double parkCouponActivityRechargeTotalAmountsPayable;    //优惠券活动充值总应付金额

    private Double parkCouponActivityRechargeTotalAmountActuallyPaid;    //优惠券活动充值总实付金额

    private Map<String,Double> paymentChannel;  //支付渠道统计

    private Double total;

    public String getCarParkId() {
        return carParkId;
    }

    public void setCarParkId(String carParkId) {
        this.carParkId = carParkId;
    }

    public String getCarParkName() {
        return carParkName;
    }

    public void setCarParkName(String carParkName) {
        this.carParkName = carParkName;
    }

    public byte getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(byte goodsType) {
        this.goodsType = goodsType;
    }

    public Double getParkingTotalAmountsPayable() {
        return parkingTotalAmountsPayable;
    }

    public void setParkingTotalAmountsPayable(Double parkingTotalAmountsPayable) {
        this.parkingTotalAmountsPayable = parkingTotalAmountsPayable;
    }

    public Double getParkingTotalAmountActuallyPaid() {
        return parkingTotalAmountActuallyPaid;
    }

    public void setParkingTotalAmountActuallyPaid(Double parkingTotalAmountActuallyPaid) {
        this.parkingTotalAmountActuallyPaid = parkingTotalAmountActuallyPaid;
    }

    public Double getParkingPackageTotalAmountsPayable() {
        return parkingPackageTotalAmountsPayable;
    }

    public void setParkingPackageTotalAmountsPayable(Double parkingPackageTotalAmountsPayable) {
        this.parkingPackageTotalAmountsPayable = parkingPackageTotalAmountsPayable;
    }

    public Double getParkingPackageTotalAmountActuallyPaid() {
        return parkingPackageTotalAmountActuallyPaid;
    }

    public void setParkingPackageTotalAmountActuallyPaid(Double parkingPackageTotalAmountActuallyPaid) {
        this.parkingPackageTotalAmountActuallyPaid = parkingPackageTotalAmountActuallyPaid;
    }

    public Double getParkCouponActivityRechargeTotalAmountsPayable() {
        return parkCouponActivityRechargeTotalAmountsPayable;
    }

    public void setParkCouponActivityRechargeTotalAmountsPayable(Double parkCouponActivityRechargeTotalAmountsPayable) {
        this.parkCouponActivityRechargeTotalAmountsPayable = parkCouponActivityRechargeTotalAmountsPayable;
    }

    public Double getParkCouponActivityRechargeTotalAmountActuallyPaid() {
        return parkCouponActivityRechargeTotalAmountActuallyPaid;
    }

    public void setParkCouponActivityRechargeTotalAmountActuallyPaid(Double parkCouponActivityRechargeTotalAmountActuallyPaid) {
        this.parkCouponActivityRechargeTotalAmountActuallyPaid = parkCouponActivityRechargeTotalAmountActuallyPaid;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Map<String, Double> getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(Map<String, Double> paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public Double getTotalAmountsPayable() {
        return totalAmountsPayable;
    }

    public void setTotalAmountsPayable(Double totalAmountsPayable) {
        this.totalAmountsPayable = totalAmountsPayable;
    }

    public Double getTotalAmountActuallyPaid() {
        return totalAmountActuallyPaid;
    }

    public void setTotalAmountActuallyPaid(Double totalAmountActuallyPaid) {
        this.totalAmountActuallyPaid = totalAmountActuallyPaid;
    }
}