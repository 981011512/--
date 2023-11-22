package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * className：NET_COMM_PROP
 * description： 串口基本属性
 * author：251589
 * createTime：2020/12/29 10:58
 *
 * @version v1.0
 */
public class NET_COMM_PROP extends NetSDKLib.SdkStructure {
    public byte    byDataBit;    // 数据位；0：5,1：6,2：7,3：8
    public byte    byStopBit;    // 停止位；0：1位,1：1.5位,2：2位
    public byte    byParity;     // 校验位；0：无校验,1：奇校验；2：偶校验; 3:标志校验; 4:空校验
    public byte    byBaudRate;   // 波特率；0：300,1：600,2：1200,3：2400,4：4800,
                                 // 5：9600,6：19200,7：38400,8：57600,9：115200
}
