package com.cf.pay.service.config;

import com.alipay.api.CertAlipayRequest;

/**
 * 支付宝配置
 *
 * @ClassName AlipayConfig
 * @Author 隔壁小王子 981011512@qq.com
 * @Date 2020/6/2/002 6:11
 * @Version 1.0
 **/
public class AlipayConfig {

    private String serverUrl="https://openapi.alipay.com/gateway.do";   //网关地址

    private String appId;

    private String subAppId;

    private String privateKey;

    private String alipayPublicKey;

    private String format = "json";  //请求格式(例如json)

    private String charset = "utf-8";

    private String signType = "RSA2";

    private String appCertPath;    //应用公钥证书路径

    private String alipayPublicCertPath;    //支付宝公钥证书路径

    private String rootCertPath;    //支付宝根证书路径

    private String notifyUrl;   //通知地址

    private String mchId;   //商户号

    private String subMchId;    //子商户号

    private String authToken;    //第三方应用授权token

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSubAppId() {
        return subAppId;
    }

    public void setSubAppId(String subAppId) {
        this.subAppId = subAppId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getAppCertPath() {
        return appCertPath;
    }

    public void setAppCertPath(String appCertPath) {
        this.appCertPath = appCertPath;
    }

    public String getAlipayPublicCertPath() {
        return alipayPublicCertPath;
    }

    public void setAlipayPublicCertPath(String alipayPublicCertPath) {
        this.alipayPublicCertPath = alipayPublicCertPath;
    }

    public String getRootCertPath() {
        return rootCertPath;
    }

    public void setRootCertPath(String rootCertPath) {
        this.rootCertPath = rootCertPath;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public CertAlipayRequest getCertAlipayRequest() {
        //构造client
        CertAlipayRequest certAlipayRequest = new CertAlipayRequest();
        //设置网关地址
        certAlipayRequest.setServerUrl(serverUrl);
        //设置应用Id
        certAlipayRequest.setAppId(appId);
        //设置应用私钥
        certAlipayRequest.setPrivateKey(privateKey);
        //设置请求格式，固定值json
        certAlipayRequest.setFormat(format);
        //设置字符集
        certAlipayRequest.setCharset(charset);
        //设置签名类型
        certAlipayRequest.setSignType(signType);
        //设置应用公钥证书路径
        certAlipayRequest.setCertPath(appCertPath);
        //设置支付宝公钥证书路径
        certAlipayRequest.setAlipayPublicCertPath(alipayPublicCertPath);
        //设置支付宝根证书路径
        certAlipayRequest.setRootCertPath(rootCertPath);
        return certAlipayRequest;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getSubMchId() {
        return subMchId;
    }

    public void setSubMchId(String subMchId) {
        this.subMchId = subMchId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
