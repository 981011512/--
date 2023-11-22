package com.cf.carpark.admin.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.pay.domain.CfOrder;
import com.cf.pay.domain.request.CfCountFinanceQuery;
import com.cf.pay.domain.request.CfOrderQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

/**
 * 请在此填写描述
 *
 * @ClassName CfCarParkOrderSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/5/005 15:39
 * @Version 1.0
 **/
@Api(tags = {"停车订单管理"})
public interface CfCarParkOrderSwagger {

    @ApiOperation(value = "根据停车记录id查询订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="id",value = "停车记录id",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="mode",value = "模式(realTime-实时/static-静态)",required=false,paramType="query",dataType="string", defaultValue = "realTime"),
    })
    public ResponseResult queryOrderByUseId(String id, String mode) throws Exception;

    /**
     * 根据停车记录id获取对应的订单数据
     * @param carParkUseLogId
     * @return
     */
    public CfOrder getOrderByCarUseLogId(String carParkUseLogId);

    @ApiOperation(value = "统计指定日期订单金额")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    ResponseResult countByQuery(CfCountFinanceQuery cfCountFinanceQuery) throws Exception;
}
