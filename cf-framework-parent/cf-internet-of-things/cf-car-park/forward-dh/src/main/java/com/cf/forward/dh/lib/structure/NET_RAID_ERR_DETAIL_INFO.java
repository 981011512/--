package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * className：NET_RAID_ERR_DETAIL_INFO
 * description：
 * author：251589
 * createTime：2021/2/26 8:43
 *
 * @version v1.0
 */


public class NET_RAID_ERR_DETAIL_INFO extends NetSDKLib.SdkStructure {
    /**
     * 子盘槽位号
     */
    public int dwSlotNum;

    /**
     * 子盘状态
     */
    public int emErrSubDisk;

    /**
     * 保留
     */
    public byte[] byReserved = new byte[24];

}

