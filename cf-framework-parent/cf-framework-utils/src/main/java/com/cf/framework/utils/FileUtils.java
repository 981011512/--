package com.cf.framework.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUtils {
	/**
	 * 根据url拿取file
	 * 
	 * @param url
	 * @param suffix
	 *            文件后缀名
	 */
	public static File createFileByUrl(String url, String suffix) {
		byte[] byteFile = getImageFromNetByUrl(url);
		if (byteFile != null) {
			File file = getFileFromBytes(byteFile, suffix);
			return file;
		} else {
			return null;
		}
	}

	/**
	 * 根据地址获得数据的字节流
	 * 
	 * @param strUrl
	 *            网络连接地址
	 * @return
	 */
	private static byte[] getImageFromNetByUrl(String strUrl) {
		try {
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5 * 1000);
			InputStream inStream = conn.getInputStream();// 通过输入流获取图片数据
			byte[] btImg = readInputStream(inStream);// 得到图片的二进制数据
			return btImg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 从输入流中获取数据
	 * 
	 * @param inStream
	 *            输入流
	 * @return
	 * @throws Exception
	 */
	private static byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toByteArray();
	}

	// 创建临时文件
	private static File getFileFromBytes(byte[] b, String suffix) {
		BufferedOutputStream stream = null;
		File file = null;
		try {
			file = File.createTempFile("pattern", "." + suffix);
			System.out.println("临时文件位置：" + file.getCanonicalPath());
			FileOutputStream fstream = new FileOutputStream(file);
			stream = new BufferedOutputStream(fstream);
			stream.write(b);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return file;
	}

	public static MultipartFile createImg(String url) {
		try {
			// File转换成MutipartFile
			File file = FileUtils.createFileByUrl(url, "jpg");
			FileInputStream inputStream = new FileInputStream(file);
			MultipartFile multipartFile = new MockMultipartFile(file.getName(), inputStream);
			return multipartFile;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static MultipartFile fileToMultipart(String filePath) {
		try {
			// File转换成MutipartFile
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			MultipartFile multipartFile = new MockMultipartFile(file.getName(), "png", "image/png", inputStream);
			return multipartFile;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		// WebFileUtils.createFileByUrl("http://122.152.205.72:88/group1/M00/00/01/CpoxxFr7oIaAZ0rOAAC0d3GKDio580.png",
		// "png");
		// WebFileUtils.createImg("http://122.152.205.72:88/group1/M00/00/01/CpoxxFr7oIaAZ0rOAAC0d3GKDio580.png");
	}

	public static boolean base64ToFile(String filePath, String base64Data)  throws Exception {
		String dataPrix = "";
        String data = "";
        
        if(base64Data == null || "".equals(base64Data)){
            return false;
        }else{
            String [] d = base64Data.split("base64,");
            if(d != null && d.length == 2){
                dataPrix = d[0];
                data = d[1];
            }else{
                return false;
            }
        }

        // 因为BASE64Decoder的jar问题，此处使用spring框架提供的工具包
        byte[] bs = Base64Utils.decodeFromString(data);
        // 使用apache提供的工具类操作流
        org.apache.commons.io.FileUtils.writeByteArrayToFile(new File(filePath), bs);
        
        return true;
	}

	/**
	 * 处理文件地址前缀
	 * @param sourceList
	 * @param preFix
	 * @param sourceField
	 * @throws Exception
	 */
	public static void handleFileSourcePrefix(List<Object> sourceList, String preFix, String sourceField) throws Exception
	{
		for (Object source: sourceList){
			String firstWord = sourceField.substring(0, 1).toUpperCase();
			String getMethodName = String.format("get%s%s", firstWord, sourceField.substring(1));
			Method getMethod = source.getClass().getMethod(getMethodName, (new String()).getClass());
			Object fieldValue = getMethod.invoke(source, new Object[]{});
			String setMethodName = String.format("set%s%s", firstWord, sourceField.substring(1));
			Method setMethod = source.getClass().getMethod(setMethodName, (new String()).getClass());
			setMethod.invoke(source, preFix+(String) fieldValue);
		}
	}

	/**
	 * 处理文件地址前缀
	 * @param source
	 * @param preFix
	 * @param sourceField
	 * @throws Exception
	 */
	public static void handleFileSourcePrefix(Object source, String preFix, String sourceField) throws Exception
	{
		if(StringUtils.isEmpty(preFix)){
			preFix = "http://file.cfeng.wang/";
		}
		String firstWord = sourceField.substring(0, 1).toUpperCase();
		if(source instanceof HashMap){
			source = (Map<String, String>)source;
			if(((HashMap<?, ?>) source).containsKey(sourceField) && StringUtils.isNotEmpty(((HashMap<?, ?>) source).get(sourceField).toString()) && ((HashMap<?, ?>) source).get(sourceField).toString().toString().indexOf("http://")<0 && ((HashMap<?, ?>) source).get(sourceField).toString().toString().indexOf("https://")<0){
				((HashMap<String, String>) source).put(sourceField,preFix+((HashMap<?, ?>) source).get(sourceField).toString());
			}
		}else{
			String getMethodName = String.format("get%s%s", firstWord, sourceField.substring(1));
			Method getMethod = source.getClass().getMethod(getMethodName);
			Object fieldValue = getMethod.invoke(source, new Object[]{});
			//如果是完整的网络地址，直接返回
			if(fieldValue!=null && StringUtils.isNotEmpty(fieldValue.toString()) && fieldValue.toString().indexOf("http://")<0 && fieldValue.toString().indexOf("https://")<0){
				//如果有英文逗号隔开，需要处理
				if(fieldValue.toString().indexOf(",")<0){
					String setMethodName = String.format("set%s%s", firstWord, sourceField.substring(1));
					Method setMethod = source.getClass().getMethod(setMethodName, (new String()).getClass());
					setMethod.invoke(source, preFix+(String) fieldValue);
				}else{
					String[] images = fieldValue.toString().split(",");
					String newString = "";
					for(int i=0; i<images.length; i++){
						if(StringUtils.isNotEmpty(images[i])){
							if(i!=images.length-1){
								newString += preFix+ images[i]+",";
							}else{
								newString += preFix+ images[i];
							}
						}
					}
					String setMethodName = String.format("set%s%s", firstWord, sourceField.substring(1));
					Method setMethod = source.getClass().getMethod(setMethodName, (new String()).getClass());
					setMethod.invoke(source, newString);
				}
			}
		}
	}
}
