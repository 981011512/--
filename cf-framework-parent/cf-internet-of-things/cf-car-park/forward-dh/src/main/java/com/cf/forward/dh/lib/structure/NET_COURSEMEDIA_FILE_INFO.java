package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * @author ： 47040
 * @since ： Created in 2020/9/28 16:51
 */
public class NET_COURSEMEDIA_FILE_INFO extends NetSDKLib.SdkStructure {
    /**
     * 视频信息ID,-1表示无此记录
     */
    public int nID;
    /**
     * 课程信息
     */
    public NET_COURSE_INFO stuCourseInfo;
    /**
     * 通道数量
     */
    public int nChannelNum;
    /**
     * 对应通道的录像分段数
     */
    public int[] nRecordNum = new int[64];
    /**
     * 录像信息，第一维下标为映射通道号(stuRecordInfo_1), 第二维为录像分段数(stuRecordInfo_1.stuRecordInfo_2)
     */
    public NET_RECORD_INFO_ARRAY[] stuRecordInfo_1 = new NET_RECORD_INFO_ARRAY[64];
    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[128];

    public NET_COURSEMEDIA_FILE_INFO() {
        for (int i = 0; i < stuRecordInfo_1.length; i++) {
            stuRecordInfo_1[i] = new NET_RECORD_INFO_ARRAY();
        }
    }

    @Override
    public int fieldOffset(String name) {
        return super.fieldOffset(name);
    }
}