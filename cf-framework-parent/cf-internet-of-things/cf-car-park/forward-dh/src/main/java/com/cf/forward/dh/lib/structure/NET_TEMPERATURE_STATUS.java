package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.NET_MAX_TEMPERATURE_NUM;

/**
 * className：NET_TEMPERATURE_STATUS
 * description：温度状态
 * author：251589
 * createTime：2021/2/25 14:34
 *
 * @version v1.0
 */

public class NET_TEMPERATURE_STATUS extends NetSDKLib.SdkStructure {
    /**
     * dwSize;
     */
    public int dwSize;
    /**
     *  查询是否成功
     */
    public int bEnable;

    /**
     *  温度数量
     */
    public int nCount;

    /**
     *  温度信息
     */
    public NET_TEMPERATURE_INFO[] stuTemps = (NET_TEMPERATURE_INFO[]) new NET_TEMPERATURE_INFO().toArray(NET_MAX_TEMPERATURE_NUM);

    public NET_TEMPERATURE_STATUS(){
        this.dwSize = this.size();
    }
}
