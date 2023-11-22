package com.cf.carpark.service.core.service;

import io.netty.channel.Channel;

/**
 * 数据接收，发送业务逻辑接口
 * @author gebilaowang
 * @date 2021/3/10 16:22
 */
public interface IWebsocketDataService {

    /**
     * 接收到的消息
     *
     * @param topic 主题
     * @param inputMessage: 接收数据
     * @return String: 向客户端响应的数据
     * @author gebilaowang
     * @date 2021/3/10 16:28
     */
    String inputListening(Channel channel, String topic, String inputMessage);

    /**
     * 推送数据
     *
     * @param userOnlyCode: 用户唯一标识
     * @param message: 消息内容
     * @return
     * @author gebilaowang
     * @date 2021/3/10 16:25
     */
    void push(String userOnlyCode,String message);

    /**
     * 推送主题内指定用户
     * @param channel
     * @param topic: 主题
     * @param message: 消息内容
     * @return
     * @author gebilaowang
     * @date 2021/3/10 16:32
     */
    void pushTopic(Channel channel, String message, String topic) throws Exception;

    /**
     * 推送主题内所有用户
     *
     * @param topics: 主题
     * @param message: 消息内容
     * @return
     * @author gebilaowang
     * @date 2021/3/10 16:32
     */
    void pushTopicAll(String message,String... topics) throws Exception;

    /**
     * 推送全部用户
     *
     * @param message: 消息内容
     * @return
     * @author gebilaowang
     * @date 2021/3/10 16:32
     */
    void pushAll(String message);


}
