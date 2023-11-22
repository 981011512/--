package com.cf.forward.hk.web.domain;

/**
 * 作者:林国定 邮件:lingguoding@gmail.com
 * 创建时间:2021/2/27 下午5:36
 * 描述:
 */
public class ForwardParam {
    private String deviceIP;
    private String username;
    private String password;
    private short port;

    public String getDeviceIP() {
        return deviceIP;
    }

    public void setDeviceIP(String deviceIP) {
        this.deviceIP = deviceIP;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getPort() {
        return port;
    }

    public void setPort(short port) {
        this.port = port;
    }
}
