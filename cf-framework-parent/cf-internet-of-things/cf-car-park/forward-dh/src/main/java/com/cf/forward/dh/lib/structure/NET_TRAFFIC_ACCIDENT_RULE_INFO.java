package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;
/**
 * @description 事件类型EVENT_IVS_RETROGRADEDETECTION(逆行检测事件) 对应的规则配置
 * @author 119178
 * @date 2021/3/11
 */
public class NET_TRAFFIC_ACCIDENT_RULE_INFO extends SdkStructure{
	/**
	 * 检测区
	 */
	public POINTCOORDINATE[]				stuDetectRegion=(POINTCOORDINATE[])new POINTCOORDINATE().toArray(20);
	/**
	 * 检测区顶点数
	 */
	public	int							nDetectRegionPoint;	
	/**
	 * 车道编号 与场景中的车道号对应
	 */
	public	int							nLaneNumber;
	/**
	 * 最短触发时间,单位：秒
	 */
	public	int							nMinDuration;							
	/**
	 * 变倍抓拍，违停球做规则判断时，默认会变倍
	 * 如下两种情况不适合变倍
	 * 1. 车速较快场合，变倍会导致跟踪不及时
	 * 2. 车牌很近，由于机芯的光轴畸变会导致车牌过大，算法无法识别
	 * 在以上这两种情况下，需要关闭变倍。是否要关闭变倍取决于现场情况，属于比较专业的配置
	 */
	public	int						bZoomEnable;
	/**
	 * 变倍停留时间，单位:秒，在ZoomEnable为true时有效，为0时表示不停留，默认为0
	 */
	public	int						nZoomStayTime;			
	/**
	 * 车辆触发报警时间阈值，大于该阈值认为是交通事件,单位：秒，范围0-3600
	 */
	public	int						nVehicleDelayTime;	
	/**
	 * 行人触发报警时间阈值，大于该阈值认为是交通事件,单位：秒，范围0-3600
	 */
	public	int						nPersonDelayTime;	
	/**
	 * 最大报警时长 超过此时间将不再报警,单位：秒，范围0-3600
	 */
	public	int						nMaxDelayTime;		
	/**
	 * 拥堵状态下的停车数阈值，用于拥堵造成的交通事故，不做报警
	 */
	public	int						nVehicleNumberThreshold;
	/**
	 * 追尾后停车时间阈值，超过阈值报警，单位ms 0~65535
	 */
	public	int						nWanderTime;	
	/**
	 * 重复报警时间，单位ms； 0~65535
	 */
	public	int						nRepeatTime;
	/**
	 * 是否需要关联行人才报警,false为不关联,true为关联
	 */
	public	int					    bRelateHuman;	
	/**
	 * 保留字节
	 */
	public	byte[]                        byReserved=new byte[4096];                       
}
