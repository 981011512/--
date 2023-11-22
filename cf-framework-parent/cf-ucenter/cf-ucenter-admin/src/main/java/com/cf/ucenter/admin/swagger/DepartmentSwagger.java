package com.cf.ucenter.admin.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.request.CfDepartmentForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 部门相关
 *
 * @ClassName DepartmentSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/21/021 14:57
 * @Version 1.0
 **/
@Api(tags = {"部门管理"})
public interface DepartmentSwagger {

    @ApiOperation(value = "部门列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult list();

    @ApiOperation(value = "添加部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult add(CfDepartmentForm cfDepartmentForm);

    @ApiOperation(value = "更新部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult update(CfDepartmentForm cfDepartmentForm);

    @ApiOperation(value = "删除部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult delete(String id);

}
