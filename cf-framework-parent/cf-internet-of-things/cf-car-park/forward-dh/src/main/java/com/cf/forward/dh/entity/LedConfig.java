package com.cf.forward.dh.entity;

/**
 * <p>
 * 描述
 * </p>
 *
 * @author 武汉才风智慧科技有限公司-Wuhan Caifeng Smart Technology Co., Ltd
 * @Linker +86 18086495676 Mr Wang 18086495676@163.com
 * @date 2022-12-06
 * @Version cfzh Smarter Cities V3.0
 */
public class LedConfig {

    private String ip;
    private Integer port;
    private String uuid;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
