package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description
 * @date 2020/9/14
 */
public enum EM_DELIVERY_FILE_TYPE {
    /**
     * 未知
     */
    EM_DELIVERY_FILE_TYPE_UNKNOWN(0,"未知"),
    /**
     * 视频
     */
    EM_DELIVERY_FILE_TYPE_VIDEO(1,"视频"),
    /**
     * 图片
     */
    EM_DELIVERY_FILE_TYPE_IMAGE(2,"图片"),
    /**
     * 音频
     */
    EM_DELIVERY_FILE_TYPE_AUDIO(3,"音频");
    private int type;
    private String desc;
    private EM_DELIVERY_FILE_TYPE(int type,String desc){
        this.type=type;
        this.desc=desc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
