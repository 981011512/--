package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;
/**
 * @description 事件类型EVENT_IVS_TRAFFICJAM(交通拥堵事件) 对应的规则配置
 * @author 119178
 * @date 2021/3/11
 */
public class NET_TRAFFIC_JAM_RULE_INFO extends SdkStructure{
	/**
	 * 检测区
	 */
	public POINTCOORDINATE[]				stuDetectRegion=(POINTCOORDINATE[])new POINTCOORDINATE().toArray(20);
	/**
	 * 检测区顶点数
	 */
	public int							nDetectRegionPoint;	
	/**
	 * 占线限值起始值(上限)，拥堵长度占车道比例限值1-100
	 */
	public int						nJamLineMargin;
	/**
	 * 占线限值终值(下限),必须比JamLineMargin小,两值的差推荐大于10，不能相等1-99
	 */
	public int						nJamLineMarginEnd;						
	/**
	 * 车道编号 与场景中的车道号对应
	 */
	public int							nLaneNumber;
	/**
	 * 检测到报警发生到开始上报的时间,单位：秒 范围1~65535
	 */
	public int						nDelay;
	/**
	 * 报警间隔时间,单位：秒 范围1~65535
	 */
	public int						nInterval;								
	/**
	 * 灵敏度,范围[1,10],灵敏度越高越容易检测
	 */
	public int                 		nSensitivity; 
	/**
	 * 上报次数 1~255
	 */
	public int						nReportTimes;
	/**
	 * 路口车辆数目阈值,大于0：只有当前路口车辆数目大于此值时才会判定为拥堵；等于0：对车辆数目没要求
	 */
	public int						nVehicleNumberThreshold;				
	/**
	 * 变倍抓拍，违停球做规则判断时，默认会变倍
	 * 如下两种情况不适合变倍
	 * 1. 车速较快场合，变倍会导致跟踪不及时
	 * 2. 车牌很近，由于机芯的光轴畸变会导致车牌过大，算法无法识别
	 * 在以上这两种情况下，需要关闭变倍。是否要关闭变倍取决于现场情况，属于比较专业的配置
	 */
	public int						bZoomEnable;			
	/**
	 * 规则特定的尺寸过滤器
	 */
	public NET_CFG_SIZEFILTER_INFO 	stuSizeFileter;
	/**
	 * 规则特定的尺寸过滤器是否有效
	 */
	public int                		bSizeFileter;                           
	/**
	 * 不连续时间阈值(单位：秒):若超过该时间阈值为不拥堵的情况，将对报警计数清零 0-255	
	 */
	public int						nDiscontinuousTimeThreshold;			
	/**
	 * 保留字节
	 */
	public byte[]                        byReserved = new byte[4092];   
}
