package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.NET_EM_CFG_OPERATE_TYPE;

/**
 * 用户自定义OSD标题
 * {@link NET_EM_CFG_OPERATE_TYPE#NET_EM_CFG_USER_DEF_TITLE}
 *
 * @author 47040
 * @version 1.0.0
 * @since Created in 2021/3/8 20:21
 */
public class NET_OSD_USER_DEF_TITLE extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 自定义标题数量
     */
    public int nUserDefTitleNum;
    /**
     * 自定义标题
     */
    public NET_USER_DEF_TITLE_INFO[] stuUserDefTitle = new NET_USER_DEF_TITLE_INFO[16];

    public NET_OSD_USER_DEF_TITLE() {
        dwSize = this.size();
        for (int i = 0; i < stuUserDefTitle.length; i++) {
            stuUserDefTitle[i] = new NET_USER_DEF_TITLE_INFO();
        }
    }

}
