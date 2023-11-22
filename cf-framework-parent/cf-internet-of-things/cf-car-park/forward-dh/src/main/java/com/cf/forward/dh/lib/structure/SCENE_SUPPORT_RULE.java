package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 场景支持的规则
 * @date 2021/01/11
 */
public class SCENE_SUPPORT_RULE extends NetSDKLib.SdkStructure {

	/**
	 * 规则类型
	 */
	public int dwSupportedRule;

	/**
	 * 支持的检测物体类型个数
	 */
	public int nSupportedObjectTypeNum;

	/**
	 * 支持的检测物体类型列表
	 */
	public MaxNameByteArrInfo[] szObjectTypeName = (MaxNameByteArrInfo[]) new MaxNameByteArrInfo()
			.toArray(NetSDKLib.MAX_OBJECT_LIST_SIZE);

	/**
	 * 支持的检测物体动作个数
	 */
	public int nSupportedActionsNum;

	/**
	 * 支持的检测物体动作列表
	 */
	public MaxNameByteArrInfo[] szSupportedActions = (MaxNameByteArrInfo[]) new MaxNameByteArrInfo()
			.toArray(NetSDKLib.MAX_ACTION_LIST_SIZE);

	/**
	 * 支持的检测类型个数
	 */
	public int nSupportedDetectTypeNum;

	/**
	 * 支持的检测类型列表
	 */
	public MaxNameByteArrInfo[] szSupportedDetectTypes = (MaxNameByteArrInfo[]) new MaxNameByteArrInfo()
			.toArray(NetSDKLib.MAX_ACTION_LIST_SIZE);

	/**
	 * 支持的人脸检测类型个数
	 */
	public int nSupportFaceTypeNum;

	/**
	 * 支持的人脸检测类型列表
	 */
	public MaxNameByteArrInfo[] szSupportFaceTypes = (MaxNameByteArrInfo[]) new MaxNameByteArrInfo()
			.toArray(NetSDKLib.MAX_HUMANFACE_LIST_SIZE);

	/**
	 * 是否支持触发报警位置
	 */
	public int bTriggerPosition;

	/**
	 * 是否支持触发跟踪
	 */
	public int bTriggerTrack;

	/**
	 * 是否允许配置开启人脸属性识别
	 */
	public int bFaceDetection;

	/**
	 * 支持的人脸属性类型个数
	 */
	public int nSupportFeactureNum;

	/**
	 * 支持的人脸属性类型列表 参考EM_FACEFEATURE_TYPE
	 */
	public int[] emFeatureList = new int[NetSDKLib.MAX_FEATURE_LIST_SIZE];

	/**
	 * 支持规则的最大个数
	 */
	public int nMaxRules;

	/**
	 * 人体检测能力（定制）
	 */
	public FACEBODY_DETECT_CAPS stuFaceBodyDetectCaps;

	/**
	 * 人体识别能力（定制）
	 */
	public FACEBODY_ANALYSE_CAPS stuFaceBodyAnalyseCaps;

	/**
	 * 是否允许配置FeatureEnable,0-不支持(默认)1-支持(用于绊线检测事件和警戒区域检测事件)
	 */
	public int nFeatureSupport;

	/**
	 * 人员聚集检测是否支持"最小聚集区域"配置,默认TRUE
	 */
	public int bSupportMinRegion;

	/**
	 * 支持的联动特写情况。 0:表示没这个字段或者不支持，1表示支持
	 */
	public int nSupportCloseUp;

	/**
	 * 特写模式个数
	 */
	public int nSupportCloseUpTypeNum;

	/**
	 * 可选择特写模式, 参考{ @link EM_SUPPORT_CLOSE_UP_TYPE}
	 */
	public int[] emSupportCloseUpType = new int[32];

	/**
	 * 睿厨着装检特征列表,参考 { @link EM_FEATURE_LIST_TYPE}
	 */
	public int[] emFeature = new int[32];

	/**
	 * 检测到的特征个数
	 */
	public int nDetectFeatureCount;

	/**
	 * 检测到的厨师服装颜色列表,参考 { @link EM_SUPPORTED_COLOR_LIST_TYPE}
	 */
	public int[] emSupportedColorList = new int[8];

	/**
	 * 检测到的厨师服装颜色个数
	 */
	public int nDetectSupportedColorCount;

	/**
	 * 人群分布图是否支持多边形，TRUE:表示支持任意边形;FALSE:表示没有这个能力表示或者只支持4个点的平行四边形
	 */
	public int bSupportPolygon;

	/**
	 * 活跃度统计规则
	 */
	public CFG_ACTIVITY_ANALYSE_CAPS stuActivityAnalyseCaps;

	/**
	 * 联动业务个数
	 */
	public int nLink;

	/**
	 * 联动业务大类选项
	 */
	public CFG_LINK_CLASS_TYPE[] stuLinkClassType = (CFG_LINK_CLASS_TYPE[]) new CFG_LINK_CLASS_TYPE().toArray(16);

	public SCENE_SUPPORT_RULE() {

		for (int i = 0; i < szObjectTypeName.length; i++) {
			szObjectTypeName[i] = new MaxNameByteArrInfo();
		}
		for (int i = 0; i < szSupportedActions.length; i++) {
			szSupportedActions[i] = new MaxNameByteArrInfo();
		}
		for (int i = 0; i < szSupportedDetectTypes.length; i++) {
			szSupportedDetectTypes[i] = new MaxNameByteArrInfo();
		}
		for (int i = 0; i < szSupportFaceTypes.length; i++) {
			szSupportFaceTypes[i] = new MaxNameByteArrInfo();
		}
		for (int i = 0; i < stuLinkClassType.length; i++) {
			stuLinkClassType[i] = new CFG_LINK_CLASS_TYPE();
		}

	}

}
