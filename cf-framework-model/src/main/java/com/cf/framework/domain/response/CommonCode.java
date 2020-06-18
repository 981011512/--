package com.cf.framework.domain.response;

import lombok.ToString;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 18:33.
 * @Modified By:
 */

@ToString
public enum CommonCode implements ResultCode {
    INVALID_PARAM(false,10000,"非法参数！"),
    SUCCESS(true,10002,"操作成功！"),
    FAIL(false,10003,"操作失败！"),
    NO_MORE_DATAS(false,10004,"没有数据！"),
    UNAUTHENTICATED(false,10005,"此操作需要登陆系统！"),
    UNAUTHORISE(false,10006,"权限不足，无权操作！"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！");
//    private static ImmutableMap<Integer, CommonCode> codes ;
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private CommonCode(boolean success,int code, String message){
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
