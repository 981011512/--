package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.NET_DEVICE_NAME_LEN;

/**
 * 电视墙预案名称 拆分自{@link NET_IN_MONITORWALL_GET_COLL_SCHD}
 *
 * @author ： 47040
 * @since ： Created in 2020/10/19 9:28
 */
public class NET_MONITORWALL_COLLECTION_NAME extends NetSDKLib.SdkStructure {
    /**
     * 电视墙预案名称
     */
    public byte[] collectionName = new byte[NET_DEVICE_NAME_LEN];

}
