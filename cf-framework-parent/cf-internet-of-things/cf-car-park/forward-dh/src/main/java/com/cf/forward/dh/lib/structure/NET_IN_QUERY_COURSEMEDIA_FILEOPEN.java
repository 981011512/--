package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_COURSE_LOCK_TYPE;
import com.cf.forward.dh.lib.enumeration.EM_COURSE_RECORD_TYPE;

import static com.cf.forward.dh.lib.NetSDKLib.NET_COMMON_STRING_128;

/**
 * 开始查询课程视频信息入参 {@link NetSDKLib#CLIENT_OpenQueryCourseMediaFile}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 16:24
 */
public class NET_IN_QUERY_COURSEMEDIA_FILEOPEN extends NetSDKLib.SdkStructure {

    /**
     * 该结构体大小
     */
    public int dwSize;
    /**
     * 查询开始时间
     */
    public NET_TIME stuStartTime;
    /**
     * 查询结束时间
     */
    public NET_TIME stuEndTime;
    /**
     * 查询关键字
     */
    public byte[] szKeyWord = new byte[NET_COMMON_STRING_128];
    /**
     * 查询课程锁定类型 {@link EM_COURSE_LOCK_TYPE}
     */
    public int emCourseLockType;
    /**
     * 查询课程录像类型 {@link EM_COURSE_RECORD_TYPE}
     */
    public int emCourseRecordType;

    public NET_IN_QUERY_COURSEMEDIA_FILEOPEN() {
        dwSize = this.size();
    }
}
