package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

import java.util.Arrays;

public class NET_ATTRIBUTE_INFO extends NetSDKLib.SdkStructure {
    /**
     *  点位名称
     */
    public byte[] szSignalName = new byte[128];

    /**
     *  单位
     */
    public byte[] szUnit = new byte[20];

    /**
     *  待查询的点位类型
     */
    public int emPointType;

    /**
     *  信号点ID
     */
    public byte[] szID = new byte[32];

    /**
     *  告警开始延时,单位:秒
     */
    public int nStartDelay;

    /**
     *  告警结束延时,单位:秒
     */
    public int nStopDelay;

    /**
     *  存储、上报周期,单位:秒
     */
    public int nPeriod;

    /**
     *  告警门限
     */
    public float fThreshold;

    /**
     *  告警回差(当告警恢复时需超过回差范围，告警才恢复，与告警延时不同时起效)
     */
    public float fAlarmWaveVal;

    /**
     *  绝对阈值(针对连续数据点（AI、AO）存储、上报)
     */
    public float fAbsoluteVal;

    /**
     *  百分比阈值(针对连续数据点（AI、AO）存储、上报，当绝对阈值不启用或者为"0"时使用)
     */
    public float fRelativeVal;

    /**
     *  信号点数据状态
     */
    public int emStatus;

    /**
     *  数据显示选项
     */
    public NET_DISPLAY_OPTIONS_INFO stuDisplayOptions;

    /**
     *  是否有效信号点 TRUE:有效 FALSE:无效
     */
    public int bIsValid;

    /**
     *  告警延时, 单位:秒
     */
    public int nDelay;

    /**
     *  点位信息描述
     */
    public byte[] szDescription = new byte[120];

    /**
     *  保留字节
     */
    public byte[] byReserved = new byte[136];

    @Override
    public String toString() {
        return "NET_ATTRIBUTE_INFO{" +
                "szSignalName=" + Arrays.toString(szSignalName) +
                ", szUnit=" + Arrays.toString(szUnit) +
                ", emPointType=" + emPointType +
                ", szID=" + Arrays.toString(szID) +
                ", nStartDelay=" + nStartDelay +
                ", nStopDelay=" + nStopDelay +
                ", nPeriod=" + nPeriod +
                ", fThreshold=" + fThreshold +
                ", fAlarmWaveVal=" + fAlarmWaveVal +
                ", fAbsoluteVal=" + fAbsoluteVal +
                ", fRelativeVal=" + fRelativeVal +
                ", emStatus=" + emStatus +
                ", stuDisplayOptions=" + stuDisplayOptions +
                ", bIsValid=" + bIsValid +
                ", nDelay=" + nDelay +
                ", szDescription=" + Arrays.toString(szDescription) +
                ", byReserved=" + Arrays.toString(byReserved) +
                '}';
    }
}
