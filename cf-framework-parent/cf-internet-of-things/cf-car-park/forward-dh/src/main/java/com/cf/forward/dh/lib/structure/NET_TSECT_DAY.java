package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.NET_TSCHE_SEC_NUM;

/**
 * 拆分自{@link MONITORWALL_COLLECTION_SCHEDULE}
 *
 * @author ： 47040
 * @since ： Created in 2020/10/19 9:43
 */
public class NET_TSECT_DAY extends NetSDKLib.SdkStructure {
    /**
     * 时间段结构
     */
    public NetSDKLib.NET_TSECT[] stuSchedule = new NetSDKLib.NET_TSECT[NET_TSCHE_SEC_NUM];

    public NET_TSECT_DAY() {
        for (int i = 0; i < stuSchedule.length; i++) {
            stuSchedule[i] = new NetSDKLib.NET_TSECT();
        }
    }
}
