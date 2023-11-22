package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

public class NET_HEALTH_CODE_INFO extends NetSDKLib.SdkStructure {
    /**
     * 身份证号
     */
    public byte[]							        szCitizenID=new byte[32];
    /**
     * 身份证姓名
     */
    public byte[]									szCitizenName=new byte[128];
    /**
     * 常驻地
     */
    public byte[]									szPermanentAddr=new byte[128];
    /**
     * 当前地址
     */
    public byte[]									szCurrentAddr=new byte[128];
    /**
     * 健康码状态,对应状态{@link EM_HEALTH_CODE_STATUS}
     */
    public int                                      emHealthCodeStatus;
    /**
     * 手机号
     */
    public byte[]									szPhoneNumber= new byte[32];
    /**
     * 异常原因
     */
    public byte[]									szAbnormalCodeReason=new byte[256];
    /**
     * 查询时间戳
     */
    public NET_TIME								    stuQueryTime;
    /**
     * 疫区经历(stuEpidemicAreaExperience)的个数
     */
    public int										nEpidemicAreaExperience;
    /**
     * 疫区经历
     */
    public NET_EPIDEMIC_AREA_EXPERIENCE[]			stuEpidemicAreaExperience=(NET_EPIDEMIC_AREA_EXPERIENCE[]) new NET_EPIDEMIC_AREA_EXPERIENCE().toArray(10);
    /**
     * 预留字段
     */
    public byte[]									byReserved=new byte[512];
}
