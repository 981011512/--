package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.EM_DETECT_SENSOR_TYPE;
import com.cf.forward.dh.lib.enumeration.EM_VEHICLEINOUT_CAR_TYPE;

/**
 * 车辆信息
 *
 * @author ： 47040
 * @since ： Created in 2020/12/17 11:54
 */
public class NET_VEHICLE_OBJECT extends NetSDKLib.SdkStructure {
    /**
     * 物体ID
     */
    public int nObjectID;
    /**
     * 车速，单位km/h
     */
    public int nSpeed;
    /**
     * 物体类型 Vehicle NonMotor Plate
     */
    public byte[] szObjectType = new byte[16];
    /**
     * 物体类型中的子类别 {@link NetSDKLib.EM_CATEGORY_TYPE}
     */
    public int emSubObject;
    /**
     * 物理车道号
     */
    public int nLane;
    /**
     * 自定义车道号
     */
    public int nRoadwayNumber;
    /**
     * 探测物体的传感器类型 {@link EM_DETECT_SENSOR_TYPE}
     */
    public int emSensorType;
    /**
     * 物体雷达和视频融合ID
     */
    public int nObjectRVID;
    /**
     * 物体的雷达ID
     */
    public int nObjectRID;
    /**
     * 行驶方向"Approach"-上行,即车辆离设备部署点越来越近; "Leave"-下行,即车辆离设备部署点越来越远,第二和第三个参数分别代表上行和下行的两个地点
     */
    public NET_VEHICLE_DRIVING_DIRECTION_INFO[] szDrivingDirection = new NET_VEHICLE_DRIVING_DIRECTION_INFO[3];
    /**
     * 车牌号码
     */
    public byte[] szPlateNumber = new byte[32];
    /**
     * 车牌颜色
     */
    public byte[] szPlateColor = new byte[16];
    /**
     * 车辆经度
     */
    public double dbLongitude;
    /**
     * 车辆纬度
     */
    public double dbLatitude;
    /**
     * 车身颜色
     */
    public byte[] szCarColor = new byte[16];
    /**
     * 车辆类型 {@link EM_VEHICLEINOUT_CAR_TYPE}
     */
    public int emCarType;
    /**
     * 车辆驶入驶出虚拟线圈的状态 {@link NetSDKLib.NET_FLOWSTAT_DIRECTION}
     */
    public int emVirtualCoilDirection;
    /**
     * 距离停车线距离
     */
    public double dbDistanceToStop;
    /**
     * 车辆与所有车道的中心点(中心点在设备所处位置，且垂直于车道方向的直线上)，X轴方向(垂直于车道方向)的距离
     */
    public double dbCarX;
    /**
     * 车辆与所有车道的中心点(中心点在设备所处位置，且垂直于车道方向的直线上)，Y轴方向(平行于车道方向)的距离
     */
    public double dbCarY;
    /**
     * 车辆与所有车道的中心点(中心点在设备所处位置且垂直于车道方向的直线上)的角度；
     */
    public double dbCarAngle;
    /**
     * 保留字节
     */
    public byte[] byReserverd = new byte[256];

    public NET_VEHICLE_OBJECT() {
        for (int i = 0; i < szDrivingDirection.length; i++) {
            szDrivingDirection[i] = new NET_VEHICLE_DRIVING_DIRECTION_INFO();
        }
    }
}
