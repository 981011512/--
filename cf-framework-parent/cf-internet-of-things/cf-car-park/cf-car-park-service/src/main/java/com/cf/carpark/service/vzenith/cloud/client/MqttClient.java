package com.cf.carpark.service.vzenith.cloud.client;

import com.cf.carpark.service.vzenith.cloud.mqtt.ReplyMessage;
import com.cf.carpark.service.vzenith.cloud.util.RandomUtil;
import com.cf.carpark.service.vzenith.cloud.mqtt.MqttCallback;
import com.cf.carpark.service.vzenith.cloud.mqtt.StateMessage;
import com.cf.carpark.service.vzenith.cloud.mqtt.UpMessage;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.SocketFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MqttClient {
  private static final Logger logger = LoggerFactory.getLogger(MqttClient.class);

  private String     sid        = "";
  private String     sn        = "";
  private BaseClient baseClient = null;

  private Pattern topicPattern = null;

  private MqttAsyncClient pahoMqttClient = null;
  private MqttCallback    mqttCallback   = null;

  /**
   * @param baseClient BaseClient 用于内部获取请求
   */
  public MqttClient(BaseClient baseClient) {
    this.baseClient = baseClient;
    this.sid = RandomUtil.GetString(12);
    topicPattern = Pattern.compile("^device/([a-z0-9]{8}-[a-z0-9]{8})/(message/up|message/down|event)/([a-z_]+?)(/reply)?$");
  }

  /**
   * @param baseClient BaseClient 用于内部获取请求
   * @param sid        由用户自定义的client标识，可以为任何数字和字母的组合。一般在同一个用户下唯一。
   *                   如果同一用户下使用相同标识，会导致mqtt连接反复断开重连。
   */
  public MqttClient(BaseClient baseClient, String sid) {
    this.baseClient = baseClient;
    this.sid = sid;
    topicPattern = Pattern.compile("^device/([a-z0-9]{8}-[a-z0-9]{8})/(message/up|message/down|event)/([a-z_]+?)(/reply)?$");
  }

  /**
   * 设置回调
   *
   * @param mqttCallback 回调
   */
  public void setMqttCallback(MqttCallback mqttCallback) {
    this.mqttCallback = mqttCallback;
  }

  public void connect(String host, String sn) throws MqttException {
    pahoMqttClient = new MqttAsyncClient(
      String.format("tcp://%s:%d", host, 9004),
            sn,
      new MemoryPersistence());
    pahoMqttClient.setManualAcks(true);
    pahoMqttClient.setCallback(new PahoMqttClientCallback(this));

    MqttConnectOptions mqttOpt = new MqttConnectOptions();
    mqttOpt.setKeepAliveInterval(180);
    mqttOpt.setUserName("cf_365_zh_3255_MQTT");
    mqttOpt.setPassword(new String("1AbW2BuyToIjePmJhV7XeK3WOfixa8").toCharArray());
    mqttOpt.setAutomaticReconnect(false);
    mqttOpt.setCleanSession(true);
    mqttOpt.setSocketFactory(SocketFactory.getDefault());

    IMqttToken token = pahoMqttClient.connect(mqttOpt, null, new PahoMqttClientConnectCallback(this));
    token.waitForCompletion(500);
    if (!token.isComplete()) {
      throw token.getException();
    }
  }

  public void disconnect() throws MqttException {
    if (pahoMqttClient != null && pahoMqttClient.isConnected()) {
      pahoMqttClient.disconnect(1000);
      pahoMqttClient = null;
    }
  }

  public void subDeviceMessage(String sn, String name) throws MqttException {
    IMqttToken token = pahoMqttClient.subscribe(
      String.format("device/%s/message/up/%s", sn, name), 0);
    token.waitForCompletion(500);
    if (!token.isComplete()) {
      throw token.getException();
    }
  }

  public void unsubDeviceMessage(String sn, String name) throws MqttException {
    pahoMqttClient.unsubscribe(String.format("device/%s/message/up/%s", sn, name));
  }

  public void subDeviceState(String sn) throws MqttException {
    IMqttToken token = pahoMqttClient.subscribe(
      String.format("device/%s/event/state", sn), 0);
    token.waitForCompletion(500);
    if (!token.isComplete()) {
      throw token.getException();
    }
  }

  public void unsubDeviceState(String sn) throws MqttException {
    pahoMqttClient.unsubscribe(String.format("device/%s/event/state", sn));
  }

  public void subDeviceReply(String sn, String name) throws MqttException {
    IMqttToken token = pahoMqttClient.subscribe(
      String.format("device/%s/message/down/%s/reply", sn, name), 0);
    token.waitForCompletion(500);
    if (!token.isComplete()) {
      throw token.getException();
    }
  }

  public void unsubDeviceReply(String sn, String name) throws MqttException {
    pahoMqttClient.unsubscribe(String.format("device/%s/message/down/%s/reply", sn, name));
  }

  public void publish(String sn, String name, String payload) throws MqttException {
    String topic = String.format("device/%s/message/down/%s", sn, name);
    String mqttPayload = String.format(
      "{\"id\": \"%s\",\"sn\": \"%s\",\"name\": \"%s\",\"version\": \"1.0\",\"payload\": %s,\"timestamp\": %d}",
      RandomUtil.GetString(12),
      sn,
      name,
      payload,
      System.currentTimeMillis() / 1000);

    pahoMqttClient.publish(topic, mqttPayload.getBytes(), 0, false);
  }

  public boolean isConnected() {
    if (pahoMqttClient == null) {
      return false;
    }
    return pahoMqttClient.isConnected();
  }

  public String getSid() {
    return sid;
  }

  public BaseClient getBaseClient() {
    return baseClient;
  }

  private class PahoMqttClientConnectCallback implements IMqttActionListener {
    private MqttClient mqttClient = null;

    private PahoMqttClientConnectCallback(MqttClient mqttClient) {
      this.mqttClient = mqttClient;
    }

    @Override
    public void onSuccess(IMqttToken iMqttToken) {
      if (mqttClient.mqttCallback != null) {
        try {
          mqttClient.mqttCallback.connected(mqttClient.sn);
        } catch (Exception e) {
          logger.error("Exception occurred in callback function: {}", e.toString());
        }
      }
    }

    @Override
    public void onFailure(IMqttToken iMqttToken, Throwable throwable) {
      if (mqttClient.mqttCallback != null) {
        try {
          mqttClient.mqttCallback.connectionLost(throwable, mqttClient.sn);
        } catch (Exception e) {
          logger.error("Exception occurred in callback function: {}", e.toString());
        }
      }
    }
  }

  private class PahoMqttClientCallback implements org.eclipse.paho.client.mqttv3.MqttCallback {
    private MqttClient mqttClient = null;

    private PahoMqttClientCallback(MqttClient mqttClient) {
      this.mqttClient = mqttClient;
    }

    @Override
    public void connectionLost(Throwable throwable) {
      if (mqttClient.mqttCallback != null) {
        try {
          mqttClient.mqttCallback.connectionLost(throwable, mqttClient.sn);
        } catch (Exception e) {
          logger.error("Exception occurred in callback function: {}", e.toString());
        }
      }
    }

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
      logger.debug("A mqttMessage arrived: {}", mqttMessage);
      if (mqttClient.mqttCallback == null) {
        return;
      }

      Matcher matcher = topicPattern.matcher(topic);
      if (!matcher.find()) {
        logger.debug("Not matched topic \"{}\", pattern: {}", topic, topicPattern.pattern());
        return;
      }
      String sn = matcher.group(1);
      String msgType = matcher.group(2);
      String msgName = matcher.group(3);

      JSONObject json = new JSONObject(new String(mqttMessage.getPayload()));
      switch (msgType) {
        case "event":
          try {
            StateMessage stateMessage = StateMessage.fromJson(json);
            mqttClient.mqttCallback.deviceStateChanged(sn, stateMessage.getName());
          } catch (Exception e) {
            logger.error("Exception occurred in callback function: {}", e.toString());
          }
          break;
        case "message/down":
          try {
            mqttClient.mqttCallback.deviceReplied(sn, msgName, ReplyMessage.fromJson(json));
          } catch (Exception e) {
            logger.error("Exception occurred in callback function: {}", e.toString());
          }
          break;
        case "message/up":
          try {
            mqttClient.mqttCallback.messageArrived(sn, msgName, UpMessage.fromJson(json));
          } catch (Exception e) {
            logger.error("Exception occurred in callback function: {}", e.toString());
          }
          break;
        default:
          logger.debug("Unknown message type \"{}\"", topic);
          break;
      }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    }
  }

  public String getSn() {
    return sn;
  }

  public void setSn(String sn) {
    this.sn = sn;
  }
}
