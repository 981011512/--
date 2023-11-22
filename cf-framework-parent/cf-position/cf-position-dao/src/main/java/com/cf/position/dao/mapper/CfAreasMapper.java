package com.cf.position.dao.mapper;

import com.cf.position.domain.CfAreas;
import com.cf.position.domain.CfAreasExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfAreasMapper {
    int countByExample(CfAreasExample example);

    int deleteByExample(CfAreasExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfAreas record);

    int insertSelective(CfAreas record);

    List<CfAreas> selectByExample(CfAreasExample example);

    CfAreas selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfAreas record, @Param("example") CfAreasExample example);

    int updateByExample(@Param("record") CfAreas record, @Param("example") CfAreasExample example);

    int updateByPrimaryKeySelective(CfAreas record);

    int updateByPrimaryKey(CfAreas record);

    int getMaxLevelType();
}