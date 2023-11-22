package com.cf.logistics.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.logistics.domain.request.CfLogisticsTaskForm;
import com.cf.logistics.domain.request.CfLogisticsTaskQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"物流任务接口"})
public interface CfLogisticsTaskSwagger {

    @ApiOperation(value = "根据Query条件查询数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult selectListByQuery(CfLogisticsTaskQuery cfLogisticsTaskQuery) throws Exception;

    @ApiOperation(value = "司机创建任务")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult driverCreateTask(CfLogisticsTaskForm cfLogisticsTaskForm) throws Exception;

}
