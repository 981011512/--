package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.MAX_PREVIEW_CHANNEL_NUM;

/**
 * 获取录播主机默认真实通道号出参，对应接口 {@link NetSDKLib#CLIENT_GetLogicChannel}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 15:01
 */
public class NET_OUT_GET_COURSE_LOGIC_CHANNEL extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 获取到的逻辑通道数
     */
    public int nChannelCount;
    /**
     * 逻辑通道信息，下标为将要获取的真实通道数
     */
    public NET_LOGIC_CHANNEL_INFO[] stuChannelInfo = new NET_LOGIC_CHANNEL_INFO[MAX_PREVIEW_CHANNEL_NUM];

    public NET_OUT_GET_COURSE_LOGIC_CHANNEL() {
        dwSize = this.size();
        for (int i = 0; i < stuChannelInfo.length; i++) {
            stuChannelInfo[i] = new NET_LOGIC_CHANNEL_INFO();
        }
    }
}
