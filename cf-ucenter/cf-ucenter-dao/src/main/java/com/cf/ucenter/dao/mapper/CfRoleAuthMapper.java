package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfRoleAuth;
import com.cf.ucenter.domain.CfRoleAuthExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfRoleAuthMapper {
    int countByExample(CfRoleAuthExample example);

    int deleteByExample(CfRoleAuthExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfRoleAuth record);

    int insertSelective(CfRoleAuth record);

    List<CfRoleAuth> selectByExample(CfRoleAuthExample example);

    CfRoleAuth selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfRoleAuth record, @Param("example") CfRoleAuthExample example);

    int updateByExample(@Param("record") CfRoleAuth record, @Param("example") CfRoleAuthExample example);

    int updateByPrimaryKeySelective(CfRoleAuth record);

    int updateByPrimaryKey(CfRoleAuth record);

    int batchInsert(List<CfRoleAuth> cfRoleAuths);
}