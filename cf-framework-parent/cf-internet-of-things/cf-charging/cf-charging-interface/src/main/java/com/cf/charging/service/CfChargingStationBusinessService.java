package com.cf.charging.service;

import com.cf.charging.domain.CfChargingUseLog;
import com.cf.charging.domain.customize.CfChargingState;
import com.cf.charging.domain.request.CfChargingStationDeviceForm;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.context.ApplicationContext;

/**
 * 充电站业务处理服务
 */
public interface CfChargingStationBusinessService {

    /**
     * 处理连接
     * @param ctx
     * @param msg
     * @return
     */
    void handleLink(ChannelHandlerContext ctx, Object msg) throws Exception;

    /**
     * 开始充电
     * @param cfChargingStationDeviceForm
     * @return
     */
    CfChargingUseLog startCharging(CfChargingStationDeviceForm cfChargingStationDeviceForm) throws Exception;

    /**
     * 停止充电(管理人员专用)
     * @param cfChargingStationDeviceForm
     * @return
     */
    CfChargingState stopCharging(CfChargingStationDeviceForm cfChargingStationDeviceForm) throws Exception;

    /**
     * 停止充电(普通用户专用)
     * @param cfChargingStationDeviceForm
     * @return
     * @throws Exception
     */
    CfChargingUseLog clientStopCharging(CfChargingStationDeviceForm cfChargingStationDeviceForm) throws Exception;

    /**
     * 充电配置
     * @param cfChargingStationDeviceForm
     * @return
     */
    CfChargingState chargingSettiong(CfChargingStationDeviceForm cfChargingStationDeviceForm) throws Exception;

    /**
     * 获取充电口实时数据
     * @param cfChargingStationDeviceForm
     * @return
     */
    CfChargingState getPortRealTimeData(CfChargingStationDeviceForm cfChargingStationDeviceForm) throws Exception;

    /**
     * 完成充电
     * @param cfChargingState
     */
    void finishCharing(CfChargingState cfChargingState);

    /**
     * 检查当前设备是否在本机
     * @param serialNumber
     */
    String checkSameServer(String serialNumber) throws Exception;

    Channel initSocketClientAndSendMessage(String host, String message) throws Exception;

    /**
     * 开始正式充电，扣费
     * @param cfChargingUseLog
     * @return
     */
    void charingAndBilling(CfChargingUseLog cfChargingUseLog);

    /**
     * 发送消息
     * @param messageContents
     * @param uid
     * @param messageType
     * @throws Exception
     */
    void sendMessage(Object messageContents, String uid, Integer messageType) throws Exception;

}
