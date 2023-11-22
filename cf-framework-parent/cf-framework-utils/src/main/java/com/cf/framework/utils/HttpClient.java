package com.cf.framework.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * http请求客户端
 * 
 * @author Administrator
 * 
 */
public class HttpClient {
	private String url;
	private Map<String, String> param;
	private int statusCode;
	private String content;
	private String xmlParam;
	private boolean isHttps;

	public boolean isHttps() {
		return isHttps;
	}

	public void setHttps(boolean isHttps) {
		this.isHttps = isHttps;
	}

	public String getXmlParam() {
		return xmlParam;
	}

	public void setXmlParam(String xmlParam) {
		this.xmlParam = xmlParam;
	}

	public HttpClient(String url, Map<String, String> param) {
		this.url = url;
		this.param = param;
	}

	public HttpClient(String url) {
		this.url = url;
	}

	public void setParameter(Map<String, String> map) {
		param = map;
	}

	public void addParameter(String key, String value) {
		if (param == null)
			param = new HashMap<String, String>();
		param.put(key, value);
	}

	public void post() throws ClientProtocolException, IOException {
		HttpPost http = new HttpPost(url);
		setEntity(http);
		execute(http);
	}

	public void put() throws ClientProtocolException, IOException {
		HttpPut http = new HttpPut(url);
		setEntity(http);
		execute(http);
	}

	public void get() throws ClientProtocolException, IOException {
		if (param != null) {
			StringBuilder url = new StringBuilder(this.url);
			boolean isFirst = true;
			for (String key : param.keySet()) {
				if (isFirst)
					url.append("?");
				else
					url.append("&");
				url.append(key).append("=").append(param.get(key));
			}
			this.url = url.toString();
		}
		HttpGet http = new HttpGet(url);
		execute(http);
	}

	/**
	 * set http post,put param
	 */
	private void setEntity(HttpEntityEnclosingRequestBase http) {
		if (param != null) {
			List<NameValuePair> nvps = new LinkedList<NameValuePair>();
			for (String key : param.keySet())
				nvps.add(new BasicNameValuePair(key, param.get(key))); // 参数
			http.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8)); // 设置参数
		}
		if (xmlParam != null) {
			http.setEntity(new StringEntity(xmlParam, Consts.UTF_8));
		}
	}

	private void execute(HttpUriRequest http) throws ClientProtocolException,
			IOException {
		CloseableHttpClient httpClient = null;
		try {
			if (isHttps) {
				SSLContext sslContext = new SSLContextBuilder()
						.loadTrustMaterial(null, new TrustStrategy() {
							// 信任所有
							public boolean isTrusted(X509Certificate[] chain,
									String authType)
									throws CertificateException {
								return true;
							}
						}).build();
				SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
						sslContext);
				httpClient = HttpClients.custom().setSSLSocketFactory(sslsf)
						.build();
			} else {
				httpClient = HttpClients.createDefault();
			}
			CloseableHttpResponse response = httpClient.execute(http);
			try {
				if (response != null) {
					if (response.getStatusLine() != null)
						statusCode = response.getStatusLine().getStatusCode();
					HttpEntity entity = response.getEntity();
					// 响应内容
					content = EntityUtils.toString(entity, Consts.UTF_8);
				}
			} finally {
				response.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpClient.close();
		}
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getContent() throws ParseException, IOException {
		return content;
	}

	public static String getIPAddress(HttpServletRequest request) {
		String ip = null;

		//X-Forwarded-For：Squid 服务代理
		String ipAddresses = request.getHeader("X-Forwarded-For");

		if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			//Proxy-Client-IP：apache 服务代理
			ipAddresses = request.getHeader("Proxy-Client-IP");
		}

		if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			//WL-Proxy-Client-IP：weblogic 服务代理
			ipAddresses = request.getHeader("WL-Proxy-Client-IP");
		}

		if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			//HTTP_CLIENT_IP：有些代理服务器
			ipAddresses = request.getHeader("HTTP_CLIENT_IP");
		}

		if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			//X-Real-IP：nginx服务代理
			ipAddresses = request.getHeader("X-Real-IP");
		}

		//有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
		if (ipAddresses != null && ipAddresses.length() != 0) {
			ip = ipAddresses.split(",")[0];
		}

		//还是不能获取到，最后再通过request.getRemoteAddr();获取
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 发起一个GET请求, 返回数据是以JSON格式返回
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static JSONObject doGet(String url) throws IOException {
		JSONObject jsonObject = null;
		CloseableHttpClient client = HttpClients.createDefault();


		HttpGet httpGet = new HttpGet(url);
		HttpResponse response = client.execute(httpGet);
		HttpEntity entity = response.getEntity();

		if (entity != null) {
			String result = EntityUtils.toString(entity, "UTF-8");
			jsonObject = JSONObject.parseObject(result);
		}

		httpGet.releaseConnection();
		return jsonObject;
	}

	/**
	 * 发起一个POST请求, 返回数据是以JSON格式返回
	 * @param params	请求参数
	 * @param url
	 * @param requestHeaders	请求头
	 * @param parse	是否需要解析请求结果
	 * @return
	 * @throws IOException
	 */
	public static Object doPost(JSONObject params, String url, Map<String, String> requestHeaders, boolean parse) throws IOException {
		JSONObject jsonObject = null;
		CloseableHttpClient client = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost(url);
		for (Map.Entry<String, String> entry: requestHeaders.entrySet()){
			httpPost.setHeader(entry.getKey(), entry.getValue());
		}

		StringEntity postingString = new StringEntity(params.toString(),"utf-8");
		httpPost.setEntity(postingString);
		HttpResponse response = client.execute(httpPost);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			if(parse){
				String result = EntityUtils.toString(entity, "UTF-8");
				jsonObject = JSONObject.parseObject(result);
			}else{
				InputStream content = response.getEntity().getContent();
				byte[] bytes = toByteArray(content);
				httpPost.releaseConnection();
				return bytes;
			}

		}
		httpPost.releaseConnection();
		return jsonObject;
	}

	/**
	 * 发起一个POST请求, 返回数据是以JSON格式返回
	 * @param params	请求参数(给的是字符串)
	 * @param url
	 * @param requestHeaders	请求头
	 * @param parse	是否需要解析请求结果
	 * @return
	 * @throws IOException
	 */
	public static Object doPostByString(String params, String url, Map<String, String> requestHeaders, boolean parse) throws IOException {
		JSONObject jsonObject = null;
		CloseableHttpClient client = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost(url);
		for (Map.Entry<String, String> entry: requestHeaders.entrySet()){
			httpPost.setHeader(entry.getKey(), entry.getValue());
		}

		StringEntity postingString = new StringEntity(params,"utf-8");
		httpPost.setEntity(postingString);
		HttpResponse response = client.execute(httpPost);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			if(parse){
				String result = EntityUtils.toString(entity, "UTF-8");
				jsonObject = JSONObject.parseObject(result);
			}else{
				InputStream content = response.getEntity().getContent();
				byte[] bytes = toByteArray(content);
				httpPost.releaseConnection();
				return bytes;
			}

		}
		httpPost.releaseConnection();
		return jsonObject;
	}

	public static byte[] toByteArray(InputStream input) throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024*4];
		int n = 0;
		while (-1 != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
		}
		return output.toByteArray();
	}

}
