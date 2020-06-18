package com.cf.ucenter.dao.mapper;

import com.cf.ucenter.domain.CfUserFriendAddLog;
import com.cf.ucenter.domain.CfUserFriendAddLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CfUserFriendAddLogMapper {
    int countByExample(CfUserFriendAddLogExample example);

    int deleteByExample(CfUserFriendAddLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(CfUserFriendAddLog record);

    int insertSelective(CfUserFriendAddLog record);

    List<CfUserFriendAddLog> selectByExample(CfUserFriendAddLogExample example);

    CfUserFriendAddLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CfUserFriendAddLog record, @Param("example") CfUserFriendAddLogExample example);

    int updateByExample(@Param("record") CfUserFriendAddLog record, @Param("example") CfUserFriendAddLogExample example);

    int updateByPrimaryKeySelective(CfUserFriendAddLog record);

    int updateByPrimaryKey(CfUserFriendAddLog record);

    /**
     * 获取指定用户的好友申请列表
     * @param uid
     * @param page
     * @param limit
     * @return
     */
    List<CfUserFriendAddLog> getFriendRequestsByUid(@Param("uid") String uid,@Param("page")  Integer page,@Param("limit")  Integer limit);

    /**
     * 获取指定来往用户和指定状态好友申请列表
     * @param fromUid
     * @param toUid
     * @param page
     * @param limit
     * @return
     */
    List<CfUserFriendAddLog> getFriendRequestsByFidAndTidAndStatus(@Param("fromUid") String fromUid,@Param("toUid") String toUid,@Param("status") Integer status,@Param("page")  Integer page,@Param("limit")  Integer limit);

    /**
     * 获取指定申请用户与目标群以及指定状态好友申请列表
     * @param fromUid
     * @param groupId
     * @param page
     * @param limit
     * @return
     */
    List<CfUserFriendAddLog> getFriendRequestsByFidAndGidAndStatus(@Param("fromUid") String fromUid,@Param("groupId") String groupId,@Param("status") Integer status,@Param("page")  Integer page,@Param("limit")  Integer limit);

    /**
     * 改变状态
     * @param id
     * @param status
     * @return
     */
    int updateStatus(@Param("id") String id,@Param("status") Integer status);

    /**
     * 刷新创建时间
     * @param id
     * @return
     */
    int updateCreateTime(@Param("id") String id,@Param("createTime") Long createTime);
}