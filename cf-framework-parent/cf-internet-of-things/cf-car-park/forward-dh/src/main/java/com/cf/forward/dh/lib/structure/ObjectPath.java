package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
/**
 * @author 251823
 * @description 图路径对象
 * @date 2021/02/23
 */
public class ObjectPath extends NetSDKLib.SdkStructure {
	/**
	 *  路径字节数组
	 */
	public byte[] objectPath = new byte[NetSDKLib.MAX_PATH];

}
