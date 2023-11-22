package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * className：NET_TRAFFICLIGHT_CHANNEL_INFO
 * description：
 * author：251589
 * createTime：2021/1/19 15:08
 *
 * @version v1.0
 */
public class NET_TRAFFICLIGHT_CHANNEL_INFO extends NetSDKLib.SdkStructure {
    /**
     *  检测通道
     */
    public int nChannel;

    /**
     *  进口方向
     */
    public int emEntryDirection;

    /**
     *  进口类型
     */
    public int[] emEntryType = new int[32];
    /**
     *  进口类型个数
     */
    public int nRetEntryTypeNum;

    /**
     *  红绿灯状态
     */
    public int emLightState;

    /**
     *  保留字节
     */
    public byte[] byReserved = new byte[368];

}
