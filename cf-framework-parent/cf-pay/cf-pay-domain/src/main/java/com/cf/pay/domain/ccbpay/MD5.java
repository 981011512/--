package com.cf.pay.domain.ccbpay;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class MD5 {
    String md5Str(String str) {
        if (str == null)
            return "";
        return md5Str(str, 0);
    }

    String md5Str(String str, int offset) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] b = str.getBytes("UTF-8");
            md5.update(b, offset, b.length);
            return byteArrayToHexString(md5.digest());
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private String byteArrayToHexString(byte[] b) {
        String result = "";
        for (int i = 0; i < b.length; i++)
            result = String.valueOf(result) + byteToHexString(b[i]);
        return result;
    }

    private static String[] hexDigits = new String[] {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b",
            "c", "d", "e", "f" };

    private String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return String.valueOf(hexDigits[d1]) + hexDigits[d2];
    }
}
