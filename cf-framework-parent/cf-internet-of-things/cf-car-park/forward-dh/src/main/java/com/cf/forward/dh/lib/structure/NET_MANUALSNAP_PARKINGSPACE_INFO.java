package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 停车位的数据信息
 *
 * @author 47040
 * @since Created in 2020/11/18 14:29
 */
public class NET_MANUALSNAP_PARKINGSPACE_INFO extends NetSDKLib.SdkStructure {
    /**
     * 车位是否有车标记 0:Unknown 1-Parking 2-NoParking
     */
    public int nStatus;
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
    public byte[] byReserved = new byte[412];
}
