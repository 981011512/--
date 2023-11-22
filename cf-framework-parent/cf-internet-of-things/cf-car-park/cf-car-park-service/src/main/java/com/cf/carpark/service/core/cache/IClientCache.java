package com.cf.carpark.service.core.cache;

import com.cf.carpark.service.core.dto.ClientDTO;
import io.netty.channel.Channel;
import io.netty.handler.codec.mqtt.MqttConnectMessage;

import java.util.Collection;


/**
 * 客户端缓存
 * @author gebilaowang
 * @date 2021/3/11 10:41
 */
public interface IClientCache {
    Collection<ClientDTO> getAllList();
    // 客户端总数量
    int count();
    // 添加客户端
    void add(Channel channel,MqttConnectMessage message);
    // 删除客户端
    void remove(Channel channel);
    // 提取客户端
    ClientDTO get(String clientKey);
}
