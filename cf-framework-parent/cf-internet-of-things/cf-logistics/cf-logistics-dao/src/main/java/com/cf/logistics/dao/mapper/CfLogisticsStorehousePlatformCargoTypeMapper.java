package com.cf.logistics.dao.mapper;

import com.cf.logistics.domain.CfLogisticsStorehousePlatformCargoType;
import com.cf.logistics.domain.CfLogisticsStorehousePlatformCargoTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfLogisticsStorehousePlatformCargoTypeMapper {
    int countByExample(CfLogisticsStorehousePlatformCargoTypeExample example);

    int deleteByExample(CfLogisticsStorehousePlatformCargoTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfLogisticsStorehousePlatformCargoType record);

    int insertSelective(CfLogisticsStorehousePlatformCargoType record);

    List<CfLogisticsStorehousePlatformCargoType> selectByExample(CfLogisticsStorehousePlatformCargoTypeExample example);

    CfLogisticsStorehousePlatformCargoType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfLogisticsStorehousePlatformCargoType record, @Param("example") CfLogisticsStorehousePlatformCargoTypeExample example);

    int updateByExample(@Param("record") CfLogisticsStorehousePlatformCargoType record, @Param("example") CfLogisticsStorehousePlatformCargoTypeExample example);

    int updateByPrimaryKeySelective(CfLogisticsStorehousePlatformCargoType record);

    int updateByPrimaryKey(CfLogisticsStorehousePlatformCargoType record);
}