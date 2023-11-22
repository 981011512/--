package com.cf.charging.dao.mapper;

import com.cf.charging.domain.CfChargingStationDeviceLinkUser;
import com.cf.charging.domain.CfChargingStationDeviceLinkUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfChargingStationDeviceLinkUserMapper {
    int countByExample(CfChargingStationDeviceLinkUserExample example);

    int deleteByExample(CfChargingStationDeviceLinkUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfChargingStationDeviceLinkUser record);

    int insertSelective(CfChargingStationDeviceLinkUser record);

    List<CfChargingStationDeviceLinkUser> selectByExample(CfChargingStationDeviceLinkUserExample example);

    CfChargingStationDeviceLinkUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfChargingStationDeviceLinkUser record, @Param("example") CfChargingStationDeviceLinkUserExample example);

    int updateByExample(@Param("record") CfChargingStationDeviceLinkUser record, @Param("example") CfChargingStationDeviceLinkUserExample example);

    int updateByPrimaryKeySelective(CfChargingStationDeviceLinkUser record);

    int updateByPrimaryKey(CfChargingStationDeviceLinkUser record);

    Integer batchAdd(String batchSQL);
}