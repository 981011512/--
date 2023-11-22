package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;
/**
 * @description 事件类型EVENT_IVS_TRAFFIC_ROAD_CONSTRUCTION(交通道路施工检测事件) 对应的规则配置
 * @author 119178
 * @date 2021/3/11
 */
public class NET_TRAFFIC_ROAD_CONSTRUCTION_RULE_INFO extends SdkStructure{
	/**
	 * 检测区
	 */
	public POINTCOORDINATE[]				stuDetectRegion=(POINTCOORDINATE[])new POINTCOORDINATE().toArray(20);
	/**
	 * 检测区顶点数
	 */
	public int							nDetectRegionPoint;	
	/**
	 * 最短持续时间,单位：秒 0~65535
	 */
	public int						nMinDuration;
	/**
	 * 灵敏度,范围[1,10],灵敏度越高越容易检测
	 */
	public int                 		nSensitivity;   
	/**
	 * 车道编号 与场景中的车道号对应
	 */
	public int							nLaneNumber;	
	/**
	 * 变倍抓拍，违停球做规则判断时，默认会变倍。有两种情况不适合变倍
	 * 1.车速较快场合，变倍会导致跟踪不及时
	 * 2.车牌很近，由于机芯的光轴畸变会导致车牌过大，算法无法识别
	 * 在以上这两种情况下，需要关闭变倍。注意是否要关闭变倍取决于现场情况，属于比较专业的配置，只对Web或者调试工具开放该选项
	 * true开启变倍，false不变倍
	 * web上默认勾选
	 */
	public int						bZoomEnable;		
	/**
	 * 重复报警时间，单位：秒，范围0-3600.无该字段时，不做处理
	 */
	public int						nRepeatAlarmTime;	
	/**
	 *  保留字节
	 */
	public byte[]                        byReserved=new byte[4096];      
}
