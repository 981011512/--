package com.cf.pay.domain.ccbpay;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

class Notify_Verify {
    boolean verifySigature(String src, String sign, String pubKey) {
        try {
            byte[] pubbyte = hexStrToBytes(pubKey.trim());
            byte[] sign1 = hexStrToBytes(sign);

            PublicKey publicKey = getPublicKeyFromX509(pubbyte);
            Signature sigEng = Signature.getInstance("MD5withRSA");
            sigEng.initVerify(publicKey);
            sigEng.update(src.getBytes());
            if (sigEng.verify(sign1))
                return true;
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    private final byte[] hexStrToBytes(String s) {
        byte[] bytes = new byte[s.length() / 2];
        for (int i = 0; i < bytes.length; i++)
            bytes[i] = (byte)Integer.parseInt(
                    s.substring(2 * i, 2 * i + 2), 16);
        return bytes;
    }

    private PublicKey getPublicKeyFromX509(byte[] encodedKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
    }
}
