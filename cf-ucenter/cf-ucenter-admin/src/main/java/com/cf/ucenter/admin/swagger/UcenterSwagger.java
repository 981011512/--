package com.cf.ucenter.admin.swagger;

import com.cf.framework.domain.response.ResponseResult;
import com.cf.ucenter.domain.CfUser;
import com.cf.ucenter.request.CfUserForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import javax.validation.constraints.*;

/**
 * 请在此填写描述
 *
 * @ClassName UcenterSwagger
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/21/021 14:57
 * @Version 1.0
 **/
@Api(tags = {"用户常规业务模块"})
public interface UcenterSwagger {
    @ApiOperation(value = "创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="phone",value = "手机号",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name="sms_code",value = "短信验证码",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "string"),
            @ApiImplicitParam(name="password",value = "密码",required=true,paramType="query",dataType="string"),
            @ApiImplicitParam(name = "nick_name", value = "昵称", required = true, paramType = "query", dataType = "string")
    })
    public ResponseResult create(
            @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))[0-9]{8}$", message = "手机号不合法") String phone,
            @NotEmpty String smsCode,
            @Pattern(regexp = "^[a-zA-Z0-9_]{5,32}$", message = "用户名长度5-32位") String userName,
            @Size(min = 10, max = 32, message = "密码长度10-32位") String password,
            @Size(min = 1, max = 20, message = "昵称长度1-20位") String nickName);

    @ApiOperation(value = "根据手机号/用户id/用户名查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name = "key", value = "搜索关键字", required = true, paramType = "query", dataType = "string")
    })
    public ResponseResult findByKey(
            @Pattern(regexp = "^[a-zA-Z0-9_]{1,64}$", message = "关键字长度1-64位") String key);

    @ApiOperation(value = "根据用户id获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name = "uid", value = "用户id", required = true, paramType = "query", dataType = "string")
    })
    public ResponseResult findById(String uid);

    @ApiOperation(value = "获取我的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult getMyInfo();

    @ApiOperation(value = "根据条件查询用户数据列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string"),
            @ApiImplicitParam(name="conditions",
                    value = "条件,例子{\"id\":{\"operator\":\"=\",\"value\":200},\"province_id\":{\"operator\":\"between\",\"min\":200,\"max\":300},\"order\":" +
                            "{\"operator\":\"order\",\"list\":{\"id\":{\"type\":\"DESC\",\"alias\":\"cp\"},\"country_id\":{\"type\":\"ASC\",\"alias\":\"cp\"}}}," +
                            "\"limit\":{\"operator\":\"limit\",\"page\":1,\"limit\":10},\"like\":{\"operator\":\"like\",\"list\":{\"name\":{\"0\":{\"value\":\"绿地国博\"," +
                            "\"alias\":\"cp\"},\"1\":{\"value\":\"财富中心\",\"alias\":\"cp\"}},\"country_id\":{\"0\":{\"value\":\"1111\",\"alias\":\"cp\"},\"1\":{\"value\":\"2222\"," +
                            "\"alias\":\"cp\"}}}}}解析出的sql为：SELECT cp.* FROM cf_car_park cp WHERE cp.id=200 AND cp.province_id>=200 AND cp.province_id<=300 AND (cp.name LIKE '%绿地国博%'" +
                            " OR cp.name LIKE '%财富中心%')  AND (cp.country_id LIKE '%1111%' OR cp.country_id LIKE '%2222%') ORDER BY cp.id DESC,cp.country_id ASC LIMIT 0,10",
                    required=true,paramType="query",dataType="string")
    })
    public ResponseResult selectListByCondition(String conditions);

    @ApiOperation(value = "更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult update(CfUserForm cfUserForm);

    @ApiOperation(value = "创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="authorization",value = "jwt串(请加\"Bearer \"前缀，注意有空格)",required=true,paramType="header",dataType="string")
    })
    public ResponseResult add(CfUserForm cfUserForm);

}
