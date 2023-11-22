package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 查询课程视频信息出参 {@link NetSDKLib#CLIENT_DoQueryCourseMediaFile}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 16:49
 */
public class NET_OUT_QUERY_COURSEMEDIA_FILE extends NetSDKLib.SdkStructure {
    /**
     * 该结构体大小
     */
    public int dwSize;
    /**
     * 查询到的个数
     */
    public int nCountResult;
    /**
     * 视频信息
     */
    public NET_COURSEMEDIA_FILE_INFO[] stuCourseMediaFile = new NET_COURSEMEDIA_FILE_INFO[64];

    public NET_OUT_QUERY_COURSEMEDIA_FILE() {
        dwSize = this.size();
        for (int i = 0; i < stuCourseMediaFile.length; i++) {
            stuCourseMediaFile[i] = new NET_COURSEMEDIA_FILE_INFO();
        }
    }

    @Override
    public int fieldOffset(String name) {
        return super.fieldOffset(name);
    }
}
