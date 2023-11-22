package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarParkDevice;
import com.cf.carpark.domain.CfCarParkPackage;
import io.netty.channel.Channel;

import java.util.List;

/**
 * 数据接收，发送业务逻辑接口
 * @author gebilaowang
 * @date 2021/3/10 16:22
 */
public interface IMqttDataService {

    /**
     * 接收到的消息
     *
     * @param topic 主题
     * @param inputMessage: 接收数据
     * @param packetId: 报文标识符
     * @return String: 向客户端响应的数据
     * @author gebilaowang
     * @date 2021/3/10 16:28
     */
    String inputListening(Channel channel, String topic, String inputMessage, Integer packetId) throws Exception;

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
     * @param packetId: 报文标识符
     * @return
     * @author gebilaowang
     * @date 2021/3/10 16:32
     */
    void pushTopic(Channel channel, String message, String topic, Integer packetId) throws Exception;

    /**
     * 给列表中的指定通道发布消息
     * @param flageKey  例如设备的 序列号 sn
     * @param message
     * @param topic
     */
    void pushTopics(String flageKey, String message, String topic) throws Exception;

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
    void pushAll(String message) throws Exception;

    /**
     * 下发白名单
     * @param channel
     * @param sn
     * @param packetId
     * @param operateType 白名单操作 0-添加 1-删除
     */
    void issuedWhitelist(Channel channel, String sn, Integer packetId, byte operateType) throws Exception;

    /**
     * 同步车辆套餐数据到硬件相机白名单里面
     * @param channel
     * @param sn
     * @param packetId
     * @param operateType
     * @param cfCarParkPackages
     * @param cfCarParkDevice
     * @throws Exception
     */
    void synchronizePackageDataToDevice(Channel channel, String sn, Integer packetId, byte operateType, List<CfCarParkPackage> cfCarParkPackages, CfCarParkDevice cfCarParkDevice) throws Exception;

    /**
     * 统计当前服务器mqtt设备连接数
     * @param value 在线设备数
     * @throws Exception
     */
    void countServerLinkCounts(int value) throws Exception;

    /**
     * 获取mqtt协议连接数最少的服务器ip
     * @return
     */
    String getMinDeviceLinkCountsServiceIp();

    /**
     * 更改停车设备消息通知状态
     * @param serialNumber 序列号
     * @date 2021/3/10 16:28
     */
    Integer updateCarParkDeviceStatus(String serialNumber) throws Exception;
}
