package com.cf.pay.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 建行被扫码扣款回复
 */
public class CCBScannedChargeback  implements Serializable {

    /**
     * 订单结果
     * Y：成功
     * N：失败
     * U：不确定（交易超时，
     * 建议通过订单查询确认扣 款结果） Q：待轮询（需按照[3.2.3.
     * 支付及轮询流程说明]继 续调用轮询接口查询订单
     * 结果）
     * 其他无法明确订单结果的
     * 情况，均继续调用轮询接
     * 口查询
     */
    String RESULT;

    String ORDERID; //订单号

    BigDecimal AMOUNT;  //订单金额

    /**
     * 二维码类型
     * 1：龙支付
     * 2：微信
     * 3：支付宝
     * 4：银联
     */
    String QRCODETYPE;

    /**
     * 等待时间
     * RESULT 为 Q（待轮询）时
     * 返回，单位:秒
     * 建议商户按返回等待相应
     * 时间后再发起轮询
     */
    Integer WAITTIME;

    /**
     * 全 局 事 件 跟踪号
     * 建行交易流水号
     */
    String TRACEID;

    /**
     * 客户识别号
     * 客 户 识 别 码 。 当
     * RETURN_FIELD 字段第一
     * 位上送 1 时返回。
     * 银联渠道不返回。
     * RESULT 为 Q，该字段不返
     * 回 ， 需 发 轮 询 接 口
     * （PAY101）获取。
     * 此字段不参与验签
     */
    String OPENID;

    /**
     * 用户子标识
     * 微信支付专有字段。
     * 当 RETURN_FIELD 字段第
     * 一位上送 1 时返回。
     * 子商户 appid 下用户唯一
     * 标识，如需返回则请求时
     * 需要传 sub_appid。
     * RESULT 为 Q，该字段不返
     * 回 ， 需 发 轮 询 接 口
     * （PAY101）获取。
     * 此字段不参与验签
     */
    String SUB_OPENID;

    /**
     * 客 户 实 付 金额
     * 客户实付金额。 当 RETURN_FIELD 字段第
     * 二位上送 1 时返回。
     * 当客户使用龙支付且享受
     * 优惠时，该参数有值。
     * RESULT 为 Q，该字段不返
     * 回 ， 需 发 轮 询 接 口
     * （PAY101）获取。
     * 此字段不参与验签
     */
    BigDecimal PAID_AMOUNT;

    /**
     *商 户 实 收 金额
     * 商户实收金额。 当 RETURN_FIELD 字段第
     * 二位上送 1 时返回。
     * 当客户使用银联支付且享
     * 受优惠时，该参数有值。
     * RESULT 为 Q，该字段不返
     * 回 ， 需 发 轮 询 接 口
     * （PAY101）获取。
     * 此字段不参与验签
     */
    BigDecimal RECEIPT_AMOUNT;

    /**
     * 优 惠 活 动 数 组
     * 优惠活动名。 当 RETURN_FIELD 字段第
     * 二位上送 1 时返回。
     * RESULT 为 Q，该字段不返
     * 回 ， 需 发 轮 询 接 口
     * （PAY101）获取。
     * 此字段不参与验签
     */
    String COUPONARRAY;

    /**
     * 支 付 详 细 信 息
     * 支 付 详 细 信 息 。 当
     * RETURN_FIELD 字段第
     * 四位上送 1 时返回。
     * RESULT 为 Q，该字段不返
     * 回 ， 需 发 轮 询 接 口
     * （PAY101）获取。
     * 此字段不参与验签。
     */
    String PAYMENT_DETAILS;

    /**
     * 微 信 优 惠 金 额
     * 微 信 优 惠 金 额 。 当
     * RETURN_FIELD 第 5 位为 1
     * 时返回。
     * RESULT 为 Q，该字段不返
     * 回 ， 需 发 轮 询 接 口
     * （PAY101）获取。
     * 此字段不参与验签。
     */
    String COUPONAMOUNT_WX;

    /**
     * 微 信 优 惠 详 情
     * 微 信 优 惠 详 情 。 当
     * RETURN_FIELD 第 5 位为 1
     * 时返回。
     * RESULT 为 Q，该字段不返
     * 回 ， 需 发 轮 询 接 口
     * （PAY101）获取。
     * 此字段不参与验签。
     */
    String promotion_detail;

    /**
     * 支 付 宝 优 惠 金额
     * 支 付 宝 优 惠 金 额 。 当
     * RETURN_FIELD 第 6 位为 1
     * 时返回。
     * RESULT 为 Q，该字段不返
     * 回 ， 需 发 轮 询 接 口 （PAY101）获取。
     * 此字段不参与验签。
     */
    String COUPONAMOUNT_ALI;

    /**
     * 支 付 宝 单 品券优惠信息
     * 本次交易支付所使用的单
     * 品券优惠的商品优惠信
     * 息。当RETURN_FIELD第6位为
     * 1 时返回。
     * RESULT 为 Q，该字段不返
     * 回 ， 需 发 轮 询 接 口
     * （PAY101）获取。
     * 此字段不参与验签。
     */
    String discount_goods_detail;

    /**
     * 支 付 宝 所 有优惠券信息
     * 本交易支付时使用的所有
     * 优惠券信息。 当RETURN_FIELD第6位为
     * 1 时返回。
     * RESULT 为 Q，该字段不返
     * 回 ， 需 发 轮 询 接 口
     * （PAY101）获取。
     * 此字段不参与验签。
     */
    String voucher_detail_list;

    /**
     * 错误码
     * 报错时返回
     */
    String ERRCODE;

    /**
     * 错误信息
     * 报错时返回
     * 错误信息可能包含中文，
     * 请使用 UTF-8 编码接收
     */
    String ERRMSG;

    /**
     * 签名
     * 签名串，签名源文格式见
     * 下方说明，验签方法详见
     * [4.2.返回报文验签方法]
     */
    String SIGN;

    @JsonProperty("RESULT")
    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }

    @JsonProperty("ORDERID")
    public String getORDERID() {
        return ORDERID;
    }

    public void setORDERID(String ORDERID) {
        this.ORDERID = ORDERID;
    }

    @JsonProperty("AMOUNT")
    public BigDecimal getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(BigDecimal AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    @JsonProperty("QRCODETYPE")
    public String getQRCODETYPE() {
        return QRCODETYPE;
    }

    public void setQRCODETYPE(String QRCODETYPE) {
        this.QRCODETYPE = QRCODETYPE;
    }

    @JsonProperty("WAITTIME")
    public Integer getWAITTIME() {
        return WAITTIME;
    }

    public void setWAITTIME(Integer WAITTIME) {
        this.WAITTIME = WAITTIME;
    }

    @JsonProperty("TRACEID")
    public String getTRACEID() {
        return TRACEID;
    }

    public void setTRACEID(String TRACEID) {
        this.TRACEID = TRACEID;
    }

    @JsonProperty("OPENID")
    public String getOPENID() {
        return OPENID;
    }

    public void setOPENID(String OPENID) {
        this.OPENID = OPENID;
    }

    @JsonProperty("SUB_OPENID")
    public String getSUB_OPENID() {
        return SUB_OPENID;
    }

    public void setSUB_OPENID(String SUB_OPENID) {
        this.SUB_OPENID = SUB_OPENID;
    }

    @JsonProperty("PAID_AMOUNT")
    public BigDecimal getPAID_AMOUNT() {
        return PAID_AMOUNT;
    }

    public void setPAID_AMOUNT(BigDecimal PAID_AMOUNT) {
        this.PAID_AMOUNT = PAID_AMOUNT;
    }

    @JsonProperty("RECEIPT_AMOUNT")
    public BigDecimal getRECEIPT_AMOUNT() {
        return RECEIPT_AMOUNT;
    }

    public void setRECEIPT_AMOUNT(BigDecimal RECEIPT_AMOUNT) {
        this.RECEIPT_AMOUNT = RECEIPT_AMOUNT;
    }

    @JsonProperty("COUPONARRAY")
    public String getCOUPONARRAY() {
        return COUPONARRAY;
    }

    public void setCOUPONARRAY(String COUPONARRAY) {
        this.COUPONARRAY = COUPONARRAY;
    }

    @JsonProperty("PAYMENT_DETAILS")
    public String getPAYMENT_DETAILS() {
        return PAYMENT_DETAILS;
    }

    public void setPAYMENT_DETAILS(String PAYMENT_DETAILS) {
        this.PAYMENT_DETAILS = PAYMENT_DETAILS;
    }

    @JsonProperty("COUPONAMOUNT_WX")
    public String getCOUPONAMOUNT_WX() {
        return COUPONAMOUNT_WX;
    }

    public void setCOUPONAMOUNT_WX(String COUPONAMOUNT_WX) {
        this.COUPONAMOUNT_WX = COUPONAMOUNT_WX;
    }

    public String getPromotion_detail() {
        return promotion_detail;
    }

    public void setPromotion_detail(String promotion_detail) {
        this.promotion_detail = promotion_detail;
    }

    @JsonProperty("COUPONAMOUNT_ALI")
    public String getCOUPONAMOUNT_ALI() {
        return COUPONAMOUNT_ALI;
    }

    public void setCOUPONAMOUNT_ALI(String COUPONAMOUNT_ALI) {
        this.COUPONAMOUNT_ALI = COUPONAMOUNT_ALI;
    }

    public String getDiscount_goods_detail() {
        return discount_goods_detail;
    }

    public void setDiscount_goods_detail(String discount_goods_detail) {
        this.discount_goods_detail = discount_goods_detail;
    }

    public String getVoucher_detail_list() {
        return voucher_detail_list;
    }

    public void setVoucher_detail_list(String voucher_detail_list) {
        this.voucher_detail_list = voucher_detail_list;
    }

    @JsonProperty("ERRCODE")
    public String getERRCODE() {
        return ERRCODE;
    }

    public void setERRCODE(String ERRCODE) {
        this.ERRCODE = ERRCODE;
    }

    @JsonProperty("ERRMSG")
    public String getERRMSG() {
        return ERRMSG;
    }

    public void setERRMSG(String ERRMSG) {
        this.ERRMSG = ERRMSG;
    }

    @JsonProperty("SIGN")
    public String getSIGN() {
        return SIGN;
    }

    public void setSIGN(String SIGN) {
        this.SIGN = SIGN;
    }
}
