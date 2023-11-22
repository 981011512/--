package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.NET_MAX_MODE_NUMBER;

/**
 * 录播主机获取模式出参
 *
 * @author ： 47040
 * @since ： Created in 2020/9/27 17:26
 */
public class NET_OUT_COURSECOMPOSITE_CHANNEL_MODE_GET extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 实际获取的模式个数
     */
    public int nReturnNum;
    /**
     * 模式编号
     */
    public int[] nMode = new int[NET_MAX_MODE_NUMBER];
    /**
     * 模式信息
     */
    public NET_COMPOSITECHANNELMODE_INFO[] stModeInfo = new NET_COMPOSITECHANNELMODE_INFO[NET_MAX_MODE_NUMBER];

    public NET_OUT_COURSECOMPOSITE_CHANNEL_MODE_GET() {
        dwSize = this.size();
        for (int i = 0; i < stModeInfo.length; i++) {
            stModeInfo[i] = new NET_COMPOSITECHANNELMODE_INFO();
        }
    }
}
