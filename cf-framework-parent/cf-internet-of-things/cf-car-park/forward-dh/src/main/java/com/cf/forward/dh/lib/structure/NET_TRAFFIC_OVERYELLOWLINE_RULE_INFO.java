package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;
/**
 * @description 事件类型EVENT_IVS_TRAFFIC_OVERYELLOWLINE(压黄线事件) 对应的规则配置
 * @author 119178
 * @date 2021/3/11
 */
public class NET_TRAFFIC_OVERYELLOWLINE_RULE_INFO extends SdkStructure{
	/**
	 * 检测区
	 */
	public POINTCOORDINATE[]				stuDetectRegion = (POINTCOORDINATE[])new POINTCOORDINATE().toArray(20);	
	/**
	 * 检测区顶点数
	 */
	public int							nDetectRegionPoint;		
	/**
	 * 车道编号 与场景中的车道号对应
	 */
	public int							nLaneNumber;
	/**
	 * 是否使能区域内触发该规则, false-不使能，true-使能
	 */
	public int						bAreaTrigEnable;			
	/**
	 * 灵敏度,范围[1,10],灵敏度越高越容易检测
	 */
	public int                 		nSensitivity;  
	/**
	 * 是否抓拍摩托车
	 */
	public int						bSnapMotorcycle;
	/**
	 * 事件检测模式下，配置给算法，表示检测到事件发生后，多长时间开始报警，单位：秒，范围0-3600,无该字段不做处理
	 */
	public int						nDelayTime;	
	/**
	 * 保留字节
	 */
	public byte[]                        byReserved=new byte[4096];                       
}
