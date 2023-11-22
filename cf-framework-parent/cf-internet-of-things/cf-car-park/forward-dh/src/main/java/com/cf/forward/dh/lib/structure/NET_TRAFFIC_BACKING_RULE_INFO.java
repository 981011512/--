package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.DH_POINT;
import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;

/**
 * @description 事件类型EVENT_IVS_TRAFFIC_BACKING(倒车) 对应的规则配置
 * @author 119178
 * @date 2021/3/11
 */
public class NET_TRAFFIC_BACKING_RULE_INFO extends SdkStructure{
	/**
	 * 检测区
	 */
	public POINTCOORDINATE[]				stuDetectRegion=(POINTCOORDINATE[])new POINTCOORDINATE().toArray(20);
	/**
	 * 检测区顶点数
	 */
	public int							nDetectRegionPoint;		
	/**
	 * 车道编号 与场景中的车道号对应
	 */
	public int							nLaneNumber;
	/**
	 * 起点，从起点到终点是正向行驶，反过来是逆行，点的坐标归一化到[0,8192)区间。
	 */
	public DH_POINT					stuDirectionStart;		
	/**
	 * 终点，从起点到终点是正向行驶，反过来是逆行，点的坐标归一化到[0,8192)区间。
	 */
	public DH_POINT					stuDirectionEnd;	
	/**
	 * 灵敏度,范围[1,10],灵敏度越高越容易检测
	 */
	public int                 		nSensitivity; 
	/**
	 * 是否使能区域内触发该规则, false-不使能，true-使能
	 */
	public int						bAreaTrigEnable;	
	/**
	 * 方案参数, false-普通变道（只要变道一次即可）,true -抓连续变道（变道2次及以上）
	 */
	public int						bContinueCrossLaneEnable;
	/**
	 * 变倍抓拍，违停球做规则判断时，默认会变倍
	 * 如下两种情况不适合变倍
	 * 1. 车速较快场合，变倍会导致跟踪不及时
	 * 2. 车牌很近，由于机芯的光轴畸变会导致车牌过大，算法无法识别
	 * 在以上这两种情况下，需要关闭变倍。是否要关闭变倍取决于现场情况，属于比较专业的配置
	 */
	public int						bZoomEnable;		
	/**
	 * 是否抓拍摩托车
	 */
	public int						bSnapMotorcycle;	
	/**
	 * 事件检测模式下，配置给算法，表示检测到事件发生后，多长时间开始报警，单位：秒，范围0-3600,无该字段不做处理
	 */
	public int						nDelayTime;		
	/**
	 * 规则特定的尺寸过滤器
	 */
	public NET_CFG_SIZEFILTER_INFO 	stuSizeFileter;  
	/**
	 * 规则特定的尺寸过滤器是否有效
	 */
	public int                		bSizeFileter;                          
	/**
	 * 是否抓拍无牌车,true-抓拍无牌车 false-不抓拍无牌车
	 */
	public int						bSnapNoPlateMotor;		
	/**
	 * 保留字节
	 */
	public byte[]                        byReserved = new byte[4092];   
}
