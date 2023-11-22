package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.CUSTOM_TITLE_LEN;

/**
 * 自定义的标题信息
 *
 * @author 47040
 * @version 1.0.0
 * @since Created in 2021/3/8 20:16
 */
public class NET_USER_DEF_TITLE_INFO extends NetSDKLib.SdkStructure {
    /**
     * 标题内容
     */
    public byte[] szText = new byte[CUSTOM_TITLE_LEN];
    /**
     * 叠加到编码视频使能
     */
    public int bEncodeBlend;
    /**
     * 叠加到预览视频使能
     */
    public int bPreviewBlend;
    /**
     * 区域, 坐标取值[0~8191], 仅使用left和top值, 点(left,top)应和(right,bottom)设置成同样的点
     */
    public NetSDKLib.NET_RECT stuRect;
    /**
     * 前景色
     */
    public NET_COLOR_RGBA stuFrontColor;
    /**
     * 背景色
     */
    public NET_COLOR_RGBA stuBackColor;
    /**
     * 文本对齐方式 枚举值 {@link NetSDKLib.EM_TITLE_TEXT_ALIGNTYPE}
     */
    public int emTextAlign;
    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[516];
}
