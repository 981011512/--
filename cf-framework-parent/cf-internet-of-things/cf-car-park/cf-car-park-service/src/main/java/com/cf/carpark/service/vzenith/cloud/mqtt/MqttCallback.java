package com.cf.carpark.service.vzenith.cloud.mqtt;

public interface MqttCallback {

  /**
   * 设备与云端的连接状态发生变化，需要提前订阅
   *
   * @param sn    设备的SN
   * @param state 状态，可能的值为online和offline
   */
  void deviceStateChanged(String sn, String state);

  /**
   * 收到了设备收到publish的消息后发送的回执，需要提前订阅
   *
   * @param sn           设备的SN
   * @param name         发送的消息名
   * @param replyMessage 设备回复的消息内容
   */
  void deviceReplied(String sn, String name, ReplyMessage replyMessage);

  /**
   * 收到了设备主动上报的特殊消息，需要提前订阅
   *
   * @param sn      设备的SN
   * @param name    发送的消息名
   * @param message 设备推送的消息内容
   */
  void messageArrived(String sn, String name, UpMessage message);

  /**
   * mqtt连接成功
   */
  void connected(String sn);

  /**
   * mqtt连接丢失
   *
   * @param throwable 错误
   */
  void connectionLost(Throwable throwable, String sn);
}
