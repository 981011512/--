package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 视频分析能力集  对应能力集命令  CFG_CAP_CMD_VIDEOANALYSE 
 * @date 2021/01/08
 */
public class CFG_CAP_ANALYSE_INFO extends NetSDKLib.SdkStructure{
	
	/**
	 * 支持的场景个数
	 */
	public int nSupportedSceneNum;
	
	/**
	 * 支持的场景列表
	 */
	public MaxNameByteArrInfo[] szSceneName = (MaxNameByteArrInfo[])new MaxNameByteArrInfo().toArray(NetSDKLib.MAX_SCENE_LIST_SIZE);
	
	
	/**
	 * 每通道支持最大分析模块数
	 */
	public int nMaxMoudles;
	
	/**
	 * 支持的检测物体类型个数
	 */
	public int nSupportedObjectTypeNum;
		
	/**
	 * 支持的检测物体类型列表
	 */
	public MaxNameByteArrInfo[] szObjectTypeName = (MaxNameByteArrInfo[])new MaxNameByteArrInfo().toArray(NetSDKLib.MAX_OBJECT_LIST_SIZE);
	
	/**
	 * 每通道支持最大规则条数
	 */
	public int nMaxRules;
	
	/**
	 * 支持的事件类型规则个数
	 */
	public int nSupportedRulesNum;
	
	/**
	 * 支持的事件类型规则列表，事件类型，详见dhnetsdk.h中"智能分析事件类型"
	 */
	public int[] dwRulesType = new int[NetSDKLib.MAX_RULE_LIST_SIZE];
	
	/**
	 * 支持的最大标尺个数
	 */
	public int nMaxStaffs;
		
	/**
	 * 折线最大顶点数
	 */
	public int nMaxPointOfLine;
	
	/**
	 * 区域最大顶点数
	 */
	public int nMaxPointOfRegion;
	
	/**
	 * 最大内部选项个数
	 */
	public int nMaxInternalOptions;
	
	/**
	 * 是否支持复杂尺寸过滤器复杂尺寸过滤器使用独立的面积过滤和宽高比过滤参数
	 */
	public byte bComplexSizeFilter;
	
	/**
	 * 是否支持特定的物体过滤器
	 */
	public byte bSpecifiedObjectFilter;
	
	/**
	 * 支持模块中的最大排除区域个数
	 */
	public int nMaxExcludeRegionNum;
		
	/**
	 * 支持的模块中的最大校准框个数
	 */
	public int nMaxCalibrateBoxNum;
	
	/**
	 * 模块中至少需要设置的校准框个数
	 */
	public int nMinCalibrateBoxNum;
	
	/**
	 * 模块中支持的最大特殊区域检测个数
	 */
	public int nMaxSepcialDetectRegions;
	
	/**
	 * 支持的每天的时间段个数
	 */
	public int nSupportedTimeSectionNum;
	
	/**
	 * 支持的特殊检测区属性个数
	 */
	public int nSpecialDetectPropertyNum;
	
	/**
	 * 支持的特殊检测区属性
	 */
	public int[] nSupportedSpecialDetectPropertys = new int[NetSDKLib.EM_SEPCIALREGION_PROPERTY_TYPE.EM_SEPCIALREGION_PROPERTY_TYPE_NUM];
	
	/**
	 * 支持的视频通道类型选择   第0位为1表示支持数字类型,第1位为1表示支持模拟类型,第2为1表示支持混合(数字和模拟)
	 */
	public int nSupportedVideoChannelType;
	
	/**
	 * 是否支持多场景切换
	 */
	public byte bSupportMultiSceneSwitch;
	
	/**
	 * 支持的场景能力集
	 */
	public CFG_VACAP_SUPPORTEDSCENES stSupportScenes;
	
	/**
	 * 支持的场景组合项个数
	 */
	public int nSupportedComp;
	
	/**
	 * 支持的场景组合项列表
	 */
	public CFG_SUPPORTED_COMP[] stuSupportedComp = (CFG_SUPPORTED_COMP[])new CFG_SUPPORTED_COMP().toArray(NetSDKLib.MAX_SUPPORTED_COMP_SIZE);
	
	/**
	 * 0 Module/Rule配置均要设置(默认，智能服务器), 1 仅Rule配置要设置(IPC/xVR)
	 */
	public byte byFilterMask;
	
	/**
	 * 摄像头安装角度显示方式,{ @link EM_DISPLAY_CAMERA_ANGLE_TYPE }
	 */
	public int emDisCameraAngleType;
	
	/**
	 * 实际返回客流量统计场景PD个数
	 */
	public int nMaxNumberStatMultNum;
	
	/**
	 * 实际返回客流量统计场景PD个数
	 */
	public CFG_NUMBERSTAT_MULT_INFO[] stuNumberStatMult = (CFG_NUMBERSTAT_MULT_INFO[])new CFG_NUMBERSTAT_MULT_INFO().toArray(NetSDKLib.MAX_NUMBER_STAT_MAULT_NUM);

	/**
	 * 全能力集，表示视频通道能力 full可以认为是不变的
	 */
	public VA_CAPS_INFO stuFullCaps;
	
	/**
	 * 动态能力集，表示当前视频通道能力
	 */
	public VA_DYNAMIC_CAPS_INFO stuDynamicCaps;
	
	public CFG_CAP_ANALYSE_INFO() {
		
		for (int i = 0; i < szSceneName.length; i++) {
			szSceneName[i] = new MaxNameByteArrInfo();
		}
		
		for (int i = 0; i < szObjectTypeName.length; i++) {
			szObjectTypeName[i] = new MaxNameByteArrInfo();
		}
		
		for (int i = 0; i < stuSupportedComp.length; i++) {
			stuSupportedComp[i] = new CFG_SUPPORTED_COMP();
		}
		
		for (int i = 0; i < stuNumberStatMult.length; i++) {
			stuNumberStatMult[i] = new CFG_NUMBERSTAT_MULT_INFO();
		}
	}	
	
}
