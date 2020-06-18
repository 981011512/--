package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfRole;
import com.cf.ucenter.domain.CfRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfRoleMapper {
    int countByExample(CfRoleExample example);

    int deleteByExample(CfRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfRole record);

    int insertSelective(CfRole record);

    List<CfRole> selectByExample(CfRoleExample example);

    CfRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfRole record, @Param("example") CfRoleExample example);

    int updateByExample(@Param("record") CfRole record, @Param("example") CfRoleExample example);

    int updateByPrimaryKeySelective(CfRole record);

    int updateByPrimaryKey(CfRole record);

    List<CfRole> selectContainDepartmentByUid(String uid);

    List<CfRole> selectContainDepartment();
}