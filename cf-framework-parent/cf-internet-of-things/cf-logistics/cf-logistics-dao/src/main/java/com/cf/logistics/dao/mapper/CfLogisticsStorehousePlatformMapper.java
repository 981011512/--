package com.cf.logistics.dao.mapper;

import com.cf.logistics.domain.CfLogisticsStorehousePlatform;
import com.cf.logistics.domain.CfLogisticsStorehousePlatformExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfLogisticsStorehousePlatformMapper {
    int countByExample(CfLogisticsStorehousePlatformExample example);

    int deleteByExample(CfLogisticsStorehousePlatformExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfLogisticsStorehousePlatform record);

    int insertSelective(CfLogisticsStorehousePlatform record);

    List<CfLogisticsStorehousePlatform> selectByExample(CfLogisticsStorehousePlatformExample example);

    CfLogisticsStorehousePlatform selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfLogisticsStorehousePlatform record, @Param("example") CfLogisticsStorehousePlatformExample example);

    int updateByExample(@Param("record") CfLogisticsStorehousePlatform record, @Param("example") CfLogisticsStorehousePlatformExample example);

    int updateByPrimaryKeySelective(CfLogisticsStorehousePlatform record);

    int updateByPrimaryKey(CfLogisticsStorehousePlatform record);
}