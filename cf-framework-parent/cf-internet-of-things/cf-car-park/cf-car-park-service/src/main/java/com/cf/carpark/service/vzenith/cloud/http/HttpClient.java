package com.cf.carpark.service.vzenith.cloud.http;

import com.cf.carpark.service.vzenith.cloud.model.common.InternalRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpClient {

  private static final Logger logger = LoggerFactory.getLogger(HttpClient.class);

  public static HttpResponse execute(InternalRequest internalRequest) throws IOException {
    String content = internalRequest.getRequest().getBody();
    HashMap<String, String> header = internalRequest.getRequest().getHeaders();

    HttpResponse response = new HttpResponse();

    DataOutputStream out = null;
    InputStream is = null;
    URL url = internalRequest.generatePresignedUrl();

    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

    // set timeout
    if (internalRequest.getConnectTimeout() > 0) {
      conn.setConnectTimeout(internalRequest.getConnectTimeout());
    }

    if (internalRequest.getReadTimeout() > 0) {
      conn.setReadTimeout(internalRequest.getReadTimeout());
    }

    conn.setDoOutput(true);
    conn.setRequestMethod(internalRequest.getRequest().getHttpMethod().toString());

    // 添加header
    for (Map.Entry<String, String> entry : header.entrySet()) {
      conn.setRequestProperty(entry.getKey(), entry.getValue());
    }

    conn.connect();
    if (content.length() > 0) {
      out = new DataOutputStream(conn.getOutputStream());
      out.write(content.getBytes(StandardCharsets.UTF_8));
      out.flush();
    }

    int statusCode = conn.getResponseCode();
    response.setHeader(conn.getHeaderFields());
    response.setStatus(statusCode);

    if (statusCode == 200) {
      is = conn.getInputStream();
    } else {
      is = conn.getErrorStream();
    }

    if (is != null) {
      ByteArrayOutputStream outStream = new ByteArrayOutputStream();
      byte[] buffer = new byte[1024];
      int len = 0;
      while ((len = is.read(buffer)) != -1) {
        outStream.write(buffer, 0, len);
      }
      response.setBody(outStream.toByteArray());
    }
    return response;
  }
}
