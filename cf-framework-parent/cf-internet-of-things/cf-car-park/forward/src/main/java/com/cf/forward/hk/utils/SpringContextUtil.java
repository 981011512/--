package com.cf.forward.hk.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {

    public static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringContextUtil.context = context;
    }

    /**
     * 获取容器中的实例
     * @param clazz 根据class获取Spring容器中对应的Bean类
     */
    public static <T> T getBean( Class<T> clazz){
        return context.getBean(clazz);
    }

    public static ApplicationContext getContext(){
        return context;
    }
}
