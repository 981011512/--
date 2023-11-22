package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_TEMPERATURE_UNIT_EX;
import com.cf.forward.dh.lib.enumeration.NET_EM_CFG_OPERATE_TYPE;

/**
 * 显示环境温度的叠加配置
 * {@link NET_EM_CFG_OPERATE_TYPE#NET_EM_CFG_TEMPERATURE}
 *
 * @author 47040
 * @version 1.0.0
 * @since Created in 2021/3/8 21:43
 */
public class NET_OSD_CFG_TEMPERATURE extends NetSDKLib.SdkStructure {

    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 显示时间,单位为秒，0 表示一直显示,自定义范围：1-3600
     */
    public int nDisplayTime;
    /**
     * 叠加到主码流视频编码
     */
    public int bEncodeBlend;
    /**
     * 是否叠加到预览显示
     */
    public int bPreviewBlend;
    /**
     * 前景色
     */
    public NET_COLOR_RGBA stuFrontColor;
    /**
     * 背景色
     */
    public NET_COLOR_RGBA stuBackColor;
    /**
     * 区域
     */
    public NetSDKLib.NET_RECT stuRect;
    /**
     * 温度单位的类型 枚举值{@link EM_TEMPERATURE_UNIT_EX}
     */
    public int emTemperatureType;

    public NET_OSD_CFG_TEMPERATURE() {
        dwSize = this.size();
    }

}
