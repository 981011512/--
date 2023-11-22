package com.cf.logistics.dao.mapper;

import com.cf.logistics.domain.CfLogisticsQueuingArea;
import com.cf.logistics.domain.CfLogisticsQueuingAreaExample;
import com.cf.logistics.domain.request.CfLogisticsQueuingAreaQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfLogisticsQueuingAreaMapper {
    int countByExample(CfLogisticsQueuingAreaExample example);

    int deleteByExample(CfLogisticsQueuingAreaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfLogisticsQueuingArea record);

    int insertSelective(CfLogisticsQueuingArea record);

    List<CfLogisticsQueuingArea> selectByExample(CfLogisticsQueuingAreaExample example);

    CfLogisticsQueuingArea selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfLogisticsQueuingArea record, @Param("example") CfLogisticsQueuingAreaExample example);

    int updateByExample(@Param("record") CfLogisticsQueuingArea record, @Param("example") CfLogisticsQueuingAreaExample example);

    int updateByPrimaryKeySelective(CfLogisticsQueuingArea record);

    int updateByPrimaryKey(CfLogisticsQueuingArea record);

    /**
     * 根据Query返回数据，会返回工厂信息
     * @param cfLogisticsQueuingAreaQuery
     * @return
     */
    List<CfLogisticsQueuingArea> selectListByQuery(CfLogisticsQueuingAreaQuery cfLogisticsQueuingAreaQuery);
}