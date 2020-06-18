package com.cf.framework.domain.message.response;

import com.cf.framework.domain.response.ResultCode;

/**
 * 请在此填写描述
 *
 * @ClassName MessageCode
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/15/015 21:45
 * @Version 1.0
 **/
public enum MessageCode implements ResultCode {

    MESSAGE_NOT_EXISTSNAME(false,60001,"指定的消息记录不存在！"),
    NO_AUTH_UPDATE_MESSAGE(false,60002,"您无权操作此条消息数据！"),
    MESSAGE_UID_NOT_MATCH(false,60003,"消息发送者id与当前用户id不匹配！"),
    ;
    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private MessageCode(boolean success, int code, String message){
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
}
