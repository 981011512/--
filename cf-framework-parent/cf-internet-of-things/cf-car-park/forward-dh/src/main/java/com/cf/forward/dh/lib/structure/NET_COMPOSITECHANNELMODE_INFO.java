package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.NET_COMMON_STRING_128;
import static com.cf.forward.dh.lib.NetSDKLib.NET_MAX_WINDOWS_NUMBER;

/**
 * 录播主机模式信息
 *
 * @author ： 47040
 * @since ： Created in 2020/9/27 16:35
 */
public class NET_COMPOSITECHANNELMODE_INFO extends NetSDKLib.SdkStructure {
    /**
     * 模式名称
     */
    public byte[] szName = new byte[NET_COMMON_STRING_128];
    /**
     * 实际窗口个数
     */
    public int nWindowNum;
    /**
     * 窗口信息
     */
    public NET_COMPOSITECHANNELMODE_WINDOWS[] stWindows = new NET_COMPOSITECHANNELMODE_WINDOWS[NET_MAX_WINDOWS_NUMBER];
    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[64];

    public NET_COMPOSITECHANNELMODE_INFO() {
        for (int i = 0; i < stWindows.length; i++) {
            stWindows[i] = new NET_COMPOSITECHANNELMODE_WINDOWS();
        }
    }
}