package com.cf.carpark.service.vzenith.cloud.model.stp.device;

import com.cf.carpark.service.vzenith.cloud.model.common.BaseRequest;
import com.cf.carpark.service.vzenith.cloud.API;
import com.cf.carpark.service.vzenith.cloud.http.HttpMethod;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeviceBindRequest extends BaseRequest {
  private JSONArray binds = null;

  public DeviceBindRequest() {
    super(HttpMethod.POST, API.DEVICE_BIND);
    binds = new JSONArray();
  }

  public void addBind(String sn, int groupId) {
    addBind(sn, groupId, null, null, null);
  }

  public void addBind(String sn, int groupId, String remark) {
    addBind(sn, groupId, null, null, remark);
  }

  public void addBind(String sn, int groupId, String username, String password) {
    addBind(sn, groupId, username, password, null);
  }

  public void addBind(String sn, int groupId, String username, String password, String remark) {
    binds.put(new JSONObject() {{
      put("sn", sn);
      put("group_id", groupId);
      if (username != null && password != null) {
        put("username", username);
        put("password", password);
      }
      if (remark != null) {
        put("remark", remark);
      }
    }});
  }

  @Override
  @Deprecated
  public void setBody(String body) {
  }

  @Override
  public String getBody() {
    return binds.toString();
  }
}
