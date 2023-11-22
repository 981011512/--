package com.cf.carpark.service.vzenith.cloud.util;

public abstract class ServiceSignature {
  /**
   * Gets the algorithm of signature.
   *
   * @return The algorithm of the signature.
   */
  public abstract String getAlgorithm();

  /**
   * Gets the algorithm version.
   *
   * @return The algorithm version.
   */
  public abstract String getVersion();

  /**
   * Computes the signature of the data by the given key.
   *
   * @param key  The key for the signature.
   * @param data The data to compute the signature on.
   * @return The signature in string.
   */
  public abstract String computeSignature(String key, String data);

  /**
   * Creates the default <code>ServiceSignature</code> instance which is
   * {@link HmacSHA1Signature}.
   *
   * @return The default <code>ServiceSignature</code> instance
   */
  public static ServiceSignature create() {
    return new HmacSHA1Signature();
  }
}
