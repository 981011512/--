package com.cf.logistics.service.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SocketNettyListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private SocketServer socketServer;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null) {
            try {
                socketServer.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
