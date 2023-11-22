package com.cf.forward.dh.config;

import com.cf.forward.dh.entity.CameraInfo;
import com.cf.forward.dh.entity.LedConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 作者:才风智慧老王
 * 创建时间:2022/5/27 上午8:31
 * 描述:
 */
@Data
@ConfigurationProperties("dh.forward")
@Component
public class DhForwardProperties {

    private List<CameraInfo> cameraInfoes;

    private String coding;  //编码，主要处理相机车牌号编码 GBK  UTF-8

    private String ledBrand;  //led主板品牌

    private List<LedConfig> ledConfigs;

}
