package com.cf.carpark.service.vzenith.cloud.model.stp.firmware;

import com.cf.carpark.service.vzenith.cloud.API;
import com.cf.carpark.service.vzenith.cloud.http.HttpMethod;
import com.cf.carpark.service.vzenith.cloud.model.common.BaseRequest;

public class FirmwareGetRequest extends BaseRequest {

  public FirmwareGetRequest(String version) {
    super(HttpMethod.GET, API.FIRMWARE_GET, version);
  }

}
