package com.cf.pay.domain.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 建行被扫码扣款表单
 */
public class CCBScannedChargebackForm implements Serializable {

    String MERCHANTID;  //商户号
    String POSID;   //柜台号
    String BRANCHID;    //分行号
    /**
     * 集团商户信息
     * （非集团商户无需上送）
     * 集团主商户代理发起子商
     * 户交易时（验证主商户柜
     * 台公钥），需将集团主商户
     * 信息填入该字段，格式为：
     * JTSH:主商户号+主商户柜
     * 台+主商户分行号
     * 例如：
     * JTSH:10500000000000012
     * 3456789441000000
     * 其中：105000000000000
     * 为主商户号，123456789
     * 为 主 商 户 柜 台 号 ，
     * 441000000 为主商户一级
     * 分行号
     */
    String GROUPMCH;
    /**
     * 加密串
     * 加密串通过[4.2.请求报文
     * 加密方法]中的说明生成，
     * 加密源串参数包含以下浅
     * ylQZnF9G57gKyms
     * jC99NTUyqUwynq
     * geCywvYhT%2Fh
     * 蓝色底纹的参数，如：
     * TXCODE=PAY100&MERFLA
     * G=1&ORDERID=201809061
     * 01102&QRCODE=1347376
     * 90209713402&AMOUNT=
     * 0.01
     */
    String ccbParam;
    String TXCODE;  //交易码
    /**
     * 商户类型
     * 1：线上商户
     * 2：线下商户
     * 商户类型请与分行确认
     * 网络特约商户和龙商户属
     * 于线上商户，卡部商户若
     * 有柜台号则归属线上商
     * 户，若没有柜台号，则按
     * 线下商户处理。
     */
    String MERFLAG;
    /**
     * 终端编号 1
     * 商户类型为 2 时上送
     * 请联系开立商户的分行提
     * 供
     */
    String TERMNO1;
    /**
     * 终端编号 2
     * 商户类型为 2 时上送
     * 请联系开立商户的分行提
     * 供
     */
    String TERMNO2;
    /**
     * 订单号
     * 订单标识，确保在商户系统中唯一
     */
    String ORDERID;
    /**
     * 码信息（一维码、二维码）
     * 客户出示的付款码（现支 持龙支付、支付宝、微信、银联系的付款码）
     */
    String QRCODE;
    BigDecimal AMOUNT;  //订单金额
    /**
     * 商品名称
     * 商品名称。 当 RETURN_FIELD 字段
     * 第三位上送 1 时，该字
     * 段将展示在客户微信/
     * 支付宝账单的商品名
     * 称字段，按微信文档要
     * 求 1 个中文算 3 个字
     * 节，1 个英文或数字算
     * 1 个字节，请注意不要
     * 超长。
     */
    String PROINFO;
    /**
     * 备注 1
     * 商户自定义，按需上送。
     * 在建行商户服务平台查询
     * 流水时可见，中文需使用
     * UTF-8 编码。如需轮询，
     * 在轮询接口中需同步上送
     */
    String REMARK1;
    /**
     * 备注 2
     * 商户自定义，按需上送。
     * 在建行商户服务平台查询
     * 流水时可见，中文需使用
     * UTF-8 编码。如需轮询，
     * 在轮询接口中需同步上送
     */
    String REMARK2;
    /**
     * 分账信息一
     * 分 账 字 段 ， 需 要 分 账 时 ，
     * FZINFO1 必送，有需要时再送
     * FZINFO2
     * 格式：
     * （1）分账组信息，最少 1 组，
     * 最多 5 组但总长度不超过 200
     * 字节，支付时需上送完整的全
     * 部分账组信息。FZINFO1 和
     * FZINFO2 累加金额等于付款金
     * 额 AMOUNT。 （2）格式：分账类型代码!编
     * 号类型^收款编号一^账号类
     * 型^费用名称一（限 5 个汉字
     * 内）^金额^退款标志#编号类
     * 型^收款编号二^账号类型^费
     * 用名称二（限 5 个汉字）^金 额^退款标志#——每组中各
     * 要素分别用“^”分隔符分开，
     * 分账信息组间用“#”分隔符
     * 分开，最后以“#”结束。
     * （3）分账类型代码：21-汇总
     * 间接二清（资金流：持卡人-
     * 收单机构-收单商户-收款编
     * 号）、22-汇总直接二清（资金
     * 流：持卡人-收单机构-收款编
     * 号）、31-明细间接二清（资金
     * 流：持卡人-收单机构-收单商
     * 户-收款编号）、32-明细直接二
     * 清（资金流：持卡人-收单机构
     * -收款编号）
     * （4）编号类型：01-商户编号、
     * 02-终端号、03-账号，必填。
     * （5）收款编号：商户编号或
     * 者终端编号或账号（最长 27
     * 位），必填。
     * （6）账号类型：01-本行对公、
     * 02-本行对私借记、03-合约账
     * 户、07-内部帐。编号类型为
     * 03 时必填，其余编号类型无需
     * 填值。
     * （7）金额：整数部分最长 10
     * 位，小数部分最长 2 位，如
     * 1.23，必填，无需补空格。
     * （8）退款标志取值用法：0-
     * 未退款，1-已退款；支付时送
     * 0，退款时送 1；必填。
     * 需使用 escape 编码，escape
     * 前 FZINFO1 的总长度不超过
     * 200。
     * 银联支付暂不支持分账。
     */
    String FZINFO1;
    /**
     * 分账字段
     * 格式：
     * （1）分账组信息，最少 1 组，
     * 最多 5 组但总长度不超过 200
     * 字节，支付时需上送完整的全
     * 部分账组信息。FZINFO1 和
     * FZINFO2 累加金额等于付款金
     * 额 AMOUNT。 （2）格式：编号类型^收款编
     * 号一^账号类型^费用名称一
     * （限 5 个汉字）^金额^退款标
     * 志#编号类型^收款编号二^账
     * 号类型^费用名称二（限 5 个
     * 汉字）^金额^退款标志#——
     * 每组中各要素分别用“^”分
     * 隔符分开，分账信息组间用
     * “#”分隔符分开。
     * （3）编号类型：01-商户编号、
     * 02-终端号、03-账号，必填。
     * （4）收款编号：商户编号或
     * 者终端编号或账号（最长 27
     * 位），必填。
     * （5）账号类型：01-本行对公、
     * 02-本行对私借记、03-合约账
     * 户、07-内部帐。编号类型为
     * 03 时必填，其余编号类型无需
     * 填值。
     * （6）金额：整数部分最长 10
     * 位，小数部分最长 2 位，如
     * 1.23，必填，无需补空格。
     * （7）退款标志取值用法：0- 未退款，1-已退款；支付时送
     * 0，退款时送 1；必填。
     * 需使用 escape 编码，escape
     * 前 FZINFO2 的总长度不超过
     * 200。
     * 银联支付暂不支持分账。
     */
    String FZINFO2;
    /**
     * 子商户公众账号 ID
     * 微信支付专有字段。
     * 如果子商户号没有绑定
     * appid，只返回 openid；
     * 如果子商户号绑定一个
     * appid 或多个 appid，返回
     * openid 和 sub_openid；
     * 子商户是否绑定 appid，请
     * 联系开立商户的分行
     */
    String SUB_APPID;
    /**
     * 返回信息位图
     * 共 20 位，位图，0 或空-
     * 不返回，1-返回。
     * 第 1 位：是否返回 OPENID
     * 和 SUB_OPENID
     * 第 2 位：是否返回优惠金
     * 额相关字段
     * 第 3 位：是否将“商品名
     * 称 PROINFO”的值上送支
     * 付宝/微信，以便展示在客
     * 户的支付宝/微信账单中
     * 1：上送
     * 0 或空：不上送
     * 第 4 位：是否返回支付详
     * 细信息字段
     * 第 5 位：是否返回微信优
     * 惠金额和微信优惠详情字 段第 6 位：是否返回支付宝
     * 优惠金额和支付宝单品券
     * 优惠信息和支付宝所有优
     * 惠券信息字段
     */
    String RETURN_FIELD;
    /**
     * 实名支付
     * 实名支付功能，包含类型、
     * 证件号、姓名三个子域（如果
     * 本字段出现，那么本字
     * 段包含的三个子域均需出
     * 现。
     * 字段说明见下方[3.1.1.1
     * 实名支付字段说明]
     */
    String USERPARAM;
    /**
     * 商品详情
     * 微信单品优惠功能字
     * 段 ， 详 见 下 文 说 明
     * [3.1.1.2 微信单品优惠活
     * 动 detail 字段列表说明]
     */
    String detail;
    /**
     * 订单优惠标记
     * 微信订单优惠标记，代
     * 金券或立减优惠功能
     * 的参数。
     * 若创建优惠活动时添
     * 加了标志，则商户下单
     * 时需要传入相同的标
     * 记，用户同时符合其他
     * 规则才能享受优惠。
     */
    String goods_tag;
    /**
     * 订单包含的商品列表信息
     * 支付宝单品券优惠功
     * 能字段，详见下方说明
     * [3.1.1.3 支付宝单品券优
     * 惠活动 goods_detail_ali 字
     * 段列表说明]
     */
    String goods_detail_ali;

    String AUTHNO;  //车牌号

    private String PlateColor;  //车牌号颜色

    private String Crdt_No;  //客户身份证号

    @JsonProperty("MERCHANTID")
    public String getMERCHANTID() {
        return MERCHANTID;
    }

    public void setMERCHANTID(String MERCHANTID) {
        this.MERCHANTID = MERCHANTID;
    }

    @JsonProperty("POSID")
    public String getPOSID() {
        return POSID;
    }

    public void setPOSID(String POSID) {
        this.POSID = POSID;
    }

    @JsonProperty("BRANCHID")
    public String getBRANCHID() {
        return BRANCHID;
    }

    public void setBRANCHID(String BRANCHID) {
        this.BRANCHID = BRANCHID;
    }

    @JsonProperty("GROUPMCH")
    public String getGROUPMCH() {
        return GROUPMCH;
    }

    public void setGROUPMCH(String GROUPMCH) {
        this.GROUPMCH = GROUPMCH;
    }

    public String getCcbParam() {
        return ccbParam;
    }

    public void setCcbParam(String ccbParam) {
        this.ccbParam = ccbParam;
    }

    @JsonProperty("TXCODE")
    public String getTXCODE() {
        return TXCODE;
    }

    public void setTXCODE(String TXCODE) {
        this.TXCODE = TXCODE;
    }

    @JsonProperty("MERFLAG")
    public String getMERFLAG() {
        return MERFLAG;
    }

    public void setMERFLAG(String MERFLAG) {
        this.MERFLAG = MERFLAG;
    }

    @JsonProperty("TERMNO1")
    public String getTERMNO1() {
        return TERMNO1;
    }

    public void setTERMNO1(String TERMNO1) {
        this.TERMNO1 = TERMNO1;
    }

    @JsonProperty("TERMNO2")
    public String getTERMNO2() {
        return TERMNO2;
    }

    public void setTERMNO2(String TERMNO2) {
        this.TERMNO2 = TERMNO2;
    }

    @JsonProperty("ORDERID")
    public String getORDERID() {
        return ORDERID;
    }

    public void setORDERID(String ORDERID) {
        this.ORDERID = ORDERID;
    }

    @JsonProperty("QRCODE")
    public String getQRCODE() {
        return QRCODE;
    }

    public void setQRCODE(String QRCODE) {
        this.QRCODE = QRCODE;
    }

    @JsonProperty("AMOUNT")
    public BigDecimal getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(BigDecimal AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    @JsonProperty("PROINFO")
    public String getPROINFO() {
        return PROINFO;
    }

    public void setPROINFO(String PROINFO) {
        this.PROINFO = PROINFO;
    }

    @JsonProperty("REMARK1")
    public String getREMARK1() {
        return REMARK1;
    }

    public void setREMARK1(String REMARK1) {
        this.REMARK1 = REMARK1;
    }

    @JsonProperty("REMARK2")
    public String getREMARK2() {
        return REMARK2;
    }

    public void setREMARK2(String REMARK2) {
        this.REMARK2 = REMARK2;
    }

    @JsonProperty("FZINFO1")
    public String getFZINFO1() {
        return FZINFO1;
    }

    public void setFZINFO1(String FZINFO1) {
        this.FZINFO1 = FZINFO1;
    }

    @JsonProperty("FZINFO2")
    public String getFZINFO2() {
        return FZINFO2;
    }

    public void setFZINFO2(String FZINFO2) {
        this.FZINFO2 = FZINFO2;
    }

    @JsonProperty("SUB_APPID")
    public String getSUB_APPID() {
        return SUB_APPID;
    }

    public void setSUB_APPID(String SUB_APPID) {
        this.SUB_APPID = SUB_APPID;
    }

    @JsonProperty("RETURN_FIELD")
    public String getRETURN_FIELD() {
        return RETURN_FIELD;
    }

    public void setRETURN_FIELD(String RETURN_FIELD) {
        this.RETURN_FIELD = RETURN_FIELD;
    }

    @JsonProperty("USERPARAM")
    public String getUSERPARAM() {
        return USERPARAM;
    }

    public void setUSERPARAM(String USERPARAM) {
        this.USERPARAM = USERPARAM;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    public String getGoods_detail_ali() {
        return goods_detail_ali;
    }

    public void setGoods_detail_ali(String goods_detail_ali) {
        this.goods_detail_ali = goods_detail_ali;
    }

    @JsonProperty("AUTHNO")
    public String getAUTHNO() {
        return AUTHNO;
    }

    public void setAUTHNO(String AUTHNO) {
        this.AUTHNO = AUTHNO;
    }

    @JsonProperty("PlateColor")
    public String getPlateColor() {
        return PlateColor;
    }

    public void setPlateColor(String plateColor) {
        PlateColor = plateColor;
    }

    @JsonProperty("Crdt_No")
    public String getCrdt_No() {
        return Crdt_No;
    }

    public void setCrdt_No(String crdt_No) {
        Crdt_No = crdt_No;
    }
}
