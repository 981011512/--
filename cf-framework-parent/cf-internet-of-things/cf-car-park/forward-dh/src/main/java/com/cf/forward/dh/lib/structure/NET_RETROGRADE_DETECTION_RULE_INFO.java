package com.cf.forward.dh.lib.structure;
/**
 * @description 事件类型EVENT_IVS_RETROGRADEDETECTION(逆行检测事件) 对应的规则配置
 * @author 119178
 * @date 2021/3/11
 */

import com.cf.forward.dh.lib.NetSDKLib.DH_POINT;
import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;
public class NET_RETROGRADE_DETECTION_RULE_INFO extends SdkStructure{
	/**
	 * 检测区
	 */
	public POINTCOORDINATE[]				stuDetectRegion=(POINTCOORDINATE[])new POINTCOORDINATE().toArray(20);
	/**
	 * 检测区顶点数
	 */
	public	int							nDetectRegionPoint;	
	/**
	 * 触发报警位置数
	 */
	public	int                 		nTriggerPosition;       
	/**
	 * 触发报警位置,0-目标外接框中心, 1-目标外接框左端中心, 2-目标外接框顶端中心, 3-目标外接框右端中心, 4-目标外接框底端中心
	 */
	public	byte[]                		bTriggerPosition=new byte[8];     
	/**
	 * 起点，从起点到终点是正向行驶，反过来是逆行，点的坐标归一化到[0,8192)区间。
	 */
	public	DH_POINT					stuDirectionStart;		
	/**
	 * 终点，从起点到终点是正向行驶，反过来是逆行，点的坐标归一化到[0,8192)区间。 
	 */
	public	DH_POINT					stuDirectionEnd;		
	/**
	 * 规则特定的尺寸过滤器
	 */
	public	NET_CFG_SIZEFILTER_INFO 	stuSizeFileter;
	/**
	 * 规则特定的尺寸过滤器是否有效
	 */
	public int                		bSizeFileter;                           
	/**
	 * 灵敏度，值越小灵敏度越低。取决于方向夹角，取值1-10
	 */
	public	int                 		nSensitivity; 
	/**
	 * 是否抓拍摩托车
	 */
	public	int						bSnapMotorcycle;	
	/**
	 * 逆行多少距离后触发报警，GB30147要求，距离归一化到8192坐标
	 */
	public	int                 		nDistance;		
	/**
	 * 保留字节
	 */
	public	byte[]                        byReserved=new byte[4092];                       
}
