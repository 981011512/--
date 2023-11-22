package com.cf.carpark.service.core.cache;

import com.cf.carpark.service.core.enums.ServerTypeEnum;
import com.cf.carpark.service.core.server.IServer;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务列表缓存
 * @author gebilaowang
 * @date 2021/3/10 17:37
 */
public interface IServerListCache {
    // 运行中服务列表
    Map<String, IServer> SERVER_LIST_MAP = new HashMap<>();

    static IServer getServer(ServerTypeEnum serverTypeEnum){
        return SERVER_LIST_MAP.get(serverTypeEnum.TYPE);
    }
}
