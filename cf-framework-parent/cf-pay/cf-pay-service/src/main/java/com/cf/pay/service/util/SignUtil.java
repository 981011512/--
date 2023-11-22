/**  
 * All rights Reserved, Designed By www.tydic.com
 * @Title: SignUtil.java   
 * @Package: com.example.down   
 * @Description: 
 * @author: wangtao 
 * @date: 2019年10月15日 下午3:06:54
 */
package com.cf.pay.service.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


/**
 * @ClassName: SignUtil
 * @Description:
 * @author: wangtao
 * @date: 2019年10月15日 下午3:06:54
 */
public class SignUtil {
	// 获取sign
	public static String getSign(Map<String, String> map, String key) {
		List<String> list = new ArrayList<String>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (!StringUtils.isBlank(entry.getValue())) {
				list.add(entry.getKey() + "=" + entry.getValue());// key=value
			}
		}
		Collections.sort(list);
		String str2 = "";
		for (int i = 0; i < list.size(); i++) {
			str2 += list.get(i) + "&";
		}
		str2 += "key=" + key;
		str2 = MD5(str2);
		return str2;
	}

	public static String getSign(Map<String, String> map) {
		List<String> list = new ArrayList<String>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (!StringUtils.isBlank(entry.getValue())) {
				list.add(entry.getKey() + "=" + entry.getValue());// key=value
			}
		}
		Collections.sort(list);
		String str2 = "";
		for (int i = 0; i < list.size(); i++) {
			str2 += list.get(i) + "&";
		}
		return str2;
	}

	// md5加密
	public static String MD5(String sourceStr) {
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(sourceStr.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			result = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e);
		}
		return result.toUpperCase();
	}

	public static boolean checksign(String str, String key) {
		JSONObject json = JSON.parseObject(str);
		if (json.containsKey("sign")) {
			String returnsign = json.getString("sign");
			json.remove("sign");
			String checksign = getSign((Map) json, key);
			if (StringUtils.isNotBlank(returnsign) && returnsign.equals(checksign)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
