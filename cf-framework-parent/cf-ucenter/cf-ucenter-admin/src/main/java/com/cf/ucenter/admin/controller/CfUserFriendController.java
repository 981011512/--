package com.cf.ucenter.admin.controller;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.framework.domain.ucenter.ext.UserBasicInfo;
import com.cf.framework.utils.HttpHearderUtils;
import com.cf.ucenter.admin.config.AuthenticationInterceptor;
import com.cf.ucenter.admin.swagger.CfUserFriendSwagger;
import com.cf.ucenter.service.CfUserFriendAddLogService;
import com.cf.ucenter.service.CfUserFriendService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * 请在此填写描述
 *
 * @ClassName CfUserFriendAddLogController
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/25/025 7:33
 * @Version 1.0
 **/
@RestController
@RequestMapping("friendsAdmin/")
@Validated
public class CfUserFriendController implements CfUserFriendSwagger {
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfUserFriendAddLogService cfUserFriendAddLogService;
    @Reference(version = "1.0.0", retries = 0, timeout = 30000, check = false)
    private CfUserFriendService cfUserFriendService;
    @Autowired
    protected HttpServletRequest request;

    @PreAuthorize("hasAuthority('ucenter-CfUserFriendController-applyAddFriend')")
    @Override
    @RequestMapping(value = "applyAddFriend", method = RequestMethod.POST)
    public ResponseResult applyAddFriend(@RequestParam("uid") String uid, @RequestParam(value = "remark",defaultValue = "",required = false) String remark) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        return cfUserFriendAddLogService.applyAddFriend(userBasicInfo.getId(),uid,remark);
    }

    @PreAuthorize("hasAuthority('ucenter-CfUserFriendController-applyAddGroup')")
    @Override
    @RequestMapping(value = "applyAddGroup", method = RequestMethod.POST)
    public ResponseResult applyAddGroup(@RequestParam("group_id") String groupId, @RequestParam(value = "remark",defaultValue = "",required = false) String remark) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        return cfUserFriendAddLogService.applyAddGroup(userBasicInfo.getId(),groupId,remark);
    }

    @PreAuthorize("hasAuthority('ucenter-CfUserFriendController-getMyFriendRequests')")
    @Override
    @RequestMapping(value = "getMyFriendRequests", method = RequestMethod.GET)
    public ResponseResult getMyFriendRequests(
            @RequestParam(value="page",defaultValue="1",required=false)
            @Min(value = 1,message = "页码最小值1")
                    Integer page,
            @RequestParam(value="limit",defaultValue="10",required=false)
            @Min(value = 3,message = "每页获取条数最小值3")
            @Max(value = 50,message = "每页获取条数最大值50")
                    Integer limit) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        return cfUserFriendAddLogService.getFriendRequestsByUid(userBasicInfo.getId(), page, limit);
    }

    @PreAuthorize("hasAuthority('ucenter-CfUserFriendController-handleFriendsRequests')")
    @Override
    @RequestMapping(value = "handleFriendsRequests", method = RequestMethod.PUT)
    public ResponseResult handleFriendsRequests(
            @RequestParam(value="id")
            @NotEmpty(message = "请提供好友申请记录id") String id,
            @RequestParam(value="status")
            @Min(value = 0,message = "状态值最小值0")
            @Max(value = 3,message = "状态值最大值3") Integer status) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        return cfUserFriendAddLogService.handleFriendsRequests(id,userBasicInfo.getId(),status);
    }

    @PreAuthorize("hasAuthority('ucenter-CfUserFriendController-getMyFriends')")
    @Override
    @RequestMapping(value = "getMyFriends", method = RequestMethod.GET)
    public ResponseResult getMyFriends(
            @RequestParam(value="page",defaultValue="1",required=false)
            @Min(value = 1, message = "页码最小值1") Integer page,
            @RequestParam(value="limit",defaultValue="10",required=false)
            @Min(value = 3, message = "每页获取条数最小值3")
            @Max(value = 50, message = "每页获取条数最大值50") Integer limit) throws Exception {
        UserBasicInfo userBasicInfo = AuthenticationInterceptor.parseJwt(HttpHearderUtils.getAuthorization(request));
        return cfUserFriendService.getMyFriendList(userBasicInfo.getId(), page, limit);
    }
}
