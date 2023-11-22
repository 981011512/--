package com.cf.forward.hk.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 作者:才风智慧科技 老王
 * 创建时间:2021/2/27 上午8:31
 * 描述:
 */
@Data
@ConfigurationProperties("hk.forward")
@Component
public class HkForwardProperties {

    /**
     * 本地IP 地址
     */
    private String localIP;
    /**
     *  设备IP 地址
     */
    private String deviceIP;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 端口
     */
    private String port;

    /**
     * 基 URL
     */
    private String baseUrl;

}
