package com.cf.carpark.service.vzenith.cloud.mqtt;

import org.json.JSONException;
import org.json.JSONObject;

public class UpMessage {
  private String     id;
  private String     sn;
  private int        bv;
  private String     name;
  private String     version;
  private JSONObject payload;
  private int        timestamp;

  public static UpMessage fromJson(JSONObject json) {
    UpMessage upMessage = new UpMessage();
    upMessage.id = json.getString("id");
    upMessage.sn = json.getString("sn");
    upMessage.bv = json.getInt("bv");
    upMessage.name = json.getString("name");
    upMessage.version = json.getString("version");
    try {
      upMessage.payload = json.getJSONObject("payload");
    } catch (JSONException ignore) {
      upMessage.payload = null;
    }
    upMessage.timestamp = json.getInt("timestamp");
    return upMessage;
  }

  public String getId() {
    return id;
  }

  public String getSn() {
    return sn;
  }

  public int getBv() {
    return bv;
  }

  public String getName() {
    return name;
  }

  public String getVersion() {
    return version;
  }

  public JSONObject getPayload() {
    return payload;
  }

  public int getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return "{" +
      "\"id\": \"" + id + '"' +
      ", \"sn\": \"" + sn + '"' +
      ", \"bv\": " + bv +
      ", \"name\": \"" + name + '"' +
      ", \"version\": \"" + version + '"' +
      ", \"payload\": " + payload +
      ", \"timestamp\": " + timestamp +
      "}";
  }
}
