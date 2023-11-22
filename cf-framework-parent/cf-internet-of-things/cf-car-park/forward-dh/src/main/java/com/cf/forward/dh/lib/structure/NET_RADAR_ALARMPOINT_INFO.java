package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 单个雷达报警点信息
 *
 * @author ： 119178
 * @since ： Created in 2021/2/03 13:56
 */
public class NET_RADAR_ALARMPOINT_INFO extends NetSDKLib.SdkStructure{
	/**
	 * 点类型的掩码,该字段废弃,请不要使用,请使用nPointType
	 * @description 枚举类型 {@link #EM_RADAR_POINTTYPE}
	 */
	public int          emPointType;   
	/**
	 *  点类型的掩码
	 *  bit0：无效
	 *  bit1：当前点是消失的轨迹点
	 *  bit2：当前点是正在被联动监控的点
	 *  bit3：当前点是报警区的报警点
	 *  备注：点的状态可能有多个，例如值为0xC时，表示当前的点既是正在被联动监控的点，又是报警区的报警点
	 */
	public int                         nPointType;  
	/**
	 * 当前点所属的防区编号,范围[0,10]([1,10]为防区编号,0表示当前点不属于任何一个防区)
	 */
	public int                         nRegionNumber;          
	/**
	 *  点所指对象的类型的掩码
	 *  @description 枚举类型 {@link #EM_RADAR_OBJECTTYPE}  
	 */
	public int         emObjectType;      
	/**
	 * 点所属的轨迹号,范围[0,63]
	 */
	public int                         nTrackID; 
	/**
	 * 当前点像素极坐标值-距离，实际长度扩大100倍的结果,单位米
	 */
	public int                         nDistance;   
	/**
	 * 当前点像素极坐标值-角度，实际角度扩大100倍的结果，单位度
	 */
	public int                         nAngle;     
	/**
	 * 当前点速度，扩大100倍的结果，单位米/秒
	 */
	public int                         nSpeed;
	/**
	 * 保留字节
	 */
	public byte[]                        byReserved = new byte[512];         
}
