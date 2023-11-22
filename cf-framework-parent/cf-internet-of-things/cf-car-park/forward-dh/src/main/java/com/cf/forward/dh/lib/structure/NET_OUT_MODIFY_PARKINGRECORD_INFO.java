package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 修改停车记录信息 出参
 * 接口 {@link NetSDKLib#CLIENT_ModifyParkingRecord}
 * 入参 {@link NET_IN_MODIFY_PARKINGRECORD_INFO}
 *
 * @author 47040
 * @since Created in 2020/11/18 14:06
 */
public class NET_OUT_MODIFY_PARKINGRECORD_INFO extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;

    public NET_OUT_MODIFY_PARKINGRECORD_INFO() {
        dwSize = this.size();
    }
}
