package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_TRFAFFIC_LIGHT_TYPE;

/**
 * 交通灯的持续时间，时间单位毫秒
 *
 * @author ： 47040
 * @since ： Created in 2020/8/29 16:48
 */
public class NET_LIGHTPERIODS_INFO extends NetSDKLib.SdkStructure {

    /**
     * 交通灯类型 枚举 {@link EM_TRFAFFIC_LIGHT_TYPE}
     */
    public int emType;
    /**
     * 直行灯持续时间
     */
    public int nStraight;
    /**
     * 左转灯持续时间
     */
    public int nTurnLeft;
    /**
     * 右转灯持续时间
     */
    public int nTurnRight;
    /**
     * 掉头灯持续时间
     */
    public int nUTurn;
    /**
     * 预留
     */
    public byte[] byReserved = new byte[60];
}
