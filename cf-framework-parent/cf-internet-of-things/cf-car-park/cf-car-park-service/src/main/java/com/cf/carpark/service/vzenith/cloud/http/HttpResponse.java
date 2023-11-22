package com.cf.carpark.service.vzenith.cloud.http;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HttpResponse {
  private Map<String, List<String>> header;
  private byte[]                    body;
  private int                       status;

  public HttpResponse() {
    status = 0;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getBodyStr() {
    if (body == null) {
      return "";
    }
    return new String(body, StandardCharsets.UTF_8);
  }

  public Map<String, List<String>> getHeader() {
    return header;
  }

  public void setHeader(Map<String, List<String>> header) {
    this.header = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
    for (Map.Entry<String, List<String>> entry : header.entrySet()) {
      if (entry.getKey() != null) {
        this.header.put(entry.getKey(), entry.getValue());
      }
    }
  }

  public byte[] getBody() {
    return body;
  }

  public void setBody(byte[] body) {
    this.body = body;
  }
}
