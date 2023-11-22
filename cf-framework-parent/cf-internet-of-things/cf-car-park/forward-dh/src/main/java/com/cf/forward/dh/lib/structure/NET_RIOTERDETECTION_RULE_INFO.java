package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;

/**
 * 事件类型 EVENT_IVS_RIOTERDETECTION (人群聚集) 对应的规则配置
 */
public class NET_RIOTERDETECTION_RULE_INFO extends SdkStructure {
    /**
     * 检测区域顶点数
     */
    public  int					nDetectRegionPoint;
    /**
     * 检测区域
     */
    public  POINTCOORDINATE[]   stuDetectRegion=(POINTCOORDINATE[]) new POINTCOORDINATE().toArray(20);
    /**
     * 检测模式个数
     */
    public int                  nModeNum;
    /**
     * 支持的检测模式,实际只能选一种0:表示"MiniArea"按最小聚集区域检测,1:表示"Humans"按聚集人员数量阈值
     */
    public  byte[]              nModeList=new byte[64];
    /**
     * 最小聚集区域矩形框，分别对应矩形框的左上和右下点，矩形框的实际面积表示触发报警的最小人群聚集面积
     */
    public  POINTCOORDINATE[]   stuMinDetectRect=(POINTCOORDINATE[]) new POINTCOORDINATE().toArray(2);
    /**
     * 聚集人数阈值,聚集人数超过此值,开始报警,0表示不报警
     */
    public  int					nRioterThreshold;
    /**
     * 最短持续时间,单位:秒 1-600,默认值30
     */
    public  int					nMinDuration;
    /**
     * 报告时间间隔,单位秒,0-600;等于0表示不重复报警,默认值30
     */
    public  int                 nReportInterval;
    /**
     * 灵敏度,取值1-10,值越小灵敏度越低,对应人群的密集程度越高
     */
    public  int                 nSensitivity;
    /**
     * 跟踪持续时间,0秒：一直跟踪,1-300秒:跟踪持续时间
     */
    public  int					nTrackDuration;
    /**
     * 保留字节
     */
    public  byte[]				byReserved=new byte[4096];
}
