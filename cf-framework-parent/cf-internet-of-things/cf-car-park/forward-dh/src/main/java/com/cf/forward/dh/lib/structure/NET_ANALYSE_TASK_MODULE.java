package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.NET_POLY_POINTS;
import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;
/**
 * @description 任务模块配置
 * @author 119178
 * @date 2021/3/16
 */
public class NET_ANALYSE_TASK_MODULE extends SdkStructure{
	/**
	 * 规则特定的尺寸过滤器
	 */
	public	NET_CFG_SIZEFILTER_INFO 				stuSizeFileter;		
	/**
	 * 排除区域
	 */
	public	NET_POLY_POINTS[]						stuExcludeRegion=(NET_POLY_POINTS[])new NET_POLY_POINTS().toArray(10);	
	/**
	 * 排除区域数
	 */
	public	int										nExcludeRegionNum;	
	/**
	 * 保留字节
	 */
	public	byte[]									byReserved = new byte[1020];									
}
