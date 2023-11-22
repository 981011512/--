package com.cf.carpark.service.vzenith.cloud.mqtt;

import org.json.JSONException;
import org.json.JSONObject;

public class ReplyMessage {
  private int        code;
  private String     id;
  private String     sn;
  private String     name;
  private String     version;
  private JSONObject payload;
  private int        timestamp;

  public static ReplyMessage fromJson(JSONObject json) {
    ReplyMessage replyMessage = new ReplyMessage();
    replyMessage.id = json.getString("id");
    replyMessage.code = json.getInt("code");
    replyMessage.sn = json.getString("sn");
    replyMessage.name = json.getString("name");
    replyMessage.version = json.getString("version");
    try {
      replyMessage.payload = json.getJSONObject("payload");
    } catch (JSONException ignore) {
      replyMessage.payload = null;
    }
    replyMessage.timestamp = json.getInt("timestamp");
    return replyMessage;
  }

  public int getCode() {
    return code;
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
      "\"code\": " + code +
      ", \"id\": \"" + id + '"' +
      ", \"sn\": \"" + sn + '"' +
      ", \"name\": \"" + name + '"' +
      ", \"version\": \"" + version + '"' +
      ", \"payload\": " + payload +
      ", \"timestamp\": " + timestamp +
      "}";
  }
}
