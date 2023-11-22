package com.cf.charging.dao.mapper;

import com.cf.charging.domain.CfChargingUseLog;
import com.cf.charging.domain.CfChargingUseLogExample;
import com.cf.charging.domain.request.CfChargingUseLogQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfChargingUseLogMapper {
    int countByExample(CfChargingUseLogExample example);

    int deleteByExample(CfChargingUseLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfChargingUseLog record);

    int insertSelective(CfChargingUseLog record);

    List<CfChargingUseLog> selectByExample(CfChargingUseLogExample example);

    CfChargingUseLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfChargingUseLog record, @Param("example") CfChargingUseLogExample example);

    int updateByExample(@Param("record") CfChargingUseLog record, @Param("example") CfChargingUseLogExample example);

    int updateByPrimaryKeySelective(CfChargingUseLog record);

    int updateByPrimaryKey(CfChargingUseLog record);

    /**
     * 根据query条件进行查询(会联表查询停电站信息)
     * @param cfChargingUseLogQuery
     * @return
     */
    List<CfChargingUseLog> selectListByQuery(CfChargingUseLogQuery cfChargingUseLogQuery);

    /**
     * 根据条件查询充电记录数据列表
     * @param conditions
     * @return
     */
    List<CfChargingUseLog> selectListByCondition(String conditions);

    /**
     * 根据条件查询充电记录数据列表数
     * @param conditions
     * @return
     */
    Integer selectListByConditionCounts(String conditions);
}