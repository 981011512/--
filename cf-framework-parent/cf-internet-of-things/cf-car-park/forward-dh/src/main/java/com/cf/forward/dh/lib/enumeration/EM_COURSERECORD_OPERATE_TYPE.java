package com.cf.forward.dh.lib.enumeration;

import com.cf.forward.dh.lib.structure.*;

/**
 * 录播主机录像信息操作
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 19:17
 */
public enum EM_COURSERECORD_OPERATE_TYPE {
    /**
     * 获取教室录像信息,对应结构体
     * pInParam = {@link NET_IN_COURSERECORD_GETINFO}
     * pOutParam = {@link NET_OUT_COURSERECORD_GETINFO}
     */
    EM_COURSERECORDE_TYPE_GET_INFO(0, "获取教室录像信息"),
    /**
     * 设置教室录像信息,对应结构体
     * pInParam = {@link NET_IN_COURSERECORD_SETINFO}
     * pOutParam = {@link NET_OUT_COURSERECORD_SETINFO}
     */
    EM_COURSERECORDE_TYPE_SET_INFO(1, "设置教室录像信息"),
    /**
     * 将录像信息更新到time时的信息,对应结构体
     * pInParam = {@link NET_IN_COURSERECORD_UPDATE_INFO}
     * pOutParam = {@link NET_OUT_COURSERECORD_UPDATE_INFO}
     */
    EM_COURSERECORDE_TYPE_UPDATE_INFO(2, "将录像信息更新到time时的信息"),
    /**
     * 获取当前课程教室已录制时间,对应结构体
     * pInParam = {@link NET_IN_COURSERECORD_GET_TIME}
     * pOutParam = {@link NET_OUT_COURSERECORD_GET_TIME}
     */
    EM_COURSERECORDE_TYPE_GET_TIME(3, "获取当前课程教室已录制时间");

    private int value;
    private String note;

    EM_COURSERECORD_OPERATE_TYPE(int givenValue, String note) {
        this.value = givenValue;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public int getValue() {
        return value;
    }

    public static String getNoteByValue(int givenValue) {
        for (EM_COURSERECORD_OPERATE_TYPE enumType : EM_COURSERECORD_OPERATE_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_COURSERECORD_OPERATE_TYPE enumType : EM_COURSERECORD_OPERATE_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_COURSERECORD_OPERATE_TYPE getEnum(int value) {
        for (EM_COURSERECORD_OPERATE_TYPE e : EM_COURSERECORD_OPERATE_TYPE.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_COURSERECORD_OPERATE_TYPE.EM_COURSERECORDE_TYPE_GET_INFO;
    }
}
