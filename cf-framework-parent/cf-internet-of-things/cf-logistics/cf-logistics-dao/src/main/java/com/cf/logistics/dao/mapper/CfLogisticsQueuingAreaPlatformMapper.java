package com.cf.logistics.dao.mapper;

import com.cf.logistics.domain.CfLogisticsQueuingAreaPlatform;
import com.cf.logistics.domain.CfLogisticsQueuingAreaPlatformExample;
import com.cf.logistics.domain.request.CfLogisticsQueuingAreaPlatformQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfLogisticsQueuingAreaPlatformMapper {
    int countByExample(CfLogisticsQueuingAreaPlatformExample example);

    int deleteByExample(CfLogisticsQueuingAreaPlatformExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfLogisticsQueuingAreaPlatform record);

    int insertSelective(CfLogisticsQueuingAreaPlatform record);

    List<CfLogisticsQueuingAreaPlatform> selectByExample(CfLogisticsQueuingAreaPlatformExample example);

    CfLogisticsQueuingAreaPlatform selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfLogisticsQueuingAreaPlatform record, @Param("example") CfLogisticsQueuingAreaPlatformExample example);

    int updateByExample(@Param("record") CfLogisticsQueuingAreaPlatform record, @Param("example") CfLogisticsQueuingAreaPlatformExample example);

    int updateByPrimaryKeySelective(CfLogisticsQueuingAreaPlatform record);

    int updateByPrimaryKey(CfLogisticsQueuingAreaPlatform record);

    List<CfLogisticsQueuingAreaPlatform> selectByQuery(CfLogisticsQueuingAreaPlatformQuery cfLogisticsQueuingAreaPlatformQuery);
}