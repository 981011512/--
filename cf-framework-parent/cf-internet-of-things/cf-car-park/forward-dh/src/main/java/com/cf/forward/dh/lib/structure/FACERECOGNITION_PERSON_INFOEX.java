package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.*;

/**
 * className：FACERECOGNITION_PERSON_INFOEX
 * description： 人员信息扩展结构体
 * author：251589
 * createTime：2020/12/28 10:47
 *
 * @version v1.0
 */
public class FACERECOGNITION_PERSON_INFOEX extends NetSDKLib.SdkStructure {
    public byte[]    szPersonName = new byte[NET_MAX_PERSON_NAME_LEN];    // 姓名
    public short    wYear;    // 出生年,作为查询条件时,此参数填0,则表示此参数无效
    public byte    byMonth;    // 出生月,作为查询条件时,此参数填0,则表示此参数无效
    public byte    byDay;    // 出生日,作为查询条件时,此参数填0,则表示此参数无效
    public byte    bImportantRank;    // 人员重要等级,1~10,数值越高越重要,作为查询条件时,此参数填0,则表示此参数无效
    public byte    bySex;    // 性别,1-男,2-女,作为查询条件时,此参数填0,则表示此参数无效
    public byte[]    szID = new byte[NET_MAX_PERSON_ID_LEN];    // 人员唯一标示(身份证号码,工号,或其他编号)
    public short    wFacePicNum;    // 图片张数
    public Net_PIC_INFO[]    szFacePicInfo = new Net_PIC_INFO[NET_MAX_PERSON_IMAGE_NUM];    // 当前人员对应的图片信息
    public byte    byType;    // 人员类型,详见 EM_PERSON_TYPE
    public byte    byIDType;    // 证件类型,详见 EM_CERTIFICATE_TYPE
    public byte    byGlasses;    // 是否戴眼镜，0-未知 1-不戴 2-戴
    public byte    byAge;    // 年龄,0表示未知
    public byte[]    szProvince = new byte[NET_MAX_PROVINCE_NAME_LEN];    // 省份
    public byte[]    szCity = new byte[NET_MAX_CITY_NAME_LEN];    // 城市
    public byte[]    szUID = new byte[NET_MAX_PERSON_ID_LEN];    // 人员唯一标识符,首次由服务端生成,区别于ID字段
    public byte[]    szCountry = new byte[NET_COUNTRY_LENGTH];    // 国籍,符合ISO3166规范
    public byte    byIsCustomType;    // 人员类型是否为自定义: 0 使用Type规定的类型 1 自定义,使用szCustomType字段
    public byte[]    szCustomType = new byte[NET_COMMON_STRING_16];    // 人员自定义类型
    public byte[]    szComment = new byte[NET_COMMENT_LENGTH];    // 备注信息
    public byte[]    szGroupID = new byte[NET_GROUPID_LENGTH];    // 人员所属组ID
    public byte[]    szGroupName = new byte[NET_GROUPNAME_LENGTH];    // 人员所属组名, 用户自己申请内存的情况时,
    public int    emEmotion;    // 表情
    public byte[]    szHomeAddress = new byte[NET_COMMON_STRING_128];    // 注册人员家庭地址
    public int    emGlassesType;    // 眼镜类型
    public int    emRace;
    public int    emEye;    // 眼睛状态
    public int    emMouth;    // 嘴巴状态
    public int    emMask;    // 口罩状态
    public int    emBeard;    // 胡子状态
    public int    nAttractive;    // 魅力值, -1表示无效, 0未识别，识别时范围1-100,得分高魅力高
    public int    emFeatureState;    // 人员建模状态
    public int    bAgeEnable;    // 是否指定年龄段
    public int[]    nAgeRange = new int[2];    // 年龄范围
    public int    nEmotionValidNum;    // 人脸特征数组有效个数,与 emFeature 结合使用, 如果为0则表示查询所有表情
    public int[]    emEmotions = new int[NET_MAX_FACEDETECT_FEATURE_NUM];    // 人脸特征数组,与 byFeatureValidNum 结合使用 设置查询条件的时候使用
    public int    nCustomPersonInfoNum;    // 注册人员信息扩展个数
    public CUSTOM_PERSON_INFO[]    szCustomPersonInfo = new CUSTOM_PERSON_INFO[NET_MAX_CUSTOM_PERSON_INFO_NUM];    //注册人员信息扩展
    public int    emRegisterDbType;    // 注册库类型
    public NET_TIME    stuEffectiveTime;    // 有效期时间
    public int    emFeatureErrCode;    // 建模失败原因
    public int    wFacePicNumEx;    // 人脸图片张数
    public NET_FACE_PIC_INFO[]    szFacePicInfoEx = new NET_FACE_PIC_INFO[6];    // 当前人员对应的图片信息
    public NET_PERSON_FEATURE_VALUE_INFO    stuPersonFeatureValue;    // 人员特征信息
    public byte[]    byReserved = new byte[396];    // 保留字节
}
