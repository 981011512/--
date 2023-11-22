package com.cf.charging.service;

import com.cf.charging.domain.CfChargingUseLog;
import com.cf.charging.domain.CfChargingUseLogExample;
import com.cf.charging.domain.request.CfChargingUseLogQuery;

import java.util.List;
import java.util.Map;

/**
 * 充电记录服务
 */
public interface CfChargingUseLogService {

    CfChargingUseLog add(CfChargingUseLog cfChargingUseLog);

    CfChargingUseLog update(CfChargingUseLog cfChargingUseLog);

    Integer delete(String id);

    CfChargingUseLogExample getExampleByQuery(CfChargingUseLogQuery cfChargingUseLogQuery);

    List<CfChargingUseLog> getListByQuery(CfChargingUseLogQuery cfChargingUseLogQuery);

    /**
     * 根据query条件进行查询(会联表查询停电站信息)
     * @param cfChargingUseLogQuery
     * @return
     */
    List<CfChargingUseLog> selectListByQuery(CfChargingUseLogQuery cfChargingUseLogQuery);

    CfChargingUseLog findById(String id);

    CfChargingUseLog findById(String id, boolean expectEmpty);

    Integer countByQuery(CfChargingUseLogQuery cfChargingUseLogQuery);

    /**
     * 根据条件查询充电记录数据列表
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    List<CfChargingUseLog> selectListByCondition(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds) throws Exception;

    /**
     * 根据条件查询充电记录数据列表数
     * @param conditions example {"字段名":"表别名"}
     * @param allowFiledsMap example {"字段名":"表别名"}
     * @param allowFileds example {"字段名"}
     * @return
     */
    Integer selectListByConditionCounts(Map<String, Map<String, Object>> conditions, Map<String, String> allowFiledsMap, List<String> allowFileds);

    /**
     * 根据序列号查询该设备正在充电中的 充电记录
     * @param SerialNumber  设备序列号
     * @param port  充电口
     * @return
     */
    CfChargingUseLog getCharingUseLogByDevcieSerialNumber(String SerialNumber, String port);

}
