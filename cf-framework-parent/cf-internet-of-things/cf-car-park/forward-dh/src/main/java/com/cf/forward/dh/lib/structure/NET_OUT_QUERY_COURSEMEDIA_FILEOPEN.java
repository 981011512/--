package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 开始查询课程视频信息出参 {@link NetSDKLib#CLIENT_OpenQueryCourseMediaFile}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 16:35
 */
public class NET_OUT_QUERY_COURSEMEDIA_FILEOPEN extends NetSDKLib.SdkStructure {
    /**
     * 该结构体大小
     */
    public int dwSize;
    /**
     * 查询到的总个数
     */
    public int ntotalNum;
    /**
     * 查询ID号
     */
    public int nfindID;

    public NET_OUT_QUERY_COURSEMEDIA_FILEOPEN() {
        dwSize = this.size();
    }
}
