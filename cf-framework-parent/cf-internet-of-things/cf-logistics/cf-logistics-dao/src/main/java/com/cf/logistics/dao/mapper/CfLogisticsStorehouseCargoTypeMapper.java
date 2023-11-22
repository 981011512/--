package com.cf.logistics.dao.mapper;

import com.cf.logistics.domain.CfLogisticsStorehouseCargoType;
import com.cf.logistics.domain.CfLogisticsStorehouseCargoTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfLogisticsStorehouseCargoTypeMapper {
    int countByExample(CfLogisticsStorehouseCargoTypeExample example);

    int deleteByExample(CfLogisticsStorehouseCargoTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfLogisticsStorehouseCargoType record);

    int insertSelective(CfLogisticsStorehouseCargoType record);

    List<CfLogisticsStorehouseCargoType> selectByExample(CfLogisticsStorehouseCargoTypeExample example);

    CfLogisticsStorehouseCargoType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfLogisticsStorehouseCargoType record, @Param("example") CfLogisticsStorehouseCargoTypeExample example);

    int updateByExample(@Param("record") CfLogisticsStorehouseCargoType record, @Param("example") CfLogisticsStorehouseCargoTypeExample example);

    int updateByPrimaryKeySelective(CfLogisticsStorehouseCargoType record);

    int updateByPrimaryKey(CfLogisticsStorehouseCargoType record);
}