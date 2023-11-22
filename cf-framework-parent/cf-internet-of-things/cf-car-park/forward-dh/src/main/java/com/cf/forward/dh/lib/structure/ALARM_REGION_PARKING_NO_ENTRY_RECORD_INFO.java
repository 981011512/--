package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * 事件类型 {@link NetSDKLib#NET_ALARM_REGION_PARKING_NO_ENTRY_RECORD}(区间车位停车,检测到车辆驶出区域时没有匹配到入场信息)
 * 调用的接口{@link NetSDKLib#CLIENT_RealLoadPictureEx(NetSDKLib.LLong, int, int, int, Callback, Pointer, Pointer)}
 * 使用的回调{@link NetSDKLib.fAnalyzerDataCallBack}
 *
 * @author ： 47040
 * @since ： Created in 2020/8/19 15:00
 */
public class ALARM_REGION_PARKING_NO_ENTRY_RECORD_INFO extends NetSDKLib.SdkStructure {

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
     * 车辆驶出区域停车位时间(单位：秒)
     */
    public NET_TIME_EX stuCarOutParkingSpaceTime;
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
