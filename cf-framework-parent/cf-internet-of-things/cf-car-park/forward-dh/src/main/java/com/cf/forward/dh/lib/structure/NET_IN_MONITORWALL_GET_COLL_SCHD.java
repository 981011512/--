package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.constant.SDKStructureFieldLenth.NET_MAX_COLLECTION_NUM;

/**
 * 获取预案时间表 入参 {@link NetSDKLib#CLIENT_OperateMonitorWall}
 *
 * @author ： 47040
 * @since ： Created in 2020/10/19 9:24
 */
public class NET_IN_MONITORWALL_GET_COLL_SCHD extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * TRUE-查询所有预案, 不需要指定预案名称. FALSE-查询名称所对应的预案
     */
    public int bAllCollections;
    /**
     * 预案数, bAllCollections为FALSE时有效
     */
    public int nCollectionNum;
    /**
     * 预案名称
     */
    public NET_MONITORWALL_COLLECTION_NAME[] szCollections = new NET_MONITORWALL_COLLECTION_NAME[NET_MAX_COLLECTION_NUM];
    /**
     * 电视墙ID
     */
    public int nMonitorWallID;

    public NET_IN_MONITORWALL_GET_COLL_SCHD() {
        dwSize = this.size();
        for (int i = 0; i < szCollections.length; i++) {
            szCollections[i] = new NET_MONITORWALL_COLLECTION_NAME();
        }
    }
}
