package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * 修改课程记录 出参指针 {@link NetSDKLib#CLIENT_ModifyCourse}
 *
 * @author ： 47040
 * @since ： Created in 2020/9/17 16:42
 */
public class NET_OUT_MODIFY_COURSE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 修改的课程ID数量
     */
    public int nResultIDNum;
    /**
     * 修改的课程ID; 原ID: 修改成功, -1: 数据库中无此记录, -2: 时间冲突
     */
    public int[] nResultID = new int[64];

    public NET_OUT_MODIFY_COURSE() {
        dwSize = this.size();
    }
}
