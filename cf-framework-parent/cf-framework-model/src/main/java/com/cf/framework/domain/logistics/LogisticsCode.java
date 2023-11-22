package com.cf.framework.domain.logistics;

import com.cf.framework.domain.response.ResultCode;

/**
 * 二维码
 *
 * @ClassName LogisticsCode
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2022/07/15/015 21:45
 * @Version 1.0
 **/
public enum LogisticsCode implements ResultCode {
    REPEAT_APPOINTMENT(false,32000,"重复预约！"),
    APPOINTMENT_IS_FULL(false,32001,"预约已满！"),
    NOT_WITHIN_THE_APPOINTMENT_TIME_PERIOD(false,32002,"不在预约时间段内！"),
    APPOINTMENT_RECORD_DOES_NOT_BELONG_TO_YOU(false,32003,"该预约记录不属于您！"),
    CHECK_IN_IS_PROHIBITED(false,32004,"禁止签到操作！"),
    CAN_NOT_FIND_PLATFORM(false,32005,"找不到月台！"),
    CAN_NOT_FIND_QUEUING_AREA(false,32006,"找不到排队区！"),
    NOT_IN_LINE(false,32007,"未处在排队中！"),
    PROHIBIT_SWITCHING_ORDER(false,32008,"未处在排队中！"),
    ONLY_CHILD_DATA_CAN_BE_OPERATED(false,32009,"只能操作子级数据！"),
    TASK_SORT_INDEX_NOT_FOUND(false,32010,"找不到对应序号的任务数据！"),
    CARGO_TYPE_NOF_FOUND(false,32011,"指定的货物类型不存在！"),
    ;
    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private LogisticsCode(boolean success, int code, String message){
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
