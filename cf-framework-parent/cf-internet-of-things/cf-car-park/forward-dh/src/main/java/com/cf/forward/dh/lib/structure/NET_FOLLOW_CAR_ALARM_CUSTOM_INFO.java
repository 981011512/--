package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
/**
 * @author 251823
 * @description 跟随车辆报警自定义信息
 * @date 2021/01/13
 */
public class NET_FOLLOW_CAR_ALARM_CUSTOM_INFO extends NetSDKLib.SdkStructure{
	
	/**
	 * GPS信息
	 */
	public NetSDKLib.NET_GPS_STATUS_INFO stuGPS;
	
	/**
	 * 保留字节
	 */
	public byte[] byReserved = new byte[256];

}
