package com.cf.carpark.service.vzenith.cloud.model.stp.pdns;

import com.cf.carpark.service.vzenith.cloud.API;
import com.cf.carpark.service.vzenith.cloud.model.common.BaseRequest;
import com.cf.carpark.service.vzenith.cloud.http.HttpMethod;

public class PdnsTelnetRequest extends BaseRequest {

  /**
   * @param sn 目标设备SN
   */
  public PdnsTelnetRequest(String sn) {
    super(HttpMethod.GET, API.PDNS_TELNET);
    addParam("sn", sn);
  }
}
