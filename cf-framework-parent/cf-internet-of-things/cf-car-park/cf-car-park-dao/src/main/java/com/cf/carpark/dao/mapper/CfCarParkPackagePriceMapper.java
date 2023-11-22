package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkPackagePrice;
import com.cf.carpark.domain.CfCarParkPackagePriceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkPackagePriceMapper {
    int countByExample(CfCarParkPackagePriceExample example);

    int deleteByExample(CfCarParkPackagePriceExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkPackagePrice record);

    int insertSelective(CfCarParkPackagePrice record);

    List<CfCarParkPackagePrice> selectByExample(CfCarParkPackagePriceExample example);

    CfCarParkPackagePrice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkPackagePrice record, @Param("example") CfCarParkPackagePriceExample example);

    int updateByExample(@Param("record") CfCarParkPackagePrice record, @Param("example") CfCarParkPackagePriceExample example);

    int updateByPrimaryKeySelective(CfCarParkPackagePrice record);

    int updateByPrimaryKey(CfCarParkPackagePrice record);

    /**
     * 根据条件查询车辆套餐数据列表
     * @param conditions
     * @return
     */
    List<CfCarParkPackagePrice> selectListByCondition(String conditions);

    /**
     * 根据条件查询车辆套餐数据列表数
     * @param conditions
     * @return
     */
    Integer selectListByConditionCounts(String conditions);

    /**
     * 根据id获取详情(返回包含名字)
     * @param id
     * @return
     */
    CfCarParkPackagePrice findByIdContainName(String id);
}