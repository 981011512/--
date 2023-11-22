package com.cf.carpark.api.swagger;

import com.cf.carpark.domain.request.CfCarParkCarForm;
import com.cf.carpark.domain.request.CfCarParkCarQuery;
import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"车辆管理"})
public interface CfCarParkCarSwagger {

    @ApiOperation(value = "添加车辆")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult add(CfCarParkCarForm cfCarParkCarForm) throws Exception;

    @ApiOperation(value = "删除车辆")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult delete(String id) throws Exception;

    @ApiOperation(value = "我的车辆")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult getMyCarsByCondition(CfCarParkCarQuery cfCarParkCarQuery) throws Exception;
}
