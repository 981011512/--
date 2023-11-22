package com.cf.carpark.api.swagger;

import com.cf.carpark.domain.request.CfCarParkCheckpointQuery;
import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 请在此填写描述
 *
 * @ClassName CfCarParkCheckpointSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/23/023 21:59
 * @Version 1.0
 **/
@Api(tags = {"停车场出入口"})
public interface CfCarParkCheckpointSwagger {

    @ApiOperation(value = "获取附近或者指定停车场的出入口")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult selectNearbyCheckPoint(CfCarParkCheckpointQuery cfCarParkCheckpointQuery);

    @ApiOperation(value = "根据条件获取停车场出入口列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult getListByQuery(CfCarParkCheckpointQuery cfCarParkCheckpointQuery);
}
