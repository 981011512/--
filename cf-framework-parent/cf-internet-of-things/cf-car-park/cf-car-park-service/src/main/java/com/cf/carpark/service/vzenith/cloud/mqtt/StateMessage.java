package com.cf.carpark.service.vzenith.cloud.mqtt;

import org.json.JSONObject;

public class StateMessage {
  private String  id;
  private String  sn;
  private String  name;
  private boolean will;
  private String  proxy;
  private int     timestamp;

  public static StateMessage fromJson(JSONObject json) {
    StateMessage stateMessage = new StateMessage();
    stateMessage.id = json.getString("id");
    stateMessage.sn = json.getString("sn");
    stateMessage.name = json.getString("name");
    stateMessage.will = json.getBoolean("will");
    stateMessage.proxy = json.getString("proxy");
    stateMessage.timestamp = json.getInt("timestamp");
    return stateMessage;
  }

  public String getId() {
    return id;
  }

  public String getSn() {
    return sn;
  }

  public String getName() {
    return name;
  }

  public boolean getWill() {
    return will;
  }

  public String getProxy() {
    return proxy;
  }

  public int getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return "{" +
      "\"id\": \"" + id + '"' +
      ", \"sn\": \"" + sn + '"' +
      ", \"name\": \"" + name + '"' +
      ", \"will\": " + will +
      ", \"proxy\": \"" + proxy + '"' +
      ", \"timestamp\": " + timestamp +
      "}";
  }
}
