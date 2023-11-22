package com.cf.charging.dao.mapper;

import com.cf.charging.domain.CfChargingStationDevice;
import com.cf.charging.domain.CfChargingStationDeviceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfChargingStationDeviceMapper {
    int countByExample(CfChargingStationDeviceExample example);

    int deleteByExample(CfChargingStationDeviceExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfChargingStationDevice record);

    int insertSelective(CfChargingStationDevice record);

    List<CfChargingStationDevice> selectByExample(CfChargingStationDeviceExample example);

    CfChargingStationDevice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfChargingStationDevice record, @Param("example") CfChargingStationDeviceExample example);

    int updateByExample(@Param("record") CfChargingStationDevice record, @Param("example") CfChargingStationDeviceExample example);

    int updateByPrimaryKeySelective(CfChargingStationDevice record);

    int updateByPrimaryKey(CfChargingStationDevice record);
}