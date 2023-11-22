package com.cf.logistics.dao.mapper;

import com.cf.logistics.domain.CfLogisticsFactory;
import com.cf.logistics.domain.CfLogisticsFactoryExample;
import com.cf.logistics.domain.request.CfLogisticsFactoryQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfLogisticsFactoryMapper {
    int countByExample(CfLogisticsFactoryExample example);

    int deleteByExample(CfLogisticsFactoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfLogisticsFactory record);

    int insertSelective(CfLogisticsFactory record);

    List<CfLogisticsFactory> selectByExample(CfLogisticsFactoryExample example);

    CfLogisticsFactory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfLogisticsFactory record, @Param("example") CfLogisticsFactoryExample example);

    int updateByExample(@Param("record") CfLogisticsFactory record, @Param("example") CfLogisticsFactoryExample example);

    int updateByPrimaryKeySelective(CfLogisticsFactory record);

    int updateByPrimaryKey(CfLogisticsFactory record);

    /**
     * 获取附近的物流工厂
     * @param cfLogisticsFactoryQuery
     * @return
     */
    List<CfLogisticsFactory> selectNearLogisticsFactory(CfLogisticsFactoryQuery cfLogisticsFactoryQuery);
}