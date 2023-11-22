package com.cf.charging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 充电桩接口服务启动类
 *
 * @ClassName ChargingApiApplication
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2022/01/01/021 23:36
 * @Version 1.0
 **/
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.cf.charging.api"})
@ComponentScan(basePackages = {"com.cf.framework"})   //扫描common包,因为我们需要在Common中统一捕获异常和其它处理
@EnableSwagger2
public class ChargingApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChargingApiApplication.class,args);
    }

}
