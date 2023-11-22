package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 开始查询课程 入参 {@link NetSDKLib#CLIENT_QueryCourseOpen}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/17 20:47
 */
public class NET_IN_QUERY_COURSE_OPEN extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
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

    public NET_IN_QUERY_COURSE_OPEN() {
        dwSize = this.size();
    }
}
