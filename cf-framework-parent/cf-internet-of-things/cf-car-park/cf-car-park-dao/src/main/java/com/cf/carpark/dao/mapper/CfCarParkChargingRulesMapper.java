package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkChargingRules;
import com.cf.carpark.domain.CfCarParkChargingRulesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkChargingRulesMapper {
    int countByExample(CfCarParkChargingRulesExample example);

    int deleteByExample(CfCarParkChargingRulesExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkChargingRules record);

    int insertSelective(CfCarParkChargingRules record);

    List<CfCarParkChargingRules> selectByExample(CfCarParkChargingRulesExample example);

    CfCarParkChargingRules selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkChargingRules record, @Param("example") CfCarParkChargingRulesExample example);

    int updateByExample(@Param("record") CfCarParkChargingRules record, @Param("example") CfCarParkChargingRulesExample example);

    int updateByPrimaryKeySelective(CfCarParkChargingRules record);

    int updateByPrimaryKey(CfCarParkChargingRules record);
}