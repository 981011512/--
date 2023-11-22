package com.cf.logistics.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 物流任务预约相关业务请求参数实体
 */
public class ReserveParams implements Serializable {

    private Long taskId;    //任务id

    private String numberPlate; //车牌号

    private String deliveryNoteCode;    //进货单条码

    private String deliveryNoteImage;   //进货单图片地址

    private Long taskLogId; //预约记录id

    private BigDecimal positionX;   //经度

    private BigDecimal positionY;   //纬度

    private String uid; //司机id

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getDeliveryNoteCode() {
        return deliveryNoteCode;
    }

    public void setDeliveryNoteCode(String deliveryNoteCode) {
        this.deliveryNoteCode = deliveryNoteCode;
    }

    public String getDeliveryNoteImage() {
        return deliveryNoteImage;
    }

    public void setDeliveryNoteImage(String deliveryNoteImage) {
        this.deliveryNoteImage = deliveryNoteImage;
    }

    public Long getTaskLogId() {
        return taskLogId;
    }

    public void setTaskLogId(Long taskLogId) {
        this.taskLogId = taskLogId;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
