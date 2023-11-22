package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.sun.jna.Pointer;

public class NET_OUT_SCADA_GET_ATTRIBUTE_INFO extends NetSDKLib.SdkStructure {
    /**
     *  结构体大小
     */
    public int dwSize;

    /**
     *  用户最大申请缓存个数
     */
    public int nMaxAttributeInfoNum;

    /**
     *  设备点位信息(内存由用户申请) NET_ATTRIBUTE_INFO
     */
    public Pointer pstuAttributeInfo;

    /**
     *  返回点位信息个数
     */
    public int nRetAttributeInfoNum;

    public NET_OUT_SCADA_GET_ATTRIBUTE_INFO(){
        this.dwSize = this.size();
    }

    @Override
    public String toString() {
        return "NET_OUT_SCADA_GET_ATTRIBUTE_INFO{" +
                "dwSize=" + dwSize +
                ", nMaxAttributeInfoNum=" + nMaxAttributeInfoNum +
                ", pstuAttributeInfo=" + pstuAttributeInfo +
                ", nRetAttributeInfoNum=" + nRetAttributeInfoNum +
                '}';
    }
}