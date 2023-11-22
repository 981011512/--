package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 关闭课程视频查询出参 {@link NetSDKLib#CLIENT_CloseQueryCourseMediaFile}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 19:06
 */
public class NET_OUT_QUERY_COURSEMEDIA_FILECLOSE extends NetSDKLib.SdkStructure {
    /**
     * 该结构体大小
     */
    public int dwSize;

    public NET_OUT_QUERY_COURSEMEDIA_FILECLOSE() {
        dwSize = this.size();
    }
}
