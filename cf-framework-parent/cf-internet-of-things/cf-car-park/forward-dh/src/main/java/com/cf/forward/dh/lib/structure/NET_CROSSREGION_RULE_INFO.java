package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.EM_CATEGORY_TYPE;
import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;
/**
 * @description 事件类型EVENT_IVS_TRAFFIC_ROAD_BLOCK(交通路障检测事件) 对应的规则配置
 * @author 119178
 * @date 2021/3/17
 */
public class NET_CROSSREGION_RULE_INFO extends SdkStructure{
	/**
	 * 结构体大小
	 */
	public int                   dwSize;    
	/**
	 * 检测方向:0:Enter;1:Leave;2:Both
	 */
	public int						nDirection;				
	/**
	 * 警戒区顶点数
	 */
	public int						nDetectRegionPoint;	
	/**
	 * 警戒区
	 */
	public POINTCOORDINATE[]			stuDetectRegion= (POINTCOORDINATE[])new POINTCOORDINATE().toArray(20);	
	/**
	 * 规则特定的尺寸过滤器是否有效
	 */
	public int                	bSizeFileter;     
	/**
	 * 规则特定的尺寸过滤器
	 */
	public NET_CFG_SIZEFILTER_INFO stuSizeFileter;   
	/**
	 * 检测动作个数
	 */
	public int                 	nActionType;  
	/**
	 * 检测动作列表,0-出现 1-消失 2-在区域内 3-穿越区域
	 */
	public byte[]                	bActionType=new byte[4];          
	/**
	 * 最小目标个数(当bActionType中包含"2-在区域内"时有效)
	 */
	public int                 	nMinTargets;         
	/**
	 * 最大目标个数(当bActionType中包含"2-在区域内"时有效)
	 */
	public int                 	nMaxTargets; 
	/**
	 * 最短持续时间， 单位秒(当bActionType中包含"2-在区域内"时有效)
	 */
	public int                 	nMinDuration; 
	/**
	 * 报告时间间隔， 单位秒(当bActionType中包含"2-在区域内"时有效)
	 */
	public int                 	nReportInterval;     
	/**
	 * 跟踪持续时间,0秒:一直跟踪,1~300秒:跟踪持续时间
	 */
	public int						nTrackDuration;	
	/**
	 * 检测的车辆子类型个数
	 */
	public int					nVehicleSubTypeNum;	
	/**
	 * 检测的车辆子类型列表
	 * {@link EM_CATEGORY_TYPE}
	 */
	public int[]		emVehicleSubType=new int[128];	
	
	public NET_CROSSREGION_RULE_INFO()
    {
        this.dwSize = this.size();
    }// 此结构体大小
}
