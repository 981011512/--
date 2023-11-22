package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 手动抓拍参数
 *
 * @author ： 47040
 * @since ： Created in 2020/9/29 19:53
 */
public class MANUAL_SNAP_PARAMETER extends NetSDKLib.SdkStructure {
    /**
     * 抓图通道, 从0开始
     */
    public int nChannel;
    /**
     * 抓图序列号字符串
     */
    public byte[] bySequence = new byte[64];
    /**
     * 保留字段
     */
    public byte[] byReserved = new byte[60];
}
