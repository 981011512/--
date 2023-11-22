package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkPackage;
import com.cf.carpark.domain.CfCarParkPackageExample;
import com.cf.carpark.domain.request.CfCarParkPackageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkPackageMapper {
    int countByExample(CfCarParkPackageExample example);

    int deleteByExample(CfCarParkPackageExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkPackage record);

    int insertSelective(CfCarParkPackage record);

    List<CfCarParkPackage> selectByExample(CfCarParkPackageExample example);

    CfCarParkPackage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkPackage record, @Param("example") CfCarParkPackageExample example);

    int updateByExample(@Param("record") CfCarParkPackage record, @Param("example") CfCarParkPackageExample example);

    int updateByPrimaryKeySelective(CfCarParkPackage record);

    int updateByPrimaryKey(CfCarParkPackage record);

    List<CfCarParkPackage> selectByExampleContainCarParkName(CfCarParkPackageExample example);

    /**
     * 根据条件查询车场套餐数据列表
     * @param conditions
     * @return
     */
    List<CfCarParkPackage> selectListByCondition(String conditions);

    /**
     * 根据条件查询车场套餐数据列表数
     * @param conditions
     * @return
     */
    Integer selectListByConditionCounts(String conditions);

    Integer batchAdd(String batchAddSQL);

    Integer batchBindUserByPhone(@Param("uid") String uid,@Param("phone") String phone);

    List<CfCarParkPackage> selectByQuery(CfCarParkPackageQuery cfCarParkPackageQuery);
}