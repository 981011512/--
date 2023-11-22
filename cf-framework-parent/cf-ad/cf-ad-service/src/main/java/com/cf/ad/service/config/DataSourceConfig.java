package com.cf.ad.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 如果需要shardingsphere分库分表功能时，需要把下面的配置类打开
 */
@Configuration
public class DataSourceConfig {

//    @ConfigurationProperties(prefix="spring.shardingsphere.datasource")
//    @Bean
//    public DataSource dataSource(){
//        return DataSourceBuilder.create().build();
//    }

}
