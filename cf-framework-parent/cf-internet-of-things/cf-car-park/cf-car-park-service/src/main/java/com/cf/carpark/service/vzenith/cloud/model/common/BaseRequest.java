package com.cf.carpark.service.vzenith.cloud.model.common;

import com.cf.carpark.service.vzenith.cloud.http.Headers;
import com.cf.carpark.service.vzenith.cloud.http.HttpContentType;
import com.cf.carpark.service.vzenith.cloud.http.HttpMethod;
import com.cf.carpark.service.vzenith.cloud.model.PresignedUrl;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseRequest {
  protected HashMap<String, String> headers;
  protected HashMap<String, String> params;
  protected String                  body = "";
  protected String                  path;
  protected HttpMethod              httpMethod;

  /**
   * @param httpMethod http method
   * @param path       API path
   */
  public BaseRequest(HttpMethod httpMethod, String path) {
    headers = new HashMap<>();
    params = new HashMap<>();
    this.httpMethod = httpMethod;
    this.path = path;
  }

  /**
   * 使用原始 path 自动构造完整 path
   *
   * @param httpMethod http method
   * @param path       API path
   * @param arguments  path variables
   */
  protected BaseRequest(HttpMethod httpMethod, String path, String... arguments) {
    headers = new HashMap<>();
    params = new HashMap<>();
    this.httpMethod = httpMethod;
    this.path = formatPathVar(path, arguments);
  }

  /**
   * 添加一条 header
   *
   * @param key   header 键
   * @param value header 值
   */
  public void addHeader(String key, String value) {
    headers.put(key, value);
  }

  /**
   * 添加多个 header
   *
   * @param headers header 键值组成的 HashMap
   */
  public void addHeaders(HashMap<String, String> headers) {
    this.headers.putAll(headers);
  }

  /**
   * 添加一条 param
   *
   * @param key   param 的键
   * @param value param 的值
   */
  public void addParam(String key, String value) {
    params.put(key, value);
  }

  public void addParams(HashMap<String, String> params) {
    this.params.putAll(params);
  }

  public HashMap<String, String> getParams() {
    return params;
  }

  public String encodeParams() {
    StringBuffer buffer = new StringBuffer();
    for (Map.Entry<String, String> entry : params.entrySet()) {
      buffer.append(String.format("%s=%s&", entry.getKey(), entry.getValue()));
    }
    if (buffer.length() > 0) {
      buffer.deleteCharAt(buffer.length() - 1);
    }
    return buffer.toString();
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    addHeader(Headers.CONTENT_TYPE, HttpContentType.JSON_DATA);
    this.body = body;
  }

  public HashMap<String, String> getHeaders() {
    return headers;
  }

  public String getPath() {
    return path;
  }

  public HttpMethod getHttpMethod() {
    return httpMethod;
  }

  public URL generatePresignedUrl(String baseUrl, String accessKeyId, String accessKeySecret, Date expires) {
    PresignedUrl presignedUrl = new PresignedUrl(this, accessKeyId, accessKeySecret)
      .setExpires(expires);
    return presignedUrl.generatePresignedUrl(baseUrl);
  }

  protected static String formatPathVar(String path, String... arguments) {
    for (String v : arguments) {
      path = path.replaceFirst(":[^/]+", v);
    }
    return path;
  }
}
