package com.cf.sms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 请在此填写描述
 *
 * @ClassName SmsApplication
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/11/21/021 23:17
 * @Version 1.0
 **/
@EnableAutoConfiguration()
@ComponentScan(basePackages = {"com.cf.sms.service","com.cf.sms.dao","com.cf.framework"})
@MapperScan("com.cf.sms.dao.mapper")
public class SmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmsApplication.class, args);
    }
}
