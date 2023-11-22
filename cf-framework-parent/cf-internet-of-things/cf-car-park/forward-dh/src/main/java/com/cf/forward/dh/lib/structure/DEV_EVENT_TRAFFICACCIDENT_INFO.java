package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.EVENT_TRAFFIC_CAR_PART_INFO;
import com.cf.forward.dh.lib.NetSDKLib.NET_EVENT_FILE_INFO;
import com.cf.forward.dh.lib.NetSDKLib.NET_MSG_OBJECT;
import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;

/**
 * @author 119178
 * @description 事件类型EVENT_IVS_TRAFFICACCIDENT(交通道路施工检测事件)对应的数据块描述信息
 * @date 2020/12/21
 */
public class DEV_EVENT_TRAFFICACCIDENT_INFO extends SdkStructure{
	/**
	 * 通道号
	 */
	public int                 nChannelID;        
	/**
	 * 事件名称
	 */
	public byte[]                szName=new byte[128];   
	/**
	 * 字节对齐
	 */
	public byte[]                bReserved1=new byte[4];  
	/**
	 * 时间戳(单位是毫秒)
	 */
	public double              PTS;   
	/**
	 * 事件发生的时间
	 */
	public NET_TIME_EX         UTC;   
	/**
	 * 事件ID
	 */
	public int                 nEventID;             
	/**
	 * 检测到的物体个数
	 */
	public int                 nObjectNum;                   
	/**
	 * 检测到的物体列表
	 */
	public NET_MSG_OBJECT[]      stuObjectIDs=(NET_MSG_OBJECT[])new NET_MSG_OBJECT().toArray(16);  
	/**
	 * 事件对应文件信息
	 */
	public NET_EVENT_FILE_INFO  stuFileInfo;   
	/**
	 * 事件动作,0表示脉冲事件,1表示持续性事件开始,2表示持续性事件结束;
	 */
	public byte                bEventAction;                              
	public byte[]                byReserved=new byte[2];
	/**
	 * 图片的序号, 同一时间内(精确到秒)可能有多张图片, 从0开始
	 */
	public byte               byImageIndex;  
	/**
	 * 抓图标志(按位),具体见NET_RESERVED_COMMON
	 */
	public int               dwSnapFlagMask;     
	/**
	 * 交通车辆部分信息
	 */
	public EVENT_TRAFFIC_CAR_PART_INFO   stuTrafficCarPartInfo;  
	/**
	 * 车道号
	 */
	public int                nLane;              
	/**
	 * 保留字节,留待扩展.
	 */
	public byte[]             bReserved=new byte[460];                             
}
