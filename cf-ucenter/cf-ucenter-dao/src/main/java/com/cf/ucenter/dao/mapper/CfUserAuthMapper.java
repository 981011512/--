package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfUserAuth;
import com.cf.ucenter.domain.CfUserAuthExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfUserAuthMapper {
    int countByExample(CfUserAuthExample example);

    int deleteByExample(CfUserAuthExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfUserAuth record);

    int insertSelective(CfUserAuth record);

    List<CfUserAuth> selectByExample(CfUserAuthExample example);

    CfUserAuth selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfUserAuth record, @Param("example") CfUserAuthExample example);

    int updateByExample(@Param("record") CfUserAuth record, @Param("example") CfUserAuthExample example);

    int updateByPrimaryKeySelective(CfUserAuth record);

    int updateByPrimaryKey(CfUserAuth record);

    int batchInsert(List<CfUserAuth> cfUserAuths);
}