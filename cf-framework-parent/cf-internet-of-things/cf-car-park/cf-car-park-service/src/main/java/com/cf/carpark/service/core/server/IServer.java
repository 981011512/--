package com.cf.carpark.service.core.server;

import com.cf.carpark.service.core.dto.ClientDTO;
import com.cf.carpark.service.core.enums.ServerRunStatusEnum;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

import java.util.Collection;
import java.util.List;


/**
 * 服务接口
 * @author gebilaowang
 * @date 2021/3/10 17:35
 */
public interface IServer {
    /**
     * 启动服务
     *
     * @return
     * @author gebilaowang
     * @date 2021/3/11 10:21
     */
    IServer run ();

    /**
     * 运行状态
     *
     * @param
     * @return
     * @author gebilaowang
     * @date 2021/3/11 11:02
     */
    ServerRunStatusEnum status();

    public ChannelFuture send(Channel channel, String topic, String sendMessage, Integer packetId) throws Exception;

    /**
     * 根据flagKey和主题发送消息
     * @param
     * @return
     * @author laowang
     * @date 2021/3/11 10:22
     */
    void sendByFlageKey(String flageKey, String topic, String sendMessage) throws Exception;/**
     * 根据主题发送消息
     *
     * @param
     * @return
     * @author gebilaowang
     * @date 2021/3/11 10:22
     */
    void sendAll(String topic, String sendMessage) throws Exception;

    void sendAllWithoutTopic(String sendMessage) throws Exception;

    /**
     * 获取所有客户端列表
     *
     * @param
     * @return
     * @author gebilaowang
     * @date 2021/3/11 10:22
     */
    Collection<ClientDTO> getClientAllList();

    /**
     * 获取客户端列表，根据主题
     *
     * @param
     * @return
     * @author gebilaowang
     * @date 2021/3/11 10:22
     */
    List<ClientDTO> getClientListByTopic(String... topic);

}
