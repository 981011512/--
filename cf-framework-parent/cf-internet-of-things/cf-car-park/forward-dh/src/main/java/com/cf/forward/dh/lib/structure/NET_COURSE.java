package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_CAN_START_STREAM;
import com.cf.forward.dh.lib.enumeration.EM_COURSE_STATE;
import com.cf.forward.dh.lib.enumeration.EM_IS_RECORD;

import static com.cf.forward.dh.lib.NetSDKLib.NET_COMMON_STRING_128;
import static com.cf.forward.dh.lib.NetSDKLib.NET_COMMON_STRING_64;

/**
 * 课程信息
 *
 * @author ： 47040
 * @since ： Created in 2020/9/17 15:46
 */
public class NET_COURSE extends NetSDKLib.SdkStructure {
    /**
     * 开始时间
     */
    public NET_TIME stuStartTime;
    /**
     * 结束时间
     */
    public NET_TIME stuEndTime;
    /**
     * 课程名称
     */
    public byte[] szCourseName = new byte[NET_COMMON_STRING_64];
    /**
     * 教师姓名
     */
    public byte[] szTeacherName = new byte[NET_COMMON_STRING_64];
    /**
     * 课程简介
     */
    public byte[] szIntroduction = new byte[NET_COMMON_STRING_128];
    /**
     * 能否被拉流逻辑通道数
     */
    public int nCanStartStreamNum;
    /**
     * 是否要录像逻辑通道号数
     */
    public int nIsRecordNum;
    /**
     * 能否被拉流 {@link EM_CAN_START_STREAM}
     */
    public int[] emCanStartStream = new int[64];
    /**
     * 是否要录像 {@link EM_IS_RECORD}
     */
    public int[] emIsRecord = new int[64];
    /**
     * 组合通道模式; 0: 无效, 1: 电影模式, 2: 常态模式, 3: 精品模式, <0:自定义模式
     */
    public int nCompositeChannelMode;
    /**
     * 课程状态 {@link EM_COURSE_STATE}
     */
    public int emCourseState;
    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[128];
}
