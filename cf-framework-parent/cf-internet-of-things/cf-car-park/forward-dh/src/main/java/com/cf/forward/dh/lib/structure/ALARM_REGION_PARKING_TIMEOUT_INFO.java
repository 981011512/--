package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 事件类型 NET_ALARM_REGION_PARKING_TIMEOUT(区间车位停车超时)
 *
 * @author ： 47040
 * @since ： Created in 2020/8/19 14:50
 */
public class ALARM_REGION_PARKING_TIMEOUT_INFO extends NetSDKLib.SdkStructure {
    /**
     * 0:脉冲
     */
    public int nAction;
    /**
     * 通道号
     */
    public int nChannelID;
    /**
     * 事件发生的时间
     */
    public NET_TIME_EX UTC;
    /**
     * 车辆驶入停车场时间(单位：秒)
     */
    public NET_TIME_EX stuCarInParkingLotTime;
    /**
     * 车牌号码
     */
    public byte[] szPlateNumber = new byte[64];
    /**
     * 停车区间信息
     */
    public byte[] szInParkRegionInfo = new byte[128];
    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[1024];
}
