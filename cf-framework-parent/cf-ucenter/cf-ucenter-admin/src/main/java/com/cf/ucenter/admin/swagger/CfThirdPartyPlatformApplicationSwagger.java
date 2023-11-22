package com.cf.ucenter.admin.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.request.CfThirdPartyPlatformApplicationForm;
import com.cf.ucenter.request.CfThirdPartyPlatformApplicationQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 第三方相关
 *
 * @ClassName DepartmentSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2022/12/21/021 14:57
 * @Version 1.0
 **/
@Api(tags = {"第三方应用管理"})
public interface CfThirdPartyPlatformApplicationSwagger {

    @ApiOperation(value = "第三方应用列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult getListByQuery(CfThirdPartyPlatformApplicationQuery cfThirdPartyPlatformApplicationQuery);

    @ApiOperation(value = "添加第三方应用")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult add(CfThirdPartyPlatformApplicationForm cfThirdPartyPlatformApplicationForm);

    @ApiOperation(value = "更新第三方应用")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult update(CfThirdPartyPlatformApplicationForm cfThirdPartyPlatformApplicationForm);

    @ApiOperation(value = "删除第三方应用")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="appid",value = "数据id",required=true,paramType="query",dataType="string")
    })
    public ResponseResult delete(String appid);

}
