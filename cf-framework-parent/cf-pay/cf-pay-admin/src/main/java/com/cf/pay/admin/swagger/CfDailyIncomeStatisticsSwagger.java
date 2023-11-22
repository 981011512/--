package com.cf.pay.admin.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.pay.domain.request.CfDailyIncomeStatisticsQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"财务收入统计"})
public interface CfDailyIncomeStatisticsSwagger {

    @ApiOperation(value = "根据Query条件搜索")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    public ResponseResult getListByQuery(CfDailyIncomeStatisticsQuery cfDailyIncomeStatisticsQuery)throws Exception;

    @ApiOperation(value = "生成或更新历史统计数据，统计对应年每个月的数据(慎用，请勿多次请求，超级耗线程)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="year",value = "年份，如果不传默认为当年",required=false,paramType="query",dataType="string")
    })
    public ResponseResult countYear(String year)throws Exception;

    @ApiOperation(value = "生成或更新历史统计对应月每天的数据(慎用，请勿多次请求，超级耗线程)")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="yearAndMonth",value = "年份-月份，如果不传默认为当年-当月，例如2023-03",required=false,paramType="query",dataType="string")
    })
    public ResponseResult countMonth(String yearAndMonth)throws Exception;

}
