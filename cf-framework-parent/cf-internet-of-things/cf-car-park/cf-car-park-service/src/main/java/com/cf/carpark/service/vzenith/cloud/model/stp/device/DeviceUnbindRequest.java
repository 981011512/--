package com.cf.carpark.service.vzenith.cloud.model.stp.device;

import com.cf.carpark.service.vzenith.cloud.model.common.BaseRequest;
import com.cf.carpark.service.vzenith.cloud.API;
import com.cf.carpark.service.vzenith.cloud.http.HttpMethod;
import org.json.JSONArray;

public class DeviceUnbindRequest extends BaseRequest {

  private JSONArray unbinds = null;

  public DeviceUnbindRequest(HttpMethod httpMethod, String path) {
    super(HttpMethod.DELETE, API.DEVICE_UNBIND);
    unbinds = new JSONArray();
  }

  public void addUnbind(String sn) {
    unbinds.put(sn);
  }

  @Override
  @Deprecated
  public void setBody(String body) {
  }

  @Override
  public String getBody() {
    return unbinds.toString();
  }
}
