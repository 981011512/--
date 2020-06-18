package com.cf.chat;

import com.cf.chat.netty.WebSocketServer;
import com.cf.framework.utils.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 请在此填写描述
 *
 * @ClassName ChatApplication
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/11/21/021 23:17
 * @Version 1.0
 **/
@EnableAutoConfiguration()
@ComponentScan(basePackages = {"com.cf.chat.service","com.cf.chat.netty","com.cf.chat.dao","com.cf.framework"})
@MapperScan("com.cf.chat.dao.mapper")
public class ChatApplication implements CommandLineRunner {

    //将springutils交由spring进行管理
    @Bean
    public SpringUtil getSpringUtil(){
        return new SpringUtil();
    }

    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
    }

    /**
     * 【注意事项】：若netty服务启动失败时请删除下面两个方法，同时删除本类对CommandLineRunner的实现，因为当前
     * 整合dubbo无法启动Listener才作此处理的
     */

    @Autowired
    private WebSocketServer websocketServer;

    @Override
    public void run(String... args) throws Exception {
        this.websocketServer.start();
    }
}
