package com.cf.framework.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Created by mrt on 2020/5/22.
 */
public class BCryptUtil {
    public static String encode(String password){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashPass = passwordEncoder.encode(password);
        return hashPass;
    }
    public static boolean matches(String password,String hashPass){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean f = passwordEncoder.matches(password, hashPass);
        return f;
    }

    public static void checkSignType(String signType) throws Exception{
        if(StringUtils.isEmpty(signType) || (!signType.equals("MD5") && !signType.equals("HMACSHA256") && !signType.equals("SHA-1"))){
            throw new Exception("signType not support");
        }
    }

    /**
     * 校验签名是否合法
     * @param data
     * @param key
     * @param signType
     * @return
     * @throws Exception
     */
    public static boolean isSignatureValid(Map<String, String> data, String key, String signType) throws Exception {
        checkSignType(signType);
        if (!data.containsKey("sign")) {
            return false;
        } else {
            String sign = (String)data.get("sign");
            return generateSignature(data, key, signType).equals(sign);
        }
    }

    /**
     * 制作签名
     * @param data
     * @param key
     * @param signType
     * @return
     * @throws Exception
     */
    public static String generateSignature(Map<String, String> data, String key, String signType) throws Exception {
        checkSignType(signType);
        Set<String> keySet = data.keySet();
        String[] keyArray = (String[])keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        String[] var6 = keyArray;
        int var7 = keyArray.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            String k = var6[var8];
            if (!k.equals("sign") && ((String)data.get(k)).trim().length() > 0) {
                sb.append(k).append("=").append(((String)data.get(k)).trim()).append("&");
            }
        }

        sb.append("key=").append(key);
        if ("MD5".equals(signType)) {
            return MD5(sb.toString()).toUpperCase();
        } else if ("HMACSHA256".equals(signType)) {
            return HMACSHA256(sb.toString(), key);
        }  else if ("SHA1".equals(signType)) {
            return SHA1(sb.toString());
        } else {
            throw new Exception(String.format("Invalid sign_type: %s", signType));
        }
    }

    /**
     * 制作签名
     * @param data
     * @return
     * @throws Exception
     */
    public static String generateSHA1Signature(Map<String, String> data) throws Exception {
        Set<String> keySet = data.keySet();
        String[] keyArray = (String[])keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        String[] var6 = keyArray;
        int var7 = keyArray.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            String k = var6[var8];
            if (((String)data.get(k)).trim().length() > 0) {
                sb.append(k).append("=").append(((String)data.get(k)).trim()).append("&");
            }
        }
        return SHA1(sb.toString()).toUpperCase();
    }

    public static String MD5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        byte[] var4 = array;
        int var5 = array.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            byte item = var4[var6];
            sb.append(Integer.toHexString(item & 255 | 256).substring(1, 3));
        }

        return sb.toString().toUpperCase();
    }

    public static String HMACSHA256(String data, String key) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        byte[] var6 = array;
        int var7 = array.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            byte item = var6[var8];
            sb.append(Integer.toHexString(item & 255 | 256).substring(1, 3));
        }

        return sb.toString().toUpperCase();
    }

    public static String SHA1(String content) throws Exception {
        // Create MD5 Hash
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.update(content.getBytes());
        byte messageDigest[] = digest.digest();

        // Create Hex String
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < messageDigest.length; i++)
            hexString.append(String.format("%02X", 0xFF & messageDigest[i]));

        return   hexString.toString().toUpperCase();
    }
}
