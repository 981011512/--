package com.cf.framework.domain.ucenter.friends;

import com.cf.framework.domain.response.ResultCode;

/**
 * 请在此填写描述
 *
 * @ClassName MessageCode
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2019/12/15/015 21:45
 * @Version 1.0
 **/
public enum FriendsCode implements ResultCode {

    FRIENDS_ADD_LOG_NOT_EXIST(false,70001,"指定的好友申请记录不存在！"),
    FRIENDS_ADD_LOG_UID_NO_MATCH(false,70002,"该友好申请记录不属于您！"),
    FRIENDS_ADD_LOG_STATUS_CHANGED(false,70003,"该好友申请记录已处理过了！"),
    FRIENDS_CAN_NOT_ADD_SELF(false,70004,"不能添加自己为好友！"),
    FRIENDS_EXIST(false,70005,"好友已经存在！"),
    FRIENDS_NOT_EXIST(false,70006,"指定的好友不存在！"),
    GROUP_EXIST(false,70007,"群已经存在！"),
    GROUP_NOT_EXIST(false, 70008, "指定的群不存在！"),
    GROUP_INVALID_ANDADMINISTRATOR(false, 70009, "您不具备该群的管理！")
    ;
    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private FriendsCode(boolean success, int code, String message){
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
