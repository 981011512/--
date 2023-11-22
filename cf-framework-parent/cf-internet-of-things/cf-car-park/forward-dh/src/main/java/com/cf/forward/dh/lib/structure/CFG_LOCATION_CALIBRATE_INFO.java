package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.constant.SDKStructureFieldLenth;

/**
 * @author 251823
 * @description 设备参数标定配置
 * @date 2021/02/01
 */
public class CFG_LOCATION_CALIBRATE_INFO extends NetSDKLib.SdkStructure{
	/**
	 * 可见光横向视角
	 */
	public int nVisualMaxHFOV;
	
	/**
	 * 可见光纵向视角
	 */
	public int nVisualMaxVFOV;
	
	/**
	 * 热成像横向视角
	 */
	public int nThermoMaxHFOV;
	
	/**
	 * 热成像纵向视角
	 */
	public int nThermoMaxVFOV;
	
	/**
	 * 标定点信息
	 */
	public CFG_LOCATION_CALIBRATE_POINT_INFO[] stuPointInfo = new CFG_LOCATION_CALIBRATE_POINT_INFO[SDKStructureFieldLenth.MAX_CALIBRATE_POINT_NUM];
	
	/**
	 * 标定点个数
	 */
	public int nPointNum;
	
	/**
	 * 字节对齐 
	 */
	public byte[] byReserved1 = new byte[4];
	
	public CFG_LOCATION_CALIBRATE_INFO() {
		for (int i = 0; i < stuPointInfo.length; i++) {
			stuPointInfo[i] = new CFG_LOCATION_CALIBRATE_POINT_INFO();
		}
	}
					
}
