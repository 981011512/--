package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.NET_MAX_MODE_NUMBER;

/**
 * 录播主机添加模式入参
 *
 * @author ： 47040
 * @since ： Created in 2020/9/27 16:32
 */
public class NET_IN_COURSECOMPOSITE_CHANNEL_MODE_ADD extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 要添加的模式数目
     */
    public int nCount;
    /**
     * 模式信息
     */
    public NET_COMPOSITECHANNELMODE_INFO[] stModeInfo = new NET_COMPOSITECHANNELMODE_INFO[NET_MAX_MODE_NUMBER];

    public NET_IN_COURSECOMPOSITE_CHANNEL_MODE_ADD() {
        dwSize = this.size();
        for (int i = 0; i < stModeInfo.length; i++) {
            stModeInfo[i] = new NET_COMPOSITECHANNELMODE_INFO();
        }
    }
}
