package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.NetSDKLib.DH_POINT;
import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;
/**
 * @description 事件类型EVENT_IVS_TRAFFIC_FLOWSTATE(交通流量统计事件) 对应的规则配置
 * @author 119178
 * @date 2021/3/11
 */
public class NET_TRAFFIC_FLOWSTAT_RULE_INFO extends SdkStructure{
	/**
	 * 检测区
	 */
	public POINTCOORDINATE[]				stuDetectRegion = (POINTCOORDINATE[])new POINTCOORDINATE().toArray(20);	
	/**
	 * 检测区顶点数
	 */
	public int							nDetectRegionPoint;
	/**
	 * 规则检测线顶点数
	 */
	public int							nDetectLineNum;			
	/**
	 * 规则检测线
	 */
	public DH_POINT[]				DetectLine = (DH_POINT[])new DH_POINT().toArray(NetSDKLib.NET_MAX_DETECT_LINE_NUM);	
	/**
	 * 车道编号 与场景中的车道号对应
	 */
	public int							nLaneNumber;
	/**
	 * 统计周期,单位：分钟
	 */
	public int						nPeriod;
	/**
	 * 保留字节
	 */
	public byte[]                        byReserved = new byte[4096];                       
}
