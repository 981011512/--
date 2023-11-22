package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * PTZ景物坐标 8191x8191 坐标系
 *
 * @author ： 47040
 * @since ： Created in 2020/10/26 15:59
 */
public class POINTCOORDINATE extends NetSDKLib.SdkStructure {
    /**
     * 第一个元素表示景物点的x坐标(0~8191)
     */
    public int nX;
    /**
     * 第二个元素表示景物点的y坐标(0~8191)
     */
    public int nY;

    public POINTCOORDINATE() {
    }

    public POINTCOORDINATE(int X, int Y) {
        nX = X;
        nY = Y;
    }
}
