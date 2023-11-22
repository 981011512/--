package com.cf.forward.dh.lib.enumeration;/**
 * @author 47081
 * @descriptio
 * @date 2020/11/9
 * @version 1.0
 */

/**
 * @author 47081
 * @version 1.0
 * @description 马赛克类型
 * @date 2020/11/9
 */
public enum NET_EM_MOSAIC_TYPE {
    NET_EM_MOSAIC_UNKNOWN(0, "未知"),
    NET_EM_MOSAIC_8(8, "[8x8大小] 马赛克"),
    NET_EM_MOSAIC_16(16, "[16x16大小] 马赛克"),

    NET_EM_MOSAIC_24(24, "[24x24大小] 马赛克"),
    NET_EM_MOSAIC_32(32, "[32x32大小] 马赛克");

    private NET_EM_MOSAIC_TYPE(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    private int type;
    private String desc;

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

    public static NET_EM_MOSAIC_TYPE getMosaicType(int type){
        for (NET_EM_MOSAIC_TYPE mosaic:NET_EM_MOSAIC_TYPE.values()) {
            if(type==mosaic.getType()){
                return mosaic;
            }
        }
        return null;
    }
}
