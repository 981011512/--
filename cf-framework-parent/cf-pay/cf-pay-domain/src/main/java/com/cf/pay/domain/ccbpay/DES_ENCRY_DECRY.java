package com.cf.pay.domain.ccbpay;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

class DES_ENCRY_DECRY {
    private SecretKeySpec keySpec = null;

    private Cipher cipher;

    private String tdesKey = "12345678";

    private String algorithm = "DES";

    private String mode = "DES/ECB/PKCS5Padding";

    DES_ENCRY_DECRY(String desKey) {
        if (!"".equals(desKey) && desKey != null) {
            desKey = (desKey.length() > 8) ? desKey.substring(0, 8) : desKey;
            this.tdesKey = desKey;
        }
    }

    String tdesEncryptSample(byte[] plainText) {
        try {
            byte[] bbb = this.tdesKey.getBytes();
            this.keySpec = new SecretKeySpec(this.tdesKey.getBytes(), this.algorithm);
            this.cipher = Cipher.getInstance(this.mode);
            this.cipher.init(1, this.keySpec);
            byte[] cipherText = this.cipher.doFinal(plainText);
            byte[] output = Base64.encodeBase64(cipherText);
            String cipherStr = new String(output);
            return cipherStr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    String tdesDecryptSample(String cipherStr) {
        try {
            byte[] cipherBytes = Base64.decodeBase64(cipherStr.getBytes());
            this.keySpec = new SecretKeySpec(this.tdesKey.getBytes(), this.algorithm);
            this.cipher = Cipher.getInstance(this.mode);
            this.cipher.init(2, this.keySpec);
            byte[] plainBytes = (byte[])null;
            plainBytes = this.cipher.doFinal(cipherBytes);
            String plainText = new String(plainBytes);
            return plainText;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
