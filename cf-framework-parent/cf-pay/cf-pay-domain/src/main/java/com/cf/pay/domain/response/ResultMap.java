package com.cf.pay.domain.response;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信支付调用回复模板
 *
 * @ClassName ResultMap
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/5/4/004 8:49
 * @Version 1.0
 **/
public class ResultMap extends HashMap<String, Object> {
    public ResultMap() {
        put("state", true);
        put("code", 0);
        put("msg", "success");
    }

    public static ResultMap error(int code, String msg) {
        ResultMap r = new ResultMap();
        r.put("state", false);
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static ResultMap error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static ResultMap error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static ResultMap ok(String msg) {
        ResultMap r = new ResultMap();
        r.put("msg", msg);
        return r;
    }

    public static ResultMap ok(Map<String, Object> par) {
        ResultMap r = new ResultMap();
        r.putAll(par);
        return r;
    }

    public static ResultMap ok() {
        return new ResultMap();
    }

    public ResultMap put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
