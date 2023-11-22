package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.NET_EM_CFG_OPERATE_TYPE;

/**
 * 区域覆盖
 * {@link NET_EM_CFG_OPERATE_TYPE#NET_EM_CFG_COVERS}
 *
 * @author 47040
 * @version 1.0.0
 * @since Created in 2021/3/8 21:55
 */
public class NET_OSD_CFG_COVERS extends NetSDKLib.SdkStructure {

    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 覆盖区域个数
     */
    public int nCoverCount;
    /**
     * 覆盖区域
     */
    public NET_VEDIO_WIDGET_COVER[] stuCovers = new NET_VEDIO_WIDGET_COVER[16];

    public NET_OSD_CFG_COVERS() {
        dwSize = this.size();
        for (int i = 0; i < stuCovers.length; i++) {
            stuCovers[i] = new NET_VEDIO_WIDGET_COVER();
        }
    }

}
