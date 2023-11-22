package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 查询课程 入参 {@link NetSDKLib#CLIENT_QueryCourse}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/17 21:12
 */
public class NET_OUT_QUERY_COURSE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 查找到的个数
     */
    public int nCountResult;
    /**
     * 查询的课程信息结果
     */
    public NET_COURSE_RESULT[] stuCourseResult = new NET_COURSE_RESULT[64];

    public NET_OUT_QUERY_COURSE() {
        dwSize = this.size();
        for (int i = 0; i < stuCourseResult.length; i++) {
            stuCourseResult[i] = new NET_COURSE_RESULT();
        }
    }
}
