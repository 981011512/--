package com.cf.carpark.service.core.dto;

import io.netty.channel.Channel;
import lombok.Data;

import java.util.List;

/**
 * 客户端对象
 * @author gebilaowang
 * @date 2021/3/11 9:58
 */
@Data
public class ClientDTO {
    // 客户端id
    private String id;
    // 对应通道
    private Channel channel;
    // 订阅主题
    private List<String> topic;
    // flagKey  例如 硬件设备 序列号
    private String flagKey;

    private Integer packetId;   //报文标识符

    private Long lastOnLineTime;    //最近在线时间

    public static ClientDTO build(String id, Channel channel, String flagKey, Integer packetId){
        return build(id,channel,null, flagKey, packetId);
    }
    public static ClientDTO build(String id, Channel channel, List<String> topic, String flagKey, Integer packetId){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(id);
        clientDTO.setChannel(channel);
        clientDTO.setTopic(topic);
        clientDTO.setFlagKey(flagKey);
        clientDTO.setPacketId(packetId);
        return clientDTO;
    }
}
