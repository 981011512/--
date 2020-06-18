package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfUserGroup;
import com.cf.ucenter.domain.CfUserGroupExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfUserGroupMapper {
    int countByExample(CfUserGroupExample example);

    int deleteByExample(CfUserGroupExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfUserGroup record);

    int insertSelective(CfUserGroup record);

    List<CfUserGroup> selectByExampleWithBLOBs(CfUserGroupExample example);

    List<CfUserGroup> selectByExample(CfUserGroupExample example);

    CfUserGroup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfUserGroup record, @Param("example") CfUserGroupExample example);

    int updateByExampleWithBLOBs(@Param("record") CfUserGroup record, @Param("example") CfUserGroupExample example);

    int updateByExample(@Param("record") CfUserGroup record, @Param("example") CfUserGroupExample example);

    int updateByPrimaryKeySelective(CfUserGroup record);

    int updateByPrimaryKeyWithBLOBs(CfUserGroup record);

    int updateByPrimaryKey(CfUserGroup record);
}