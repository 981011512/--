package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_TRFAFFIC_LIGHT_SOURCE;

/**
 * (交通灯事件)对应的数据块描述信息
 *
 * @author ： 47040
 * @since ： Created in 2020/8/29 16:41
 */
public class ALARM_TRAFFIC_LIGHT_STATE_INFO extends NetSDKLib.SdkStructure {

    /**
     * 通道号
     */
    public int nChannelID;
    /**
     * 0:脉冲 1:开始 2:停止
     */
    public int nAction;
    /**
     * 事件名称
     */
    public byte[] szName = new byte[128];
    /**
     * 时间戳(单位是毫秒)
     */
    public double PTS;
    /**
     * 事件发生的时间
     */
    public NET_TIME_EX UTC;
    /**
     * 事件ID
     */
    public int nEventID;
    /**
     * 视频分析的数据源地址
     */
    public int nSource;
    /**
     * 帧序号
     */
    public int nFrameSequence;
    /**
     * 红绿灯触发源 枚举{@link EM_TRFAFFIC_LIGHT_SOURCE}
     */
    public int emLightSource;
    /**
     * stuLightPeriods元素个数
     */
    public int nLightPeriodsNum;
    /**
     * 每个元素表示一种灯亮的持续时间，时间单位毫秒
     */
    public NET_LIGHTPERIODS_INFO[] stuLightPeriods = new NET_LIGHTPERIODS_INFO[4];
    /**
     * 交通灯状态，数组下标为车道号，实际只用到了第一个元素
     */
    public NET_TRAFFIC_LIGHT_STATE[] stuLightStates = new NET_TRAFFIC_LIGHT_STATE[8];
    /**
     * stuLightStates元素个数
     */
    public int nLightStateNum;
    /**
     * 预留字段
     */
    public byte[] byReserved = new byte[1020];

    public ALARM_TRAFFIC_LIGHT_STATE_INFO() {
        for (int i = 0; i < stuLightPeriods.length; i++) {
            stuLightPeriods[i] = new NET_LIGHTPERIODS_INFO();
        }

        for (int j = 0; j < stuLightStates.length; j++) {
            stuLightStates[j] = new NET_TRAFFIC_LIGHT_STATE();
        }

    }
}
