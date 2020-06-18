package com.cf.file;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * 请在此填写描述
 *
 * @ClassName SmsApplication
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/11/21/021 23:17
 * @Version 1.0
 **/
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.cf.file.service","com.cf.file.dao","com.cf.framework"})
@MapperScan("com.cf.file.dao.mapper")
public class FileApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class, args);
    }
}
