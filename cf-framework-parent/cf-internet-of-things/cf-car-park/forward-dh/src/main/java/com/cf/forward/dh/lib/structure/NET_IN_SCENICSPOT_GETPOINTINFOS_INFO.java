package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 分页获取 信息标注信息列表 入参
 * 出参 {@link NET_OUT_SCENICSPOT_GETPOINTINFOS_INFO}
 * 接口 {@link NetSDKLib#CLIENT_ScenicSpotGetPointInfos}
 *
 * @author ： 47040
 * @since ： Created in 2020/10/26 15:41
 */
public class NET_IN_SCENICSPOT_GETPOINTINFOS_INFO extends NetSDKLib.SdkStructure {

    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 通道号
     */
    public int nChannelID;
    /**
     * 从第几位开始获取（最大 255）
     */
    public int nOffset;
    /**
     * 获取几个信息点结构（从 0 开始）
     */
    public int nLimit;

    public NET_IN_SCENICSPOT_GETPOINTINFOS_INFO() {
        dwSize = this.size();
    }
}
