package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfSystemConfig;
import com.cf.ucenter.domain.CfSystemConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfSystemConfigMapper {
    int countByExample(CfSystemConfigExample example);

    int deleteByExample(CfSystemConfigExample example);

    int deleteByPrimaryKey(String enName);

    int insert(CfSystemConfig record);

    int insertSelective(CfSystemConfig record);

    List<CfSystemConfig> selectByExample(CfSystemConfigExample example);

    CfSystemConfig selectByPrimaryKey(String enName);

    int updateByExampleSelective(@Param("record") CfSystemConfig record, @Param("example") CfSystemConfigExample example);

    int updateByExample(@Param("record") CfSystemConfig record, @Param("example") CfSystemConfigExample example);

    int updateByPrimaryKeySelective(CfSystemConfig record);

    int updateByPrimaryKey(CfSystemConfig record);
}