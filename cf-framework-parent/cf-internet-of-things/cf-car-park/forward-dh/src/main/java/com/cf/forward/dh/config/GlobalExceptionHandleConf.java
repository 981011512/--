package com.cf.forward.dh.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.UndeclaredThrowableException;

/**
 * 全局异常处理配置
 * @author EternalRay
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandleConf {

    /**
     * 顶级异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public void handlerException(Exception e){
        //annotation抛出的异常
        if(e instanceof UndeclaredThrowableException) {
            e = (Exception) ((UndeclaredThrowableException)e).getUndeclaredThrowable();
        }
        log.error("[handleException]: ",e);
        System.out.println(e.getMessage());
    }
}
