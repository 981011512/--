package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 事件类型EVENT_IVS_SMOKEDETECTION(烟雾报警事件)对应的数据块描述信息
 * @date 2020/12/21
 */
public class DEV_EVENT_SMOKE_INFO extends NetSDKLib.SdkStructure{
	/**
	 * 通道号
	 * */
	public int nChannelID;
	/**
	 * 事件名称
	 * */
	public byte[] szName = new byte[128]; 
	/**
	 * 时间戳(单位是毫秒)
	 * */
	public double PTS; 
	/**
	 * 事件发生的时间
	 * */
	public NetSDKLib.NET_TIME_EX UTC; 
	/**
	 * 事件ID
	 * */
	public int nEventID; 
	/**
	 * 检测到的物体
	 * */
	public NetSDKLib.NET_MSG_OBJECT stuObject; 
	/**
	 * 事件对应文件信息
	 * */
	public NetSDKLib.NET_EVENT_FILE_INFO stuFileInfo; 
	/**
	 * 事件动作,0表示脉冲事件,1表示持续性事件开始,2表示持续性事件结束
	 * */
	public byte bEventAction;
	/**
	 * 保留字节
	 * */
	public byte[] byReserved = new byte[2]; 
	/**
	 * 图片的序号, 同一时间内(精确到秒)可能有多张图片, 从0开始
	 * */
	public byte byImageIndex; 
	/**
	 * 抓图标志(按位),具体见NET_RESERVED_COMMON
	 * */
	public int dwSnapFlagMask; 
	/**
	 * 事件触发累计次数, unsigned int 类型
	 * */
	public int nOccurrenceCount; 
	/**
	 * 智能事件公共信息
	 * */
	public NetSDKLib.EVENT_INTELLI_COMM_INFO stuIntelliCommInfo; 		
	/**
	 * 云台的坐标和放大倍数
	 * */
	public NetSDKLib.PTZ_SPACE_UNIT stuPtzPosition;						
	/**
	 * stuSceneImage 是否有效
	 * */
	public int bSceneImage; 
	/**
	 * 全景广角图 
	 * */
	public NetSDKLib.SCENE_IMAGE_INFO_EX stuSceneImage; 
	/**
	 * 车身信息
	 * */
	public NetSDKLib.NET_MSG_OBJECT stuVehicle; 
	/**
	 * 触发类型,参考EM_TRIGGER_TYPE
	 * */
	public int emTriggerType; 
	/**
	 * 标记抓拍帧
	 * */
	public int nMark; 
	/**
	 * 视频分析的数据源地址
	 * */
	public int nSource;
	/**
	 * 视频分析帧序号
	 * */
	public int nFrameSequence; 
	/**
	 * 交通车辆信息
	 * */
	public NetSDKLib.DEV_EVENT_TRAFFIC_TRAFFICCAR_INFO stTrafficCar; 
	/**
	 * 公共信息 
	 * */
	public NetSDKLib.EVENT_COMM_INFO stuCommInfo;
	/**
	 * 抓拍过程,参考EM_CAPTURE_PROCESS_END_TYPE 
	 * */
	public int emCaptureProcess; 
}
