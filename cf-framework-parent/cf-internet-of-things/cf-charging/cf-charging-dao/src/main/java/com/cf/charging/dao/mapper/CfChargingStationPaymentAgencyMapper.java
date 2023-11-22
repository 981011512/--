package com.cf.charging.dao.mapper;

import com.cf.charging.domain.CfChargingStationPaymentAgency;
import com.cf.charging.domain.CfChargingStationPaymentAgencyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfChargingStationPaymentAgencyMapper {
    int countByExample(CfChargingStationPaymentAgencyExample example);

    int deleteByExample(CfChargingStationPaymentAgencyExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfChargingStationPaymentAgency record);

    int insertSelective(CfChargingStationPaymentAgency record);

    List<CfChargingStationPaymentAgency> selectByExample(CfChargingStationPaymentAgencyExample example);

    CfChargingStationPaymentAgency selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfChargingStationPaymentAgency record, @Param("example") CfChargingStationPaymentAgencyExample example);

    int updateByExample(@Param("record") CfChargingStationPaymentAgency record, @Param("example") CfChargingStationPaymentAgencyExample example);

    int updateByPrimaryKeySelective(CfChargingStationPaymentAgency record);

    int updateByPrimaryKey(CfChargingStationPaymentAgency record);
}