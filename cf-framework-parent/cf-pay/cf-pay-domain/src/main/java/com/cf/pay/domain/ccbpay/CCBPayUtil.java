package com.cf.pay.domain.ccbpay;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CCBPayUtil {
    private final String VERSION = "1.0.0";

    private final String MD5KEY = "20120315201809041004";

    public String makeCCBParam(String params, String pubkey) throws UnsupportedEncodingException {
        String md5Str = dicSort(params);
        md5Str = String.valueOf(md5Str) + MD5KEY;
        String mac = (new MD5()).md5Str(md5Str);
        params = String.valueOf(params) + "&SIGN=" + mac;
        if (pubkey.length() >= 30)
            pubkey = pubkey.substring(pubkey.length() - 30);
        if (pubkey.length() >= 8)
            pubkey = pubkey.substring(0, 8);
        DES_ENCRY_DECRY des = new DES_ENCRY_DECRY(pubkey);
        String encrypt = des.tdesEncryptSample(params.getBytes("utf-16"));
        encrypt = encrypt.replaceAll("\\+", ",");
        String url = URLEncoder.encode(encrypt, "iso-8859-1");
        log(md5Str);
        log(params);
        log(url);
        return url;
    }

    public boolean verifyNotifySign(String src, String sign, String pubKey) {
        return (new Notify_Verify()).verifySigature(src, sign, pubKey);
    }

    private String dicSort(String params) {
        return getSignContent(strToMap(params));
    }

    private Map<String, String> strToMap(String params) {
        Map<String, String> requestMap = new TreeMap<String, String>();
        String[] kv = params.split("&");
        byte b;
        int i;
        String[] arrayOfString1;
        for (i = (arrayOfString1 = kv).length, b = 0; b < i; ) {
            String s = arrayOfString1[b];
            if (!"".equals(s)) {
                String[] v1 = s.split("\\=");
                if (v1.length == 1) {
                    requestMap.put(v1[0], "");
                } else {
                    requestMap.put(v1[0], v1[1]);
                }
            }
            b++;
        }
        return requestMap;
    }

    private String getSignContent(Map<String, String> sortedParams) {
        if (sortedParams == null)
            return "";
        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(sortedParams.keySet());
        Collections.sort(keys);
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = sortedParams.get(key);
            if (areNotEmpty(new String[] { key, value })) {
                content.append(String.valueOf((index == 0) ? "" : "&") + key + "=" + value);
                index++;
            }
        }
        return content.toString();
    }

    private boolean areNotEmpty(String... values) {
        boolean result = true;
        if (values == null || values.length == 0) {
            result = false;
        } else {
            byte b;
            int j;
            String[] arrayOfString;
            for (j = (arrayOfString = values).length, b = 0; b < j; ) {
                String value = arrayOfString[b];
                result = result & (!isEmpty(value));
                b++;
            }
        }
        return result;
    }

    private boolean isEmpty(String value) {
        int strLen;
        if (value == null || (strLen = value.length()) == 0)
            return true;
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(value.charAt(i)))
                return false;
        }
        return true;
    }

    private void log(String s) {}
}
