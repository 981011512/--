package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 文件所属的模式
 * @date 2020/9/10
 */
public enum EM_PLAY_WITH_MODE {
    /**
     * 未知
     */
    EM_PLAY_WITH_MODE_UNKNOWN(0, "未知"),
    /**
     * 识别模式
     */
    EM_PLAY_WITH_MODE_RECOGNITION(1, "识别"),
    /**
     * 信息发布模式
     */
    EM_PLAY_WITH_MODE_INFORMATION_RELEASE(2, "信息发布"),
    /**
     * 主界面模式
     */
    EM_PLAY_WITH_MODE_MAIN_INTERFACE(3, "主界面");

    private EM_PLAY_WITH_MODE(int mode, String desc) {
        this.mode = mode;
        this.desc = desc;
    }

    private int mode;
    private String desc;

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static EM_PLAY_WITH_MODE getPlayMode(int mode) {
        for (EM_PLAY_WITH_MODE playMode : EM_PLAY_WITH_MODE.values()) {
            if (playMode.getMode() == mode) {
                return playMode;
            }
        }
        return null;
    }
}
