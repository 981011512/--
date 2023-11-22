package com.cf.charging.service;

import com.cf.charging.domain.CfChargingStation;
import com.cf.charging.domain.CfChargingStationExample;
import com.cf.charging.domain.request.CfChargingStationQuery;

import java.util.List;
import java.util.Map;

/**
 * 充电站管理服务
 */
public interface CfChargingStationService {

    CfChargingStation add(CfChargingStation cfChargingStation);

    CfChargingStation update(CfChargingStation cfChargingStation);

    Integer updateByQuery(CfChargingStation cfChargingStation, CfChargingStationQuery cfChargingStationQuery);

    Integer delete(String id);

    CfChargingStation findById(String id);

    CfChargingStation findById(String id, boolean expectEmty);

    CfChargingStationExample getExampleByQuery(CfChargingStationQuery cfChargingStationQuery);

    List<CfChargingStation> getListByQuery(CfChargingStationQuery cfChargingStationQuery);

    Integer countByQuery(CfChargingStationQuery cfChargingStationQuery);

    /**
     * 根据条件查询充电站数据列表
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    List<CfChargingStation> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 根据条件查询充电站数据列表数
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 查询附近充电站并返回其距离当前位置的距离(单位米)
     * @param cfChargingStationQuery
     * @return
     */
    List<CfChargingStation> selectContalDistanceListByQuery(CfChargingStationQuery cfChargingStationQuery) throws Exception;

    /**
     * 更新部分字段的值
     * @param cfChargingStation
     * @return
     */
    Integer increaseOrreduceFieldValue(CfChargingStation cfChargingStation);

}
