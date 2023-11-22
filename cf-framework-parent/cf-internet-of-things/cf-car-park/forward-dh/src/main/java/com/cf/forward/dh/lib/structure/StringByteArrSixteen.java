package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 字符串字节数组对象(长度16)
 * @date 2021/01/13
 */
public class StringByteArrSixteen extends NetSDKLib.SdkStructure{
	/**
	 * 二维数组内字符串对应字节数组
	 */
	public byte[] data = new byte[NetSDKLib.CFG_COMMON_STRING_16];
}
