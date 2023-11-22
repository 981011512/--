package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_PARKINGSPACE_STATE;

/**
 * 设置停车车位状态 入参
 * 接口 {@link NetSDKLib#CLIENT_SetParkingSpaceState}
 * 出参 {@link NET_OUT_SET_PARKINGSPACE_STATE_INFO}
 *
 * @author 47040
 * @since Created in 2020/11/18 13:32
 */
public class NET_IN_SET_PARKINGSPACE_STATE_INFO extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 通道号
     */
    public int nChannel;
    /**
     * 车牌号码
     */
    public byte[] szPlateNumber = new byte[64];
    /**
     * 车位号
     */
    public byte[] szParkingNo = new byte[32];
    /**
     * 车位状态 {@link EM_PARKINGSPACE_STATE}
     */
    public int emState;
    /**
     * 是否需要图片 0 不需要 1 需要
     */
    public int bUnNeedPic;

    public NET_IN_SET_PARKINGSPACE_STATE_INFO() {
        dwSize = this.size();
    }
}