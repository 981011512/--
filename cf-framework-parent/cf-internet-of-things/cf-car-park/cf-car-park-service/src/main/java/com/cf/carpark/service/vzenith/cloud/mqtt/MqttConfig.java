package com.cf.carpark.service.vzenith.cloud.mqtt;

public class MqttConfig {
  private String host;
  private int    port;
  private String username;
  private String password;
  private String clientId;

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  @Override
  public String toString() {
    return "{" +
      "\"host\": \"" + host + '"' +
      ", \"port\": " + port +
      ", \"username\": \"" + username + '"' +
      ", \"password\": \"" + password + '"' +
      ", \"clientId\": \"" + clientId + '"' +
      "}";
  }
}
