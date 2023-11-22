package com.cf.forward.dh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "dahua-server")
public class DahuaServerConfig {
    private String startUuid;
}
