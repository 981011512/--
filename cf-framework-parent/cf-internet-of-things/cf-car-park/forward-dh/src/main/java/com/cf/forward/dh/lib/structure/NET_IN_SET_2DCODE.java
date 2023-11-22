package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.constant.SDKStructureFieldLenth;
import com.sun.jna.Pointer;

/**
 * @author 47081
 * @version 1.0
 * @description {@link NetSDKLib#CLIENT_Set2DCode(NetSDKLib.LLong, Pointer, Pointer, int)}的入参
 * @date 2020/9/10
 */
public class NET_IN_SET_2DCODE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 二维码类型,
     * 对应枚举类型{@link com.cf.forward.dh.lib.enumeration.NET_EM_2DCODE_TYPE}
     */
    public int em2DCodeType;
    /**
     * 二维码信息
     */
    public byte[] sz2DCode = new byte[SDKStructureFieldLenth.SDK_COMMON_STRING_512];

    public NET_IN_SET_2DCODE() {
        this.dwSize = this.size();
    }
}
