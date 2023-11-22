package com.cf.ucenter.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName CfAppVersionLogSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/25/025 7:30
 * @Version 1.0
 **/
@Api(tags = {"APP版本发行管理"})
public interface CfAppVersionLogSwagger {

    @ApiOperation(value = "app新版本检测")
    @ApiImplicitParams({
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="platform",value = "操作系统平台",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="versionNumber",value = "自己当前应用版本号",required=true,paramType="query",dataType="string")
    })
    public ResponseResult checkVersion(String platform, String versionNumber);

}
