package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * className：NET_CPU_INFO
 * description：CPU信息
 * author：251589
 * createTime：2021/2/25 12:02
 *
 * @version v1.0
 */

public class NET_CPU_INFO extends NetSDKLib.SdkStructure {
    /**
     * dwSize;
     */
    public int dwSize;
    /**
     *  CPU利用率
     */
    public int nUsage;

    public NET_CPU_INFO(){
        this.dwSize = this.size();
    }
}
