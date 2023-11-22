package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
/**
 * @author 251823
 * @description 场景子类型字符串字节数组对象
 * @date 2021/01/13
 */
public class MaxSceneSupTypeByteArrInfo extends NetSDKLib.SdkStructure{
	/**
	 * 二维数组内字符串对应字节数组
	 */
	public byte[] sceneSupType = new byte[NetSDKLib.MAX_SCENE_SUBTYPE_LEN];
}
