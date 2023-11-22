package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarParkDevice;
import com.cf.carpark.domain.CfCarParkDeviceExample;
import com.cf.carpark.domain.request.CfCarParkDeviceQuery;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;
import java.util.Map;

/**
 * 设备管理
 *
 * @ClassName CfCarParkDeviceService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/1/001 15:10
 * @Version 1.0
 **/
public interface CfCarParkDeviceService {

    /**
     * 根据id获取一条硬件数据
     * @param id
     * @return
     */
    public CfCarParkDevice findById(String id);

    public CfCarParkDevice findById(String id, Boolean expectEmpty);

    /**
     * 根据设备二维码(序列号)获取一条设备数据
     * @param barCode
     * @param expectEmpty
     * @return
     */
    public CfCarParkDevice findByCode(String barCode, Boolean expectEmpty);

    /**
     * 根据条件查询停车场硬件数据列表
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public List<CfCarParkDevice> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 根据条件查询停车场硬件数据列表数
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    public CfCarParkDevice add(CfCarParkDevice cfCarParkDevice);

    public Integer delete(String id);

    public Integer deleteByQuery(CfCarParkDeviceQuery cfCarParkDeviceQuery);

    public CfCarParkDevice update(CfCarParkDevice cfCarParkDevice);

    CfCarParkDevice updateByPrimaryKeySelective(CfCarParkDevice cfCarParkDevice);

    Integer updateByQuery(CfCarParkDevice cfCarParkDevice, CfCarParkDeviceQuery cfCarParkDeviceQuery);

    public CfCarParkDeviceExample getExampleByQuery(CfCarParkDeviceQuery cfCarParkDeviceQuery);

    public List<CfCarParkDevice> getListByQuery(CfCarParkDeviceQuery cfCarParkDeviceQuery);

    public Integer countByQuery(CfCarParkDeviceQuery cfCarParkDeviceQuery);

    /**
     * 更新设备最近上线时间
     * @param deviceSerialNumber
     */
    void updateLastOnLineTime(String deviceSerialNumber);

    void monitorDeviceStatus();

    /**
     * 处理连接
     * @param ctx
     * @param msg
     * @return
     */
    void handleLink(ChannelHandlerContext ctx, Object msg) throws Exception;

    /**
     * 控制地锁设备起降
     * @param action    操作 down-降落/up-升起
     * @param serialNumber
     */
    void controlledLockUpAndDown(String action, String serialNumber) throws Exception;

    /**
     * 检查当前设备是否在本机
     * @param serialNumber
     */
    String checkSameServer(String serialNumber) throws Exception;

    /**
     * 下发led广告
     * @param serialNumber
     * @param adList
     * @param validityPeriod 下发的内容有效期 默认为"临时-temporary"，permanent-永久
     * @throws Exception
     */
    void publishLedAd(String serialNumber, List<String> adList, String validityPeriod) throws Exception;

}
