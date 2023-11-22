package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.NET_EM_CFG_OPERATE_TYPE;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

import java.util.Arrays;

/**
 * @author 47081
 * @version 1.0
 * @description 广告禁用时段配置
 * 对应的枚举值{@link NET_EM_CFG_OPERATE_TYPE#NET_EM_CFG_FORBIDDEN_ADVERT_PLAY}
 * * 调用的接口 {@link NetSDKLib#CLIENT_GetConfig(NetSDKLib.LLong, int, int, Pointer, int, int, Pointer)}和
 * * {@link NetSDKLib#CLIENT_SetConfig(NetSDKLib.LLong, int, int, Pointer, int, int, IntByReference, Pointer)}
 * @date 2020/9/10
 */
public class NET_CFG_FORBIDDEN_ADVERT_PLAY extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 广告配置时间段个数
     */
    public int nAdvertNum;
    /**
     * 广告禁用时段配置信息
     */
    public NET_CFG_FORBIDDEN_ADVERT_PLAY_INFO[] stuAdvertInfo = (NET_CFG_FORBIDDEN_ADVERT_PLAY_INFO[]) new NET_CFG_FORBIDDEN_ADVERT_PLAY_INFO().toArray(8);

    public NET_CFG_FORBIDDEN_ADVERT_PLAY() {
        this.dwSize = this.size();
    }

    @Override
    public String toString() {
        return "NET_CFG_FORBIDDEN_ADVERT_PLAY{" +
                "dwSize=" + dwSize +
                ", nAdvertNum=" + nAdvertNum +
                ", stuAdvertInfo=" + Arrays.toString(stuAdvertInfo) +
                '}';
    }
}
