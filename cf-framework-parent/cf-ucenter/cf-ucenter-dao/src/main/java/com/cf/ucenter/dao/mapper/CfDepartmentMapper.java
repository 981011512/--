package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfDepartment;
import com.cf.ucenter.domain.CfDepartmentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfDepartmentMapper {
    int countByExample(CfDepartmentExample example);

    int deleteByExample(CfDepartmentExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfDepartment record);

    int insertSelective(CfDepartment record);

    List<CfDepartment> selectByExample(CfDepartmentExample example);

    CfDepartment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfDepartment record, @Param("example") CfDepartmentExample example);

    int updateByExample(@Param("record") CfDepartment record, @Param("example") CfDepartmentExample example);

    int updateByPrimaryKeySelective(CfDepartment record);

    int updateByPrimaryKey(CfDepartment record);
}