package com.cf.forward.dh.lib.structure;

import static com.cf.forward.dh.lib.NetSDKLib.*;

/**
 * 组合通道信息
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 20:24
 */
public class NET_COMPOSITECHANNEL_INFO extends SdkStructure {
    /**
     * 课程名称
     */
    public byte[] szCourseName = new byte[NET_COMMON_STRING_128];
    /**
     * 教师名称
     */
    public byte[] szTeacherName = new byte[NET_COMMON_STRING_64];
    /**
     * 录制模式; 0:无效；1:电影模式； 2:常态模式； 3:精品模式； <0:用户自定义模式
     * 你在合成通道组合配置里自定义的那些都属于 用户自定义 模式，这也是为什么它们的编号是负的
     */
    public int nCompositeChannelMode;
    /**
     * 逻辑通道数量
     */
    public int nChannelNum;
    /**
     * 是否能拉流，下标对应为逻辑通道号
     */
    public int[] bCanStream = new int[MAX_COURSE_LOGIC_CHANNEL];
    /**
     * 保留字节
     */
    public byte[] byReserved = new byte[256];
}
