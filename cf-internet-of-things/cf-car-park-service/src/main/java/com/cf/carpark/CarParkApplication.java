package com.cf.carpark;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 请在此填写描述
 *
 * @ClassName carparkApplication
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/11/21/021 23:17
 * @Version 1.0
 **/
@EnableAutoConfiguration()
@ComponentScan(basePackages = {"com.cf.carpark.service","com.cf.carpark.dao","com.cf.framework"})
@MapperScan("com.cf.carpark.dao.mapper")
public class CarParkApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarParkApplication.class, args);
    }
}
