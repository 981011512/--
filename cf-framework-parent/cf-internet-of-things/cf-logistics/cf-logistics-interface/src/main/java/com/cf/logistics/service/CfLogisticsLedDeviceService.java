package com.cf.logistics.service;

import com.cf.logistics.domain.CfLogisticsLedDevice;
import com.cf.logistics.domain.CfLogisticsLedDeviceExample;
import com.cf.logistics.domain.device.CfLinXinLed;
import com.cf.logistics.domain.request.CfLogisticsLedDeviceQuery;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

public interface CfLogisticsLedDeviceService {

    CfLogisticsLedDevice add(CfLogisticsLedDevice cfLogisticsLedDevice);

    CfLogisticsLedDevice update(CfLogisticsLedDevice cfLogisticsLedDevice);

    Integer delete(Long id);

    CfLogisticsLedDevice findById(Long id);

    CfLogisticsLedDevice findById(Long id, boolean expectEmpty);

    CfLogisticsLedDeviceExample getExampleByQuery(CfLogisticsLedDeviceQuery cfLogisticsLedDeviceQuery);

    List<CfLogisticsLedDevice> getListByQuery(CfLogisticsLedDeviceQuery cfLogisticsLedDeviceQuery);

    Integer countByQuery(CfLogisticsLedDeviceQuery cfLogisticsLedDeviceQuery);

    /**
     * 处理连接
     * @param ctx
     * @param msg
     * @return
     */
    void handleLink(ChannelHandlerContext ctx, Object msg) throws Exception;

    /**
     * 制作tcp数据
     * @param serialNumber  LED主板序列号
     * @param cfLinXinLed
     * @return
     * @throws Exception
     */
    String makeTcpData(String serialNumber, CfLinXinLed cfLinXinLed) throws Exception;

    /**
     * 发送tcp数据
     * @param serialNumber
     * @param cfLinXinLed
     */
    void sendTcpData(String serialNumber, CfLinXinLed cfLinXinLed) throws Exception;

}
