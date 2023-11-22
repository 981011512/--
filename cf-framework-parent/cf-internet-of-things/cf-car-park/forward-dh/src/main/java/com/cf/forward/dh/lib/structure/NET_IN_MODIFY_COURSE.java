package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 修改课程记录 入参指针 {@link NetSDKLib#CLIENT_ModifyCourse}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/17 16:37
 */
public class NET_IN_MODIFY_COURSE extends NetSDKLib.SdkStructure {

    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 课程数量
     */
    public int nCourseNum;
    /**
     * 课程信息
     */
    public NET_COURSE[] stuCourseInfo = new NET_COURSE[64];
    /**
     * 课程ID
     */
    public int[] nId = new int[64];

    public NET_IN_MODIFY_COURSE() {
        dwSize = this.size();
        for (int i = 0; i < stuCourseInfo.length; i++) {
            stuCourseInfo[i] = new NET_COURSE();
        }
    }
}
