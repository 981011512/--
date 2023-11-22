package com.cf.logistics;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 请在此填写描述
 *
 * @ClassName LogisticsApplication
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2022/11/21/021 23:17
 * @Version 1.0
 **/
@EnableAutoConfiguration()
@ComponentScan(basePackages = {"com.cf.logistics.service","com.cf.logistics.dao","com.cf.framework"})
@MapperScan("com.cf.logistics.dao.mapper")
public class LogisticsApplication{

    public static void main(String[] args) {
        SpringApplication.run(LogisticsApplication.class, args);
    }
}
