package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.NET_EM_SHAPE_TYPE;

import static com.cf.forward.dh.lib.NetSDKLib.MAX_COMMON_STRING_64;
import static com.cf.forward.dh.lib.NetSDKLib.NET_MAX_POLYGON_NUM;

/**
 * 设置景物点，原编号的景物点将会被覆盖 入参
 * 出参 {@link NET_OUT_SCENICSPOT_SETPOINTINFO_INFO}
 * 接口 {@link NetSDKLib#CLIENT_ScenicSpotSetPointInfo}
 *
 * @author ： 47040
 * @since ： Created in 2020/10/26 16:14
 */
public class NET_IN_SCENICSPOT_SETPOINTINFO_INFO extends NetSDKLib.SdkStructure {
    /**
     * 结构体大小
     */
    public int dwSize;
    /**
     * 通道号
     */
    public int nChannel;
    /**
     * 信息点编号
     */
    public int nIndex;
    /**
     * 信息点是否生效
     */
    public byte bEnable;
    /**
     * 该信息点是否有子标题
     */
    public byte bTitleAttribute;
    /**
     * 云台方向与放大倍数 (绝对坐标)
     */
    public POSTION stuPosition;
    /**
     * 景物点位置
     */
    public POINTCOORDINATE stuPoint;
    /**
     * 一级标题名称
     */
    public byte[] szTitleName = new byte[MAX_COMMON_STRING_64];
    /**
     * 一级标题名称类型
     */
    public byte byTitleType;
    /**
     * 预留字节
     */
    public byte[] byReserved = new byte[3];
    /**
     * 景物形状 {@link NET_EM_SHAPE_TYPE}
     */
    public int emShapeType;
    /**
     * 景物的轮廓,每个点依次表示轮廓顶点坐标
     */
    public NetSDKLib.DH_POINT[] stuPolygon = new NetSDKLib.DH_POINT[NET_MAX_POLYGON_NUM];
    /**
     * 景物轮廓点的个数，最大不超过 {@link NetSDKLib#NET_MAX_POLYGON_NUM}
     */
    public int nPolygonPointNum;

    public NET_IN_SCENICSPOT_SETPOINTINFO_INFO() {
        dwSize = this.size();
        for (int i = 0; i < stuPolygon.length; i++) {
            stuPolygon[i] = new NetSDKLib.DH_POINT();
        }
    }
}
