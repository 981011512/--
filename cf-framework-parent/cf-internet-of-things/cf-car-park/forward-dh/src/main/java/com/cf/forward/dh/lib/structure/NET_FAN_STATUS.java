package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.NET_MAX_FAN_NUM;

/**
 * className：NET_FAN_STATUS
 * description：风扇状态
 * author：251589
 * createTime：2021/2/25 14:05
 *
 * @version v1.0
 */

public class NET_FAN_STATUS extends NetSDKLib.SdkStructure {
    /**
     * dwSize;
     */
    public int dwSize;
    /**
     *  查询是否成功
     */
    public int bEnable;

    /**
     *  风扇数量
     */
    public int nCount;

    /**
     *  风扇状态
     */
    public NET_FAN_INFO[] stuFans = (NET_FAN_INFO[]) new NET_FAN_INFO().toArray(NET_MAX_FAN_NUM);
    public NET_FAN_STATUS(){
        this.dwSize = this.size();
    }
}
