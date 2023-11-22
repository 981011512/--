package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.MAX_PREVIEW_CHANNEL_NUM;

/**
 * 设置逻辑通道号和真实通道号的绑定关系入参 ，对应接口 {@link NetSDKLib#CLIENT_SetBlindRealChannel}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 15:08
 */
public class NET_IN_SET_BLIND_REAL_CHANNEL extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 通道数量
     */
    public int nChannelNum;
    /**
     * 通道号
     */
    public int[] nChannel = new int[MAX_PREVIEW_CHANNEL_NUM];
    /**
     * 逻辑通道信息，下标为将要设置的真实通道数
     */
    public NET_LOGIC_CHANNEL_INFO[] stuChannelInfo = new NET_LOGIC_CHANNEL_INFO[MAX_PREVIEW_CHANNEL_NUM];

    public NET_IN_SET_BLIND_REAL_CHANNEL() {
        dwSize = this.size();
        for (int i = 0; i < stuChannelInfo.length; i++) {
            stuChannelInfo[i] = new NET_LOGIC_CHANNEL_INFO();
        }
    }
}
