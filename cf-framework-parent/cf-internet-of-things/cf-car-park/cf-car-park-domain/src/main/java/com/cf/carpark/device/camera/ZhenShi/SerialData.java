package com.cf.carpark.device.camera.ZhenShi;

import java.io.Serializable;

/**
 *
 * @ClassName SerialData
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/3/003 10:18
 * @Version 1.0
 **/
public class SerialData implements Serializable {
    private Integer serialChannel;
    private Object data;
    private Integer dataLen;
    private Integer channel;
    private String serialno;
    private String ipaddr;
    private String deviceName;

    public Integer getSerialChannel() {
        return serialChannel;
    }

    public void setSerialChannel(Integer serialChannel) {
        this.serialChannel = serialChannel;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getDataLen() {
        return dataLen;
    }

    public void setDataLen(Integer dataLen) {
        this.dataLen = dataLen;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
