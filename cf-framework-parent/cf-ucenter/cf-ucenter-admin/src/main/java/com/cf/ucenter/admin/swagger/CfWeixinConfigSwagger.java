package com.cf.ucenter.admin.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.request.CfWeixinConfigForm;
import com.cf.ucenter.request.CfWeixinConfigQuery;
import com.cf.ucenter.request.UnlimitedForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 微信配置相关
 *
 * @ClassName CfWeixinConfigSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/21/021 14:57
 * @Version 1.0
 **/
@Api(tags = {"微信配置管理"})
public interface CfWeixinConfigSwagger {

    @ApiOperation(value = "微信配置列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult list(CfWeixinConfigQuery cfWeixinConfigQuery);

    @ApiOperation(value = "添加微信配置")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult add(CfWeixinConfigForm cfWeixinConfigForm);

    @ApiOperation(value = "更新微信配置")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult update(CfWeixinConfigForm cfWeixinConfigForm);

    @ApiOperation(value = "删除微信配置")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult delete(String id);

    @ApiOperation(value = "获取微信小程序二维码")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    Object getUnlimited(UnlimitedForm unlimitedForm) throws Exception;

    @ApiOperation(value = "获取自定义的二维码")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string"),
            @ApiImplicitParam(name="path",value = "创建自定义的二维码",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="width",value = "宽度",required=true,paramType="query",dataType="int"),
            @ApiImplicitParam(name="height",value = "高度",required=true,paramType="query",dataType="int")
    })
    Object createSelfDefinedQrCode(String path, Integer width, Integer height) throws Exception;

    @ApiOperation(value = "获取海康的密钥")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="lang",value = "语言(zh-中文[默认]/en-英文...更多见官网文档)",required=false,paramType="header",dataType="string")
    })
    ResponseResult getHKAccessToken() throws Exception;

}
