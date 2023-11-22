package com.cf.carpark;

import com.alibaba.fastjson.JSONObject;
import com.cf.carpark.service.impl.NettyServerInit;
import com.cf.framework.utils.HttpClient;
import com.cf.framework.utils.SpringUtil;
import com.cf.ucenter.domain.CfWeixinConfig;
import com.cf.ucenter.service.CfWeixinConfigService;
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
@ComponentScan(basePackages = {"com.cf.carpark.service","com.cf.carpark.dao","com.cf.framework"})
@MapperScan("com.cf.carpark.dao.mapper")
public class CarParkApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(CarParkApplication.class, args);
    }

    @Autowired
    private NettyServerInit nettyServerInit;

    @Override
    public void run(String... args) throws Exception {
        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                nettyServerInit.init();
            }
        });
        thread.run();
    }
}
