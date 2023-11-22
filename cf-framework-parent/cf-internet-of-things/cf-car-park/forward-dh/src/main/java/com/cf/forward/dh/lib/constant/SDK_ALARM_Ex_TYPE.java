package com.cf.forward.dh.lib.constant;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.structure.ALARM_SOLARCELL_SYSTEM_INFO;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;

/**
 * @author 47081
 * @version 1.0
 * @description \if ENGLISH_LANG
 * <p>
 * \else
 * 扩展报警类型,对应{@link NetSDKLib#CLIENT_StartListenEx(NetSDKLib.LLong)}
 * \endif
 * @date 2020/8/11
 */
public class SDK_ALARM_Ex_TYPE {
    /**
     * 太阳能系统信息上报(对应结构体 {@link ALARM_SOLARCELL_SYSTEM_INFO}),枚举值对应的回调接口{@link NetSDKLib.fMessCallBack#invoke(int, NetSDKLib.LLong, Pointer, int, String, NativeLong, Pointer)}
     * 对应的接口{@link NetSDKLib#CLIENT_StartListenEx(NetSDKLib.LLong)}
     */
    public static final int SDK_ALARM_SOLARCELL_SYSTEM_INFO = 0x345F;

    /**
     * 硬盘满报警，数据为1个字节，1为有硬盘满报警，0为无报警。
     * 对应的回调接口{@link NetSDKLib.fMessCallBack#invoke(int, NetSDKLib.LLong, Pointer, int, String, NativeLong, Pointer)}
     * 对应的接口{@link NetSDKLib#CLIENT_StartListenEx(NetSDKLib.LLong)}
     */
    public static final int SDK_DISKFULL_ALARM_EX = 0x2106;
    /**
     * 坏硬盘报警，数据为32个字节，每个字节表示一个硬盘的故障报警状态，1为有报警，0为无报警。
     * 对应的回调接口{@link NetSDKLib.fMessCallBack#invoke(int, NetSDKLib.LLong, Pointer, int, String, NativeLong, Pointer)}
     * 对应的接口{@link NetSDKLib#CLIENT_StartListenEx(NetSDKLib.LLong)}
     */
    public static final int SDK_DISKERROR_ALARM_EX = 0x2107;
    /**
     * 无硬盘报警,对应结构体{@link com.cf.forward.dh.lib.structure.ALARM_NO_DISK_INFO}
     * 对应的回调接口{@link NetSDKLib.fMessCallBack#invoke(int, NetSDKLib.LLong, Pointer, int, String, NativeLong, Pointer)}
     * 对应的接口{@link NetSDKLib#CLIENT_StartListenEx(NetSDKLib.LLong)}
     */
    public static final int SDK_ALARM_NO_DISK = 0x2183;

}
