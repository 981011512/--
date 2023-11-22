package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_PLAY_WITH_MODE;
import com.cf.forward.dh.lib.enumeration.NET_EM_CFG_OPERATE_TYPE;

/**
 * @author 47081
 * @version 1.0
 * @description 门禁设备当前模式配置 对应枚举值{@link NET_EM_CFG_OPERATE_TYPE#NET_EM_CFG_BGY_CUSTOMERCFG}
 * @date 2020/9/10
 */
public class NET_CFG_BGY_CUSTOMERCFG extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 模式类别,对应枚举{@link EM_PLAY_WITH_MODE}
     */
    public int emModeType;

    public NET_CFG_BGY_CUSTOMERCFG() {
        this.dwSize = this.size();
    }

    @Override
    public String toString() {
        return "NET_CFG_BGY_CUSTOMERCFG{" +
                "dwSize=" + dwSize +
                ", emModeType=" + emModeType +
                '}';
    }
}
