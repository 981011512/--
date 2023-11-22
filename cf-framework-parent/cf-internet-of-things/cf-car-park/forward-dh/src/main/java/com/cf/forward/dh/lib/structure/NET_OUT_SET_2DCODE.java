package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.sun.jna.Pointer;

/**
 * @author 47081
 * @version 1.0
 * @description {@link NetSDKLib#CLIENT_Set2DCode(NetSDKLib.LLong, Pointer, Pointer, int)}的出参
 * @date 2020/9/10
 */
public class NET_OUT_SET_2DCODE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;

    public NET_OUT_SET_2DCODE() {
        this.dwSize = this.size();
    }
}
