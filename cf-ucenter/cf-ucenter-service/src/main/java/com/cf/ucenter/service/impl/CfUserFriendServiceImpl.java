package com.cf.ucenter.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.friends.FriendsCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.ucenter.dao.mapper.CfUserFriendMapper;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.domain.CfUserFriend;
import com.cf.ucenter.domain.CfUserFriendExample;
import com.cf.ucenter.service.CfUserFriendService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0")
@Transactional
public class CfUserFriendServiceImpl implements CfUserFriendService {
    @Autowired
    private CfUserFriendMapper cfUserFriendMapper;
    @Override
    public ResponseResult addFriend(CfUserFriend cfUserFriend) {
        checkFriendship(cfUserFriend.getUid(), cfUserFriend.getFriendId(), true);
        cfUserFriend.setCreateTime(System.currentTimeMillis());
        cfUserFriendMapper.insert(cfUserFriend);
        return new ResponseResult(CommonCode.SUCCESS,cfUserFriend);
    }

    @Override
    public ResponseResult getMyFriendList(String uid, Integer page, Integer limit) {
        List<CfUser> cfUsers = cfUserFriendMapper.selectListByUid(uid, page-1, limit);
        return new ResponseResult(CommonCode.SUCCESS,cfUsers);
    }

    @Override
    public CfUserFriend getFriendByUidAndFriendId(String uid, String friendId) {
        CfUserFriendExample cfUserFriendExample = new CfUserFriendExample();
        cfUserFriendExample.createCriteria().andUidEqualTo(uid).andFriendIdEqualTo(friendId);
        List<CfUserFriend> cfUserFriends = cfUserFriendMapper.selectByExample(cfUserFriendExample);
        if(cfUserFriends==null || cfUserFriends.size()==0){
            return null;
        }
        return cfUserFriends.get(0);
    }

    @Override
    public CfUserFriend checkFriendship(String uid, String friendId, Boolean expectEmpty) {
        CfUserFriend cfUserFriend = getFriendByUidAndFriendId(uid,friendId);
        if(expectEmpty && cfUserFriend!=null){
            ExceptionCast.cast(FriendsCode.FRIENDS_EXIST);
            return null;
        }else if(!expectEmpty && cfUserFriend==null){
            ExceptionCast.cast(FriendsCode.FRIENDS_NOT_EXIST);
            return null;
        }
        return cfUserFriend;
    }
}
