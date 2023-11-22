package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * className：NET_BATTERY_INFO
 * description：
 * author：251589
 * createTime：2021/2/25 15:51
 *
 * @version v1.0
 */

public class NET_BATTERY_INFO extends NetSDKLib.SdkStructure {
    /**
     * dwSize;
     */
    public int dwSize;
    /**
     *  电池容量百分比
     */
    public int nPercent;

    /**
     *  是否正在充电
     */
    public int bCharging;

    /**
     *  电池在位状态
     */
    public int emExistState;

    /**
     *  电池电量状态
     */
    public int emState;

    /**
     *  电池电压
     */
    public float fVoltage;

    public NET_BATTERY_INFO(){
        this.dwSize = this.size();
    }
}
