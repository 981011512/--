package com.cf.charging.dao.mapper;

import com.cf.charging.domain.CfChargingStationRules;
import com.cf.charging.domain.CfChargingStationRulesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfChargingStationRulesMapper {
    int countByExample(CfChargingStationRulesExample example);

    int deleteByExample(CfChargingStationRulesExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfChargingStationRules record);

    int insertSelective(CfChargingStationRules record);

    List<CfChargingStationRules> selectByExample(CfChargingStationRulesExample example);

    CfChargingStationRules selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfChargingStationRules record, @Param("example") CfChargingStationRulesExample example);

    int updateByExample(@Param("record") CfChargingStationRules record, @Param("example") CfChargingStationRulesExample example);

    int updateByPrimaryKeySelective(CfChargingStationRules record);

    int updateByPrimaryKey(CfChargingStationRules record);
}