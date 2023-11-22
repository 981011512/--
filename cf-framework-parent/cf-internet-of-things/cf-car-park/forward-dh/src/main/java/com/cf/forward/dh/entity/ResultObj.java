package com.cf.forward.dh.entity;

public class ResultObj {
    /**
     * "000000"标识操作成功，其他均为失败。
     */
    private String resCode;
    private String resMsg;
    private Object data;

    public static ResultObj success(String resMsg,Object data){
        return new ResultObj("000000",resMsg,data);
    }

    public static ResultObj error(String resMsg,Object data){
        return new ResultObj("1",resMsg,data);
    }

    public ResultObj(String resCode, String resMsg, Object data) {
        this.resCode = resCode;
        this.resMsg = resMsg;
        this.data = data;
    }

    public ResultObj() {
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "ResultObj{" +
                "resCode='" + resCode + '\'' +
                ", resMsg='" + resMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
