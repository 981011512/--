package com.cf.ucenter.service;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.domain.CfUserGroup;
import com.cf.ucenter.domain.CfUserGroupMember;

import java.util.List;

public interface CfUserGroupService {
    /**
     * 创建用户群
     * @param cfUserGroup
     * @return
     */
    public ResponseResult createGroup(CfUserGroup cfUserGroup);

    /**
     * 添加群成员
     * @param cfUserGroupMember
     * @return
     */
    public ResponseResult addGroupmember(CfUserGroupMember cfUserGroupMember);

    /**
     * 根据id获取指定群
     * @param groupId
     * @return
     */
    public CfUserGroup getGroupById(String groupId);

    /**
     * 根据群id判断群是否已经存在
     * @param groupId
     * @param expectEmpty 期望数据为空(true-若数据存在抛出已存在异常/false-若数据不存在则抛出数据不存在异常)
     */
    public CfUserGroup checkGroupExistById(String groupId, Boolean expectEmpty);

    /**
     * 检查某个用户是否属于某个群成员
     * @param uid
     * @param groupId
     * @param expectEmpty 期望数据为空(true-若数据存在抛出已存在异常/false-若数据不存在则抛出数据不存在异常)
     * @return
     */
    public void checkUserInTheGroup(String uid, String groupId, Boolean expectEmpty);

    /**
     * 验证指定用户是否为某群的群主或者管理员
     *
     * @param groupId
     * @param uid
     */
    public void checkGroupAdministrator(String groupId, String uid);

    /**
     * 根据群id和用户id获取用户在该群中的数据
     *
     * @param groupId
     * @param uid
     * @return
     */
    public CfUserGroupMember getUserGroupMemberByGroupIdAndUid(String groupId, String uid);

    /**
     * 获取某个群的所有群成员
     * @param groupId
     * @return
     */
    public List<CfUserGroupMember> getUserGroupMemberByGroupId(String groupId);
}
