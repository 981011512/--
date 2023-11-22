package com.cf.framework.domain.pay;

import com.cf.framework.domain.response.ResultCode;

/**
 * 支付
 *
 * @ClassName AccountCode
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2021/12/15/015 21:45
 * @Version 1.0
 **/
public enum AccountCode implements ResultCode {

    ACCOUNT_NOT_EXIST(false,13000,"指定的资金账户不存在！"),
    ACCOUNT_INSUFFICIENT_BALANCE(false,13001,"资金账户余额不足！"),
    MISS_SOCRE_TYPE_OR_UID(false,13002,"未指定资金账户积分类型或用户！"),
    SCORE_TYPE_NOT_EXIST(false,13003,"指定的积分类型不存在！"),
    ;
    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private AccountCode(boolean success, int code, String message){
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
