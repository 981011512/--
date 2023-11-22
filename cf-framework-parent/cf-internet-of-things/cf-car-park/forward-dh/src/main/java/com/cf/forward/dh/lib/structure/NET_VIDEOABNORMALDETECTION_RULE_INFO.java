package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;

/**
 * 事件类型EVENT_IVS_VIDEOABNORMALDETECTION(视频异常)对应的规则配置
 */
public class NET_VIDEOABNORMALDETECTION_RULE_INFO extends SdkStructure {
    /**
     * 检测类型数
     */
    public int                     nDetectType;
    /**
     * 检测类型,0-视频丢失, 1-视频遮挡, 2-画面冻结, 3-过亮, 4-过暗, 5-场景变化
     * 6-条纹检测 , 7-噪声检测 , 8-偏色检测 , 9-视频模糊检测 , 10-对比度异常检测
     * 11-视频运动 , 12-视频闪烁 , 13-视频颜色 , 14-虚焦检测 , 15-过曝检测, 16-场景巨变
     */
    public byte[]                  bDetectType=new byte[32];
    /**
     * 最短持续时间	单位：秒，0~65535
     */
    public int					    nMinDuration;
    /**
     * 灵敏度, 取值1-10，值越小灵敏度越低(只对检测类型视频遮挡，过亮，过暗，场景变化有效)
     */
     public int                     nSensitivity;
    /**
     * 异常检测阈值数量
     */
    public int					    nThresholdNum;
    /**
     * 异常检测阈值,范围1~100
     */
    public int[]					nThreshold=new int[32];
    /**
     * 保留字节
     */
    public byte[]				    byReserved=new byte[4096];
}
