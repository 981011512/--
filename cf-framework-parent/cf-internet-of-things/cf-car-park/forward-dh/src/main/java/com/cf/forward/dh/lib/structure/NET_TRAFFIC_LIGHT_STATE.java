package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.NET_TRAFFIC_LIGHT_STATUS;

/**
 * 信号灯指示灯状态
 *
 * @author ： 47040
 * @since ： Created in 2020/8/29 17:01
 */
public class NET_TRAFFIC_LIGHT_STATE extends NetSDKLib.SdkStructure {
    /**
     * 直行信号灯状态 {@link NET_TRAFFIC_LIGHT_STATUS}
     */
    public int emStraightLightInfo;
    /**
     * 左转信号灯状态 {@link NET_TRAFFIC_LIGHT_STATUS}
     */
    public int emTurnLeftLightInfo;
    /**
     * 右转信号灯状态 {@link NET_TRAFFIC_LIGHT_STATUS}
     */
    public int emTurnRightLightInfo;
    /**
     * 调头信号灯状态 {@link NET_TRAFFIC_LIGHT_STATUS}
     */
    public int emUTurnLightInfo;
    /**
     * 预留
     */
    public byte[] byReserved = new byte[64];
}
