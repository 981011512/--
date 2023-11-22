package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;
/**
 * @description 事件类型EVENT_IVS_TRAFFIC_THROW(抛洒物事件) 对应的规则配置
 * @author 119178
 * @date 2021/3/11
 */
public class NET_TRAFFIC_THROW_RULE_INFO extends SdkStructure{
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
	 * 报警间隔时间,单位：秒
	 */
	public	int							nInterval;	
	/**
	 * 是否抓拍摩托车
	 */
	public	int						bSnapMotorcycle;	
	/**
	 * 变倍抓拍，违停球做规则判断时，默认会变倍
	 * 如下两种情况不适合变倍
	 * 1. 车速较快场合，变倍会导致跟踪不及时
	 * 2. 车牌很近，由于机芯的光轴畸变会导致车牌过大，算法无法识别
	 * 在以上这两种情况下，需要关闭变倍。是否要关闭变倍取决于现场情况，属于比较专业的配置
	 */
	public	int						bZoomEnable;							
	/**
	 * 重复报警时间,无该字段不做处理
	 */
	public	int						nRepeatAlarmTime;
	/**
	 * 抓拍目标类型，默认抓拍行人，后续可做扩展.无该字段不做处理
	 */
	public	int						nSnapObjectType;		
	/**
	 * 检测到行人后多少时间开始报警。单位：秒，范围0-3600.无该字段不做处理
	 */
	public	int						nDelayTime;			
	/**
	 * 灵敏度,范围1~100 ,配置0即为默认值,灵敏度越大算法检测越灵敏
	 */
	public	int                 		nSensitivity;  
	/**
	 *  保留字节
	 */
	public	byte[]                        byReserved = new byte[4096]; 
}
