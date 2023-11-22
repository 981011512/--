package com.cf.carpark.service.vzenith.cloud.util;

public class RandomUtil {

  private static final java.util.Random randomSource = new java.util.Random();

  final private static String letterBytes = "abcdefghijkrmnopqlstuvwxyzABCDEFGHIJKRMNOPQLSTUVWXYZ0123456789";

  public static String GetString(int len) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < len; i++) {
      builder.append(letterBytes.charAt(randomSource.nextInt(letterBytes.length())));
    }
    return builder.toString();
  }
}
