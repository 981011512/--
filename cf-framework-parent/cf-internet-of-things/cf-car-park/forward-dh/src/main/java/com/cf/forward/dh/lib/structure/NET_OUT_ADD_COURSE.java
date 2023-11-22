package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 添加新的课程记录 出参指针 {@link NetSDKLib#CLIENT_AddCourse}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/17 16:10
 */
public class NET_OUT_ADD_COURSE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 课程ID数量
     */
    public int nIdNum;
    /**
     * 返回新增的课程ID; -1:数据库中无此记录, -2:记录已存在, -3:数据库已满
     */
    public int[] nId = new int[64];

    public NET_OUT_ADD_COURSE() {
        dwSize = this.size();
    }
}
