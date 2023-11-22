package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 通用名字字符串字节数组对象
 * @date 2021/01/13
 */
public class MaxNameByteArrInfo extends NetSDKLib.SdkStructure{
	
	/**
	 * 二维数组内字符串对应字节数组
	 */
	public byte[] name = new byte[NetSDKLib.MAX_NAME_LEN];
}
