package com.cf.carpark.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 请在此填写描述
 *
 * @ClassName CfCarParkCarTypeSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/23/023 21:59
 * @Version 1.0
 **/
@Api(tags = {"车辆类型(套餐类型)"})
public interface CfCarParkCarTypeSwagger {
    @ApiOperation(value = "获取车辆类型列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult getAllList();
}
