package com.cf.forward.dh.lib.enumeration;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.structure.*;

/**
 * 电视墙操作类型
 * 对应接口 {@link NetSDKLib#CLIENT_OperateMonitorWall}
 *
 * @author ： 47040
 * @since ： Created in 2020/10/19 9:11
 */
public enum NET_MONITORWALL_OPERATE_TYPE {

    /**
     * 添加电视墙, 对应 NET_IN_MONITORWALL_ADD 和 NET_OUT_MONITORWALL_ADD
     */
    NET_MONITORWALL_OPERATE_ADD(0, "添加电视墙"),
    /**
     * 预案轮巡控制, 对应 NET_IN_CTRL_COLLECTIONTOUR 和 NET_OUT_CTRL_COLLECTIONTOUR
     */
    NET_MONITORWALL_OPERATE_CTRL_TOUR(1, "预案轮巡控制"),
    /**
     * 获取矩阵当前状态, 对应 NET_IN_MONITORWALL_GET_STATUS 和 NET_OUT_MONITORWALL_GET_STATUS
     */
    NET_MONITORWALL_OPERATE_GET_STATUS(2, "获取矩阵当前状态"),
    /**
     * 设置预案时间表, 对应
     * {@link NET_IN_MONITORWALL_SET_COLL_SCHD} 和 {@link NET_OUT_MONITORWALL_SET_COLL_SCHD}
     */
    NET_MONITORWALL_OPERATE_SET_COLL_SCHD(3, "设置预案时间表"),
    /**
     * 获取预案时间表, 对应
     * {@link NET_IN_MONITORWALL_GET_COLL_SCHD} 和 {@link NET_OUT_MONITORWALL_GET_COLL_SCHD}
     */
    NET_MONITORWALL_OPERATE_GET_COLL_SCHD(4, "获取预案时间表"),
    /**
     * 删除电视墙, 对应 NET_IN_MONITORWALL_REMOVE 和 NET_OUT_MONITORWALL_REMOVE
     */
    NET_MONITORWALL_OPERATE_REMOVE(5, "删除电视墙"),
    /**
     * 设置使能, 对应
     * {@link NET_IN_MONITORWALL_SET_ENABLE} 和 {@link NET_OUT_MONITORWALL_SET_ENABLE}
     */
    NET_MONITORWALL_OPERATE_SET_ENABLE(6, "设置使能"),
    /**
     * 获取使能, 对应
     * {@link NET_IN_MONITORWALL_GET_ENABLE} 和 {@link NET_OUT_MONITORWALL_GET_ENABLE}
     */
    NET_MONITORWALL_OPERATE_GET_ENABLE(7, "获取使能"),
    /**
     * 电视墙是否存在, 对应 NET_IN_MONITORWALL_NAME_EXIST 和 NET_OUT_MONITORWALL_NAME_EXIST
     */
    NET_MONITORWALL_OPERATE_NAME_EXIST(8, "电视墙是否存在"),
    /**
     * 修改电视墙名称, 对应 NET_IN_MONITORWALL_RENAME  和 NET_OUT_MONITORWALL_RENAME
     */
    NET_MONITORWALL_OPERATE_RENAME(9, "修改电视墙名称"),
    /**
     * 更新已上墙的视频源URL, 对应 NET_IN_MONITORWALL_UPDATE_SOURCE_URL 和 NET_OUT_MONITORWALL_UPDATE_SOURCE_URL
     */
    NET_MONITORWALL_OPERATE_UPDATE_SOURCE_URL(10, "更新已上墙的视频源URL"),
    /**
     * 获取电视墙锁定状态, 对应 NET_IN_MONITORWALL_GET_LOCK_STATUS  和 NET_OUT_MONITORWALL_GET_LOCK_STATUS
     */
    NET_MONITORWALL_OPERATE_GET_LOCK_STATUS(11, "获取电视墙锁定状态"),
    /**
     * 锁定电视墙(自由开窗的窗口不能再移动，防止用户误操作), 对应 NET_IN_MONITORWALL_LOCK  和 NET_OUT_MONITORWAL L_LOCK
     */
    NET_MONITORWALL_OPERATE_LOCK(12, "锁定电视墙");

    private int value;
    private String note;

    NET_MONITORWALL_OPERATE_TYPE(int givenValue, String note) {
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
        for (NET_MONITORWALL_OPERATE_TYPE enumType : NET_MONITORWALL_OPERATE_TYPE.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (NET_MONITORWALL_OPERATE_TYPE enumType : NET_MONITORWALL_OPERATE_TYPE.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }

    public static NET_MONITORWALL_OPERATE_TYPE getEnum(int value) {
        for (NET_MONITORWALL_OPERATE_TYPE e : NET_MONITORWALL_OPERATE_TYPE.values()) {
            if (e.getValue() == value)
                return e;
        }
        return NET_MONITORWALL_OPERATE_TYPE.NET_MONITORWALL_OPERATE_GET_STATUS;
    }
}


