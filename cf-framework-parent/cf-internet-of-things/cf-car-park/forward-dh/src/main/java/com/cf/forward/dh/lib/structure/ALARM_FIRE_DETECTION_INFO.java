package com.cf.forward.dh.lib.structure;
/**
 * @author 251823
 * @description 火警事件 (DH_ALARM_FIRE_DETECTION)
 * @date 2020/12/21
 */

import com.cf.forward.dh.lib.NetSDKLib;

public class ALARM_FIRE_DETECTION_INFO extends NetSDKLib.SdkStructure{
	
	/**
	 * 通道号
	 * */
	public int nChannelID;
		
	/**
	 * 事件动作,0表示脉冲事件,1表示持续性事件开始,2表示持续性事件结束
	 * */
	public int nAction;
	
	/**
	 * 事件发生的时间
	 * */
	public NetSDKLib.NET_TIME_EX UTC;
	
	/**
	 * 保留字节 
	 * */
	public byte[] byReserved = new byte[1024];

}
