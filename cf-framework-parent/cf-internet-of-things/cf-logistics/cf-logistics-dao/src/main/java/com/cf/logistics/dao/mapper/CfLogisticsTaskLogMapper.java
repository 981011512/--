package com.cf.logistics.dao.mapper;

import com.cf.logistics.domain.CfLogisticsTaskLog;
import com.cf.logistics.domain.CfLogisticsTaskLogExample;
import com.cf.logistics.domain.request.CfLogisticsTaskLogQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfLogisticsTaskLogMapper {
    int countByExample(CfLogisticsTaskLogExample example);

    int deleteByExample(CfLogisticsTaskLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfLogisticsTaskLog record);

    int insertSelective(CfLogisticsTaskLog record);

    List<CfLogisticsTaskLog> selectByExample(CfLogisticsTaskLogExample example);

    CfLogisticsTaskLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfLogisticsTaskLog record, @Param("example") CfLogisticsTaskLogExample example);

    int updateByExample(@Param("record") CfLogisticsTaskLog record, @Param("example") CfLogisticsTaskLogExample example);

    int updateByPrimaryKeySelective(CfLogisticsTaskLog record);

    int updateByPrimaryKey(CfLogisticsTaskLog record);

    List<CfLogisticsTaskLog> selectListByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery);

    List<CfLogisticsTaskLog> selectDeliverListByQuery(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery);

    Integer increaseQueueIndex(CfLogisticsTaskLogQuery cfLogisticsTaskLogQuery);
}