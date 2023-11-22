package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 查询课程视频信息入参 {@link NetSDKLib#CLIENT_DoQueryCourseMediaFile}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 16:40
 */
public class NET_IN_QUERY_COURSEMEDIA_FILE extends NetSDKLib.SdkStructure {
    /**
     * 该结构体大小
     */
    public int dwSize;
    /**
     * 查询ID号
     */
    public int nfindID;
    /**
     * 开始查询偏移
     */
    public int nOffset;
    /**
     * 需要查询的个数
     */
    public int nCount;

    public NET_IN_QUERY_COURSEMEDIA_FILE() {
        dwSize = this.size();
    }
}
