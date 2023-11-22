// This file is auto-generated, don't edit it. Thanks.
package com.cf.pay.service.alipay.marketing.pass;

import com.aliyun.tea.*;
import com.cf.pay.service.alipay.marketing.pass.models.*;
import com.cf.pay.service.alipay.kernel.BaseClient;

public class Client extends BaseClient {
    public Client(Config config) throws Exception {
        super(TeaModel.buildMap(config));
    }

    public AlipayPassTemplateAddResponse createTemplate(String uniqueId, String tplContent) throws Exception {
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
                    new TeaPair("method", "alipay.pass.template.add"),
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
                    new TeaPair("unique_id", uniqueId),
                    new TeaPair("tpl_content", tplContent)
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

                java.util.Map<String, Object> respMap = _readAsJson(response_, "alipay.pass.template.add");
                if (_isCertMode()) {
                    if (_verify(respMap, _extractAlipayPublicKey(_getAlipayCertSN(respMap)))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayPassTemplateAddResponse());
                    }

                } else {
                    if (_verify(respMap, _getConfig("alipayPublicKey"))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayPassTemplateAddResponse());
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

    public AlipayPassTemplateUpdateResponse updateTemplate(String tplId, String tplContent) throws Exception {
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
                    new TeaPair("method", "alipay.pass.template.update"),
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
                    new TeaPair("tpl_id", tplId),
                    new TeaPair("tpl_content", tplContent)
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

                java.util.Map<String, Object> respMap = _readAsJson(response_, "alipay.pass.template.update");
                if (_isCertMode()) {
                    if (_verify(respMap, _extractAlipayPublicKey(_getAlipayCertSN(respMap)))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayPassTemplateUpdateResponse());
                    }

                } else {
                    if (_verify(respMap, _getConfig("alipayPublicKey"))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayPassTemplateUpdateResponse());
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

    public AlipayPassInstanceAddResponse addInstance(String tplId, String tplParams, String recognitionType, String recognitionInfo) throws Exception {
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
                    new TeaPair("method", "alipay.pass.instance.add"),
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
                    new TeaPair("tpl_id", tplId),
                    new TeaPair("tpl_params", tplParams),
                    new TeaPair("recognition_type", recognitionType),
                    new TeaPair("recognition_info", recognitionInfo)
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

                java.util.Map<String, Object> respMap = _readAsJson(response_, "alipay.pass.instance.add");
                if (_isCertMode()) {
                    if (_verify(respMap, _extractAlipayPublicKey(_getAlipayCertSN(respMap)))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayPassInstanceAddResponse());
                    }

                } else {
                    if (_verify(respMap, _getConfig("alipayPublicKey"))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayPassInstanceAddResponse());
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

    public AlipayPassInstanceUpdateResponse updateInstance(String serialNumber, String channelId, String tplParams, String status, String verifyCode, String verifyType) throws Exception {
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
                    new TeaPair("method", "alipay.pass.instance.update"),
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
                    new TeaPair("serial_number", serialNumber),
                    new TeaPair("channel_id", channelId),
                    new TeaPair("tpl_params", tplParams),
                    new TeaPair("status", status),
                    new TeaPair("verify_code", verifyCode),
                    new TeaPair("verify_type", verifyType)
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

                java.util.Map<String, Object> respMap = _readAsJson(response_, "alipay.pass.instance.update");
                if (_isCertMode()) {
                    if (_verify(respMap, _extractAlipayPublicKey(_getAlipayCertSN(respMap)))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayPassInstanceUpdateResponse());
                    }

                } else {
                    if (_verify(respMap, _getConfig("alipayPublicKey"))) {
                        return TeaModel.toModel(_toRespModel(respMap), new AlipayPassInstanceUpdateResponse());
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

}
