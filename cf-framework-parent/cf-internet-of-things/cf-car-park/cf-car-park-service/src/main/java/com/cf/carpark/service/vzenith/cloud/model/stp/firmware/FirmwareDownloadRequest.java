package com.cf.carpark.service.vzenith.cloud.model.stp.firmware;

import com.cf.carpark.service.vzenith.cloud.API;
import com.cf.carpark.service.vzenith.cloud.model.common.BaseRequest;
import com.cf.carpark.service.vzenith.cloud.http.HttpMethod;

public class FirmwareDownloadRequest extends BaseRequest {

  public FirmwareDownloadRequest(String version) {
    super(HttpMethod.GET, API.FIRMWARE_DOWNLOAD, version);
  }

}
