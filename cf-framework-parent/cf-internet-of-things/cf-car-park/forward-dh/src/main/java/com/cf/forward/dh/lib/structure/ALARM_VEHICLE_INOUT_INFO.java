package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.sun.jna.Pointer;

/**
 * 事件类型 车辆进出车道报警
 * {@link NetSDKLib#NET_ALARM_VEHICLE_INOUT}
 *
 * @author 47040
 * @since Created in 2020/12/17 11:17
 */
public class ALARM_VEHICLE_INOUT_INFO extends NetSDKLib.SdkStructure {
    /**
     * 事件动作,0表示脉冲事件
     */
    public int nAction;
    /**
     * 通道号
     */
    public int nChannel;
    /**
     * 事件名称
     */
    public byte[] szName = new byte[128];
    /**
     * 事件发生的时间
     */
    public NET_TIME_EX UTC;
    /**
     * 事件ID
     */
    public int nEventID;
    /**
     * 物体列表 长度由nObjectNum决定 指向 {@link NET_VEHICLE_OBJECT}
     */
    public Pointer pstObjets;
    /**
     * 物体有效个数
     */
    public int nObjectNum;
    /**
     * 统计有效个数
     */
    public int nStatNum;
    /**
     * 各个车道实时交通流量统计信息, 最大支持8车道
     */
    public NET_TRAFFIC_FLOW_STAT[] stuStats = new NET_TRAFFIC_FLOW_STAT[8];
    /**
     * 保留字节
     */
    public byte[] byReserverd = new byte[1024];

    public ALARM_VEHICLE_INOUT_INFO() {
        for (int i = 0; i < stuStats.length; i++) {
            stuStats[i] = new NET_TRAFFIC_FLOW_STAT();
        }
    }
}
