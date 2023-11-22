package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.NET_RADIOMETRY_ALARMCONTION;
import com.cf.forward.dh.lib.enumeration.NET_RADIOMETRY_RESULT;

/**
 * 热成像测温点温度异常报警事件(对应结构体 {@link NetSDKLib#NET_ALARM_HEATIMG_TEMPER})
 *
 * @author ： 47040
 * @since ： Created in 2020/9/12 16:46
 */
public class ALARM_HEATIMG_TEMPER_INFO extends NetSDKLib.SdkStructure {

    /**
     * 温度异常点名称  从测温规则配置项中选择
     */
    public byte[] szName = new byte[64];
    /**
     * 报警项编号
     */
    public int nAlarmId;
    /**
     * 报警结果值 fTemperatureValue 的类型,见枚举 {@link NET_RADIOMETRY_RESULT}
     */
    public int nResult;
    /**
     * 报警条件,见枚举 {@link NET_RADIOMETRY_ALARMCONTION}
     */
    public int nAlarmContion;
    /**
     * 报警温度值
     */
    public float fTemperatureValue;
    /**
     * 温度单位(当前配置的温度单位),见 {@link NetSDKLib.NET_TEMPERATURE_UNIT}
     */
    public int nTemperatureUnit;
    /**
     * 报警点的坐标  相对坐标体系,取值均为 0~8191
     */
    public NetSDKLib.NET_POINT stCoordinate;
    /**
     * 预置点
     */
    public int nPresetID;
    /**
     * 通道号
     */
    public int nChannel;
    /**
     * 0:开始 1:停止 -1:无意义
     */
    public int nAction;
    /**
     * 报警坐标, 其类型可以是点，线或多边形。替换 stCoordinate字段
     */
    public NetSDKLib.NET_POLY_POINTS stuAlarmCoordinates;
    /**
     * 保留字节
     */
    public byte[] reserved = new byte[156];
}
