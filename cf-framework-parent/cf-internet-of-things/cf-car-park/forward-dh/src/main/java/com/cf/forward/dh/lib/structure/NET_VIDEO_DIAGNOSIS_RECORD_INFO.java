package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_SOURCE_VIDEO_LOCATION;
import com.cf.forward.dh.lib.enumeration.EM_VIDEO_TYPE;

/**
 * @author 47081
 * @version 1.0
 * @description 视频诊断录像详细信息
 * @date 2021/2/22
 */
public class NET_VIDEO_DIAGNOSIS_RECORD_INFO extends NetSDKLib.SdkStructure {
    /**
     * 录像保存的位置,对应枚举{@link EM_SOURCE_VIDEO_LOCATION}
     */
    public int    emSourceLocation;
    /**
     * 视频诊断录像类型,对应枚举{@link EM_VIDEO_TYPE}
     */
    public int               emRecordType;
    /**
     * 视频诊断录像开始时间
     */
    public NetSDKLib.CFG_NET_TIME stuStartTime;
    /**
     * 视频诊断录像开始时间为当前实际检测时间的前PreSeconds秒（当该字段与StartTime同时存在时，以该字段优先）
     */
    public int                         nPreSeconds;
}
