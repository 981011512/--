package com.cf.pay.domain.response;


/**
 * 诺诺电子发票调用回复模板
 *
 * @ClassName TaxNuoNuoResultMap
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/12/4/004 8:49
 * @Version 1.0
 **/
public class TaxNuoNuoResultMap {

    private String code;
    private String describe;
    private Object result;

    public TaxNuoNuoResultMap(String code, String describe, Object result){
        this.code = code;
        this.describe = describe;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
