package com.cf.charging.domain.customize;

import java.io.Serializable;

/**
 * 充电桩设备配置实体
 */
public class CfChargingDeviceSetting implements Serializable {

    private Integer maxPower;    //功率(单位 瓦-w)

    private Integer maxAmpere;  //最大电流(单位 安培-A)

    private Integer maxVolt;  //最大电压(单位 伏特-V)

    private Integer heartbeat;  //心跳间隔时间(单位 毫秒)

    private Integer reportRegularly;  //定时上报间隔时间(单位 秒)

    public Integer getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(Integer maxPower) {
        this.maxPower = maxPower;
    }

    public Integer getMaxAmpere() {
        return maxAmpere;
    }

    public void setMaxAmpere(Integer maxAmpere) {
        this.maxAmpere = maxAmpere;
    }

    public Integer getMaxVolt() {
        return maxVolt;
    }

    public void setMaxVolt(Integer maxVolt) {
        this.maxVolt = maxVolt;
    }

    public Integer getHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(Integer heartbeat) {
        this.heartbeat = heartbeat;
    }

    public Integer getReportRegularly() {
        return reportRegularly;
    }

    public void setReportRegularly(Integer reportRegularly) {
        this.reportRegularly = reportRegularly;
    }
}
