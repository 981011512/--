package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_COURSE_RECORD_COMPRESSION_TYPE;

/**
 * 录像文件信息
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 16:54
 */
public class NET_RECORD_INFO extends NetSDKLib.SdkStructure {

    /**
     * 真实通道号
     */
    public int nRealChannel;
    /**
     * 查询开始时间
     */
    public NET_TIME stuStartTime;
    /**
     * 查询结束时间
     */
    public NET_TIME stuEndTime;
    /**
     * 通道录像文件总长度低32位,0表示此通道没录像
     */
    public int nFileLen;
    /**
     * 通道录像文件总长度高32位,与FileLen一起表示录像长度
     */
    public int nFileLenEx;
    /**
     * 录像时长
     */
    public int nTime;
    /**
     * 文件类型，0:裁减文件，1:原始文件
     */
    public int nFileType;
    /**
     * 课程录像压缩类型 {@link EM_COURSE_RECORD_COMPRESSION_TYPE}
     */
    public int emCompression;
    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[60];
}
