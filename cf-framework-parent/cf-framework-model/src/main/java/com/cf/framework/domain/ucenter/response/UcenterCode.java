package com.cf.framework.domain.ucenter.response;

import com.cf.framework.domain.response.ResultCode;
import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;


/**
 * Created by admin on 2020/3/5.
 */
@ToString
public enum UcenterCode implements ResultCode {
    UCENTER_USERNAME_NONE(false,23001,"请输入账号！"),
    UCENTER_PASSWORD_NONE(false,23002,"请输入密码！"),
    UCENTER_VERIFYCODE_NONE(false,23003,"请输入验证码！"),
    UCENTER_ACCOUNT_NOTEXISTS(false,23004,"账号不存在！"),
    UCENTER_CREDENTIAL_ERROR(false,23005,"账号或密码错误！"),
    UCENTER_LOGIN_ERROR(false,23006,"登陆过程出现异常请尝试重新操作！"),
    UCENTER_USERNAME_EXIST(false,23007,"用户名已经存在！"),
    UCENTER_PHONE_REGISTERED(false,23008,"该手机号已经注册过了！"),
    UCENTER_EXIST(false,23009,"该用户已经存在！"),
    UCENTER_NOT_EXIST(false,23010,"指定的用户不存在！"),
    PHONE_IS_NOT_REGISTERED(false,23011,"手机未注册！"),
    MISSING_WECHAT_CONFIGURATION(false,23012,"缺少微信配置！"),
    WECHAT_CONFIGURATION_DOES_NOT_EXIST(false,23013,"指定的微信配置不存在！"),
    SYSTEM_CONFIGURATION_DOES_NOT_EXIST(false,23014,"指定的系统配置不存在！"),
    CAPTCHA_NOT_MATCH(false,23015,"图形验证码不匹配！"),
    USER_ID_IS_ABNORMAL(false,23016,"用户证件异常！"),
    ID_NUMBER_IS_BOUND(false,23017,"证件号已绑定！"),
    INVALID_CALL_KEY(false,23018,"调用密钥无效！")
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
    private UcenterCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }
    private static final ImmutableMap<Integer, UcenterCode> CACHE;

    static {
        final ImmutableMap.Builder<Integer, UcenterCode> builder = ImmutableMap.builder();
        for (UcenterCode commonCode : values()) {
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

    String mixMessage;
    @Override
    public String mixMessage() {
        return mixMessage;
    }

    @Override
    public void setMixMessage(String _mixMessage) {
        this.mixMessage = _mixMessage;
    }
}
