package com.cf.charging.dao.mapper;

import com.cf.charging.domain.CfChargingStationLinkUser;
import com.cf.charging.domain.CfChargingStationLinkUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfChargingStationLinkUserMapper {
    int countByExample(CfChargingStationLinkUserExample example);

    int deleteByExample(CfChargingStationLinkUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfChargingStationLinkUser record);

    int insertSelective(CfChargingStationLinkUser record);

    List<CfChargingStationLinkUser> selectByExample(CfChargingStationLinkUserExample example);

    CfChargingStationLinkUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfChargingStationLinkUser record, @Param("example") CfChargingStationLinkUserExample example);

    int updateByExample(@Param("record") CfChargingStationLinkUser record, @Param("example") CfChargingStationLinkUserExample example);

    int updateByPrimaryKeySelective(CfChargingStationLinkUser record);

    int updateByPrimaryKey(CfChargingStationLinkUser record);
}