package com.cf.ucenter.admin.swagger;

import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Api(tags = {"用户群组管理"})
public interface CfUserGroupSwagger {
    @ApiOperation(value = "创建群")
    @ApiImplicitParams({
        @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
        @ApiImplicitParam(name="name",value = "群名",required=true,paramType="query",dataType="string"),
        @ApiImplicitParam(name="people_cap",value = "群人数上限",required=true,paramType="query",dataType="int")
    })
    public ResponseResult createGroup(
            @NotEmpty String name,
            @Pattern(regexp = "^(200|500|1000|2000){1}$", message = "暂时只支持200|500|1000|2000人群") String peopleCap
    );
}
