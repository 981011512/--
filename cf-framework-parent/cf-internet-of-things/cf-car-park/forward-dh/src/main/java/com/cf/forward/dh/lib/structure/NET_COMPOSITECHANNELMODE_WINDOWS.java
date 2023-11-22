package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 录播主机窗口信息
 * @author ： 47040
 * @since ： Created in 2020/9/27 16:37
 */
public class NET_COMPOSITECHANNELMODE_WINDOWS extends NetSDKLib.SdkStructure {
    /**
     * 窗口坐标, 采用8192坐标体系
     */
    public NetSDKLib.DH_RECT stRect;
    /**
     * 逻辑通道号, 为-1表示此窗口没有绑定通道
     */
    public int nLogicChannel;
    /**
     * Z序
     */
    public int nZOrder;
    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[64];
}
