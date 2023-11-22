package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.constant.SDKStructureFieldLenth.NET_MAX_COLLECTION_NUM;

/**
 * 设置预案时间表 入参 {@link NetSDKLib#CLIENT_OperateMonitorWall}
 *
 * @author ： 47040
 * @since ： Created in 2020/10/19 10:34
 */
public class NET_IN_MONITORWALL_SET_COLL_SCHD extends NetSDKLib.SdkStructure {
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
    /**
     * 电视墙ID
     */
    public int nMonitorWallID;

    public NET_IN_MONITORWALL_SET_COLL_SCHD() {
        dwSize = this.size();
        for (int i = 0; i < stuCollShedule.length; i++) {
            stuCollShedule[i] = new MONITORWALL_COLLECTION_SCHEDULE();
        }
    }
}
