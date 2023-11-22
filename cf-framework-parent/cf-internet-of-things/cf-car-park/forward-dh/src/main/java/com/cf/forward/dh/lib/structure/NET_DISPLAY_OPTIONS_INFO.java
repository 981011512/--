package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @description: 数据显示选项
 */

public class NET_DISPLAY_OPTIONS_INFO extends NetSDKLib.SdkStructure {
    /**
     *  是否显示开关 TRUE：是 FALSE:否
     */
    public int bIsSwitchDisplayed;

    /**
     *  是否显示滚动开关 TRUE：是 FALSE:否
     */
    public int bIsScrollDisplaySwitch;

    /**
     *  保留字节
     */
    public byte[] byReserved = new byte[120];

}
