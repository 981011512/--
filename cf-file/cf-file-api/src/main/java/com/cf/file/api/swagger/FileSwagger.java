package com.cf.file.api.swagger;

import com.cf.framework.domain.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Api(tags = {"文件模块"})
public interface FileSwagger {
    @ApiOperation(value = "文件上传")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="file",value = "文件",required=true,paramType="formData",dataType="file"),
//            @ApiImplicitParam(name="filetag",value = "文件标签",required=false,paramType="query",dataType="string",defaultValue = ""),
//            @ApiImplicitParam(name="businesskey",value = "文件业务key",required=true,paramType="query",dataType="string"),
//            @ApiImplicitParam(name="metadata",value = "文件元数据",required=false,paramType="query",dataType="string",defaultValue = ""),
//    })
    public ResponseResult upload(MultipartFile file,String filetag,String businesskey,String metadata);
}
