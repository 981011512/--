package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;

/**
 * className：NET_STJ77D5_RADAR_CONFIG
 * description： 森思泰克77Ghz网络雷达配置
 * author：251589
 * createTime：2020/12/29 11:13
 *
 * @version v1.0
 */
public class NET_STJ77D5_RADAR_CONFIG extends NetSDKLib.SdkStructure {
    public int    nLaneNumber;    // 车道个数, 范围1~4
    public int    nDetectMode;    // 道路方向, 取值:17 来向, 18 去向, 19 双向
    public double    dbHeight;    // 雷达安装高度 ,0.01m/bit; 范围0~25
    public double    dbHorizonShift;    // 水平偏移, 0.2m/bit; 范围-25~25
    public int    nLaneCount;    // 车道个数
    public double[]    dbLaneWidth = new double[4];    // 车道1-4宽度, 0.01m/bit; 范围2~5。第一个元素是车道1宽度, 以此类推
    public double    dbStopLine;    // 停止线距离, 0.1m/bit; 范围20~60
    public int    nSceneMode;    // 雷达工作场景模式, 0:未知, 1:主路模式, 2:路口模式
    public double    dbShiftAngle;    // 角度修正 ,0.1/bit; 范围-12~12
    public double    dbLengthwayShiftDistance;    // 纵向距离修正, 0.2m/bit; 范围-25~25
    public double    dbSensitive;    // 灵敏度设置, 0.1/bit; 范围0~3
    public int    nIDset;    // ID设置; 范围0~4
    public int    nWorkMode;    // 雷达工作模式, 0:调试模式 1:工作模式
    public int    nRadarFlowTime;    // 雷达流量统计时间间隔, 单位:s
    public int    nRadarFlowSwitch;    // 雷达流量输出开关, 0:未知, 1:开启, 2:关闭
    public int    nNonMotorDiscern;    // 非机动车/行人识别控制开关, 0:未知, 1:开启, 2:关闭
    public int    nVehicleDistinguish;    // 车型分别能力;范围-10~10, 负值:大车门限降低, 正值:大车门限升高
    public int    nStopTargetDisappearTime;    // 停止目标消失时间,1s/bit, 0:关闭, 非0时:停止目标消失的时间
    public int    nStartLane;    // 雷达的起始车道号, 取值范围: 0~7
    public int    nRadarLanNumber;    // 雷达支持的车道数目, 取值范围:1~8
    public int    nVirtualCoilTriggerCount;    // 虚拟线圈个数
    public int[]    nVirtualCoilTrigger = new int[4];    // 虚拟线圈触发方式: 1:头线圈, 2:尾线圈, 3:头尾线圈, 90:线圈,不统计
    public int    nVirtualCoilDistanceCount;    // 虚拟线圈个数
    public double[]    dbVirtualCoilDistance = new double[4];    // 虚拟线圈起始位置(下边沿,y向距离雷达距离), 单位:m
    public int    nVirtualCoilLengthCount;    // 虚拟线圈个数
    public double[]    dbVirtualCoilLength = new double[4];    // 虚拟线圈长度, 单位:m
    public int[]    nLaneDirection = new int[4];    // 车道方向,
    public double    dbCameraToRoadEndDistance;    // 相机到车道监控面路口距离, 单位:m, 0.1m/bit(精确到小数点后一位,步长0.1m)
    public double    dbCameraToStopLane;    // 相机到停止线距离, 单位:m, 0.1m/bit(精确到小数点后一位,步长0.1m)
    public int    nLaneDirectionCount;    // 车道个数
    public byte[]    bReserved = new byte[1020];    // 保留字节
}
