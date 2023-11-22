package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;
/**
 * @author 119178
 * @description 海康视图云存储服务器鉴权密钥
 * @date 2021/4/20
 */
public class NET_HKIMAGESERVER_INFO extends SdkStructure{
	/**
	 * 接入码
	 */
	public byte[]						szAccessKey = new byte[136];	
	/**
	 * 鉴权密钥
	 */
	public byte[]						szSecretKey = new byte[136];
	/**
	 * 预留字段
	 */
	public byte[]						szReserved = new byte[512];				
}
