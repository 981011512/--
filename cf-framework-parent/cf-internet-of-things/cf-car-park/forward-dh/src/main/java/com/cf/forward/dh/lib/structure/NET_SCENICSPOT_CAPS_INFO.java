package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 景物信息记录能力集
 *
 * @author ： 47040
 * @since ： Created in 2020/10/26 17:20
 */
public class NET_SCENICSPOT_CAPS_INFO extends NetSDKLib.SdkStructure {
    /**
     * 是否支持景物点功能
     */
    public int bEnable;
    /**
     * 总共最多支持多少个景物点
     */
    public int nTotalNum;
    /**
     * 单画面最多支持多少个景物点
     */
    public int nRegionNum;
    /**
     * 保留字段
     */
    public byte[] byReserved = new byte[256];
}
