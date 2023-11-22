package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 251823
 * @description 人脸检测信息
 * @date 2021/02/22
 */
public class MEDIAFILE_ANATOMY_TEMP_DETECT_FACEDETECT_RESULT extends NetSDKLib.SdkStructure{
	 /**
     *  性别,参考枚举{@link NetSDKLib.EM_SEX_TYPE }
     */
    public int emSex;

    /**
     *  年龄
     */
    public int nAge;

    /**
     *  人脸表情,参考枚举{@link NetSDKLib.EM_DEV_EVENT_FACEDETECT_FEATURE_TYPE }
     */
    public int emEmotion;

    /**
     *  肤色类型,参考枚举{@link NetSDKLib.EM_RACE_TYPE }
     */
    public int emRace;

    /**
     *  眼睛状态,参考枚举{@link NetSDKLib.EM_EYE_STATE_TYPE }
     */
    public int emEye;

    /**
     *  嘴巴状态,参考枚举{@link NetSDKLib.EM_MOUTH_STATE_TYPE }
     */
    public int emMouth;

    /**
     *  口罩状态,参考枚举{@link NetSDKLib.EM_MASK_STATE_TYPE }
     */
    public int emMask;

    /**
     *  胡子状态,参考枚举{@link NetSDKLib.EM_BEARD_STATE_TYPE }
     */
    public int emBeard;

    /**
     *  魅力值, -1表示无效, 0未识别，识别时范围1-100,得分高魅力高
     */
    public int nAttractive;

    /**
     *  民族
     */
    public int nNation;

    /**
     *  眼镜类型,参考枚举{@link NetSDKLib.EM_FACEDETECT_GLASSES_TYPE } 
     */
    public int emGlasses;

    /**
     *  预留字段
     */
    public byte[] byReserved = new byte[1020];
	
}
