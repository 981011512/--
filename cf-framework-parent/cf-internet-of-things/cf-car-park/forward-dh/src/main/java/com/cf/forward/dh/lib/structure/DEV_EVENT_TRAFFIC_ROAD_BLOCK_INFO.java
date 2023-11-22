package com.cf.forward.dh.lib.structure;
/**
 * @author 119178
 * @description 事件类型EVENT_IVS_TRAFFIC_ROAD_BLOCK(交通路障检测事件)对应的数据块描述信息
 * @date 2020/12/21
 */

import com.cf.forward.dh.lib.NetSDKLib.EVENT_COMM_INFO;
import com.cf.forward.dh.lib.NetSDKLib.NET_EVENT_FILE_INFO;
import com.cf.forward.dh.lib.NetSDKLib.NET_RECT;
import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;

public class DEV_EVENT_TRAFFIC_ROAD_BLOCK_INFO extends SdkStructure{
	/**
	 * 通道号
	 */
	public int                 nChannelID;    
	/**
	 * 事件动作, 0表示脉冲事件, 1表示持续性事件开始, 2表示持续性事件结束
	 */
	public int					nAction;							       
	/**
	 * 事件名称
	 */
	public byte[]                szName=new byte[128];      
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
	public int                nEventID;     
	/**
	 * 事件对应文件信息
	 */
	public NET_EVENT_FILE_INFO	stuFileInfo;							   
	/**
	 * 物体包围盒
	 */
	public NET_RECT			stuBoundingBox;
	/**
	 * 车道号
	 */
	public int                nLane;    
	/**
	 * 公共信息
	 */
	public EVENT_COMM_INFO     stCommInfo;    
	/**
	 * 抓图标志(按位),具体见NET_RESERVED_COMMON
	 */
	public int               dwSnapFlagMask;   
	/**
	 * 预留字节
	 */
	public byte[]                bReserved=new byte[4092];                           
}
