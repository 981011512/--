package com.cf.forward.dh.lib.structure;/**
 * @author 47081
 * @descriptio
 * @date 2020/11/9
 * @version 1.0
 */

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.constant.SDKStructureFieldLenth.MAX_MASKTYPE_COUNT;
import static com.cf.forward.dh.lib.constant.SDKStructureFieldLenth.MAX_MOSAICTYPE_COUNT;

/**
 * @author 47081
 * @version 1.0
 * @description 隐私遮挡能力集
 * @date 2020/11/9
 */
public class CFG_PTZ_PRIVACY_MASKING extends NetSDKLib.SdkStructure {
    /**
     * 是否支持隐私遮挡设置
     */
    public boolean bPrivacyMasking;
    /**
     * 是否支持遮挡块颜色设置
     */
    public boolean bSetColorSupport;
    /**
     * emMaskType是否有效
     */
    public boolean abMaskType;
    /**
     * 实际支持的遮挡块形状个数
     */
    public int nMaskTypeCount;
    /**
     * 支持的遮挡块形状，没有该项配置时默认支持矩形
     * 枚举参考{@link com.cf.forward.dh.lib.enumeration.NET_EM_MASK_TYPE}
     */
    public int[] emMaskType = new int[MAX_MASKTYPE_COUNT];
    /**
     * 是否支持马赛克遮挡块设置
     */
    public boolean bSetMosaicSupport;
    /**
     * 是否支持遮挡块颜色相互独立(bSetColorSupport为true时该能力有效)
     */
    public boolean bSetColorIndependent;
    /**
     * emMosaicType是否有效
     */
    public boolean abMosaicType;
    /**
     * 实际支持的马赛克类型个数
     */
    public int nMosaicTypeCount;
    /**
     * 支持的马赛克类型(SetMosaicSupport为true时该能力有效，没有该项配置时默认支持24x24大小马赛克)
     * 枚举值参考{@link com.cf.forward.dh.lib.enumeration.NET_EM_MOSAIC_TYPE}
     */
    public int[] emMosaicType = new int[MAX_MOSAICTYPE_COUNT];
}
