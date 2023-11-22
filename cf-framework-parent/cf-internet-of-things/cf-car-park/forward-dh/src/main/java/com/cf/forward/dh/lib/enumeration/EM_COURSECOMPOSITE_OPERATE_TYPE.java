package com.cf.forward.dh.lib.enumeration;

import com.cf.forward.dh.lib.structure.*;

/**
 * 录播主机组合通道操作
 *
 * @author ： 47040
 * @since ： Created in 2020/9/28 19:49
 */
public enum EM_COURSECOMPOSITE_OPERATE_TYPE {
    /**
     * 控制组合通道与逻辑通道，对应结构体
     * pInParam = {@link NET_IN_COURSECOMPOSITE_LOCK_CONTROL}
     * pOutParam = {@link NET_OUT_COURSECOMPOSITE_LOCK_CONTROL}
     */
    EM_COURSECOMPOSITE_TYPE_LOCK_CONTROL(0, "控制组合通道与逻辑通道"),
    /**
     * 获取组合通道与逻辑通道的锁定信息，对应结构体
     * pInParam = {@link NET_IN_COURSECOMPOSITE_GET_LOCKINFO}
     * pOutParam = {@link NET_OUT_COURSECOMPOSITE_GET_LOCKINFO}
     */
    EM_COURSECOMPOSITE_TYPE_GET_LOCKINFO(1, "获取组合通道与逻辑通道的锁定信息"),
    /**
     * 获取组合通道信息,对应结构体
     * pInParam = {@link NET_IN_COURSECOMPOSITE_GET_INFO}
     * pOutParam = {@link NET_OUT_COURSECOMPOSITE_GET_INFO}
     */
    EM_COURSECOMPOSITE_TYPE_GET_INFO(2, "获取组合通道信息"),
    /**
     * 设置组合通道信息,对应结构体
     * pInParam = {@link NET_IN_COURSECOMPOSITE_SET_INFO}
     * pOutParam = {@link NET_OUT_COURSECOMPOSITE_SET_INFO}
     */
    EM_COURSECOMPOSITE_TYPE_SET_INFO(3, "设置组合通道信息"),
    /**
     * 将组合通道信息更新到time时的信息，对应结构体
     * pInParam = {@link NET_IN_COURSECOMPOSITE_UPDATE_INFO}
     * pOutParam = {@link NET_OUT_COURSECOMPOSITE_UPDATE_INFO}
     */
    EM_COURSECOMPOSITE_TYPE_UPDATE_INFO(4, "将组合通道信息更新到time时的信息");

    private int value;
    private String note;

    EM_COURSECOMPOSITE_OPERATE_TYPE(int givenValue, String note) {
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
        for (EM_COURSECOMPOSITE_OPERATE_TYPE enumType : EM_COURSECOMPOSITE_OPERATE_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (EM_COURSECOMPOSITE_OPERATE_TYPE enumType : EM_COURSECOMPOSITE_OPERATE_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static EM_COURSECOMPOSITE_OPERATE_TYPE getEnum(int value) {
        for (EM_COURSECOMPOSITE_OPERATE_TYPE e : EM_COURSECOMPOSITE_OPERATE_TYPE.values()) {
            if (e.getValue() == value)
                return e;
        }
        return EM_COURSECOMPOSITE_OPERATE_TYPE.EM_COURSECOMPOSITE_TYPE_LOCK_CONTROL;
    }
}
