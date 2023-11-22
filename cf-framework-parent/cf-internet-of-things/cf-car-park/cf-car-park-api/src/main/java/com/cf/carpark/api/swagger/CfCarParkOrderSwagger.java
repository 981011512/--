package com.cf.carpark.api.swagger;

import com.cf.carpark.domain.request.CfCarParkUseLogQuery;
import com.cf.carpark.domain.request.PayForCarUseLog;
import com.cf.framework.domain.response.ResponseResult;
import com.cf.pay.domain.CfOrder;
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
@Api(tags = {"停车订单"})
public interface CfCarParkOrderSwagger {

    @ApiOperation(value = "根据停车记录id查询订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="id",value = "停车记录id",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="couponId",value = "优惠券id",required=false,paramType="query",dataType="string"),
            @ApiImplicitParam(name="useCoupon",value = "是否使用优惠券(默认：是-yes)",required=false,paramType="query",dataType="string")
    })
    public ResponseResult queryOrderByUseId(String id, String couponId, String useCoupon) throws Exception;

    @ApiOperation(value = "支付停车费(date部分为null表示无须支付且已支付成功)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult payForCarUseLog(HttpServletRequest httpServletRequest, PayForCarUseLog payForCarUseLog) throws Exception;

    /**
     * 根据停车记录id获取对应的订单数据
     * @param carParkUseLogId
     * @return
     */
    public CfOrder getOrderByCarUseLogId(String carParkUseLogId);
}
