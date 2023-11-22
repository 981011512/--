package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 标定信息单元
 * @date 2021/02/02
 */
public class CFG_CALIBRATE_UNIT_INFO extends NetSDKLib.SdkStructure{
	
	/**
	 * 分辨率高
	 */
	public int nHeight;
	
	/**
	 * 分辨率宽
	 */
	public int nWidth;
	
	/**
	 * 云台位置(P/T/Z 归一化)
	 */
	public float[] nPosition =new float[3];
	
	/**
	 * 标定点坐标
	 */
	public int[] nLocation =new int[2];
	
	/**
	 * 横向视场角(单位：0.01度)
	 */
	public int nHFOV;
	
	/**
	 * 纵向视场角(单位：0.01度)
	 */
	public int nVFOV;
		
}
