package com.cf.charging.dao.mapper;

import com.cf.charging.domain.CfChargingStationDeviceType;
import com.cf.charging.domain.CfChargingStationDeviceTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfChargingStationDeviceTypeMapper {
    int countByExample(CfChargingStationDeviceTypeExample example);

    int deleteByExample(CfChargingStationDeviceTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfChargingStationDeviceType record);

    int insertSelective(CfChargingStationDeviceType record);

    List<CfChargingStationDeviceType> selectByExample(CfChargingStationDeviceTypeExample example);

    CfChargingStationDeviceType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfChargingStationDeviceType record, @Param("example") CfChargingStationDeviceTypeExample example);

    int updateByExample(@Param("record") CfChargingStationDeviceType record, @Param("example") CfChargingStationDeviceTypeExample example);

    int updateByPrimaryKeySelective(CfChargingStationDeviceType record);

    int updateByPrimaryKey(CfChargingStationDeviceType record);
}