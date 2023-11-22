package com.cf.logistics.dao.mapper;

import com.cf.logistics.domain.CfLogisticsStorehouse;
import com.cf.logistics.domain.CfLogisticsStorehouseExample;
import com.cf.logistics.domain.request.CfLogisticsStorehouseQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfLogisticsStorehouseMapper {
    int countByExample(CfLogisticsStorehouseExample example);

    int deleteByExample(CfLogisticsStorehouseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CfLogisticsStorehouse record);

    int insertSelective(CfLogisticsStorehouse record);

    List<CfLogisticsStorehouse> selectByExample(CfLogisticsStorehouseExample example);

    CfLogisticsStorehouse selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CfLogisticsStorehouse record, @Param("example") CfLogisticsStorehouseExample example);

    int updateByExample(@Param("record") CfLogisticsStorehouse record, @Param("example") CfLogisticsStorehouseExample example);

    int updateByPrimaryKeySelective(CfLogisticsStorehouse record);

    int updateByPrimaryKey(CfLogisticsStorehouse record);

    /**
     * 获取附近的物流仓库
     * @param cfLogisticsStorehouseQuery
     * @return
     */
    List<CfLogisticsStorehouse> selectNearLogisticsStorehouse(CfLogisticsStorehouseQuery cfLogisticsStorehouseQuery);

    /**
     * 根据Query条件查询仓库数据，会联表查询工厂数据
     * @param cfLogisticsStorehouseQuery
     * @return
     */
    List<CfLogisticsStorehouse> selectListByQuery(CfLogisticsStorehouseQuery cfLogisticsStorehouseQuery);
}