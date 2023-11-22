package com.cf.carpark.service.vzenith.cloud.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class BinaryUtil {
  private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
    'E', 'F'};

  public static String toBase64String(byte[] binaryData) {
    return new String(Base64.getEncoder().encode(binaryData));
  }

  public static byte[] fromBase64String(String base64String) {
    return Base64.getDecoder().decode(base64String);
  }

  public static byte[] calculateMd5(byte[] binaryData) {
    MessageDigest messageDigest = null;
    try {
      messageDigest = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("MD5 algorithm not found.");
    }
    messageDigest.update(binaryData);
    return messageDigest.digest();
  }

  public static String encodeMD5(byte[] binaryData) {
    byte[] md5Bytes = calculateMd5(binaryData);
    int len = md5Bytes.length;
    char buf[] = new char[len * 2];
    for (int i = 0; i < len; i++) {
      buf[i * 2] = HEX_DIGITS[(md5Bytes[i] >>> 4) & 0x0f];
      buf[i * 2 + 1] = HEX_DIGITS[md5Bytes[i] & 0x0f];
    }
    return new String(buf);
  }
}
