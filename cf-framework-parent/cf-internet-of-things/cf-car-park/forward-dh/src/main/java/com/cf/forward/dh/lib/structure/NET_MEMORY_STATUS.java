package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * className：NET_MEMORY_STATUS
 * description：
 * author：251589
 * createTime：2021/2/25 13:36
 *
 * @version v1.0
 */

public class NET_MEMORY_STATUS  extends NetSDKLib.SdkStructure {
    /**
     * dwSize;
     */
    public int dwSize;
    /**
     *  查询是否成功
     */
    public int bEnable;

    /**
     *  内存信息
     */
    public NET_MEMORY_INFO stuMemory;

    public NET_MEMORY_STATUS (){
        this.dwSize = this.size();
    }
}
