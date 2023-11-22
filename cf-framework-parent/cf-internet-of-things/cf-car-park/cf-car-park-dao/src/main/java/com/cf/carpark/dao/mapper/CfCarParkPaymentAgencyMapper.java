package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkPaymentAgency;
import com.cf.carpark.domain.CfCarParkPaymentAgencyExample;
import com.cf.carpark.domain.request.CfCarParkPaymentAgencyQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkPaymentAgencyMapper {
    int countByExample(CfCarParkPaymentAgencyExample example);

    int deleteByExample(CfCarParkPaymentAgencyExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkPaymentAgency record);

    int insertSelective(CfCarParkPaymentAgency record);

    List<CfCarParkPaymentAgency> selectByExample(CfCarParkPaymentAgencyExample example);

    CfCarParkPaymentAgency selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkPaymentAgency record, @Param("example") CfCarParkPaymentAgencyExample example);

    int updateByExample(@Param("record") CfCarParkPaymentAgency record, @Param("example") CfCarParkPaymentAgencyExample example);

    int updateByPrimaryKeySelective(CfCarParkPaymentAgency record);

    int updateByPrimaryKey(CfCarParkPaymentAgency record);

    List<CfCarParkPaymentAgency> selectByQuery(CfCarParkPaymentAgencyQuery cfCarParkPaymentAgencyQuery);
}