package com.cf.framework.domain.ucenter.response;

import com.cf.framework.domain.response.ResultCode;
import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;


/**
 * Created by admin on 2018/3/5.
 */
@ToString
public enum AuthCode implements ResultCode {
    AUTH_USERNAME_NONE(false,24001,"请输入账号！"),
    AUTH_PASSWORD_NONE(false,24002,"请输入密码！"),
    AUTH_VERIFYCODE_NONE(false,24003,"请输入验证码！"),
    AUTH_ACCOUNT_NOTEXISTS(false,24004,"账号不存在！"),
    AUTH_CREDENTIAL_ERROR(false,24005,"账号或密码错误！"),
    AUTH_LOGIN_ERROR(false,24006,"登陆过程出现异常请尝试重新操作！"),
    AUTH_LOGIN_APPLYTOKEN_FAIL(false,24007,"申请令牌失败！"),
    AUTH_LOGIN_TOKEN_SAVEFAIL(false,24008,"存储令牌失败！"),
    AUTH_LOGIN_TOKEN_ILLEGAL(false,24009,"非法的身份令牌！"),
    AUTH_LOGIN_TOKEN_EXPIRED(false,24010,"身份信息已过期！"),
    AUTH_LOGOUT_FAIL(false,24011,"退出失败！"),
    AUTH_EXIST_SUBORDINATE(false,24012,"该权限存在下级，禁止删除！"),
    AUTH_MODULE_CONTROLLER_METHOD_FORMAT_ERROR(false,24013,"权限模块-控制器-方法格式错误！"),
    AUTH_EXIST_SUBORDINATE_FORBID_MOVE(false,24014,"该权限存在下级，禁止移动！"),
    HAVE_NOT_USER_AUTH(false,24015,"请提供用户权限列表！"),
    INSUFFICIENT_PERMISSIONS(false,24016,"权限不足！")
    ;

    //操作代码
    @ApiModelProperty(value = "操作是否成功", example = "true", required = true)
    boolean success;

    //操作代码
    @ApiModelProperty(value = "操作代码", example = "22001", required = true)
    int code;
    //提示信息
    @ApiModelProperty(value = "操作提示", example = "操作过于频繁！", required = true)
    String message;
    private AuthCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }
    private static final ImmutableMap<Integer, AuthCode> CACHE;

    static {
        final ImmutableMap.Builder<Integer, AuthCode> builder = ImmutableMap.builder();
        for (AuthCode commonCode : values()) {
            builder.put(commonCode.code(), commonCode);
        }
        CACHE = builder.build();
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public void setMessage(String _message) {
        this.message = _message;
    }
}
