package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

public class NET_IDCARD_INFO extends NetSDKLib.SdkStructure {
    /**
     * 身份证消息类型,请参考EM_IDCARD_MSG_TYPE
     */
    public  int emIDCardMsgType;
    // EM_IDCARD_MSG_TYP_QUERY：除 nEventGroupID 和 szRoomNo （在上一层）字段不用填，其余必填
    // EM_IDCARD_MSG_TYPE_ISSUE_PERMISSION：nEventGroupID 、szRoomNo（在上一层）及 szCitizenName 字段必填，其余可为空
    /**
     * 姓名
     */
    public byte[]								szCitizenName=new byte[32];
    /**
     * 性别,请参考EM_CITIZENIDCARD_SEX_TYPE
     */
    public  int emSexType;
    /**
     * 民族
     * 0 无效数据
     * 1 汉族
     * 2 蒙古族
     * 3 回族
     * 4 藏族
     * 5 维吾尔族
     * 6 苗族
     * 7 彝族
     * 8 壮族
     * 9 布依族
     * 10 朝鲜族
     * 11 满族
     * 12 侗族
     * 13 瑶族
     * 14 白族
     * 15 土家族
     * 16 哈尼族
     * 17 哈萨克族
     * 18 傣族
     * 19 黎族
     * 20 傈僳族
     * 21 佤族
     * 22 畲族
     * 23 高山族
     * 24 拉祜族
     * 25 水族
     * 26 东乡族
     * 27 纳西族
     * 28 景颇族
     * 29 柯尔克孜族
     * 30 土族
     * 31 达斡尔族
     * 32 仫佬族
     * 33 羌族
     * 34 布朗族
     * 35 撒拉族
     * 36 毛南族
     * 37 仡佬族
     * 38 锡伯族
     * 39 阿昌族
     * 40 普米族
     * 41 塔吉克族
     * 42 怒族
     * 43 乌孜别克族
     * 44 俄罗斯族
     * 45 鄂温克族
     * 46 德昂族
     * 47 保安族
     * 48 裕固族
     * 49 京族
     * 50 塔塔尔族
     * 51 独龙族
     * 52 鄂伦春族
     * 53 赫哲族
     * 54 门巴族
     * 55 珞巴族
     * 56 基诺族
     */
    public int									nRace;
    /**
     * 生日(年月日有效)
     */
    public NET_TIME                             stuBirthday;
    /**
     * 地址
     */
    public byte[]								szAddress=new byte[128];
    /**
     * 身份证号
     */
    public byte[]								szCitizenID=new byte[32];
    /**
     * 签发机关
     */
    public byte[]								szAuthority=new byte[48];
    /**
     * 有效期限起始日期(年月日有效)
     */
    public NET_TIME                             stuBeginValidTime;
    /**
     * 有效期限截止日期(年月日有效)
     */
    public NET_TIME                             stuEndValidTime;
    /**
     * 事件组ID,用于标示不同事件的对同一动作的关联
     */
    public int									nEventGroupID;
    /**
     * 预留字段
     */
    public byte[]								byReserved=new byte[1024];
}
