package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 上报的雷达报警点信息
 *
 * @author ： 119178
 * @since ： Created in 2021/2/03 13:56
 */
public class NET_RADAR_NOTIFY_ALARMPOINTINFO extends NetSDKLib.SdkStructure{
	/**
	 * 雷达报警点的数量
	 */
	public int                         nNumAlarmPoint;   
	/**
	 * 雷达报警点信息
	 * NET_RADAR_MAX_NUM_ALARMPOINT=64(雷达报警点的最大数量)
	 */
	public NET_RADAR_ALARMPOINT_INFO[]   stuAlarmPoint = (NET_RADAR_ALARMPOINT_INFO[])new NET_RADAR_ALARMPOINT_INFO().toArray(64);  
	/**
	 * 通道号
	 */
	public int							nChannel;				
	/**
	 * 保留字节
	 */
	public byte[]                        byReserved= new byte[1020];        
}
