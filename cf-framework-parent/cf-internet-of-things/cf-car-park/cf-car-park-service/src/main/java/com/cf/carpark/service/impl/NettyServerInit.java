package com.cf.carpark.service.impl;


import com.cf.carpark.service.core.cache.ClientCache;
import com.cf.carpark.service.core.dto.InitParamDTO;
import com.cf.carpark.service.core.server.IServer;
import com.cf.carpark.service.IMqttDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

/**
 * @author: gebilaowang
 * @date: 2020-11-04 14:28
 * @description: netty启动服务
 **/
@Slf4j
@Component
public class NettyServerInit {
    @Autowired
    private IMqttDataService mqttService;
//    @Autowired
//    private WebSocketDataServiceImpl webSocketDataService;

    @PostConstruct
    public IServer init(){
        // 创建mqtt服务
        //请自己创建mqtt服务，如果不会去，去gitee复制一个
        return null;

//        IServer wsRun = wsServer.run();

        // 测试监听服务客户端状态
//        Thread thread = new Thread(new Runnable() {
//            @SneakyThrows
//            @Override
//            public void run() {
//                while (true) {
//                    Thread.sleep(10000);
//                    Collection<ClientDTO> clientList = mqttRun.getClientAllList();
//                    if (clientList.size() > 0) {
//                        log.info("mqtt客户端连接数:{}:{}", clientList.size());
//                    }
//
////                    Collection<ClientDTO> clientAllList = wsRun.getClientAllList();
////                    if (clientAllList.size() > 0) {
////                        log.info("ws客户端连接数:{}:{}", clientAllList.size());
////                    }
//                }
//            }
//        });
//        thread.run();
    }
}
