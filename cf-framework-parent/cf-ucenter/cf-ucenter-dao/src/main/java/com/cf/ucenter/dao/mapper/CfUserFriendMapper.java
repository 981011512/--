package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.domain.CfUserFriend;
import com.cf.ucenter.domain.CfUserFriendExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfUserFriendMapper {
    int countByExample(CfUserFriendExample example);

    int deleteByExample(CfUserFriendExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfUserFriend record);

    int insertSelective(CfUserFriend record);

    List<CfUserFriend> selectByExample(CfUserFriendExample example);

    CfUserFriend selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfUserFriend record, @Param("example") CfUserFriendExample example);

    int updateByExample(@Param("record") CfUserFriend record, @Param("example") CfUserFriendExample example);

    int updateByPrimaryKeySelective(CfUserFriend record);

    int updateByPrimaryKey(CfUserFriend record);

    List<CfUser> selectListByUid(@Param("uid") String uid, @Param("page") Integer page, @Param("limit") Integer limit);
}