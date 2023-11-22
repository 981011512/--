package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author 47081
 * @version 1.0
 * @description 广告禁用时段配置信息
 * @date 2020/9/10
 */
public class NET_CFG_FORBIDDEN_ADVERT_PLAY_INFO extends NetSDKLib.SdkStructure {
    /**
     * 时间段使能
     */
    public boolean bEnable;
    /**
     * 广告禁用开始时间
     */
    public NET_TIME_EX1 stuBeginTime;
    /**
     * 广告结束开始时间
     */
    public NET_TIME_EX1 stuEndTime;
    /**
     * 保留字节
     */
    public byte[] reserved = new byte[256];

    @Override
    public String toString() {
        return "NET_CFG_FORBIDDEN_ADVERT_PLAY_INFO{" +
                "bEnable=" + bEnable +
                ", stuBeginTime=" + stuBeginTime.toTime() +
                ", stuEndTime=" + stuEndTime.toTime() +
                '}';
    }
}
