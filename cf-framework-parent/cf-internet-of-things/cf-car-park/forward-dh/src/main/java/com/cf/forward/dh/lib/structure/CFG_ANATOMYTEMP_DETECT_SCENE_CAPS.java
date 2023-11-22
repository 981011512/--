package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 人体测温检测场景能力
 * @date 2021/01/11
 */
public class CFG_ANATOMYTEMP_DETECT_SCENE_CAPS extends NetSDKLib.SdkStructure{
	
	/**
	 * 人体测温智能支持类型 ,参考{ @link CFG_EM_FACEDETECT_TYPE }
	 */
	public int[] emFaceDetectTypes = new int[32];
	
	/**
	 * 人体测温智能支持类型的个数
	 */
	public int nFaceDetectTypesNum;
	
	/**
	 * 可见光的能力配置
	 */
	public CFG_ANATOMYTEMP_VISUAL_CAPS stuVisual;
	
	/**
	 * 预留
	 */
	public byte[] byReserved = new byte[1024];

}
