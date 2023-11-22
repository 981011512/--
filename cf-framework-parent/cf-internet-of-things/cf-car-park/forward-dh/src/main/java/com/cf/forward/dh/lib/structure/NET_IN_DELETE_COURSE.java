package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 删除课程记录 入参指针 {@link NetSDKLib#CLIENT_DeleteCourse}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/17 20:30
 */
public class NET_IN_DELETE_COURSE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 课程 ID 数量
     */
    public int nIdNum;
    /**
     * 课程ID
     */
    public int[] nId = new int[64];

    public NET_IN_DELETE_COURSE() {
        dwSize = this.size();
    }
}
