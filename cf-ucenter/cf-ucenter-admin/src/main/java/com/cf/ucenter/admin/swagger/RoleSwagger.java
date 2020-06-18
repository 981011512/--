package com.cf.ucenter.admin.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.request.CfRoleForm;
import com.cf.ucenter.request.CfUserForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 角色相关
 *
 * @ClassName RoleSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/21/021 14:57
 * @Version 1.0
 **/
@Api(tags = {"角色管理模块"})
public interface RoleSwagger {

    @ApiOperation(value = "角色列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult list();

    @ApiOperation(value = "添加角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult add(CfRoleForm cfRoleForm);

    @ApiOperation(value = "更新角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult update(CfRoleForm cfRoleForm);

    @ApiOperation(value = "删除角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult delete(String id);

}
