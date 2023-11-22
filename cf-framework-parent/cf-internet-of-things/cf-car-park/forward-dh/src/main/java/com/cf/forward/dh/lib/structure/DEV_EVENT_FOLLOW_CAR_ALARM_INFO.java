package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 事件类型 EVENT_IVS_FOLLOW_CAR_ALARM 跟车报警事件 对应的数据块描述信息
 * @date 2021/01/13
 */
public class DEV_EVENT_FOLLOW_CAR_ALARM_INFO extends NetSDKLib.SdkStructure {
	
	/**
	 * 通道号
	 */
	public int nChannelID;
	
	/**
	 * 事件动作,0表示脉冲事件,1表示持续性事件开始,2表示持续性事件结束;
	 */
	public int nAction;
	
	/**
	 * 事件发生的时间
	 */
	public NetSDKLib.NET_TIME_EX UTC;
	
	/**
	 * 跟车图片信息个数
	 */
	public int nImageInfoNum;
	
	/**
	 * 跟车图片信息
	 */
	public NET_FOLLOW_CAR_ALARM_IMAGE_INFO[] stuImageInfo = new NET_FOLLOW_CAR_ALARM_IMAGE_INFO[8];
	
	/**
	 * 自定义信息
	 */
	public NET_FOLLOW_CAR_ALARM_CUSTOM_INFO stuCustomInfo;
	
	/**
	 * 交通车辆信息
	 */
	public NetSDKLib.DEV_EVENT_TRAFFIC_TRAFFICCAR_INFO stTrafficCar;
				
	/**
	 * 保留字节
	 */
	public byte[] byReserved = new byte[1024];
	
	public DEV_EVENT_FOLLOW_CAR_ALARM_INFO() {
		for (int i = 0; i < stuImageInfo.length; i++) {
			stuImageInfo[i] = new  NET_FOLLOW_CAR_ALARM_IMAGE_INFO();
		}
	}
}
