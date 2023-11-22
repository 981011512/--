package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 音频文件预上传错误原因
 * @date 2020/6/10
 */
public enum EM_REASON_TYPE {
    /**
     * 未知原因
     */
    EM_REASON_TYPE_UNKNOWN(0, "未知原因"),
    /**
     * 文件个数超出
     */
    EM_REASON_TYPE_OVERNUMBER(1, "文件个数超出"),
    /**
     * 文件存储已满
     */
    EM_REASON_TYPE_FULLSTORAGE(2, "文件存储空间已满"),
    /**
     * 文件太大
     */
    EM_REASON_TYPE_TOOLARGE_FILE(3, "该文件太大"),
    /**
     * 无效的文件类型
     */
    EM_REASON_TYPE_INVALID_FILETYPE(4, "无效的文件类型"),
    /**
     * 没有上传权限
     */
    EM_REASON_TYPE_UNAUTH_UPLOAD(5, "没有上传权限"),
    /**
     * 文件命名异常
     */
    EM_REASON_TYPE_EXCEPTION_NAME(6, "文件命名异常"),
    /**
     * 文件名太长
     */
    EM_REASON_TYPE_TOOLONG_NAME(7, "文件名太长"),
    /**
     * 文件名已存在
     */
    EM_REASON_TYPE_EXIST_NAME(8, "文件名已存在");
    private int type;
    private String reason;

    private EM_REASON_TYPE(int type, String reson) {
        this.type = type;
        this.reason = reson;
    }

    public String getReason() {
        return reason;
    }

    public int getType() {
        return type;
    }

    public static String getReason(int type) {
        for (EM_REASON_TYPE reason : EM_REASON_TYPE.values()) {
            if (type == reason.getType()) {
                return reason.getReason();
            }
        }
        return null;
    }

    public static EM_REASON_TYPE getReasonType(int type) {
        for (EM_REASON_TYPE reason : EM_REASON_TYPE.values()) {
            if (type == reason.type) {
                return reason;
            }
        }
        return null;
    }
}
