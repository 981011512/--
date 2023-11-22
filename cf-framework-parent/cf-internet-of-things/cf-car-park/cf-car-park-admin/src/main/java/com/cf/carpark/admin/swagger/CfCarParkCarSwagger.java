package com.cf.carpark.admin.swagger;

import com.cf.carpark.domain.request.CfCarParkCarForm;
import com.cf.carpark.domain.request.CfCarParkCarQuery;
import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = {"车辆管理"})
public interface CfCarParkCarSwagger {

    @ApiOperation(value = "添加车辆")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult add(@RequestBody CfCarParkCarForm cfCarParkCarForm) throws Exception;

    @ApiOperation(value = "更新车辆")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult update(@RequestBody CfCarParkCarForm cfCarParkCarForm) throws Exception;

    @ApiOperation(value = "删除车辆")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult delete(String id) throws Exception;

    @ApiOperation(value = "根据Query查询车辆列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult getListByQuery(CfCarParkCarQuery cfCarParkCarQuery) throws Exception;
}
