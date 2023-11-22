package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 获取设备点位信息 入参
 */

public class NET_GET_CONDITION_INFO extends NetSDKLib.SdkStructure {
    /**
     *  设备ID
     */
    public byte[] szDeviceID = new byte[32];

    /**
     *  是否发生ID,TRUE:发送 FALSE:不发送（如无此节点则返回该DeviceId下所有ID）
     */
    public int bIsSendID;

    /**
     *  相应的监控点ID号
     */
    public byte[] szID = new byte[256*256];

    /**
     *  下发个数
     */
    public int nIDNum;

    /**
     *  保留字节
     */
    public byte[] byReserved = new byte[256];

    public NET_GET_CONDITION_INFO(){

    }

}