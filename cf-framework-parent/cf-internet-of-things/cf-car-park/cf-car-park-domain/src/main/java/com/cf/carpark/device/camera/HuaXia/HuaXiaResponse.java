package com.cf.carpark.device.camera.HuaXia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 华夏相机响应实体
 */
public class HuaXiaResponse implements Serializable {

    private Integer error_num;  //错误码，0 表示无错误，其它表示有错误
    private String error_str;   //错误信息 可自动
    private String passwd;  //密码
    private List<GpioData> gpio_data;  //开闸数据
    private List<Rs485Data> rs485_data;    //显示屏 文字和语音
    private TrigerData triger_data; //软件触发数据
    private List<WhitelistData> whitelist_data;   //白名单数据
    private Object mqttDatas;   //mqtt数据

    public Integer getError_num() {
        return error_num;
    }

    public void setError_num(Integer error_num) {
        this.error_num = error_num;
    }

    public String getError_str() {
        return error_str;
    }

    public void setError_str(String error_str) {
        this.error_str = error_str;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public List<GpioData> getGpio_data() {
        return gpio_data;
    }

    public void setGpio_data(List<GpioData> gpio_data) {
        this.gpio_data = gpio_data;
    }

    public List<Rs485Data> getRs485_data() {
        return rs485_data;
    }

    public void setRs485_data(List<Rs485Data> rs485_data) {
        this.rs485_data = rs485_data;
    }

    public TrigerData getTriger_data() {
        return triger_data;
    }

    public void setTriger_data(TrigerData triger_data) {
        this.triger_data = triger_data;
    }

    public List<WhitelistData> getWhitelist_data() {
        return whitelist_data;
    }

    public void setWhitelist_data(List<WhitelistData> whitelist_data) {
        this.whitelist_data = whitelist_data;
    }

    public Object getMqttDatas() {
        return mqttDatas;
    }

    public void setMqttDatas(Object mqttDatas) {
        this.mqttDatas = mqttDatas;
    }
}
