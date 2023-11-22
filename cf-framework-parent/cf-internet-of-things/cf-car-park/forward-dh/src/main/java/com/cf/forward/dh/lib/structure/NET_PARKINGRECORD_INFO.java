package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 停车位记录信息
 *
 * @author 47040
 * @since Created in 2020/11/18 14:17
 */
public class NET_PARKINGRECORD_INFO extends NetSDKLib.SdkStructure {
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
     * 保留字节
     */
    public byte[] byReserverd = new byte[512];
}
