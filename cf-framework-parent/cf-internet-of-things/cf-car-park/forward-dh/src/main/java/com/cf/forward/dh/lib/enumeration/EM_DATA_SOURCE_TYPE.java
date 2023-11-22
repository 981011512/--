package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 智能分析数据源类型
 * @date 2020/10/19
 */
public enum EM_DATA_SOURCE_TYPE {
    /**
     * {@link com.cf.forward.dh.lib.NetSDKLib.NET_REMOTE_REALTIME_STREAM_INFO}
     */
    EM_DATA_SOURCE_REMOTE_REALTIME_STREAM(1, "远程实时流"),
    /**
     * {@link com.cf.forward.dh.lib.NetSDKLib.NET_PUSH_PICFILE_INFO}
     */
    EM_DATA_SOURCE_PUSH_PICFILE(2, "主动推送图片文件");
    private int type;
    private String des;

    private EM_DATA_SOURCE_TYPE(int type, String des) {
        this.type = type;
        this.des = des;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public static EM_DATA_SOURCE_TYPE getDataSourceType(int type) {
        for (EM_DATA_SOURCE_TYPE source : EM_DATA_SOURCE_TYPE.values()) {
            if (type == source.getType()) {
                return source;
            }
        }
        return null;
    }
}
