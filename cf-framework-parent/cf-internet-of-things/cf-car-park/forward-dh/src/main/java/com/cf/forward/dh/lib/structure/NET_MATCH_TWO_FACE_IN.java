package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.sun.jna.Pointer;

/**
 * @author 47081
 * @version 1.0
 * @description {@link NetSDKLib#CLIENT_MatchTwoFaceImage}的入参
 * @date 2020/10/19
 */
public class NET_MATCH_TWO_FACE_IN extends NetSDKLib.SdkStructure {
    public int dwSize;
    /**
     * 原图
     */
    public NET_IMAGE_COMPARE_INFO stuOriginalImage;
    /**
     * 比较图
     */
    public NET_IMAGE_COMPARE_INFO stuCompareImage;
    /**
     * 两张人脸图片数据
     */
    public Pointer pSendBuf;
    /**
     * 数据大小
     */
    public int dwSendBufLen;

    public NET_MATCH_TWO_FACE_IN() {
        this.dwSize = this.size();
    }
}
