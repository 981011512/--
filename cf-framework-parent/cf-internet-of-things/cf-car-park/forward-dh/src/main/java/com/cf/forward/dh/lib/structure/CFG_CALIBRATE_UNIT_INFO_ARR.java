package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 标定信息单元数组
 * @date 2021/02/02
 */
public class CFG_CALIBRATE_UNIT_INFO_ARR extends NetSDKLib.SdkStructure{
	
	/**
	 * 标定信息单元
	 */
	public CFG_CALIBRATE_UNIT_INFO[] unitArr = new CFG_CALIBRATE_UNIT_INFO[2];
	
	public CFG_CALIBRATE_UNIT_INFO_ARR() {
		for (int i = 0; i < unitArr.length; i++) {
			unitArr[i] = new CFG_CALIBRATE_UNIT_INFO();
		}
	}

}
