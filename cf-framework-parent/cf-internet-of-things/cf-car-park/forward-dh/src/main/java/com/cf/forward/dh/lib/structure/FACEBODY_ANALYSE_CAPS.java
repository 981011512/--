package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 人体识别能力集（定制）
 * @date 2021/01/11
 */
public class FACEBODY_ANALYSE_CAPS extends NetSDKLib.SdkStructure{
	/**
	 * 支持检测的人脸属性,参考枚举CFG_EM_FACE_TRAIT
	 */
	public int[] szFaceFeatureList = new int[32];
	
	/**
	 * 返回的人脸属性个数
	 */
	public int nFaceFeature;
		
	/**
	 * 支持检测的人体属性,参考枚举CFG_EM_BODY_TRAIT
	 */
	public int[] szBodyFeatureList = new int[32];
	
	/**
	 * 返回的人体属性个数
	 */
	public int nBodyFeature;
	
	/**
	 * 支持抓拍属性,参考枚举CFG_EM_FACE_SNAP_POLICY
	 */
	public int[] szSnapPolicyList = new int[16];
	
	/**
	 * 返回的抓拍属性个数
	 */
	public int nSnapPolicy;
	
	/**
	 * 预留字段
	 */
	public byte[] byReserved = new byte[256];
}
