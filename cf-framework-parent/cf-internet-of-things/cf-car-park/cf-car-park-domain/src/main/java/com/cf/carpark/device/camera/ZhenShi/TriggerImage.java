package com.cf.carpark.device.camera.ZhenShi;

import java.io.Serializable;

/**
 *
 * @ClassName TriggerImage
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/3/003 10:25
 * @Version 1.0
 **/
public class TriggerImage implements Serializable {
    Integer port;
    String snapImageRelativeUrl;
    String snapImageAbsolutelyUrl;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getSnapImageRelativeUrl() {
        return snapImageRelativeUrl;
    }

    public void setSnapImageRelativeUrl(String snapImageRelativeUrl) {
        this.snapImageRelativeUrl = snapImageRelativeUrl;
    }

    public String getSnapImageAbsolutelyUrl() {
        return snapImageAbsolutelyUrl;
    }

    public void setSnapImageAbsolutelyUrl(String snapImageAbsolutelyUrl) {
        this.snapImageAbsolutelyUrl = snapImageAbsolutelyUrl;
    }
}
