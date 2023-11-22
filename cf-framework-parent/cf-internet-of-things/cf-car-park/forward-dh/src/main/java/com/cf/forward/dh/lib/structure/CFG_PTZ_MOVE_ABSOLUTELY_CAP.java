package com.cf.forward.dh.lib.structure;/**
 * @author 47081
 * @descriptio
 * @date 2020/11/9
 * @version 1.0
 */

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 绝对控制云台能力
 * @date 2020/11/9
 */
public class CFG_PTZ_MOVE_ABSOLUTELY_CAP extends NetSDKLib.SdkStructure {
    /**
     * 支持的云台动作类型
     */
    public CFG_PTZ_ACTION_CAPS stuPTZ;
    /**
     * 支持的云台精确定位方式类型
     */
    public CFG_PTZ_ABSOLUTELY_CAPS stuType;
    /**
     * 预留
     */
    public byte[] byReserved = new byte[768];

    @Override
    public String toString() {
        return "CFG_PTZ_MOVE_ABSOLUTELY_CAP{" +
                "stuPTZ=" + stuPTZ +
                ", stuType=" + stuType +
                '}';
    }
}
