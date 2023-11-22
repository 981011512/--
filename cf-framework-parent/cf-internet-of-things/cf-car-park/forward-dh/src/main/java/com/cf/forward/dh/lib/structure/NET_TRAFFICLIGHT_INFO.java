package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * className：NET_TRAFFICLIGHT_INFO
 * description：交通信号灯信息
 * author：251589
 * createTime：2021/1/19 15:04
 *
 * @version v1.0
 */
public class NET_TRAFFICLIGHT_INFO extends NetSDKLib.SdkStructure {
    /**
     *  UTC时间, 发生红绿灯切换时的时间, 本地时区
     */
    public NET_TIME stuUTC;

    /**
     *  stuChannels 有效个数
     */
    public int nRetChannelNum;

    /**
     *  通道信息
     */
    public NET_TRAFFICLIGHT_CHANNEL_INFO[] stuChannels = (NET_TRAFFICLIGHT_CHANNEL_INFO[])new NET_TRAFFICLIGHT_CHANNEL_INFO().toArray(32);

    /**
     *  nLightChangedChannels 有效个数
     */
    public int nRetLightChangedNum;

    /**
     *  发生红绿灯变换的通道
     */
    public int[] nLightChangedChannels = new int[32];
    /**
     *  保留字节
     */
    public byte[] byReserved = new byte[512];

    public NET_TRAFFICLIGHT_INFO(){
        for (int i = 0; i < stuChannels.length; i++){
            stuChannels[i] = new NET_TRAFFICLIGHT_CHANNEL_INFO();
        }
    }

}
