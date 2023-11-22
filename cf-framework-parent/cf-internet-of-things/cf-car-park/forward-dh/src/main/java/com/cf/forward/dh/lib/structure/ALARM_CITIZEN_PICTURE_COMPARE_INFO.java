package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import static com.cf.forward.dh.lib.NetSDKLib.*;

/**
 * 普通报警事件 -> 人证比对事件
 *
 * @author ： 47040
 * @since ： Created in 2020/8/27 10:58
 */
public class ALARM_CITIZEN_PICTURE_COMPARE_INFO extends NetSDKLib.SdkStructure {

    /**
     * 通道号
     */
    public int nChannelID;
    /**
     * 事件ID
     */
    public int nEventID;
    /**
     * 事件发生的时间
     */
    public NET_TIME_EX stuTime;
    /**
     * 人证比对结果,相似度大于等于阈值认为比对成功,1 表示成功,0 表示失败
     */
    public int bCompareResult;
    /**
     * 两张图片的相似度,单位百分比,范围[1,100]
     */
    public byte nSimilarity;
    /**
     * 检测阈值,范围[1,100]
     */
    public byte nThreshold;
    /**
     * 字节对齐
     */
    public byte[] byReserved1 = new byte[2];
    /**
     * 性别 {@link EM_CITIZENIDCARD_SEX_TYPE}
     */
    public int emSex;
    /**
     * 民族(参照DEV_EVENT_ALARM_CITIZENIDCARD_INFO的 nEthnicity 定义)
     */
    public int nEthnicity;
    /**
     * 居民姓名
     */
    public byte[] szCitizen = new byte[NET_COMMON_STRING_64];
    /**
     * 住址
     */
    public byte[] szAddress = new byte[NET_COMMON_STRING_256];
    /**
     * 身份证号
     */
    public byte[] szNumber = new byte[NET_COMMON_STRING_64];
    /**
     * 签发机关
     */
    public byte[] szAuthority = new byte[NET_COMMON_STRING_256];
    /**
     * 出生日期(年月日)
     */
    public NET_TIME stuBirth;
    /**
     * 有效期限起始日期(年月日)
     */
    public NET_TIME stuValidityStart;
    /**
     * 该值为 1, 表示长期有效,此时 stuValidityEnd 值无意义
     * 该值为 0, 此时 截止日期 查看 stuValidityEnd 的值
     */
    public int bLongTimeValidFlag;
    /**
     * 有效期限结束日期(年月日) bLongTimeValidFlag 为 0 时有效
     */
    public NET_TIME stuValidityEnd;
    /**
     * IC卡号
     */
    public byte[] szCardNo = new byte[NET_COMMON_STRING_32];
    /**
     * 手机号（比对时先输入手机号）
     */
    public byte[] szCellPhone = new byte[NET_COMMON_STRING_32];
    /**
     * 事件类型：0：人证比对结果	1：人证人脸采集
     */
    public int nEventType;
    /**
     * 人证人脸采集时人员ID（定制）
     */
    public byte[] szUserID = new byte[32];
    /**
     * 人脸序号
     */
    public int nFaceIndex;
    /**
     * 口罩状态 {@link EM_MASK_STATE_TYPE}
     */
    public int emMask;
    /**
     * 人脸质量评分
     */
    public int nScore;

    /**
     *  物理身份证号（身份证序列号）
     */
    public byte[] szIDPhysicalNumber = new byte[20];

    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[956];
}
