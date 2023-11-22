package com.cf.forward.dh.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyUncaughtExceptionHandler  implements Thread.UncaughtExceptionHandler {

    private static Logger log = LoggerFactory.getLogger(MyUncaughtExceptionHandler .class);

    public void uncaughtException(Thread t, Throwable ex) {
        log.error("未捕获的异常: " + t.getName(), ex);
    }

}
