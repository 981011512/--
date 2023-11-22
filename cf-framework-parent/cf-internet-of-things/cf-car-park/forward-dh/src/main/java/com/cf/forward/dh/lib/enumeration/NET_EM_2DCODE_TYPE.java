package com.cf.forward.dh.lib.enumeration;

/**
 * @author 47081
 * @version 1.0
 * @description 二维码类型
 * @date 2020/9/10
 */
public enum NET_EM_2DCODE_TYPE {
    /**
     * TYCO客户的P2P功能
     */
    NET_EM_2DCODE_TYPE_OZVISION(0, "TYCO"),
    /**
     * 乐橙手机客户端
     */
    NET_EM_2DCODE_TYPE_LCWEBSITE(1, "乐橙"),
    /**
     * easy4ip手机客户端
     */
    NET_EM_2DCODE_TYPE_EASY4IP(2, "easy4ip"),
    /**
     * i/gDMSS手机客户端
     */
    NET_EM_2DCODE_TYPE_DMSS(3, "i/gDMSS"),
    /**
     * 可视对讲客户端
     */
    NET_EM_2DCODE_TYPE_VIDEOTALK(4, "可视对讲"),
    /**
     * app注册信息二维码
     */
    NET_EM_2DCODE_TYPE_APPREGISTER(5, "app注册信息"),
    /**
     * H500平台向美的平台获取授权
     */
    NET_EM_2DCODE_TYPE_DEVAUTH(6, "H500平台");

    private NET_EM_2DCODE_TYPE(int type, String descrip) {
        this.type = type;
        this.descrip = descrip;
    }

    private int type;
    private String descrip;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription(int type) {
        for (NET_EM_2DCODE_TYPE code : NET_EM_2DCODE_TYPE.values()) {
            if (code.getType() == type) {
                return code.getDescrip();
            }
        }
        return "";
    }

    public static NET_EM_2DCODE_TYPE getCode(int type) {
        for (NET_EM_2DCODE_TYPE code : NET_EM_2DCODE_TYPE.values()) {
            if (code.getType() == type) {
                return code;
            }
        }
        return null;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
