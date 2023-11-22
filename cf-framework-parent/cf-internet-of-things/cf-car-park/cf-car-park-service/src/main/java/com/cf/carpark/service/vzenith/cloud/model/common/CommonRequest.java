package com.cf.carpark.service.vzenith.cloud.model.common;

import com.cf.carpark.service.vzenith.cloud.http.HttpMethod;

public class CommonRequest extends BaseRequest {
  public CommonRequest(HttpMethod httpMethod, String path) {
    super(httpMethod, path);
  }
}