package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.NET_MAX_RAID_DEVICE_NAME;

/**
 * className：ALARM_RAID_INFO_EX
 * description：
 * author：251589
 * createTime：2021/2/26 8:52
 *
 * @version v1.0
 */

public class ALARM_RAID_INFO_EX  extends NetSDKLib.SdkStructure {
    /**
     *  0-开始, 1-停止
     */
    public int nAction;

    /**
     *  设备名称
     */
    public byte[] szDevice = new byte[NET_MAX_RAID_DEVICE_NAME];

    /**
     *  错误类型
     */
    public int emErrorType;

    /**
     *  有效的故障子盘个数
     */
    public int nDetailNum;

    /**
     *  故障子盘详细信息
     */
    public NET_RAID_ERR_DETAIL_INFO[] stuErrDetail = (NET_RAID_ERR_DETAIL_INFO[]) new NET_RAID_ERR_DETAIL_INFO().toArray(16);
    /**
     *  保留
     */
    public byte[] byReserved = new byte[508];

}
