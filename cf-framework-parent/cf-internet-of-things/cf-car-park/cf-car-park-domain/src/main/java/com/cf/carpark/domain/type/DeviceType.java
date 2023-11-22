package com.cf.carpark.domain.type;

import java.io.Serializable;

/**
 * <p>
 * 描述
 * </p>
 *
 * @author 武汉才风智慧科技有限公司-Wuhan Caifeng Smart Technology Co., Ltd
 * @Linker +86 18086495676 Mr Wang 18086495676@163.com
 * @date 2022-12-20
 * @Version cfzh Smarter Cities V3.0
 */
public class DeviceType implements Serializable {

    public static final Byte ROAD_GATE = (byte)1;   //道闸
    public static final Byte LICENSE_PLATE_RECOGNITION_CAMERA = (byte)2;    //车牌识别相机
    public static final Byte FLOOR_LOCK = (byte)3;    //地锁
    public static final Byte HIGH_POSITION_CAMERA = (byte)4;    //高位相机

}
