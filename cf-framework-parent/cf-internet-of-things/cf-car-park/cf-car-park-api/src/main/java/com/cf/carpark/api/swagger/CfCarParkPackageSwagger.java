package com.cf.carpark.api.swagger;

import com.cf.carpark.domain.CfCarParkPackagePrice;
import com.cf.carpark.domain.request.BuyCfCarParkPackage;
import com.cf.carpark.domain.request.CfCarParkPackagePriceQuery;
import com.cf.carpark.domain.request.CfCarParkPackageQuery;
import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

/**
 * 请在此填写描述
 *
 * @ClassName CfCarParkPackageSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/23/023 20:32
 * @Version 1.0
 **/
@Api(tags = {"停车套餐相关"})
public interface CfCarParkPackageSwagger {

    @ApiOperation(value = "我的车辆套餐")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult getMyCarParkPackageByCondition(CfCarParkPackageQuery cfCarParkPackageQuery) throws Exception;

    @ApiOperation(value = "获取停车场的套餐列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult getCarParkPackagePriceByCondition(CfCarParkPackagePriceQuery cfCarParkPackagePriceQuery);

    @ApiOperation(value = "购买套餐")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult buyCfCarParkPackage(HttpServletRequest httpServletRequest, BuyCfCarParkPackage buyCfCarParkPackage) throws Exception;

    @ApiOperation(value = "续费套餐时查询该车辆是否存在临停费追缴")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult queryCfCarParkPackageRecoverFee(BuyCfCarParkPackage buyCfCarParkPackage) throws Exception;

    @ApiOperation(value = "套餐产品详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="cfCarParkPackagePriceId",value = "套餐id",required=true,paramType="query",dataType="string")
    })
    ResponseResult getCarParkPackagePriceDetail(HttpServletRequest httpServletRequest, String cfCarParkPackagePriceId) throws Exception ;

}
