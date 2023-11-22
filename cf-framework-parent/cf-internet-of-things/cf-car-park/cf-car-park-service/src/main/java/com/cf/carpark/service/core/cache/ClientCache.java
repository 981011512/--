package com.cf.carpark.service.core.cache;

import com.cf.carpark.service.core.dto.ClientDTO;
import io.netty.channel.Channel;
import io.netty.handler.codec.mqtt.MqttConnectMessage;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gebilaowang
 * @date 2021/3/11 11:51
 */
public class ClientCache implements IClientCache{
    // 客户端id:客户端
    public static ConcurrentHashMap<String, ClientDTO> channels = new ConcurrentHashMap<>();

    @Override
    public Collection<ClientDTO> getAllList() {
        return channels.values();
    }

    @Override
    public int count() {
        return channels.size();
    }

    @Override
    public void add(Channel channel,MqttConnectMessage message) {
        String sn = "";
        if(message.payload().clientIdentifier().indexOf("_")>=0){
            sn = message.payload().clientIdentifier().substring(0, message.payload().clientIdentifier().indexOf("_"));
        }else{
            sn = message.payload().clientIdentifier();
        }
        ClientDTO build = ClientDTO.build(channel.id().asShortText(), channel, sn, 0);
        channels.put(channel.id().asShortText(),build);
    }

    @Override
    public void remove(Channel channel) {
        channels.remove(channel.id().asShortText());
    }

    @Override
    public ClientDTO get(String clientKey) {
        return null;
    }
}
