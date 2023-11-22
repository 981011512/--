package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;

/**
 * @description 事件类型EVENT_IVS_TRAFFIC_OVERSPEED(超速事件) 对应的规则配置
 * @author 119178
 * @date 2021/3/11
 */
public class NET_TRAFFIC_OVERSPEED_RULE_INFO extends SdkStructure{
	/**
	 * 限速范围
	 */
	public NET_SPEED_LIMIT				stuSpeedLimit;		
	/**
	 * 最短触发时间,单位：秒
	 */
	public int							nMinDuration;		
	/**
	 * 是否抓拍摩托车
	 */
	public int						bSnapMotorcycle;	
	/**
	 * 黄牌车限速范围,范围0~255km/h
	 */
	public NET_SPEED_LIMIT				stuYellowSpeedLimit;		
	/**
	 * 车道编号 与场景中的车道号对应
	 */
	public int							nLaneNumber;			
	/**
	 * 是否启用大小车限速,True-使用下面具体的大小车限速字段,False-使用SpeedLimit字段,该字段缺省时默认False，即使用通用字段SpeedLimit
	 */
	public int						bSpeedLimitForSize;	
	/**
	 * 小型车辆速度下限和上限,0~255km/h，启用bSpeedLimitForSize有效，作为普通车辆限速
	 */
	public NET_SPEED_LIMIT				stuSmallCarSpeedLimit;
	/**
	 * 大型车辆速度下限和上限,0~255km/h，启用bSpeedLimitForSize有效，作为大型车辆限速
	 */
	public NET_SPEED_LIMIT				stuBigCarSpeedLimit;
	/**
	 * 小车限高速宽限值,单位：km/h，不启用大小车限速时作为普通车辆高速宽限值，启用bSpeedLimitForSize时作为小车高速宽限值
	 */
	public NET_SPEED_LIMIT				stuOverSpeedMargin;	
	/**
	 * 大车限高速宽限值,单位：km/h，不启用大小车限速时作为普通车辆高速宽限值，启用bSpeedLimitForSize时作为大型车辆高速宽限值
	 */
	public NET_SPEED_LIMIT				stuBigCarOverSpeedMargin;	
	/**
	 * 小车限低速宽限值,单位：km/h，不启用大小车限速时作为普通车辆低速宽限值，启用bSpeedLimitForSize时，作为小车低速宽限值
	 */
	public NET_SPEED_LIMIT				stuUnderSpeedMargin;
	/**
	 * 大车限低速宽限值,单位：km/h，不启用大小车限速时作为普通车辆低速宽限值，启用bSpeedLimitForSize时作为大型车辆高速宽限值
	 */
	public NET_SPEED_LIMIT				stuBigCarUnderSpeedMargin;
	/**
	 * 语音播报使能
	 */
	public int						bVoiceBroadcastEnable;	
	/**
	 * 保留字节
	 */
	public byte[]                        byReserved= new byte[4092];                       
}
