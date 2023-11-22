package com.cf.carpark.device.camera.ZhenShi;

import java.io.Serializable;

/**
 *
 * @ClassName AlarmInfoPlate
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/1/001 14:54
 * @Version 1.0
 **/
public class AlarmInfoPlate implements Serializable {
        Integer channel;
        String deviceName;
        String ipaddr;
        String serialno;
        String user_data;
        Result result;

        public Integer getChannel() {
            return channel;
        }

        public void setChannel(Integer channel) {
            this.channel = channel;
        }

        public String getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }

        public String getIpaddr() {
            return ipaddr;
        }

        public void setIpaddr(String ipaddr) {
            this.ipaddr = ipaddr;
        }

        public String getSerialno() {
            return serialno;
        }

        public void setSerialno(String serialno) {
            this.serialno = serialno;
        }

        public String getUser_data() {
            return user_data;
        }

        public void setUser_data(String user_data) {
            this.user_data = user_data;
        }

        public Result getResult() {
            return result;
        }

        public void setResult(Result result) {
            this.result = result;
        }
}
