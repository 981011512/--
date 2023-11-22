package com.cf.framework.domain.sms.response;

import com.cf.framework.domain.response.ResultCode;

/**
 * 请在此填写描述
 *
 * @ClassName MessageCode
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/15/015 21:45
 * @Version 1.0
 **/
public enum SmsCode implements ResultCode {

    SMS_SEND_FREQUENTLY(false,80001,"频繁发送！"),
    SMS_CODE_INVALID(false,80002,"无效的短信验证码！"),
    CHECKING_TOO_FREQUENTLY(false,80003,"校验太频繁，请稍后再试！"),
    PHONE_NUMBER_MISSING(false,80004,"缺少手机号！")
    ;
    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private SmsCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
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
