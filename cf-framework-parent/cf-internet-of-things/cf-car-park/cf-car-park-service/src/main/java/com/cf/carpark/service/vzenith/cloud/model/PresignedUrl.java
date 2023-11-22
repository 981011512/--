package com.cf.carpark.service.vzenith.cloud.model;

import com.cf.carpark.service.vzenith.cloud.model.common.BaseRequest;
import com.cf.carpark.service.vzenith.cloud.util.BinaryUtil;
import com.cf.carpark.service.vzenith.cloud.util.HttpUtil;
import com.cf.carpark.service.vzenith.cloud.util.ServiceSignature;
import com.cf.carpark.service.vzenith.cloud.http.Headers;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class PresignedUrl {
  private BaseRequest request;
  private String      accessKeyId;
  private String      accessKeySecret;
  private String      expires;

  public PresignedUrl(BaseRequest request, String accessKeyId, String accessKeySecret) {
    this.request = request;
    this.accessKeyId = accessKeyId;
    this.accessKeySecret = accessKeySecret;
  }

  public PresignedUrl setExpires(Date expires) {
    this.expires = String.valueOf(expires.getTime() / 1000L);
    return this;
  }

  private static String buildCannibalizedResource(String resourcePath, Map<String, String> parameters) {
    if (!resourcePath.startsWith("/")) {
      throw new IllegalArgumentException("Resource path should start with slash character");
    }

    StringBuilder builder = new StringBuilder();
    builder.append(resourcePath);

    if (parameters != null) {
      String[] parameterNames = parameters.keySet().toArray(new String[parameters.size()]);
      Arrays.sort(parameterNames);

      char separater = '?';
      for (String paramName : parameterNames) {
        builder.append(separater);
        builder.append(paramName);
        String paramValue = parameters.get(paramName);
        if (paramValue != null) {
          builder.append("=").append(paramValue);
        }
        separater = '&';
      }
    }
    return builder.toString();
  }

  public String generateSignature() {
    byte[] body = request.getBody().getBytes(StandardCharsets.UTF_8);
    int bodyLength = body.length;
    request.addHeader(Headers.CONTENT_LENGTH, Integer.toString(bodyLength));

    HashMap<String, String> headers = request.getHeaders();
    String method = request.getHttpMethod().toString();

    String contentMD5 = "";
    String contentType = "";
    if (bodyLength > 0) {
      contentMD5 = BinaryUtil.toBase64String(BinaryUtil.calculateMd5(body));
      if (headers.containsKey(Headers.CONTENT_TYPE)) {
        contentType = headers.get(Headers.CONTENT_TYPE);
      }
    }

    String canonical = String.format("%s\n%s\n%s\n%s\n%s",
      method,
      contentMD5,
      contentType,
      this.expires,
      buildCannibalizedResource(this.request.getPath(), this.request.getParams()));
    return ServiceSignature.create().computeSignature(this.accessKeySecret, canonical);
  }

  public URL generatePresignedUrl(String baseUrl) {
    String signature = generateSignature();
    Map<String, String> params = new LinkedHashMap<String, String>();
    params.put("expires", this.expires);
    params.put("accesskey_id", this.accessKeyId);
    params.put("signature", signature);
    params.putAll(this.request.getParams());

    String queryString = HttpUtil.paramToQueryString(params, StandardCharsets.UTF_8);
    String tempUrl = this.request.getPath();
    int pos = tempUrl.indexOf("?");
    if (pos != -1) {
      tempUrl = tempUrl.substring(0, pos);
    }
    String url = baseUrl + tempUrl + "?" + queryString;

    try {
      return new URL(url);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }
}
