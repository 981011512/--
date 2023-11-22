package com.cf.pay.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 支付服务启动类
 *
 * @ClassName SmsApplication
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/11/21/021 23:17
 * @Version 1.0
 **/
@EnableAutoConfiguration()
@ComponentScan(basePackages = {"com.cf.pay.service","com.cf.pay.dao","com.cf.framework"})
@MapperScan("com.cf.pay.dao.mapper")
public class PayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class, args);
    }
}
