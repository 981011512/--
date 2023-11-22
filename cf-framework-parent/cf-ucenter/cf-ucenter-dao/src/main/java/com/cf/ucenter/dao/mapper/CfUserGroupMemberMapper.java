package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfUserGroupMember;
import com.cf.ucenter.domain.CfUserGroupMemberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfUserGroupMemberMapper {
    int countByExample(CfUserGroupMemberExample example);

    int deleteByExample(CfUserGroupMemberExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfUserGroupMember record);

    int insertSelective(CfUserGroupMember record);

    List<CfUserGroupMember> selectByExample(CfUserGroupMemberExample example);

    CfUserGroupMember selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfUserGroupMember record, @Param("example") CfUserGroupMemberExample example);

    int updateByExample(@Param("record") CfUserGroupMember record, @Param("example") CfUserGroupMemberExample example);

    int updateByPrimaryKeySelective(CfUserGroupMember record);

    int updateByPrimaryKey(CfUserGroupMember record);
}