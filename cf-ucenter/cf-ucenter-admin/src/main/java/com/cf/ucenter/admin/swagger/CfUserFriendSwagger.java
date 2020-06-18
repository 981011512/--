package com.cf.ucenter.admin.swagger;

import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * 请在此填写描述
 *
 * @ClassName CfUserFriendAddLogSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/25/025 7:30
 * @Version 1.0
 **/
@Api(tags = {"好友管理"})
public interface CfUserFriendSwagger {
    @ApiOperation(value = "申请添加好友")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="uid",value = "要添加的用户id",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="remark",value = "添加好友备注",required=false,paramType="query",dataType="string",defaultValue = "")
    })
    public ResponseResult applyAddFriend(String uid, String remark);

    @ApiOperation(value = "申请添加群")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="group_id",value = "要添加的群id",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="remark",value = "添加群备注",required=false,paramType="query",dataType="string",defaultValue = "")
    })
    public ResponseResult applyAddGroup(String groupId, String remark);

    @ApiOperation(value = "获取我的好友申请列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="page",value = "页码最小值1",required=false,paramType="path",dataType="int",defaultValue = "1"),
            @ApiImplicitParam(name="limit",value = "每页条数(3-50)",required=false,paramType="path",dataType="int",defaultValue = "10")
    })
    public ResponseResult getMyFriendRequests(
            @Min(value = 1, message = "页码最小值1") Integer page,
            @Min(value = 3, message = "每页获取条数最小值3") @Max(value = 50, message = "每页获取条数最大值50") Integer limit);

    @ApiOperation(value = "处理好友申请")//String addLogId, String uid, Integer status
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="id",value = "好友申请记录id",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="status",value = "状态值",required=true,paramType="query",dataType="int")
    })
    public ResponseResult handleFriendsRequests(
            @NotEmpty(message = "请提供好友申请记录id") String id,
            @Min(value = 0, message = "状态值最小值0")
            @Max(value = 3, message = "状态值最大值3") Integer status);

    @ApiOperation(value = "获取我的好友列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="page",value = "页码最小值1",required=false,paramType="path",dataType="int",defaultValue = "1"),
            @ApiImplicitParam(name="limit",value = "每页条数(3-50)",required=false,paramType="path",dataType="int",defaultValue = "10")
    })
    public ResponseResult getMyFriends(
            @Min(value = 1, message = "页码最小值1") Integer page,
            @Min(value = 3, message = "每页获取条数最小值3") @Max(value = 50, message = "每页获取条数最大值50") Integer limit);
}
