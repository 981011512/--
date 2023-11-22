package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 覆盖区域
 *
 * @author 47040
 * @version 1.0.0
 * @since Created in 2021/3/8 21:52
 */
public class NET_VEDIO_WIDGET_COVER extends NetSDKLib.SdkStructure {

    /**
     * 叠加到预览视频
     */
    public int bPreviewBlend;
    /**
     * 叠加到主码流
     */
    public int bEncodeBlend;
    /**
     * 叠加到辅码流1
     */
    public int bEncodeBlendExtra1;
    /**
     * 叠加到辅码流2
     */
    public int bEncodeBlendExtra2;
    /**
     * 叠加到辅码流3
     */
    public int bEncodeBlendExtra3;
    /**
     * 叠加到抓图
     */
    public int bEncodeBlendSnapshot;
    /**
     * 前景色
     */
    public NET_COLOR_RGBA stuFrontColor;
    /**
     * 背景色
     */
    public NET_COLOR_RGBA stuBackColor;
    /**
     * 区域, 坐标取值0~8191
     */
    public NetSDKLib.NET_RECT stuRect;
    /**
     * 保留字节
     */
    public byte[] byReserver = new byte[128];

}
