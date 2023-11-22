package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * className：NET_VIDEOIN_DEFOG_INFO
 * description： 透雾配置
 * author：251589
 * createTime：2020/12/28 14:37
 *
 * @version v1.0
 */
public class NET_VIDEOIN_DEFOG_INFO extends NetSDKLib.SdkStructure {
    public int    dwSize;    // 结构体大小
    public int    emCfgType;    // 配置类型，获取和设置时都要指定
    public int    emDefogMode;    // 透雾模式
    public int    nIntensity;    // 强度0-100
    public int    emIntensityMode;    //大气光模式
    public int    nLightIntensityLevel;    //大气光强度(0-15)
    public boolean    bCamDefogEnable;    //光学去雾使能 (TRUE使能，FALSE去使能)

    public NET_VIDEOIN_DEFOG_INFO(){
        this.dwSize = this.size();
    }
}
