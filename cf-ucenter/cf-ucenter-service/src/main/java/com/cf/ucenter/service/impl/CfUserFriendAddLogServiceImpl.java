package com.cf.ucenter.service.impl;

import com.cf.chat.domain.CfUserMessage;
import com.cf.chat.service.CfUserMessageService;
import com.cf.framework.domain.response.CommonCode;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.friends.FriendsCode;
import com.cf.framework.exception.ExceptionCast;
import com.cf.framework.utils.IdWorker;
import com.cf.ucenter.dao.mapper.CfUserFriendAddLogMapper;
import com.cf.ucenter.dao.mapper.CfUserGroupMemberMapper;
import com.cf.ucenter.domain.*;
import com.cf.ucenter.service.CfUserFriendAddLogService;
import com.cf.ucenter.service.CfUserFriendService;
import com.cf.ucenter.service.CfUserGroupService;
import com.cf.ucenter.service.CfUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 请在此填写描述
 *
 * @ClassName CfUserFriendAddLogServiceImpl
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/25/025 7:25
 * @Version 1.0
 **/
@Service(version = "1.0.0")
@Transactional
public class CfUserFriendAddLogServiceImpl implements CfUserFriendAddLogService {
    @Autowired
    private CfUserFriendAddLogMapper cfUserFriendAddLogMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CfUserFriendService cfUserFriendService;
    @Autowired
    private CfUserService cfUserService;
    @Autowired
    private CfUserGroupService cfUserGroupService;
    @Autowired
    private CfUserGroupMemberMapper cfUserGroupMemberMapper;
    @Reference(version = "1.0.0", retries = 0, timeout = 10000, check = false)
    private CfUserMessageService cfUserMessageService;

    @Override
    public ResponseResult applyAddFriend(String fromUid, String toUid, String remark) {

        cfUserService.checkUserExistByUid(toUid,false);
        cfUserFriendService.checkFriendship(fromUid,toUid,true);
        List<CfUserFriendAddLog> cfUserFriendAddLogs = cfUserFriendAddLogMapper.getFriendRequestsByFidAndTidAndStatus(fromUid, toUid, 0, 0, 1);
        if(cfUserFriendAddLogs!=null && cfUserFriendAddLogs.size()>0){
            cfUserFriendAddLogMapper.updateCreateTime(cfUserFriendAddLogs.get(0).getId(),System.currentTimeMillis());
            return new ResponseResult(CommonCode.SUCCESS);
        }
        if(fromUid.equals(toUid)){
            ExceptionCast.cast(FriendsCode.FRIENDS_CAN_NOT_ADD_SELF);
        }
        int insert = cfUserFriendAddLogMapper.insert(new CfUserFriendAddLog(idWorker.nextId(),fromUid,toUid,"",System.currentTimeMillis(),0,remark,1));
        if(insert>0){
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    @Override
    public ResponseResult applyAddGroup(String fromUid, String groupId, String remark) {
        CfUserGroup cfUserGroup = cfUserGroupService.checkGroupExistById(groupId, false);
        cfUserGroupService.checkUserInTheGroup(fromUid,groupId,true);
        List<CfUserFriendAddLog> cfUserFriendAddLogs = cfUserFriendAddLogMapper.getFriendRequestsByFidAndGidAndStatus(fromUid, groupId, 0, 0, 1);
        if(cfUserFriendAddLogs!=null && cfUserFriendAddLogs.size()>0){
            cfUserFriendAddLogMapper.updateCreateTime(cfUserFriendAddLogs.get(0).getId(),System.currentTimeMillis());
            return new ResponseResult(CommonCode.SUCCESS);
        }
        noticeLordAndAdministratorAddGroupMessage(cfUserGroup, new CfUserFriendAddLog(null, fromUid, "", groupId, System.currentTimeMillis(), 0, remark, 1));
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @Override
    public ResponseResult getFriendRequestsByUid(String uid, Integer page, Integer limit) {
        List<CfUserFriendAddLog> cfUserFriendAddLogs = cfUserFriendAddLogMapper.getFriendRequestsByUid(uid,(page-1)*limit,limit);
        if(cfUserFriendAddLogs!=null && cfUserFriendAddLogs.size()>0){
            return new ResponseResult(CommonCode.SUCCESS,cfUserFriendAddLogs);
        }
        return new ResponseResult(CommonCode.NO_MORE_DATAS);
    }

    @Override
    public ResponseResult handleFriendsRequests(String addLogId, String uid, Integer status) {
        CfUserFriendAddLog cfUserFriendAddLog = cfUserFriendAddLogMapper.selectByPrimaryKey(addLogId);
        if(cfUserFriendAddLog==null){
            ExceptionCast.cast(FriendsCode.FRIENDS_ADD_LOG_NOT_EXIST);
        }
        if(cfUserFriendAddLog.getStatus()!=0){
            ExceptionCast.cast(FriendsCode.FRIENDS_ADD_LOG_STATUS_CHANGED);
        }
        if(!cfUserFriendAddLog.getToUid().equals(uid)){
            ExceptionCast.cast(FriendsCode.FRIENDS_ADD_LOG_UID_NO_MATCH);
        }
        if (status == 1 && StringUtils.isEmpty(cfUserFriendAddLog.getGroupId())) {
            cfUserService.checkUserExistByUid(cfUserFriendAddLog.getToUid(), false);
            //添加双向好友
            cfUserFriendService.addFriend(new CfUserFriend(idWorker.nextId(), uid, cfUserFriendAddLog.getFromUid(), null));
            cfUserMessageService.sendMessage(new CfUserMessage(idWorker.nextId(), cfUserFriendAddLog.getFromUid(), uid,
                    "", 0, "我通过了你的好友请求，现在我们可以开始聊天了。", 0, "", "", System.currentTimeMillis(), 0L));
            cfUserFriendService.addFriend(new CfUserFriend(idWorker.nextId(), cfUserFriendAddLog.getFromUid(), uid, null));
            cfUserMessageService.sendMessage(new CfUserMessage(idWorker.nextId(), uid, cfUserFriendAddLog.getFromUid(),
                    "", 0, "我通过了你的好友请求，现在我们可以开始聊天了。", 0, "", "", System.currentTimeMillis(), 0L));
        } else if (status == 1 && StringUtils.isNotEmpty(cfUserFriendAddLog.getGroupId())) {
            cfUserGroupService.checkGroupExistById(cfUserFriendAddLog.getGroupId(), false);
            cfUserGroupService.checkGroupAdministrator(cfUserFriendAddLog.getGroupId(), uid);
            //添加群成员
            cfUserGroupService.addGroupmember(new CfUserGroupMember(idWorker.nextId(), cfUserFriendAddLog.getGroupId(),
                    cfUserFriendAddLog.getFromUid(), 0, "", 1, System.currentTimeMillis(), 1, 0L
            ));
            cfUserMessageService.sendMessage(new CfUserMessage(idWorker.nextId(), "", cfUserFriendAddLog.getFromUid(),
                    cfUserFriendAddLog.getGroupId(), 0, "欢迎加入本群，给大家打个招呼吧", 0, "", "", System.currentTimeMillis(), 0L));
        }
        cfUserFriendAddLogMapper.updateStatus(addLogId,status);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @Override
    public void noticeLordAndAdministratorAddGroupMessage(CfUserGroup cfUserGroup, CfUserFriendAddLog cfUserFriendAddLog) {
        cfUserFriendAddLog.setId(idWorker.nextId());
        cfUserFriendAddLog.setGroupId(cfUserGroup.getId());
        cfUserFriendAddLog.setToUid(cfUserGroup.getCreaterId());
        cfUserFriendAddLogMapper.insert(cfUserFriendAddLog);
        CfUserGroupMemberExample cfUserGroupMemberExample = new CfUserGroupMemberExample();
        cfUserGroupMemberExample.createCriteria().andGroupIdEqualTo(cfUserGroup.getId()).andLevelEqualTo(1).andStatusEqualTo(1);
        List<CfUserGroupMember> cfUserGroupMembers = cfUserGroupMemberMapper.selectByExample(cfUserGroupMemberExample);
        if(cfUserGroupMembers!=null){
            for(CfUserGroupMember cfUserGroupMember: cfUserGroupMembers){
                cfUserFriendAddLog.setId(idWorker.nextId());
                cfUserFriendAddLog.setToUid(cfUserGroupMember.getUid());
                cfUserFriendAddLogMapper.insert(cfUserFriendAddLog);
            }
        }
    }
}
