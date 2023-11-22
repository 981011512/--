package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.constant.SDKStructureFieldLenth.MAX_SCENICSPOT_POINTS_NUM;

/**
 * 分页获取 信息标注信息列表 出参
 * 入参 {@link NET_IN_SCENICSPOT_GETPOINTINFOS_INFO}
 * 接口 {@link NetSDKLib#CLIENT_ScenicSpotGetPointInfos}
 *
 * @author ： 47040
 * @since ： Created in 2020/10/26 15:41
 */
public class NET_OUT_SCENICSPOT_GETPOINTINFOS_INFO extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 设备总共多少个景物点信息
     */
    public int nTotal;
    /**
     * 当前获取到景物点个数
     */
    public int nRetSceneNum;
    /**
     * 数组长度等于limit,最后一组查询可能小于limit
     */
    public POINTINFOS[] stuPointInfos = new POINTINFOS[MAX_SCENICSPOT_POINTS_NUM];

    public NET_OUT_SCENICSPOT_GETPOINTINFOS_INFO() {
        dwSize = this.size();
        for (int i = 0; i < stuPointInfos.length; i++) {
            stuPointInfos[i] = new POINTINFOS();
        }
    }
}
