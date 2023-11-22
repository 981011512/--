package com.cf.carpark.admin.swagger;

import com.cf.carpark.domain.request.CfCarParkPackageLogQuery;
import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"套餐修改记录管理"})
public interface CfCarParkPackageLogSwagger {

    @ApiOperation(value = "根据条件获取套餐操作记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    ResponseResult selectByQuery(CfCarParkPackageLogQuery cfCarParkPackageLogQuery) throws Exception;

}
