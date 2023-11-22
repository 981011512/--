package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 人体测温的可见光的能力
 * @date 2021/01/11
 */
public class CFG_ANATOMYTEMP_VISUAL_CAPS extends NetSDKLib.SdkStructure{
	/**
	 * 是否支持人脸左右角度过滤
	 */
	public int bSupportFaceRight;

	/**
	 * 是否支持人脸上下角度过滤
	 */
	public int bSupportFaceUp;
	
	/**
	 * 是否支持人脸左右歪头角度过滤
	 */
	public int bSupportFaceRoll;
	
	/**
	 * 预留
	 */
	public byte[] byReserved = new byte[64];
}
