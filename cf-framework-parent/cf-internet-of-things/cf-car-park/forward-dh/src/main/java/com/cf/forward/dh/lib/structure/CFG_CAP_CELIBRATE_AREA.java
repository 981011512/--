package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 标定区域能力信息
 * @date 2021/01/11
 */
public class CFG_CAP_CELIBRATE_AREA extends NetSDKLib.SdkStructure{
	
	/**
	 * 标定区域类型,参考{ @link EM_CALIBRATEAREA_TYPE}
	 */
	public int emType;
	
	 /**
     *  支持的水平标尺最大个数
     */
    public byte byMaxHorizontalStaffNum;

    /**
     *  支持的水平标尺最小个数
     */
    public byte byMinHorizontalStaffNum;

    /**
     *  支持的垂直标尺最大个数
     */
    public byte byMaxVerticalStaffNum;

    /**
     *  支持的垂直标尺最小个数
     */
    public byte byMinVerticalStaffNum;

}
