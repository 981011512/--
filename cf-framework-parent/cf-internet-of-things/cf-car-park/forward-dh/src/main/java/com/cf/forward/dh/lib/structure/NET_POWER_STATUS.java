package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.NET_MAX_BATTERY_NUM;
import static com.cf.forward.dh.lib.NetSDKLib.NET_MAX_POWER_NUM;

/**
 * className：NET_POWER_STATUS
 * description：
 * author：251589
 * createTime：2021/2/25 16:04
 *
 * @version v1.0
 */

public class NET_POWER_STATUS extends NetSDKLib.SdkStructure {
    /**
     * dwSize;
     */
    public int dwSize;
    /**
     *  查询是否成功
     */
    public int bEnable;

    /**
     *  电源数量
     */
    public int nCount;

    /**
     *  电源状态
     */
    public NET_POWER_INFO[] stuPowers = (NET_POWER_INFO[]) new NET_POWER_INFO().toArray(NET_MAX_POWER_NUM);
    /**
     *  电池数量
     */
    public int nBatteryNum;

    /**
     *  电池状态
     */
    public NET_BATTERY_INFO[] stuBatteries = (NET_BATTERY_INFO[]) new NET_BATTERY_INFO().toArray(NET_MAX_BATTERY_NUM);
    public NET_POWER_STATUS(){
        this.dwSize = this.size();
    }
}
