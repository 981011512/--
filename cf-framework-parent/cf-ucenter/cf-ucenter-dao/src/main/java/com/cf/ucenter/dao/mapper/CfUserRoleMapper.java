package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfUserRole;
import com.cf.ucenter.domain.CfUserRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfUserRoleMapper {
    int countByExample(CfUserRoleExample example);

    int deleteByExample(CfUserRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfUserRole record);

    int insertSelective(CfUserRole record);

    List<CfUserRole> selectByExample(CfUserRoleExample example);

    CfUserRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfUserRole record, @Param("example") CfUserRoleExample example);

    int updateByExample(@Param("record") CfUserRole record, @Param("example") CfUserRoleExample example);

    int updateByPrimaryKeySelective(CfUserRole record);

    int updateByPrimaryKey(CfUserRole record);

    Integer batchInsert(List<CfUserRole> cfUserRoles);
}