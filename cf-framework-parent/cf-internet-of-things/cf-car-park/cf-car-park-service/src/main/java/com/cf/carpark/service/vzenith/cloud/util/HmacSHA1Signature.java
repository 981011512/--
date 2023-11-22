package com.cf.carpark.service.vzenith.cloud.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HmacSHA1Signature extends ServiceSignature {
  /* The default encoding. */
  private static final String DEFAULT_ENCODING = "UTF-8";

  /* Signature method. */
  private static final String ALGORITHM = "HmacSHA1";

  /* Signature version. */
  private static final String VERSION = "1";

  private static final Object LOCK = new Object();

  /* Prototype of the Mac instance. */
  private static Mac macInstance;

  public String getAlgorithm() {
    return ALGORITHM;
  }

  public String getVersion() {
    return VERSION;
  }

  public String computeSignature(String key, String data) {
    try {
      byte[] signData = sign(key.getBytes(DEFAULT_ENCODING), data.getBytes(DEFAULT_ENCODING));
      return BinaryUtil.toBase64String(signData);
    } catch (UnsupportedEncodingException ex) {
      throw new RuntimeException("Unsupported algorithm: " + DEFAULT_ENCODING, ex);
    }
  }

  private byte[] sign(byte[] key, byte[] data) {
    try {
      // Because Mac.getInstance(String) calls a synchronized method, it
      // could block on
      // invoked concurrently, so use prototype pattern to improve perf.
      if (macInstance == null) {
        synchronized (LOCK) {
          if (macInstance == null) {
            macInstance = Mac.getInstance(ALGORITHM);
          }
        }
      }

      Mac mac = null;
      try {
        mac = (Mac) macInstance.clone();
      } catch (CloneNotSupportedException e) {
        // If it is not clonable, create a new one.
        mac = Mac.getInstance(ALGORITHM);
      }
      mac.init(new SecretKeySpec(key, ALGORITHM));
      return mac.doFinal(data);
    } catch (NoSuchAlgorithmException ex) {
      throw new RuntimeException("Unsupported algorithm: " + ALGORITHM, ex);
    } catch (InvalidKeyException ex) {
      throw new RuntimeException("Invalid key: " + key, ex);
    }
  }
}
