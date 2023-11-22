package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 按照事件类型抓图 出参
 * 接口 {@link NetSDKLib#CLIENT_SnapPictureByEvent}
 * 入参 {@link NET_IN_SNAP_BY_EVENT}
 *
 * @author 47040
 * @since Created in 2020/11/18 17:29
 */
public class NET_OUT_SNAP_BY_EVENT extends NetSDKLib.SdkStructure {
    /**
     * 本结构体大小, 初始化时必须填写
     */
    public int dwSize;

    public NET_OUT_SNAP_BY_EVENT() {
        dwSize = this.size();
    }
}
