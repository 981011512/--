package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_DETECT_SENSOR_TYPE;
import com.cf.forward.dh.lib.enumeration.EM_TRAFFIC_FLOW_STATUS;
import com.cf.forward.dh.lib.enumeration.EM_VIRTUAL_COIL_OCCUPANCY_STATUS;

/**
 * @author ： 47040
 * @since ： Created in 2020/12/17 11:38
 */
public class NET_TRAFFIC_FLOW_STAT extends NetSDKLib.SdkStructure {
    /**
     * 物理车道号
     */
    public int nLane;
    /**
     * 自定义车道号
     */
    public int nRoadwayNumber;
    /**
     * 流量状态 枚举 {@link EM_TRAFFIC_FLOW_STATUS}
     */
    public int emStatus;
    /**
     * 车头虚拟线圈状态, 即车进线圈 枚举 {@link EM_VIRTUAL_COIL_OCCUPANCY_STATUS}
     */
    public int emHeadCoil;
    /**
     * 车尾虚拟线圈状态, 即车出线圈 枚举 {@link EM_VIRTUAL_COIL_OCCUPANCY_STATUS}
     */
    public int emTailCoil;
    /**
     * 车道平均速度(单位：km/h)
     */
    public int nSpeed;
    /**
     * 排队长度(单位：cm)
     */
    public int nQueueLen;
    /**
     * 排队车辆数
     */
    public int nCarsInQueue;
    /**
     * 探测物体的传感器类型 {@link EM_DETECT_SENSOR_TYPE}
     */
    public int emSensorType;
    /**
     * 保留字节
     */
    public byte[] byReserverd = new byte[256];
}
