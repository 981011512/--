package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 时间段结构
 * @date 2020/10/19
 */
public class SDK_TSECT extends NetSDKLib.SdkStructure {
    /**
     * 当表示录像时间段时,按位表示四个使能,从低位到高位分别表示动检录象、报警录象、普通录象、动检和报警同时发生才录像
     * 当表示布撤防时间段时, 表示使能
     * 当表示推送时间段时, 表示使能：1表示使能，0表示非使能
     */
    public int bEnable;
    public int iBeginHour;
    public int iBeginMin;
    public int iBeginSec;
    public int iEndHour;
    public int iEndMin;
    public int iEndSec;

    /*
     * 设置时间
     */
    public void setTime(int bEnable, int beginHour, int beginMinute, int beginSecond, int endHour, int endMinute, int endSecond) {
        this.bEnable = bEnable;
        this.iBeginHour = beginHour;
        this.iBeginMin = beginMinute;
        this.iBeginSec = beginSecond;
        this.iEndHour = endHour;
        this.iEndMin = endMinute;
        this.iEndSec = endSecond;
    }

    @Override
    public String toString() {
        return String.format("enable:%d,%02d:%02d:%02d-%02d:%02d:%02d", bEnable, iBeginHour, iBeginMin, iBeginSec, iEndHour, iEndMin, iEndSec);
    }
}
