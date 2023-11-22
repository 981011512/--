package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.constant.SDKStructureFieldLenth.NET_MAX_COLLECTION_NUM;

/**
 * 获取预案时间表 出参 {@link NetSDKLib#CLIENT_OperateMonitorWall}
 *
 * @author ： 47040
 * @since ： Created in 2020/10/19 9:35
 */
public class NET_OUT_MONITORWALL_GET_COLL_SCHD extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 预案数
     */
    public int nCollectionNum;
    /**
     * 预案时间表
     */
    public MONITORWALL_COLLECTION_SCHEDULE[] stuCollShedule = new MONITORWALL_COLLECTION_SCHEDULE[NET_MAX_COLLECTION_NUM];

    public NET_OUT_MONITORWALL_GET_COLL_SCHD() {
        dwSize = this.size();
        for (int i = 0; i < stuCollShedule.length; i++) {
            stuCollShedule[i] = new MONITORWALL_COLLECTION_SCHEDULE();
        }
    }
}
