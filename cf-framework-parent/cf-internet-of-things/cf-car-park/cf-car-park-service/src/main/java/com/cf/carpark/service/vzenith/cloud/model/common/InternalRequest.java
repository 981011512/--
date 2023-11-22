package com.cf.carpark.service.vzenith.cloud.model.common;

import java.net.URL;
import java.util.Date;

public class InternalRequest {
  private String      baseUrl         = "";
  private BaseRequest request         = null;
  private String      accesskeyId     = "";
  private String      accesskeySecret = "";
  private int         readTimeout     = 0;
  private int         connectTimeout  = 0;

  public InternalRequest(BaseRequest request) {
    this.request = request;
  }

  public URL generatePresignedUrl() {
    long expiresLong = System.currentTimeMillis();
    expiresLong += (60 * 1000);
    return request.generatePresignedUrl(baseUrl, accesskeyId, accesskeySecret, new Date(expiresLong));
  }

  public String getBaseUrl() {
    return baseUrl;
  }

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public BaseRequest getRequest() {
    return request;
  }

  public String getAccesskeyId() {
    return accesskeyId;
  }

  public void setAccesskeyId(String accesskeyId) {
    this.accesskeyId = accesskeyId;
  }

  public String getAccesskeySecret() {
    return accesskeySecret;
  }

  public void setAccesskeySecret(String accesskeySecret) {
    this.accesskeySecret = accesskeySecret;
  }

  public int getReadTimeout() {
    return readTimeout;
  }

  public void setReadTimeout(int readTimeout) {
    this.readTimeout = readTimeout;
  }

  public int getConnectTimeout() {
    return connectTimeout;
  }

  public void setConnectTimeout(int connectTimeout) {
    this.connectTimeout = connectTimeout;
  }
}
