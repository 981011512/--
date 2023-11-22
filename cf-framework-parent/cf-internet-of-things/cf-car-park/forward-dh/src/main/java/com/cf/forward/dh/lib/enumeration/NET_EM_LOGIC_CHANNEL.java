package com.cf.forward.dh.lib.enumeration;

/**
 * 逻辑通道号
 *
 * @author ： 47040
 * @since ： Created in 2020/9/18 9:44
 */
public enum NET_EM_LOGIC_CHANNEL {

    /**
     * 无效
     */
    NET_EM_LOGIC_CHANNEL_INVALID(-1, "无效"),
    /**
     * 视频组合通道号
     */
    NET_EM_LOGIC_CHANNEL_COMPOSITE(0, "视频组合通道号"),
    /**
     * PPT显示逻辑通道号
     */
    NET_EM_LOGIC_CHANNEL_PPT(1, "PPT显示逻辑通道号"),
    /**
     * 板书特写逻辑通道号
     */
    NET_EM_LOGIC_CHANNEL_BLACKBOARD(2, "板书特写逻辑通道号"),
    /**
     * 学生特写逻辑通道号
     */
    NET_EM_LOGIC_CHANNEL_STUDENTFEATURE(3, "学生特写逻辑通道号"),
    /**
     * 学生全景逻辑通道号
     */
    NET_EM_LOGIC_CHANNEL_STUDENTFULLVIEW(4, "学生全景逻辑通道号"),
    /**
     * 教师特写逻辑通道号
     */
    NET_EM_LOGIC_CHANNEL_TEACHERFEATURE(5, "教师特写逻辑通道号"),
    /**
     * 教师全景逻辑通道号
     */
    NET_EM_LOGIC_CHANNEL_TEACHERFULLVIEW(6, "教师全景逻辑通道号"),
    /**
     * 教师检测逻辑通道号
     */
    NET_EM_LOGIC_CHANNEL_TEACHERDETECT(7, "教师检测逻辑通道号"),
    /**
     * 板书检测逻辑通道号
     */
    NET_EM_LOGIC_CHANNEL_BLACKBOARDDETECT(8, "板书检测逻辑通道号"),
    /**
     * 板书特写1逻辑通道号
     */
    NET_EM_LOGIC_CHANNEL_BLACKBOARD1(9, "板书特写1逻辑通道号"),
    /**
     * 板书检测1逻辑通道号
     */
    NET_EM_LOGIC_CHANNEL_BLACKBOARDDETECT1(10, "板书检测1逻辑通道号"),
    /**
     * 展台显示逻辑通道号
     */
    NET_EM_LOGIC_CHANNEL_VISUALPRESENTER(11, "展台显示逻辑通道号"),
    /**
     * 视频监控逻辑通道号
     */
    NET_EM_LOGIC_CHANNEL_VIDEOSURVEILLANCE(12, "视频监控逻辑通道号"),
    /**
     * 互动会议逻辑通道号
     */
    NET_EM_LOGIC_CHANNEL_VIDEOCONFERENCE(13, "互动会议逻辑通道号"),
    /**
     * 互动演示逻辑通道
     */
    NET_EM_LOGIC_CHANNEL_VIDEO_PRESENTATION(14, "互动演示逻辑通道");

    private int value;
    private String note;

    NET_EM_LOGIC_CHANNEL(int givenValue, String note) {
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
        for (NET_EM_LOGIC_CHANNEL enumType : NET_EM_LOGIC_CHANNEL.values()) {
            if (givenValue == enumType.getValue()) {
                return enumType.getNote();
            }
        }
        return null;
    }

    public static int getValueByNote(String givenNote) {
        for (NET_EM_LOGIC_CHANNEL enumType : NET_EM_LOGIC_CHANNEL.values()) {
            if (givenNote.equals(enumType.getNote())) {
                return enumType.getValue();
            }
        }
        return -1;
    }
}
