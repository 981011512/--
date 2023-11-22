package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 云台连续运动能力
 * @date 2020/11/11
 */
public class CFG_PTZ_MOVE_CONTINUOUSLY_CAPS extends NetSDKLib.SdkStructure {

    /**
     * 支持的PTZ动作
     */
    public CFG_PTZ_ACTION_CAPS stuPTZ;
    /**
     *连续移动方式类型
     */
    public CFG_PTZ_CONTINUOUSLY_TYPE stuType;
    /**
     * 预留
     */
    public byte[] byReserved = new byte[1024];
}
