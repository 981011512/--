package com.cf.position.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"地区管理"})
public interface CfAreasSwagger {
    @ApiOperation(value = "获取所有地区")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult selectAll();

    @ApiOperation(value = "根据等级和父级id")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="level",value = "级别",required=true,paramType="query",dataType="int"),
            @ApiImplicitParam(name="parentId",value = "父级id",paramType="query",dataType="string",defaultValue = ""),
    })
    public ResponseResult selectByLevelAndParentId(Integer level, String parentId);
}
