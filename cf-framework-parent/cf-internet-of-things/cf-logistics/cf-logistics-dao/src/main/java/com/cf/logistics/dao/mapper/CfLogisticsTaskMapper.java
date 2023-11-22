package com.cf.logistics.dao.mapper;

import com.cf.logistics.domain.CfLogisticsTask;
import com.cf.logistics.domain.CfLogisticsTaskExample;
import com.cf.logistics.domain.request.CfLogisticsTaskQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfLogisticsTaskMapper {
    int countByExample(CfLogisticsTaskExample example);

    int deleteByExample(CfLogisticsTaskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfLogisticsTask record);

    int insertSelective(CfLogisticsTask record);

    List<CfLogisticsTask> selectByExample(CfLogisticsTaskExample example);

    CfLogisticsTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfLogisticsTask record, @Param("example") CfLogisticsTaskExample example);

    int updateByExample(@Param("record") CfLogisticsTask record, @Param("example") CfLogisticsTaskExample example);

    int updateByPrimaryKeySelective(CfLogisticsTask record);

    int updateByPrimaryKey(CfLogisticsTask record);

    List<CfLogisticsTask> selectListByQuery(CfLogisticsTaskQuery cfLogisticsTaskQuery);

    Integer updateReservedVehicles(@Param("id") Long id, @Param("changeValue") short changeValue);
}
