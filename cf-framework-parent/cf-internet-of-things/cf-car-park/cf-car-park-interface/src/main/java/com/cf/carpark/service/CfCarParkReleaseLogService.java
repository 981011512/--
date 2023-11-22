package com.cf.carpark.service;

import com.cf.carpark.domain.CfCarParkReleaseLog;
import com.cf.carpark.domain.CfCarParkReleaseLogExample;
import com.cf.carpark.domain.CfCarParkUseLog;
import com.cf.carpark.domain.request.CfCarParkReleaseLogQuery;
import com.cf.framework.domain.report.CountByKeyAndValue;

import java.util.List;
import java.util.Map;

/**
 * 车辆放行记录管理服务
 */
public interface CfCarParkReleaseLogService {

    CfCarParkReleaseLog add(CfCarParkReleaseLog cfCarParkReleaseLog, String redisPreFix) throws Exception;

    String getDeviceLinkLocalServerIp(String sn) throws Exception;

    CfCarParkReleaseLog update(CfCarParkReleaseLog cfCarParkReleaseLog);

    /**
     * 更新放行记录中对应的redis数据缓存
     * @param cfCarParkReleaseLog
     * @param redisPreFix
     */
    void updateRedisCache(CfCarParkReleaseLog cfCarParkReleaseLog, String redisPreFix);

    Integer delete(String id);

    Integer deleteByQuery(CfCarParkReleaseLogQuery cfCarParkReleaseLogQuery);

    CfCarParkReleaseLog findById(String id);

    CfCarParkReleaseLog findById(String id, boolean exceptEmpty);

    CfCarParkReleaseLogExample getExampleByQuery(CfCarParkReleaseLogQuery cfCarParkReleaseLogQuery);

    List<CfCarParkReleaseLog> getListByQuery(CfCarParkReleaseLogQuery cfCarParkReleaseLogQuery);

    Integer getCountByQuery(CfCarParkReleaseLogQuery cfCarParkReleaseLogQuery);

    /**
     * 根据条件查询放行记录数据列表
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public List<CfCarParkReleaseLog> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 根据条件查询放行记录数据列表数
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    public Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 监听放行
     * @param deviceSerialNumber 硬件序列号
     * @param deviceBrand 硬件品牌
     * @return
     */
    public Map<String, Object> releaseMonitoring(String deviceSerialNumber, String deviceBrand);

    /**
     * 移除redis中放行代码
     * @param redisPreFix
     * @param cfCarParkReleaseLog
     */
    void cleanReleaseRedis(String redisPreFix, CfCarParkReleaseLog cfCarParkReleaseLog);

    /**
     * 移除redis中抓拍代码
     * @param redisPreFix
     */
    void cleanCaptureRedis(String redisPreFix);

    /**
     * 执行开闸
     * @param cfCarParkReleaseLog
     * @param deviceBrand
     * @param channel   通道
     * @return
     */
    public Object executeRelease(CfCarParkReleaseLog cfCarParkReleaseLog, String deviceBrand, Integer channel);

    /**
     * 相机抓拍
     * @param sn    相机序列号
     * @param deviceBrand
     * @param channel   通道
     * @return
     */
    public Object capture(String sn, String deviceBrand, Integer channel);

    /**
     * 给指定停车记录放行
     * @param cfCarParkUseLog
     * @param applicationReason
     * @param type
     * @return
     */
    CfCarParkReleaseLog executeReleaseByCarParkUseLog(CfCarParkUseLog cfCarParkUseLog, String applicationReason, byte type) throws Exception;

    /**
     * 统计N天前的放行次数，并按倒序排序
     * @param day
     * @param carParkIds
     * @return
     */
    List<CountByKeyAndValue> countAndOrder(Integer day, List<String> carParkIds);

}
