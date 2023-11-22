package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @version 1.0
 * @description {@link NetSDKLib#CLIENT_GetChannelCfg}的入参
 * @date 2020/11/09
 */
public class NET_IN_GET_CHANNEL_CFG extends NetSDKLib.SdkStructure {

	// 结构体大小
	public int dwSize;
	
	// 检测通道
	public int nChannelNo;


	public NET_IN_GET_CHANNEL_CFG() {
		this.dwSize = this.size();
	}
}
