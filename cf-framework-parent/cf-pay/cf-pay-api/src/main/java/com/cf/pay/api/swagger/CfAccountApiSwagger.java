package com.cf.pay.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.pay.domain.CfScoreType;
import com.cf.pay.domain.request.CfAccountQuery;
import com.cf.pay.domain.request.CfCouponQuery;
import com.cf.pay.domain.request.CfScoreTypeQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@Api(tags = {"资金账户"})
public interface CfAccountApiSwagger {

    @ApiOperation(value = "我的资金账户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
    })
    public ResponseResult myAccountList(CfAccountQuery cfAccountQuery) throws Exception;

    @ApiOperation(value = "客户端积分充值")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    ResponseResult customerCheckAndAddBalanceByQuery(HttpServletRequest httpServletRequest, @RequestBody CfAccountQuery cfAccountQuery) throws Exception;

    @ApiOperation(value = "根据条件获取积分类型列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    ResponseResult getScoreTypeListByQuery(CfScoreTypeQuery cfScoreTypeQuery) throws Exception;

}
