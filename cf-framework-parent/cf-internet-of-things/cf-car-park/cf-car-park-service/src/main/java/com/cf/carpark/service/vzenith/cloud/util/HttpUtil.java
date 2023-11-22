package com.cf.carpark.service.vzenith.cloud.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;

public class HttpUtil {
  /**
   * Encode a URL segment with special chars replaced.
   */
  public static String urlEncode(String value, String encoding) {
    if (value == null) {
      return "";
    }

    try {
      String encoded = URLEncoder.encode(value, encoding);
      return encoded.replace("+", "%20").replace("*", "%2A").replace("~", "%7E").replace("/", "%2F");
    } catch (UnsupportedEncodingException e) {
      throw new IllegalArgumentException("编码Url失败");
    }
  }

  public static String urlDecode(String value, String encoding) {
    if (value == null || value.length() == 0) {
      return value;
    }

    try {
      return URLDecoder.decode(value, encoding);
    } catch (UnsupportedEncodingException e) {
      throw new IllegalArgumentException("解码Url失败");
    }
  }

  /**
   * Encode request parameters to URL segment.
   */
  public static String paramToQueryString(Map<String, String> params, Charset charset) {

    if (params == null || params.isEmpty()) {
      return null;
    }

    StringBuilder paramString = new StringBuilder();
    boolean first = true;
    for (Map.Entry<String, String> p : params.entrySet()) {
      String key = p.getKey();
      String value = p.getValue();

      if (!first) {
        paramString.append("&");
      }

      // Urlencode each request parameter
      paramString.append(urlEncode(key, charset.toString()));
      if (value != null) {
        paramString.append("=").append(urlEncode(value, charset.toString()));
      }

      first = false;
    }

    return paramString.toString();
  }
}
