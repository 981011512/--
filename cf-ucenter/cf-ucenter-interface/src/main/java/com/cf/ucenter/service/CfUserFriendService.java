package com.cf.ucenter.service;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.domain.CfUserFriend;

/**
 * 请在此填写描述
 *
 * @ClassName CfUserFriendAddLogService
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/25/025 7:25
 * @Version 1.0
 **/
public interface CfUserFriendService {

    /**
     * 添加好友
     * @param cfUserFriend
     * @return
     */
    public ResponseResult addFriend(CfUserFriend cfUserFriend);

    /**
     * 获取我的好友列表
     * @param uid
     * @param page
     * @param limit
     * @return
     */
    public ResponseResult getMyFriendList(String uid, Integer page, Integer limit);

    /**
     * 根据用户id和朋友获取数据
     * @param uid
     * @return
     */
    public CfUserFriend getFriendByUidAndFriendId(String uid, String friendId);

    /**
     * 判断两个用户是否为好友关系
     * @param uid
     * @param friendId
     * @param expectEmpty 期望数据为空(true-若数据存在抛出已存在异常/false-若数据不存在则抛出数据不存在异常)
     */
    public CfUserFriend checkFriendship(String uid,String friendId, Boolean expectEmpty);

}
