package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.DH_POINT;
import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;
import com.cf.forward.dh.lib.enumeration.EM_GLOBAL_LANES_LINE_TYPE;
/**
 * @description 车道信息，每个车道两条边界线
 * @author 119178
 * @date 2021/3/16
 */
public class NET_ANALYSE_TASK_GLOBAL_LANES extends SdkStructure{
	/**
	 * 车道使能  
	 * 本车道规则只有在车道使能情况下才可能生效，实际应对用户在一段时期内某车道施工引起的误检
	 * 该字段缺省时默认该车道使能
	 */
	public	int						bEnable;	
	/**
	 * 车道编号
	 */
	public	int							nNumber;
	/**
	 * 左车道线，车道线的方向表示车道方向，沿车道方向左边的称为左车道线点的坐标坐标归一化到[0,8192)区间
	 */
	public	DH_POINT []					stuLeftLinePoint= (DH_POINT [])new DH_POINT().toArray(20);	
	/**
	 * 左车道线点个数
	 */
	public	int							nLeftLinePointNum;	
	/**
	 * 左车道线的属性
	 * {@link EM_GLOBAL_LANES_LINE_TYPE}
	 */
	public	int                     	emLeftLineType;	
	/**
	 * 右车道线，车道线的方向表示车道方向，沿车道方向左边的称为左车道线点的坐标坐标归一化到[0,8192)区间
	 */
	public	DH_POINT []					stuRightLinePoint= (DH_POINT [])new DH_POINT().toArray(20);	
	/**
	 * 右车道线点个数
	 */
	public	int							nRightLinePointNum;		
	/**
	 * 右车道线的属性
	 * {@link EM_GLOBAL_LANES_LINE_TYPE}
	 */
	public	int                       	emRightLineType;
	/**
	 * 保留字节
	 */
	public	byte[]                      byReserved = new byte[1024];                       
}
