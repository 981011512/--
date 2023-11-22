package com.cf.forward.dh.lib.enumeration;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.structure.*;

/**
 * {@link NetSDKLib#CLIENT_OperateCourseCompositeChannelMode}
 * @author ： 47040
 * @since ： Created in 2020/9/27 16:30
 */
public enum NET_COURSECOMPOSITE_MODE_OPERATE_TYPE {
    /**
     * 添加模式,对应结构体
     * pInParam {@link NET_IN_COURSECOMPOSITE_CHANNEL_MODE_ADD}
     * pOutParam {@link NET_OUT_COURSECOMPOSITE_CHANNEL_MODE_ADD}
     */
    NET_COURSECOMPOSITE_MODE_ADD(0, "添加模式"),
    /**
     * 删除模式,对应结构体
     * pInParam {@link NET_IN_COURSECOMPOSITE_CHANNEL_MODE_DELETE}
     * pOutParam {@link NET_OUT_COURSECOMPOSITE_CHANNEL_MODE_DELETE}
     */
    NET_COURSECOMPOSITE_MODE_DELETE(1, "删除模式"),
    /**
     * 修改模式,对应结构体
     * pInParam {@link NET_IN_COURSECOMPOSITE_CHANNEL_MODE_MODIFY}
     * pOutParam {@link NET_OUT_COURSECOMPOSITE_CHANNEL_MODE_MODIFY}
     */
    NET_COURSECOMPOSITE_MODE_MODIFY(2, "修改模式"),
    /**
     * 获取模式,对应结构体
     * pInParam {@link NET_IN_COURSECOMPOSITE_CHANNEL_MODE_GET}
     * pOutParam {@link NET_OUT_COURSECOMPOSITE_CHANNEL_MODE_GET}
     */
    NET_COURSECOMPOSITE_MODE_GET(3, "获取模式");


    private int value;
    private String note;

    NET_COURSECOMPOSITE_MODE_OPERATE_TYPE(int givenValue, String note) {
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
        for (NET_COURSECOMPOSITE_MODE_OPERATE_TYPE enumType : NET_COURSECOMPOSITE_MODE_OPERATE_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (NET_COURSECOMPOSITE_MODE_OPERATE_TYPE enumType : NET_COURSECOMPOSITE_MODE_OPERATE_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static NET_COURSECOMPOSITE_MODE_OPERATE_TYPE getEnum(int value) {
        for (NET_COURSECOMPOSITE_MODE_OPERATE_TYPE e : NET_COURSECOMPOSITE_MODE_OPERATE_TYPE.values()) {
            if (e.getValue() == value)
                return e;
        }
        return NET_COURSECOMPOSITE_MODE_OPERATE_TYPE.NET_COURSECOMPOSITE_MODE_GET;
    }
}
