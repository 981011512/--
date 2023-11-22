// This file is auto-generated, don't edit it. Thanks.
package com.cf.pay.service.alipay.payment.common;

import com.aliyun.tea.*;
import com.cf.pay.service.alipay.payment.common.models.*;
import com.cf.pay.service.alipay.kernel.BaseClient;

public class Client extends BaseClient {
    public Client(Config config) throws Exception {
        super(TeaModel.buildMap(config));
    }

    public AlipayTradeCreateResponse create(String subject, String outTradeNo, String totalAmount, String buyerId) throws Exception {
        java.util.Map<String, Object> runtime_ = TeaConverter.buildMap(
            new TeaPair("connectTimeout", 15000),
            new TeaPair("readTimeout", 15000),
            new TeaPair("retry", TeaConverter.buildMap(
                new TeaPair("maxAttempts", 0)
            ))
        );

        TeaRequest _lastRequest = null;
        long _now = System.currentTimeMillis();
        int _retryTimes = 0;
        while (Tea.allowRetry((java.util.Map<String, Object>) runtime_.get("retry"), _retryTimes, _now)) {
            if (_retryTimes > 0) {
                int backoffTime = Tea.getBackoffTime(runtime_.get("backoff"), _retryTimes);
                if (backoffTime > 0) {
                    Tea.sleep(backoffTime);
                }
            }
            _retryTimes = _retryTimes + 1;
            try {
                TeaRequest request_ = new TeaRequest();
                java.util.Map<String, String> systemParams = TeaConverter.buildMap(
                    new TeaPair("method", "alipay.trade.create"),
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
                    new TeaPair("total_amount", totalAmount),
                    new TeaPair("buyer_id", buyerId)
                );
                java.util.Map<String, String> textParams = new java.util.HashMap<>();
                request_.protocol = _getConfig("protocol");
                request_.method = "POST";
                request_.pathname = "/gateway.do";
                request_.headers = TeaConverter.buildMap(
                    new TeaPair("host", _getConfig("gatewayHost")),
                    new TeaPair("content-type", "application/x-www-form-urlencoded;charset=utf-8")
                );
                request_.query = TeaConverter.merge(String.class,
                    TeaConverter.buildMap(
                        new TeaPair("sign", _sign(systemParams, bizParams, textParams, _getConfig("merchantPrivateKey")))
                    ),
                    systemParams,
                    textParams
                );
                request_.body = Tea.toReadable(_toUrlEncodedRequestBody(bizParams));
                _lastRequest = request_;
                TeaResponse response_ = Tea.doAction(request_, runtime_);

                java.util.Map<String, Object> respMap = _readAsJson(response_, "alipay.trade.create");
                if (_isCertMode()) {
                    if (_verify(respMap, _extractAlipayPublicKey(_getAlipayCertSN(respMap)))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayTradeCreateResponse());
                    }

                } else {
                    if (_verify(respMap, _getConfig("alipayPublicKey"))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayTradeCreateResponse());
                    }

                }

                throw new TeaException(TeaConverter.buildMap(
                    new TeaPair("message", "验签失败，请检查支付宝公钥设置是否正确。")
                ));
            } catch (Exception e) {
                if (Tea.isRetryable(e)) {
                    continue;
                }
                throw e;
            }
        }

        throw new TeaUnretryableException(_lastRequest);
    }

    public AlipayTradeQueryResponse query(String outTradeNo) throws Exception {
        java.util.Map<String, Object> runtime_ = TeaConverter.buildMap(
            new TeaPair("connectTimeout", 15000),
            new TeaPair("readTimeout", 15000),
            new TeaPair("retry", TeaConverter.buildMap(
                new TeaPair("maxAttempts", 0)
            ))
        );

        TeaRequest _lastRequest = null;
        long _now = System.currentTimeMillis();
        int _retryTimes = 0;
        while (Tea.allowRetry((java.util.Map<String, Object>) runtime_.get("retry"), _retryTimes, _now)) {
            if (_retryTimes > 0) {
                int backoffTime = Tea.getBackoffTime(runtime_.get("backoff"), _retryTimes);
                if (backoffTime > 0) {
                    Tea.sleep(backoffTime);
                }
            }
            _retryTimes = _retryTimes + 1;
            try {
                TeaRequest request_ = new TeaRequest();
                java.util.Map<String, String> systemParams = TeaConverter.buildMap(
                    new TeaPair("method", "alipay.trade.query"),
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
                    new TeaPair("out_trade_no", outTradeNo)
                );
                java.util.Map<String, String> textParams = new java.util.HashMap<>();
                request_.protocol = _getConfig("protocol");
                request_.method = "POST";
                request_.pathname = "/gateway.do";
                request_.headers = TeaConverter.buildMap(
                    new TeaPair("host", _getConfig("gatewayHost")),
                    new TeaPair("content-type", "application/x-www-form-urlencoded;charset=utf-8")
                );
                request_.query = TeaConverter.merge(String.class,
                    TeaConverter.buildMap(
                        new TeaPair("sign", _sign(systemParams, bizParams, textParams, _getConfig("merchantPrivateKey")))
                    ),
                    systemParams,
                    textParams
                );
                request_.body = Tea.toReadable(_toUrlEncodedRequestBody(bizParams));
                _lastRequest = request_;
                TeaResponse response_ = Tea.doAction(request_, runtime_);

                java.util.Map<String, Object> respMap = _readAsJson(response_, "alipay.trade.query");
                if (_isCertMode()) {
                    if (_verify(respMap, _extractAlipayPublicKey(_getAlipayCertSN(respMap)))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayTradeQueryResponse());
                    }

                } else {
                    if (_verify(respMap, _getConfig("alipayPublicKey"))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayTradeQueryResponse());
                    }

                }

                throw new TeaException(TeaConverter.buildMap(
                    new TeaPair("message", "验签失败，请检查支付宝公钥设置是否正确。")
                ));
            } catch (Exception e) {
                if (Tea.isRetryable(e)) {
                    continue;
                }
                throw e;
            }
        }

        throw new TeaUnretryableException(_lastRequest);
    }

    public AlipayTradeRefundResponse refund(String outTradeNo, String refundAmount) throws Exception {
        java.util.Map<String, Object> runtime_ = TeaConverter.buildMap(
            new TeaPair("connectTimeout", 15000),
            new TeaPair("readTimeout", 15000),
            new TeaPair("retry", TeaConverter.buildMap(
                new TeaPair("maxAttempts", 0)
            ))
        );

        TeaRequest _lastRequest = null;
        long _now = System.currentTimeMillis();
        int _retryTimes = 0;
        while (Tea.allowRetry((java.util.Map<String, Object>) runtime_.get("retry"), _retryTimes, _now)) {
            if (_retryTimes > 0) {
                int backoffTime = Tea.getBackoffTime(runtime_.get("backoff"), _retryTimes);
                if (backoffTime > 0) {
                    Tea.sleep(backoffTime);
                }
            }
            _retryTimes = _retryTimes + 1;
            try {
                TeaRequest request_ = new TeaRequest();
                java.util.Map<String, String> systemParams = TeaConverter.buildMap(
                    new TeaPair("method", "alipay.trade.refund"),
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
                    new TeaPair("out_trade_no", outTradeNo),
                    new TeaPair("refund_amount", refundAmount)
                );
                java.util.Map<String, String> textParams = new java.util.HashMap<>();
                request_.protocol = _getConfig("protocol");
                request_.method = "POST";
                request_.pathname = "/gateway.do";
                request_.headers = TeaConverter.buildMap(
                    new TeaPair("host", _getConfig("gatewayHost")),
                    new TeaPair("content-type", "application/x-www-form-urlencoded;charset=utf-8")
                );
                request_.query = TeaConverter.merge(String.class,
                    TeaConverter.buildMap(
                        new TeaPair("sign", _sign(systemParams, bizParams, textParams, _getConfig("merchantPrivateKey")))
                    ),
                    systemParams,
                    textParams
                );
                request_.body = Tea.toReadable(_toUrlEncodedRequestBody(bizParams));
                _lastRequest = request_;
                TeaResponse response_ = Tea.doAction(request_, runtime_);

                java.util.Map<String, Object> respMap = _readAsJson(response_, "alipay.trade.refund");
                if (_isCertMode()) {
                    if (_verify(respMap, _extractAlipayPublicKey(_getAlipayCertSN(respMap)))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayTradeRefundResponse());
                    }

                } else {
                    if (_verify(respMap, _getConfig("alipayPublicKey"))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayTradeRefundResponse());
                    }

                }

                throw new TeaException(TeaConverter.buildMap(
                    new TeaPair("message", "验签失败，请检查支付宝公钥设置是否正确。")
                ));
            } catch (Exception e) {
                if (Tea.isRetryable(e)) {
                    continue;
                }
                throw e;
            }
        }

        throw new TeaUnretryableException(_lastRequest);
    }

    public AlipayTradeCloseResponse close(String outTradeNo) throws Exception {
        java.util.Map<String, Object> runtime_ = TeaConverter.buildMap(
            new TeaPair("connectTimeout", 15000),
            new TeaPair("readTimeout", 15000),
            new TeaPair("retry", TeaConverter.buildMap(
                new TeaPair("maxAttempts", 0)
            ))
        );

        TeaRequest _lastRequest = null;
        long _now = System.currentTimeMillis();
        int _retryTimes = 0;
        while (Tea.allowRetry((java.util.Map<String, Object>) runtime_.get("retry"), _retryTimes, _now)) {
            if (_retryTimes > 0) {
                int backoffTime = Tea.getBackoffTime(runtime_.get("backoff"), _retryTimes);
                if (backoffTime > 0) {
                    Tea.sleep(backoffTime);
                }
            }
            _retryTimes = _retryTimes + 1;
            try {
                TeaRequest request_ = new TeaRequest();
                java.util.Map<String, String> systemParams = TeaConverter.buildMap(
                    new TeaPair("method", "alipay.trade.close"),
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
                    new TeaPair("out_trade_no", outTradeNo)
                );
                java.util.Map<String, String> textParams = new java.util.HashMap<>();
                request_.protocol = _getConfig("protocol");
                request_.method = "POST";
                request_.pathname = "/gateway.do";
                request_.headers = TeaConverter.buildMap(
                    new TeaPair("host", _getConfig("gatewayHost")),
                    new TeaPair("content-type", "application/x-www-form-urlencoded;charset=utf-8")
                );
                request_.query = TeaConverter.merge(String.class,
                    TeaConverter.buildMap(
                        new TeaPair("sign", _sign(systemParams, bizParams, textParams, _getConfig("merchantPrivateKey")))
                    ),
                    systemParams,
                    textParams
                );
                request_.body = Tea.toReadable(_toUrlEncodedRequestBody(bizParams));
                _lastRequest = request_;
                TeaResponse response_ = Tea.doAction(request_, runtime_);

                java.util.Map<String, Object> respMap = _readAsJson(response_, "alipay.trade.close");
                if (_isCertMode()) {
                    if (_verify(respMap, _extractAlipayPublicKey(_getAlipayCertSN(respMap)))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayTradeCloseResponse());
                    }

                } else {
                    if (_verify(respMap, _getConfig("alipayPublicKey"))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayTradeCloseResponse());
                    }

                }

                throw new TeaException(TeaConverter.buildMap(
                    new TeaPair("message", "验签失败，请检查支付宝公钥设置是否正确。")
                ));
            } catch (Exception e) {
                if (Tea.isRetryable(e)) {
                    continue;
                }
                throw e;
            }
        }

        throw new TeaUnretryableException(_lastRequest);
    }

    public AlipayTradeCancelResponse cancel(String outTradeNo) throws Exception {
        java.util.Map<String, Object> runtime_ = TeaConverter.buildMap(
            new TeaPair("connectTimeout", 15000),
            new TeaPair("readTimeout", 15000),
            new TeaPair("retry", TeaConverter.buildMap(
                new TeaPair("maxAttempts", 0)
            ))
        );

        TeaRequest _lastRequest = null;
        long _now = System.currentTimeMillis();
        int _retryTimes = 0;
        while (Tea.allowRetry((java.util.Map<String, Object>) runtime_.get("retry"), _retryTimes, _now)) {
            if (_retryTimes > 0) {
                int backoffTime = Tea.getBackoffTime(runtime_.get("backoff"), _retryTimes);
                if (backoffTime > 0) {
                    Tea.sleep(backoffTime);
                }
            }
            _retryTimes = _retryTimes + 1;
            try {
                TeaRequest request_ = new TeaRequest();
                java.util.Map<String, String> systemParams = TeaConverter.buildMap(
                    new TeaPair("method", "alipay.trade.cancel"),
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
                    new TeaPair("out_trade_no", outTradeNo)
                );
                java.util.Map<String, String> textParams = new java.util.HashMap<>();
                request_.protocol = _getConfig("protocol");
                request_.method = "POST";
                request_.pathname = "/gateway.do";
                request_.headers = TeaConverter.buildMap(
                    new TeaPair("host", _getConfig("gatewayHost")),
                    new TeaPair("content-type", "application/x-www-form-urlencoded;charset=utf-8")
                );
                request_.query = TeaConverter.merge(String.class,
                    TeaConverter.buildMap(
                        new TeaPair("sign", _sign(systemParams, bizParams, textParams, _getConfig("merchantPrivateKey")))
                    ),
                    systemParams,
                    textParams
                );
                request_.body = Tea.toReadable(_toUrlEncodedRequestBody(bizParams));
                _lastRequest = request_;
                TeaResponse response_ = Tea.doAction(request_, runtime_);

                java.util.Map<String, Object> respMap = _readAsJson(response_, "alipay.trade.cancel");
                if (_isCertMode()) {
                    if (_verify(respMap, _extractAlipayPublicKey(_getAlipayCertSN(respMap)))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayTradeCancelResponse());
                    }

                } else {
                    if (_verify(respMap, _getConfig("alipayPublicKey"))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayTradeCancelResponse());
                    }

                }

                throw new TeaException(TeaConverter.buildMap(
                    new TeaPair("message", "验签失败，请检查支付宝公钥设置是否正确。")
                ));
            } catch (Exception e) {
                if (Tea.isRetryable(e)) {
                    continue;
                }
                throw e;
            }
        }

        throw new TeaUnretryableException(_lastRequest);
    }

    public AlipayTradeFastpayRefundQueryResponse queryRefund(String outTradeNo, String outRequestNo) throws Exception {
        java.util.Map<String, Object> runtime_ = TeaConverter.buildMap(
            new TeaPair("connectTimeout", 15000),
            new TeaPair("readTimeout", 15000),
            new TeaPair("retry", TeaConverter.buildMap(
                new TeaPair("maxAttempts", 0)
            ))
        );

        TeaRequest _lastRequest = null;
        long _now = System.currentTimeMillis();
        int _retryTimes = 0;
        while (Tea.allowRetry((java.util.Map<String, Object>) runtime_.get("retry"), _retryTimes, _now)) {
            if (_retryTimes > 0) {
                int backoffTime = Tea.getBackoffTime(runtime_.get("backoff"), _retryTimes);
                if (backoffTime > 0) {
                    Tea.sleep(backoffTime);
                }
            }
            _retryTimes = _retryTimes + 1;
            try {
                TeaRequest request_ = new TeaRequest();
                java.util.Map<String, String> systemParams = TeaConverter.buildMap(
                    new TeaPair("method", "alipay.trade.fastpay.refund.query"),
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
                    new TeaPair("out_trade_no", outTradeNo),
                    new TeaPair("out_request_no", outRequestNo)
                );
                java.util.Map<String, String> textParams = new java.util.HashMap<>();
                request_.protocol = _getConfig("protocol");
                request_.method = "POST";
                request_.pathname = "/gateway.do";
                request_.headers = TeaConverter.buildMap(
                    new TeaPair("host", _getConfig("gatewayHost")),
                    new TeaPair("content-type", "application/x-www-form-urlencoded;charset=utf-8")
                );
                request_.query = TeaConverter.merge(String.class,
                    TeaConverter.buildMap(
                        new TeaPair("sign", _sign(systemParams, bizParams, textParams, _getConfig("merchantPrivateKey")))
                    ),
                    systemParams,
                    textParams
                );
                request_.body = Tea.toReadable(_toUrlEncodedRequestBody(bizParams));
                _lastRequest = request_;
                TeaResponse response_ = Tea.doAction(request_, runtime_);

                java.util.Map<String, Object> respMap = _readAsJson(response_, "alipay.trade.fastpay.refund.query");
                if (_isCertMode()) {
                    if (_verify(respMap, _extractAlipayPublicKey(_getAlipayCertSN(respMap)))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayTradeFastpayRefundQueryResponse());
                    }

                } else {
                    if (_verify(respMap, _getConfig("alipayPublicKey"))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayTradeFastpayRefundQueryResponse());
                    }

                }

                throw new TeaException(TeaConverter.buildMap(
                    new TeaPair("message", "验签失败，请检查支付宝公钥设置是否正确。")
                ));
            } catch (Exception e) {
                if (Tea.isRetryable(e)) {
                    continue;
                }
                throw e;
            }
        }

        throw new TeaUnretryableException(_lastRequest);
    }

    public AlipayDataDataserviceBillDownloadurlQueryResponse downloadBill(String billType, String billDate) throws Exception {
        java.util.Map<String, Object> runtime_ = TeaConverter.buildMap(
            new TeaPair("connectTimeout", 15000),
            new TeaPair("readTimeout", 15000),
            new TeaPair("retry", TeaConverter.buildMap(
                new TeaPair("maxAttempts", 0)
            ))
        );

        TeaRequest _lastRequest = null;
        long _now = System.currentTimeMillis();
        int _retryTimes = 0;
        while (Tea.allowRetry((java.util.Map<String, Object>) runtime_.get("retry"), _retryTimes, _now)) {
            if (_retryTimes > 0) {
                int backoffTime = Tea.getBackoffTime(runtime_.get("backoff"), _retryTimes);
                if (backoffTime > 0) {
                    Tea.sleep(backoffTime);
                }
            }
            _retryTimes = _retryTimes + 1;
            try {
                TeaRequest request_ = new TeaRequest();
                java.util.Map<String, String> systemParams = TeaConverter.buildMap(
                    new TeaPair("method", "alipay.data.dataservice.bill.downloadurl.query"),
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
                    new TeaPair("bill_type", billType),
                    new TeaPair("bill_date", billDate)
                );
                java.util.Map<String, String> textParams = new java.util.HashMap<>();
                request_.protocol = _getConfig("protocol");
                request_.method = "POST";
                request_.pathname = "/gateway.do";
                request_.headers = TeaConverter.buildMap(
                    new TeaPair("host", _getConfig("gatewayHost")),
                    new TeaPair("content-type", "application/x-www-form-urlencoded;charset=utf-8")
                );
                request_.query = TeaConverter.merge(String.class,
                    TeaConverter.buildMap(
                        new TeaPair("sign", _sign(systemParams, bizParams, textParams, _getConfig("merchantPrivateKey")))
                    ),
                    systemParams,
                    textParams
                );
                request_.body = Tea.toReadable(_toUrlEncodedRequestBody(bizParams));
                _lastRequest = request_;
                TeaResponse response_ = Tea.doAction(request_, runtime_);

                java.util.Map<String, Object> respMap = _readAsJson(response_, "alipay.data.dataservice.bill.downloadurl.query");
                if (_isCertMode()) {
                    if (_verify(respMap, _extractAlipayPublicKey(_getAlipayCertSN(respMap)))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayDataDataserviceBillDownloadurlQueryResponse());
                    }

                } else {
                    if (_verify(respMap, _getConfig("alipayPublicKey"))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayDataDataserviceBillDownloadurlQueryResponse());
                    }

                }

                throw new TeaException(TeaConverter.buildMap(
                    new TeaPair("message", "验签失败，请检查支付宝公钥设置是否正确。")
                ));
            } catch (Exception e) {
                if (Tea.isRetryable(e)) {
                    continue;
                }
                throw e;
            }
        }

        throw new TeaUnretryableException(_lastRequest);
    }

    public boolean verifyNotify(java.util.Map<String, String> parameters) throws Exception {
        if (_isCertMode()) {
            return _verifyParams(parameters, _extractAlipayPublicKey(""));
        } else {
            return _verifyParams(parameters, _getConfig("alipayPublicKey"));
        }

    }
}
