package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 删除课程记录 出参指针 {@link NetSDKLib#CLIENT_DeleteCourse}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/17 20:33
 */
public class NET_OUT_DELETE_COURSE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 课程 ID 数量
     */
    public int nResultIdNum;
    /**
     * 课程 ID; -1:删除成功, 原id:删除失败
     */
    public int[] nResultId = new int[64];

    public NET_OUT_DELETE_COURSE() {
        dwSize = this.size();
    }
}
