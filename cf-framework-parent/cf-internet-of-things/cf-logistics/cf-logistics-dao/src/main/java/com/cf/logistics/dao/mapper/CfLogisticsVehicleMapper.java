package com.cf.logistics.dao.mapper;

import com.cf.logistics.domain.CfLogisticsVehicle;
import com.cf.logistics.domain.CfLogisticsVehicleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfLogisticsVehicleMapper {
    int countByExample(CfLogisticsVehicleExample example);

    int deleteByExample(CfLogisticsVehicleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfLogisticsVehicle record);

    int insertSelective(CfLogisticsVehicle record);

    List<CfLogisticsVehicle> selectByExample(CfLogisticsVehicleExample example);

    CfLogisticsVehicle selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfLogisticsVehicle record, @Param("example") CfLogisticsVehicleExample example);

    int updateByExample(@Param("record") CfLogisticsVehicle record, @Param("example") CfLogisticsVehicleExample example);

    int updateByPrimaryKeySelective(CfLogisticsVehicle record);

    int updateByPrimaryKey(CfLogisticsVehicle record);
}