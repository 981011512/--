package com.cf.logistics.dao.mapper;

import com.cf.logistics.domain.CfLogisticsCargoType;
import com.cf.logistics.domain.CfLogisticsCargoTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfLogisticsCargoTypeMapper {
    int countByExample(CfLogisticsCargoTypeExample example);

    int deleteByExample(CfLogisticsCargoTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfLogisticsCargoType record);

    int insertSelective(CfLogisticsCargoType record);

    List<CfLogisticsCargoType> selectByExample(CfLogisticsCargoTypeExample example);

    CfLogisticsCargoType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfLogisticsCargoType record, @Param("example") CfLogisticsCargoTypeExample example);

    int updateByExample(@Param("record") CfLogisticsCargoType record, @Param("example") CfLogisticsCargoTypeExample example);

    int updateByPrimaryKeySelective(CfLogisticsCargoType record);

    int updateByPrimaryKey(CfLogisticsCargoType record);
}