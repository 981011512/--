package com.cf.forward.dh;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 请在此填写描述
 *
 * @ClassName HkApplication
 * @Author yyq 1766462016@qq.com
 * @Date 2021/01/21/021 23:36
 * @Version 1.0
 **/
@Slf4j
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
@ComponentScan(basePackages = {"com.cf.forward.dh","com.cf.framework"})
@EnableAsync
@EnableScheduling
public class DhApplication {


    public static void main(String[] args) {
        SpringApplication.run(DhApplication.class, args);
    }


    @Bean(name = "processExecutor")
    public TaskExecutor workExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("Async-");
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(20);
        threadPoolTaskExecutor.setQueueCapacity(600);
        threadPoolTaskExecutor.afterPropertiesSet();

        // 自定义拒绝策略
        threadPoolTaskExecutor.setRejectedExecutionHandler((r, executor) -> {
            // .....
        });
        // 使用预设的拒绝策略
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        return threadPoolTaskExecutor;
    }

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

}
