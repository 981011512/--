package com.cf.ucenter.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.request.CfStaffForm;
import com.cf.ucenter.request.CfStaffQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"员工管理"})
public interface CfStaffSwagger {

    @ApiOperation(value = "雇主删除员工")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="id",value = "员工记录id",required=true,paramType="query",dataType="string")
    })
    ResponseResult employerDeleteStaff(String id) throws Exception;

    @ApiOperation(value = "雇主更新员工数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    ResponseResult employerUpdateStaff(CfStaffForm cfStaffForm) throws Exception;

    @ApiOperation(value = "雇主添加员工")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    ResponseResult employerAddStaff(CfStaffForm cfStaffForm) throws Exception;

    @ApiOperation(value = "获取我的员工")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    ResponseResult getMyStaffList(CfStaffQuery cfStaffQuery) throws Exception;

}
