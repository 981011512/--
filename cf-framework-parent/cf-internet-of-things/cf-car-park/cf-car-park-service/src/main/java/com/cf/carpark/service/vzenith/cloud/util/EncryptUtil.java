package com.cf.carpark.service.vzenith.cloud.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class EncryptUtil {
  public static String encryptUserInfo(String username, String password, String accessKeySecret) {
    try {
      Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");

      byte[] encryptKey = BinaryUtil.calculateMd5(accessKeySecret.getBytes(StandardCharsets.UTF_8));
      SecretKeySpec keySpec = new SecretKeySpec(encryptKey, "AES");
      cipher.init(Cipher.ENCRYPT_MODE, keySpec);

      byte[] userinfo = (username + ":" + password).getBytes(StandardCharsets.UTF_8);
      int userinfoLength = userinfo.length;
      if (userinfoLength % cipher.getBlockSize() != 0) {
        userinfoLength += cipher.getBlockSize() - (userinfoLength % cipher.getBlockSize());
      }
      byte[] fixedUserinfo = new byte[userinfoLength];
      System.arraycopy(userinfo, 0, fixedUserinfo, 0, userinfo.length);

      byte[] encrypted = cipher.doFinal(fixedUserinfo);

      return BinaryUtil.toBase64String(encrypted);

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
