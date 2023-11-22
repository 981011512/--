package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;
import com.cf.forward.dh.lib.enumeration.NET_EM_SCENEDETECTION_TYPE;
/**
 * @description 事件类型EVENT_IVS_FIREDETECTION(火焰检测事件) 对应的规则配置
 * @author 119178
 * @date 2021/3/11
 */
public class NET_FIRE_DETECTION_RULE_INFO extends SdkStructure{
	/**
	 * 检测区顶点数
	 */
	public int							nDetectRegionPoint;
	/**
	 * 字节对齐
	 */
	public byte[]                        byReserved1=new byte[4];	
	/**
	 * 检测区
	 */
	public POINTCOORDINATE[]				stuDetectRegion=(POINTCOORDINATE[])new POINTCOORDINATE().toArray(20);
	/**
	 * 最短持续时间,单位：秒 0~65535
	 */
	public int						nMinDuration;	
	/**
	 * 灵敏度,范围[1,10],灵敏度越高越容易检测
	 */
	public int                 		nSensitivity;            
	/**
	 * 火焰定位参数
	 */
	public NET_FIRE_DETECTION_POSITION_PARAM stuPositionParam;	
	/**
	 * 重复报警时间，单位：秒，范围0-3600.无该字段时，不做处理
	 */
	public int						nRepeatAlarmTime;	
	/**
	 * 场景类型
	 * {@link NET_EM_SCENEDETECTION_TYPE}
	 */
	public int  emSceneType;			
	/**
	 * 保留字节
	 */
	public byte[]                        byReserved=new byte[4096];                       
}
