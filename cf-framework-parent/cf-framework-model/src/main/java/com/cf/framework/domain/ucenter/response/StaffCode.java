package com.cf.framework.domain.ucenter.response;

import com.cf.framework.domain.response.ResultCode;
import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;


/**
 * Created by admin on 2020/3/5.
 */
@ToString
public enum StaffCode implements ResultCode {
    STAFF_DOES_NOT_EXIST(false,26001,"指定的员工不存在！"),
    STAFF_NOT_BELONG_TO_YOU(false,26002,"指定的员工不属于您！"),
    CANT_NOT_ADD_YOURSELF(false,26003,"您不能把您自己添加为员工！"),
    CANT_NOT_REPEAT_ADD_STAFF(false,26004,"不能重复添加员工！")
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
    private StaffCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }
    private static final ImmutableMap<Integer, StaffCode> CACHE;

    static {
        final ImmutableMap.Builder<Integer, StaffCode> builder = ImmutableMap.builder();
        for (StaffCode commonCode : values()) {
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
