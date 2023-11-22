package com.cf.carpark.service.vzenith.cloud.client;

import com.cf.carpark.service.vzenith.cloud.http.HttpClient;
import com.cf.carpark.service.vzenith.cloud.http.HttpResponse;
import com.cf.carpark.service.vzenith.cloud.model.common.BaseRequest;
import com.cf.carpark.service.vzenith.cloud.model.common.InternalRequest;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class BaseClient {
  private static final Logger logger = LoggerFactory.getLogger(BaseClient.class);

  protected String accesskeyId     = "";
  protected String accesskeySecret = "";
  protected String baseURL         = "";

  protected int readTimeout    = 0;
  protected int connectTimeout = 0;

  public BaseClient(String baseURL, String accesskeyId, String accesskeySecret) {
    this.baseURL = baseURL;
    this.accesskeyId = accesskeyId;
    this.accesskeySecret = accesskeySecret;
  }

  /**
   * @param timeout 服务器建立连接的超时时间（单位：毫秒）
   */
  public void setConnectTimeout(int timeout) {
    connectTimeout = timeout;
  }

  /**
   * @param timeout 通过打开的连接传输数据的超时时间（单位：毫秒）
   */
  public void setReadTimeout(int timeout) {
    readTimeout = timeout;
  }

  public HttpResponse requestServer(BaseRequest request) throws IOException {
    InternalRequest internalRequest = new InternalRequest(request);
    internalRequest.setBaseUrl(baseURL);
    internalRequest.setAccesskeyId(accesskeyId);
    internalRequest.setAccesskeySecret(accesskeySecret);
    internalRequest.setConnectTimeout(connectTimeout);
    internalRequest.setReadTimeout(readTimeout);

    return HttpClient.execute(internalRequest);
  }

  /**
   * @param request 请求体
   */
  public JSONObject requestServerJson(BaseRequest request) throws IOException {
    HttpResponse response = requestServer(request);
    String resData = response.getBodyStr();
    int status = response.getStatus();
    if (status == 200) {
      JSONObject data = new JSONObject();
      data.put("code", 0);
      data.put("message", "Success!");
      if (resData.length() != 0) {
        data.put("data", new JSONObject(resData));
      }
      return data;
    } else {
      return new JSONObject(resData);
    }
  }

  public String requestServerText(BaseRequest request) throws IOException {
    HttpResponse response = requestServer(request);
    String resData = response.getBodyStr();
    int status = response.getStatus();
    return resData;
  }

  public String getAccesskeyId() {
    return accesskeyId;
  }

  public String getAccesskeySecret() {
    return accesskeySecret;
  }

  public String getBaseURL() {
    return baseURL;
  }
}
