package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 颜色RGBA
 *
 * @author 47040
 * @version 1.0.0
 * @since Created in 2021/3/8 20:11
 */
public class NET_COLOR_RGBA extends NetSDKLib.SdkStructure {
    /**
     * 红
     */
    public int nRed;
    /**
     * 绿
     */
    public int nGreen;
    /**
     * 蓝
     */
    public int nBlue;
    /**
     * 透明
     */
    public int nAlpha;

    public void setRGBA(int R, int G, int B, int A) {
        nRed = R;
        nGreen = G;
        nBlue = B;
        nAlpha = A;
    }

    public String toString() {
        return String.format("RGBN ( %03d, %03d, %03d, %03d )", nRed, nGreen, nBlue, nAlpha);
    }
}
