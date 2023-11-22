package com.cf.ad.service;

import lombok.SneakyThrows;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 请在此填写描述
 *
 * @ClassName carparkApplication
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/11/21/021 23:17
 * @Version 1.0
 **/
@EnableAutoConfiguration()
@ComponentScan(basePackages = {"com.cf.ad.service","com.cf.ad.dao","com.cf.framework"})
@MapperScan("com.cf.ad.dao.mapper")
public class AdApplication{
    public static void main(String[] args) {
        SpringApplication.run(AdApplication.class, args);
    }
}
