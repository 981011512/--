package com.cf.ucenter.service.impl;

import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.friends.FriendsCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.dao.mapper.CfUserGroupMapper;
import com.cf.ucenter.dao.mapper.CfUserGroupMemberMapper;
import com.cf.ucenter.domain.CfUserGroup;
import com.cf.ucenter.domain.CfUserGroupMember;
import com.cf.ucenter.domain.CfUserGroupMemberExample;
import com.cf.ucenter.service.CfUserGroupService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
public class CfUserGroupServiceImpl implements CfUserGroupService {
    @Autowired
    private CfUserGroupMapper cfUserGroupMapper;
    @Autowired
    private CfUserGroupMemberMapper cfUserGroupMemberMapper;
    @Autowired
    private IdWorker idWorker;

    @Override
    public ResponseResult createGroup(CfUserGroup cfUserGroup) {
        cfUserGroupMapper.insert(cfUserGroup);
        addGroupmember(new CfUserGroupMember(idWorker.nextId(),cfUserGroup.getId(),cfUserGroup.getCreaterId(),2,"",0,
            System.currentTimeMillis(),1,0L));
        return new ResponseResult(CommonCode.SUCCESS,cfUserGroup);
    }

    @Override
    public ResponseResult addGroupmember(CfUserGroupMember cfUserGroupMember) {
        cfUserGroupMemberMapper.insert(cfUserGroupMember);
        return new ResponseResult(CommonCode.SUCCESS,cfUserGroupMember);
    }

    @Override
    public CfUserGroup getGroupById(String groupId) {
        return cfUserGroupMapper.selectByPrimaryKey(groupId);
    }

    @Override
    public CfUserGroup checkGroupExistById(String groupId, Boolean expectEmpty) {
        CfUserGroup cfUserGroup = getGroupById(groupId);
        if(expectEmpty && cfUserGroup!=null){
            ExceptionCast.cast(FriendsCode.GROUP_NOT_EXIST);
            return null;
        }else if(!expectEmpty && cfUserGroup==null){
            ExceptionCast.cast(FriendsCode.GROUP_EXIST);
            return null;
        }
        return cfUserGroup;
    }

    @Override
    public void checkUserInTheGroup(String uid, String groupId, Boolean expectEmpty) {
        CfUserGroupMember cfUserGroupMember = getUserGroupMemberByGroupIdAndUid(groupId, uid);
        if (expectEmpty && cfUserGroupMember != null) {
            ExceptionCast.cast(FriendsCode.FRIENDS_EXIST);
        } else if (!expectEmpty && cfUserGroupMember == null) {
            ExceptionCast.cast(FriendsCode.FRIENDS_NOT_EXIST);
        }
    }

    @Override
    public void checkGroupAdministrator(String groupId, String uid) {
        CfUserGroupMember cfUserGroupMember = getUserGroupMemberByGroupIdAndUid(groupId, uid);
        if (cfUserGroupMember == null || cfUserGroupMember.getLevel() == 0) {
            ExceptionCast.cast(FriendsCode.GROUP_INVALID_ANDADMINISTRATOR);
        }
    }

    @Override
    public CfUserGroupMember getUserGroupMemberByGroupIdAndUid(String groupId, String uid) {
        CfUserGroupMemberExample cfUserGroupMemberExample = new CfUserGroupMemberExample();
        cfUserGroupMemberExample.createCriteria().andGroupIdEqualTo(groupId).andUidEqualTo(uid);
        List<CfUserGroupMember> cfUserGroupMembers = cfUserGroupMemberMapper.selectByExample(cfUserGroupMemberExample);
        if (cfUserGroupMembers != null && cfUserGroupMembers.size() > 0) {
            return cfUserGroupMembers.get(0);
        }
        return null;
    }

    @Override
    public List<CfUserGroupMember> getUserGroupMemberByGroupId(String groupId) {
        CfUserGroupMemberExample cfUserGroupMemberExample = new CfUserGroupMemberExample();
        cfUserGroupMemberExample.createCriteria().andGroupIdEqualTo(groupId);
        return cfUserGroupMemberMapper.selectByExample(cfUserGroupMemberExample);
    }
}
