package com.cf.carpark.dao.mapper;

import com.cf.carpark.domain.CfCarParkReleaseLog;
import com.cf.carpark.domain.CfCarParkReleaseLogExample;
import com.cf.framework.domain.report.CountByKeyAndValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfCarParkReleaseLogMapper {
    int countByExample(CfCarParkReleaseLogExample example);

    int deleteByExample(CfCarParkReleaseLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfCarParkReleaseLog record);

    int insertSelective(CfCarParkReleaseLog record);

    List<CfCarParkReleaseLog> selectByExample(CfCarParkReleaseLogExample example);

    CfCarParkReleaseLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfCarParkReleaseLog record, @Param("example") CfCarParkReleaseLogExample example);

    int updateByExample(@Param("record") CfCarParkReleaseLog record, @Param("example") CfCarParkReleaseLogExample example);

    int updateByPrimaryKeySelective(CfCarParkReleaseLog record);

    int updateByPrimaryKey(CfCarParkReleaseLog record);

    /**
     * 根据条件查询放行记录数据列表
     * @param conditions
     * @return
     */
    List<CfCarParkReleaseLog> selectListByCondition(String conditions);

    /**
     * 根据条件查询放行记录数据列表数
     * @param conditions
     * @return
     */
    Integer selectListByConditionCounts(String conditions);

    /**
     * 更新(值为null的字段会被忽略掉)
     * @param record
     * @return
     */
    Integer update(CfCarParkReleaseLog record);

    /**
     * 统计N天前的放行次数，并按倒序排序
     * @param day
     * @return
     */
    List<CountByKeyAndValue> countAndOrder(@Param("day") Integer day, @Param("carParkIds") List<String> carParkIds);
}