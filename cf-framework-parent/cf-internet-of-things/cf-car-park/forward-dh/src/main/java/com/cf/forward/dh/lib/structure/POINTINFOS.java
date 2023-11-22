package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.cf.forward.dh.lib.enumeration.NET_EM_SHAPE_TYPE;

import static com.cf.forward.dh.lib.NetSDKLib.MAX_COMMON_STRING_64;
import static com.cf.forward.dh.lib.NetSDKLib.NET_MAX_POLYGON_NUM;

/**
 * PTZ景物点信息
 *
 * @author ： 47040
 * @since ： Created in 2020/10/26 15:56
 */
public class POINTINFOS extends NetSDKLib.SdkStructure {
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
     * 云台方向与放大倍数（第一个元素为水平角度，0~3600；第二个元素为垂直角度，-1800~1800；第三个元素为放大倍数，0~127）
     */
    public POSTION stuPostion;
    /**
     * 景物点位置（使用相对坐标体系，取值均为0-8191在整个屏幕上的位置）
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
     * 景物形状 {@link NET_EM_SHAPE_TYPE }
     */
    public int emShapeType;
    /**
     * 景物的轮廓,每个点依次表示轮廓顶点坐标
     */
    public NetSDKLib.DH_POINT[] stuPolygon = new NetSDKLib.DH_POINT[NET_MAX_POLYGON_NUM];
    /**
     * 返回的景物轮廓顶点个数
     */
    public int nRetPolygonPointNum;
    /**
     * 保留字段
     */
    public byte[] byReserved1 = new byte[184];

    public POINTINFOS() {
        for (int i = 0; i < stuPolygon.length; i++) {
            stuPolygon[i] = new NetSDKLib.DH_POINT();
        }
    }
}
