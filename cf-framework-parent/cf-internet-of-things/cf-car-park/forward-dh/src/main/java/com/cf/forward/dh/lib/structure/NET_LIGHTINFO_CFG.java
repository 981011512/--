package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @version 1.0
 * @description 相机对应的红绿灯通道状态
 * @date 2020/11/09
 */
public class NET_LIGHTINFO_CFG extends NetSDKLib.SdkStructure{
			
	//红绿灯通道
	public int nLightNo;
	
	// 红绿灯状态{@link EM_TRAFFIC_LIGHT_DETECT_STATE}
	public int emLightState;
	
	//预留
	public byte[] byReserved = new byte[504];

}
