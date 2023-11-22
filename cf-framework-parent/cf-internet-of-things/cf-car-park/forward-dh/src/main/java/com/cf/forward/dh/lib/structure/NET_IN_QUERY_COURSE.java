package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 查询课程 入参 {@link NetSDKLib#CLIENT_QueryCourse}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/17 21:08
 */
public class NET_IN_QUERY_COURSE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 查询句柄号
     */
    public int nFindID;
    /**
     * 开始查询偏移
     */
    public int nOffset;
    /**
     * 需要查询的个数
     */
    public int nCount;

    public NET_IN_QUERY_COURSE() {
        dwSize = this.size();
    }
}
