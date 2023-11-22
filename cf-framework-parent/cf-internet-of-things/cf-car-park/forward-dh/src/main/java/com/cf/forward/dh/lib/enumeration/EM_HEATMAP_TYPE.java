package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 热度图类型
 * @date 2020/9/21
 */
public enum EM_HEATMAP_TYPE {
    /**
     * 未知
     */
    EM_HEATMAP_UNKNOWN(0,"未知"),
    /**
     * 平均滞留时间热度图
     */
    EM_HEATMAP_AVERAGESTAYTIME(1,"平均滞留时间热度图"),
    /**
     * 人数统计热度图
     */
    EM_HEATMAP_HUMANSTATISTICS(2,"人数统计热度图"),
    /**
     * 行人轨迹图
     */
    EM_HEATMAP_HUMANTRACK(3,"行人轨迹图");
    /**
     * 类型
     */
    private int type;
    /**
     * 解释
     */
    private String desc;
    private EM_HEATMAP_TYPE(int type,String desc){
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

    public static EM_HEATMAP_TYPE getEmHeatMap(int type) {
        for (EM_HEATMAP_TYPE heatmap : EM_HEATMAP_TYPE.values()) {
            if (heatmap.getType() == type) {
                return heatmap;
            }
        }
        return null;
    }
}
