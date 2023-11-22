package com.cf.forward.dh.utils;

import lombok.extern.slf4j.Slf4j;

import java.net.ServerSocket;
import java.util.Random;

@Slf4j
public class IpUtil {

    public static Integer getPort(Integer MinPort, Integer MAXPort) {
        Random random = new Random();
        int tempPort = 0;
        int port;
        try{
            while (true){
                tempPort = random.nextInt(MAXPort)%(MAXPort-MinPort+1) + MinPort;
                ServerSocket serverSocket =  new ServerSocket(tempPort);
                port = serverSocket.getLocalPort();
                log.info("获取到空闲端口：" + port);
                serverSocket.close();
                break;
            }
        }catch (Exception e){
            log.info("端口{}被占用，重新分配！",tempPort);
            port = getPort(MinPort,MAXPort);
        }
        return port;
    }
}
