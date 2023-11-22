package com.cf.logistics.dao.mapper;

import com.cf.logistics.domain.CfLogisticsQueue;
import com.cf.logistics.domain.CfLogisticsQueueExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfLogisticsQueueMapper {
    int countByExample(CfLogisticsQueueExample example);

    int deleteByExample(CfLogisticsQueueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfLogisticsQueue record);

    int insertSelective(CfLogisticsQueue record);

    List<CfLogisticsQueue> selectByExample(CfLogisticsQueueExample example);

    CfLogisticsQueue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfLogisticsQueue record, @Param("example") CfLogisticsQueueExample example);

    int updateByExample(@Param("record") CfLogisticsQueue record, @Param("example") CfLogisticsQueueExample example);

    int updateByPrimaryKeySelective(CfLogisticsQueue record);

    int updateByPrimaryKey(CfLogisticsQueue record);
}