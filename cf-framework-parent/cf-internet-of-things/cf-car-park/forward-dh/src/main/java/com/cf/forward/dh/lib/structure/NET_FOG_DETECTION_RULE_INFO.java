package com.cf.forward.dh.lib.structure;
/**
 * @description 事件类型EVENT_IVS_FOG_DETECTION(起雾检测) 对应的规则配置
 * @author 119178
 * @date 2021/3/11
 */

import com.cf.forward.dh.lib.NetSDKLib.EM_FOG_LEVEL;
import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;

public class NET_FOG_DETECTION_RULE_INFO extends SdkStructure{
	/**
	 * 报警阈值。当雾情达到什么程度时，进行报警
	 * {@link EM_FOG_LEVEL}
	 */
	public	int				emAlarmFogLevel;	
	/**
	 * 报警时间间隔,单位秒，取值范围为[60，86400]
	 */
	public	int						nAlarmInterval;	
	/**
	 * 是否上报实时数据
	 */
	public	int						bRealDataUpload;	
	/**
	 * 实时数据上报间隔,单位秒，取值范围为[60，86400]
	 */
	public	int						nRealUpdateInterval;	
	/**
	 *  保留字节
	 */
	public	byte[]                        byReserved=new byte[4096];                      
}
