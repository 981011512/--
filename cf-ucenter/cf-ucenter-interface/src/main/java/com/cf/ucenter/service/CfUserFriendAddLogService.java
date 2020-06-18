package com.cf.ucenter.service;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.domain.CfUserFriend;
import com.cf.ucenter.domain.CfUserFriendAddLog;
import com.cf.ucenter.domain.CfUserGroup;

/**
 * 请在此填写描述
 *
 * @ClassName CfUserFriendAddLogService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/25/025 7:25
 * @Version 1.0
 **/
public interface CfUserFriendAddLogService {

    /**
     * 申请添加好友
     * @param fromUid
     * @param toUid
     * @param remark
     * @return
     */
    public ResponseResult applyAddFriend(String fromUid, String toUid, String remark);

    /**
     * 申请添加群
     * @param fromUid
     * @param groupId
     * @param remark
     * @return
     */
    public ResponseResult applyAddGroup(String fromUid, String groupId, String remark);

    /**
     * 获取指定用户好友申请列表
     * @param uid
     * @param page
     * @param limit
     * @return
     */
    public ResponseResult getFriendRequestsByUid(String uid, Integer page, Integer limit);

    /**
     * 处理好友请求
     * @param addLogId
     * @param uid 当前处理人id
     * @param status
     * @return
     */
    public ResponseResult handleFriendsRequests(String addLogId, String uid, Integer status);

    /**
     * 通知
     * @param cfUserGroup
     * @param cfUserFriendAddLog
     */
    public void noticeLordAndAdministratorAddGroupMessage(CfUserGroup cfUserGroup, CfUserFriendAddLog cfUserFriendAddLog);

}
