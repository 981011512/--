package com.cf.ucenter.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;



//@EnableFeignClients
@EntityScan("com.cf.framework.domain.ucenter.dao")//扫描实体类
@ComponentScan(basePackages={"com.cf.ucenter.auth"})//扫描接口
@ComponentScan(basePackages={"com.cf.framework"})//扫描common下的所有类
@MapperScan("com.cf.ucenter.dao.mapper")
@SpringBootApplication
public class UcenterAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(UcenterAuthApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }

}
