package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 人脸图片比较信息
 * @date 2020/10/19
 */
public class NET_IMAGE_COMPARE_INFO extends NetSDKLib.SdkStructure {
    /**
     * 在二进制数据块中的偏移,单位:字节
     */
    public int dwoffset;
    /**
     * 图片大小,单位:字节
     */
    public int dwLength;
    /**
     * 图片宽度
     */
    public int dwWidth;
    /**
     * 图片高度
     */
    public int dwHeight;
    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[128];
}
