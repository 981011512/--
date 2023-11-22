package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.MAX_PREVIEW_CHANNEL_NUM;

/**
 * 获取录播主机逻辑通道号入参，对应接口 {@link NetSDKLib#CLIENT_GetLogicChannel}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 14:57
 */
public class NET_IN_GET_COURSE_LOGIC_CHANNEL extends NetSDKLib.SdkStructure {
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

    public NET_IN_GET_COURSE_LOGIC_CHANNEL(){
        dwSize = this.size();
    }
}
