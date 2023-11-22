package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
/**
 * @author 251823
 * @description 场景能力
 * @date 2021/01/11
 */
public class CFG_CAP_SCENE extends NetSDKLib.SdkStructure{
	
	/**
	 * 场景名称
	 */
	public byte[] szSceneName = new byte[NetSDKLib.MAX_PATH];
	
	/**
	 * 当前规则类型支持的检测物体类型个数
	 */
	public int nSupportedObjectTypeNum;
	
	/**
	 * 当前规则类型支持的检测物体类型列表
	 */
	public MaxNameByteArrInfo[] szObjectTypeName = (MaxNameByteArrInfo[])new MaxNameByteArrInfo().toArray(NetSDKLib.MAX_OBJECT_LIST_SIZE);
	
	/**
	 * 支持的规则个数
	 */
	public int nSupportRules;
	
	/**
	 * 支持的规则列表
	 */
	public SCENE_SUPPORT_RULE[] stSpportRules = (SCENE_SUPPORT_RULE[])new SCENE_SUPPORT_RULE().toArray(NetSDKLib.MAX_RULE_LIST_SIZE);
	
	/**
	 * 是否支持扰动强度设置  
	 */
	public byte bDisturbance;
	
	/**
	 * 是否支持去扰动处理
	 */
	public byte bAntiDisturbance;
	
	/**
	 * 是否支持逆光处理
	 */
	public byte bBacklight;
	
	/**
     *  是否支持阴影处理
     */
    public byte bShadow;

    /**
     *  是否支持检测精度
     */
    public byte bAccuracy;

    /**
     *  是否支持检测步长
     */
    public byte bMovingStep;

    /**
     *  是否支持检测缩放
     */
    public byte bScalingFactor;

    /**
     *  是否支持Y分量判定阈值
     */
    public byte bThresholdY;

    /**
     *  是否支持UV分量判定阈值
     */
    public byte bThresholdUV;

    /**
     *  是否支持边缘检测判定阈值
     */
    public byte bThresholdEdge;

    /**
     *  是否支持检测平衡
     */
    public byte bDetectBalance;

    /**
     *  是否支持算法序号
     */
    public byte bAlgorithmIndex;

    /**
     *  是否支持高光处理，即Backgroud参数 
     */
    public byte bHighlight;

    /**
     *  是否支持物体抓图
     */
    public byte bSnapshot;

    /**
     *  是否支持检测区域配置
     */
    public byte bDetectRegion;

    /**
     *  是否支持排除区域配置
     */
    public byte bExcludeRegion;

    /**
     *  是否支持轮廓辅助跟踪
     */
    public byte bContourAssistantTrack;

    /**
     *  是否摄像头位置参数
     */
    public byte bCameraAspect;

    /**
     *  是否支持抖动参数
     */
    public byte bJitter;

    /**
     *  是否支持去抖动处理参数
     */
    public byte bDejitter;

    /**
     *  最大标定区域个数
     */
    public int nMaxCalibrateAreaNum;

    /**
     *  标定区域能力信息个数
     */
    public int nCalibrateAreaNum;

    /**
     *  标定区域能力信息
     */
    public CFG_CAP_CELIBRATE_AREA[] stCalibrateAreaCap = (CFG_CAP_CELIBRATE_AREA[])new CFG_CAP_CELIBRATE_AREA().toArray(NetSDKLib.MAX_CALIBRATEAREA_TYPE_NUM);

    /**
     *  是否支持像素计量方式
     */
    public byte bPixel;

    /**
     *  是否支持实际长度计量方式
     */
    public byte bMetric;

    /**
     *  是否支持远端近端标定后的像素计量方式
     */
    public byte bCalibratedPixel;

    /**
     *  当前场景下支持的子场景类型
     */
    public MaxSceneSupTypeByteArrInfo[] szSubType = (MaxSceneSupTypeByteArrInfo[])new MaxSceneSupTypeByteArrInfo().toArray(NetSDKLib.MAX_SCENE_SUBTYPE_NUM);

    /**
     *  子场景类型个数
     */
    public int nSubTypeNum;

    /**
     *  每个大类支持的最大规则条数
     */
    public int nMaxRules;

    /**
     *  是否支持重建背景，默认不支持(false)
     */
    public int bSupportedSetModule;

    /**
     *  是否支持打架标定配置,默认FALSE
     */
    public int bSupportFightCalibrate;

    /**
     *  车辆种类划分类型个数
     */
    public int nVehicleTypeSplitNum;

    /**
     *  车辆种类划分类型 { @link EM_VEHICLE_TYPE_SPLIT }
     */
    public int[] emVehicleTypeSplit = new int[16];

    /**
     *  是否支持隐私保护, false-不支持(默认);true-支持
     */
    public int bPrivacyMaskSupport;

    /**
     *  隐私保护的物体类型的数量
     */
    public int nPrivacyMaskCount;

    /**
     *  隐私保护的物体类型 { @link EM_PRIVACY_MASK_TYPE }
     */
    public int[] emPrivacyMaskTypes = new int[32];

    /**
     *  大类业务方案别名
     */
    public byte[] szClassAlias = new byte[16];

    /**
     *  人群分布图的标定线段相关能力 
     */
   public CROWD_CALIBRATION stuCalibration;

    /**
     *  人体测温场景能力
     */
   public CFG_ANATOMYTEMP_DETECT_SCENE_CAPS stuAnatomyTempDetect;

    /**
     *  立体行为分析场景能力
     */
   public CFG_STEREO_BEHAVIOR_SCENE_CAPS stuStereoBehaviorCaps;

    /**
     *  保留字节
     */
    public byte[] byReserved = new byte[1024];		
	

	public CFG_CAP_SCENE() {
		for (int i = 0; i < szObjectTypeName.length; i++) {
			szObjectTypeName[i] = new MaxNameByteArrInfo();
		}
		for (int i = 0; i < stSpportRules.length; i++) {
			stSpportRules[i] = new SCENE_SUPPORT_RULE();
		}
		for (int i = 0; i < stCalibrateAreaCap.length; i++) {
			stCalibrateAreaCap[i] = new CFG_CAP_CELIBRATE_AREA();
		}
		
		for (int i = 0; i < szSubType.length; i++) {
			szSubType[i] = new MaxSceneSupTypeByteArrInfo();
		}
	}
	
}
