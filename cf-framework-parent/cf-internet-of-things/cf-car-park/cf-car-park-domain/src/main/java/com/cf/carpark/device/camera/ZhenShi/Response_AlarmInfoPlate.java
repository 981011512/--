package com.cf.carpark.device.camera.ZhenShi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @ClassName Response_AlarmInfoPlate
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/3/003 10:28
 * @Version 1.0
 **/
public class Response_AlarmInfoPlate implements Serializable {
    String info;
    String plateid;
    Integer channelNum;
    String manualTrigger;
    TriggerImage TriggerImage;
    String is_pay;
    List<SerialData> serialData;
    WhiteListOperate white_list_operate;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPlateid() {
        return plateid;
    }

    public void setPlateid(String plateid) {
        this.plateid = plateid;
    }

    public Integer getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(Integer channelNum) {
        this.channelNum = channelNum;
    }

    public String getManualTrigger() {
        return manualTrigger;
    }

    public void setManualTrigger(String manualTrigger) {
        this.manualTrigger = manualTrigger;
    }

    @JsonProperty("TriggerImage")
    public com.cf.carpark.device.camera.ZhenShi.TriggerImage getTriggerImage() {
        return TriggerImage;
    }

    public void setTriggerImage(com.cf.carpark.device.camera.ZhenShi.TriggerImage triggerImage) {
        TriggerImage = triggerImage;
    }

    public String getIs_pay() {
        return is_pay;
    }

    public void setIs_pay(String is_pay) {
        this.is_pay = is_pay;
    }

    public List<SerialData> getSerialData() {
        return serialData;
    }

    public void setSerialData(List<SerialData> serialData) {
        this.serialData = serialData;
    }

    @JsonProperty("white_list_operate")
    public WhiteListOperate getWhite_list_operate() {
        return white_list_operate;
    }

    public void setWhite_list_operate(WhiteListOperate white_list_operate) {
        this.white_list_operate = white_list_operate;
    }
}
