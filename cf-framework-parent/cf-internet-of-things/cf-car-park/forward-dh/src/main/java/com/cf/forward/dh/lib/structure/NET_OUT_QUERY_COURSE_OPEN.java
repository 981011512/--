package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 开始查询课程 出参 {@link NetSDKLib#CLIENT_QueryCourseOpen}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/17 20:47
 */
public class NET_OUT_QUERY_COURSE_OPEN extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 查询到的总个数
     */
    public int nTotalNum;
    /**
     * 查询的句柄号
     */
    public int nFindID;

    public NET_OUT_QUERY_COURSE_OPEN() {
        dwSize = this.size();
    }
}
