// This file is auto-generated, don't edit it. Thanks.
package com.cf.pay.service.alipay.payment.app;

import com.aliyun.tea.*;
import com.cf.pay.service.alipay.payment.app.models.*;
import com.cf.pay.service.alipay.kernel.BaseClient;

public class Client extends BaseClient {
    public Client(Config config) throws Exception {
        super(TeaModel.buildMap(config));
    }


    public AlipayTradeAppPayResponse pay(String subject, String outTradeNo, String totalAmount) throws Exception {
        java.util.Map<String, String> systemParams = TeaConverter.buildMap(
            new TeaPair("method", "alipay.trade.app.pay"),
            new TeaPair("app_id", _getConfig("appId")),
            new TeaPair("timestamp", _getTimestamp()),
            new TeaPair("format", "json"),
            new TeaPair("version", "1.0"),
            new TeaPair("alipay_sdk", _getSdkVersion()),
            new TeaPair("charset", "UTF-8"),
            new TeaPair("sign_type", _getConfig("signType")),
            new TeaPair("app_cert_sn", _getMerchantCertSN()),
            new TeaPair("alipay_root_cert_sn", _getAlipayRootCertSN())
        );
        java.util.Map<String, Object> bizParams = TeaConverter.buildMap(
            new TeaPair("subject", subject),
            new TeaPair("out_trade_no", outTradeNo),
            new TeaPair("total_amount", totalAmount)
        );
        java.util.Map<String, String> textParams = new java.util.HashMap<>();
        String sign = _sign(systemParams, bizParams, textParams, _getConfig("merchantPrivateKey"));
        java.util.Map<String, String> response = TeaConverter.buildMap(
            new TeaPair("body", _generateOrderString(systemParams, bizParams, textParams, sign))
        );
        return TeaModel.toModel(response, new AlipayTradeAppPayResponse());
    }
}
