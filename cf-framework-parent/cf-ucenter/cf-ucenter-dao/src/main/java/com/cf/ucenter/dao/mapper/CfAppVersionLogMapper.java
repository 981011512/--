package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfAppVersionLog;
import com.cf.ucenter.domain.CfAppVersionLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfAppVersionLogMapper {
    int countByExample(CfAppVersionLogExample example);

    int deleteByExample(CfAppVersionLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfAppVersionLog record);

    int insertSelective(CfAppVersionLog record);

    List<CfAppVersionLog> selectByExample(CfAppVersionLogExample example);

    CfAppVersionLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfAppVersionLog record, @Param("example") CfAppVersionLogExample example);

    int updateByExample(@Param("record") CfAppVersionLog record, @Param("example") CfAppVersionLogExample example);

    int updateByPrimaryKeySelective(CfAppVersionLog record);

    int updateByPrimaryKey(CfAppVersionLog record);
}