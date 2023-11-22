package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
/**
 * @author 251823
 * @description 人数统计大类场景
 * @date 2021/01/11
 */
public class CFG_NUMBER_STAT_INFO extends NetSDKLib.SdkStructure{
	
	/**
	 * 相机类型，0：表示老单目客流 1：表示新统一单目客流 2：表示新统一双目客流
	 */
	public int nCameraType;

}
