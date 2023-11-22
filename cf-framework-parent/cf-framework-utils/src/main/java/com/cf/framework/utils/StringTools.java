package com.cf.framework.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 */
public class StringTools {

    /**
     * 随机获取字符串
     * @param optionalCharacter 可操作的字符串
     * @param length    生成长度
     * @return
     */
    public static String getRandomString(String optionalCharacter, Integer length){
        if(StringUtils.isEmpty(optionalCharacter)){
            optionalCharacter = "abcdefghijklmnopqrstuxyvwzABCDEFGHIJKLMNOPQRSTUXYVWZ0123456789";
        }
        if(length==null || length==0){
            length = 10;
        }
        String randomString = "";
        Random random = new Random();
        for(int i=0; i<length; i++){
            int radomInt = getRadomInt(0, optionalCharacter.length() - 2);
            randomString+= optionalCharacter.substring(radomInt,radomInt+1);
        }
        return randomString;
    }

    /**
     * 获取一个范围内的随机数字
     * @return
     */
    public static int getRadomInt(int min,int max){
        return (new Random()).nextInt(max-min+1)+min;
    }


    /**
     * XML格式字符串转换为Map
     *
     * @param xml XML字符串
     * @return XML数据转换后的Map
     * @throws Exception
     */
    public static Map<String, String> xmlToMap(String xml) throws Exception{
        InputStream stream = null;
        try {
            Map<String, String> data = new HashMap<>();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
            org.w3c.dom.Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            stream.close();
            return data;
        } catch (Exception e) {
            stream.close();
            return null;
        }
    }

    /**
     *
     * @Description: 将实体类clazz的属性转换为url参数
     * @param clazz	参数实体类
     * @return
     * String
     */
    public static String pojoToURLParams(Object clazz) throws Exception{
        // 遍历属性类、属性值
        Field[] fields = clazz.getClass().getDeclaredFields();

        StringBuilder requestURL = new StringBuilder();
            boolean flag = true;
            String property, value;
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                // 允许访问私有变量
                field.setAccessible(true);

                // 属性名
                property = field.getName();
                // 属性值
                if(field.get(clazz)==null){
                    value = "";
                }else{
                    value = field.get(clazz).toString();
                }


                String params = property + "=" + value;
                if (flag) {
                    flag = false;
                }
                if(StringUtils.isNotEmpty(value)){
                    requestURL.append("&" + params);
                }
            }
        return requestURL.toString();
    }


    /**
     *
     * @Description: 将实体类clazz转换为JSONObject
     * @param clazz	参数实体类
     * @return
     * String
     */
    public static JSONObject pojoToJSONObject(Object clazz) throws Exception{
        // 遍历属性类、属性值
        Field[] fields = clazz.getClass().getDeclaredFields();

        JSONObject jsonObject = new JSONObject();
        boolean flag = true;
        String property, value;
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            // 允许访问私有变量
            field.setAccessible(true);

            // 属性名
            property = field.getName();
            // 属性值
            if(field.get(clazz)==null){
                value = "";
            }else{
                value = field.get(clazz).toString();
            }

            if(StringUtils.isNotEmpty(value)){
                jsonObject.put(property, value);
            }
        }
        return jsonObject;
    }

    /**
     * 查找指定字符串数组中的目标
     * @param stringArray
     * @param targetValue
     * @return
     */
    public static int findStringInArray(String[] stringArray, String targetValue){
        int i = -1;
        int length = stringArray.length;
        for (int j = 0; j < length; j++) {
            if(stringArray[j].equals(targetValue)){
                i = j;
                break;
            }
        }
        return i;
    }

    /**
     * @Title:判断是否存在特殊字符串
     * @param
     * @author:yanbing
     * @date:2017-12-05 10:14
     */
    public static boolean hasEmoji(String content){
        Pattern pattern = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]");
        Matcher matcher = pattern.matcher(content);
        if(matcher .find()){
            return true;
        }
        return false;
    }

    /**
     * @Title:替换字符串中的emoji字符
     * @param
     * @author:yanbing
     * @date:2017-12-05 10:17
     */
    public static String replaceEmoji(String str){
        if(!hasEmoji(str)){
            return str;
        }else{
            str=str.replaceAll("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]", " ");
            return str;
        }
    }

    /**
     * 数字补齐(例如前缀补0等)
     * @param makeUpStr 要补的字符 例如 补0  请传入字符串的0
     * @param number
     * @param length
     * @return
     */
    public static String preMakeUp(String makeUpStr, String number, int length){
        int sLength = number.length();
        if(sLength>=length){
            return number;
        }
        String pre = "";
        for(int i=0; i<length-sLength; i++){
            pre += makeUpStr;
        }
        return pre+number;
    }

    //16进制字符异或
    public static String hexXOP(String content) {
        content = change(content);
        String[] b = content.split(" ");
        int a = 0;
        for (int i = 0; i < b.length; i++) {
            a = a ^ Integer.parseInt(b[i], 16);
        }
        if(a<10){
            StringBuffer sb = new StringBuffer();
            sb.append("0");
            sb.append(a);
            return sb.toString();
        }
        String hexString = Integer.toHexString(a);
        if(hexString.length()<2){
            hexString = "0"+hexString;
        }
        return hexString;
    }

    public static String change(String content) {
        String str = "";
        for (int i = 0; i < content.length(); i++) {
            if (i % 2 == 0) {
                str += " " + content.substring(i, i + 1);
            } else {
                str += content.substring(i, i + 1);
            }
        }
        return str.trim();
    }

    /**
     * 将Hex String转换为Byte数组
     *
     * @param hexString the hex string
     * @return the byte [ ]
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (StringUtils.isEmpty(hexString)) {
            return null;
        }
        hexString = hexString.toLowerCase();
        final byte[] byteArray = new byte[hexString.length() >> 1];
        int index = 0;
        for (int i = 0; i < hexString.length(); i++) {
            if (index  > hexString.length() - 1) {
                return byteArray;
            }
            byte highDit = (byte) (Character.digit(hexString.charAt(index), 16) & 0xFF);
            byte lowDit = (byte) (Character.digit(hexString.charAt(index + 1), 16) & 0xFF);
            byteArray[i] = (byte) (highDit << 4 | lowDit);
            index += 2;
        }
        return byteArray;
    }

    /**
     * byte[] 转16进制字符串
     * @param b
     * @return
     */
    public static String bytesToString16(byte[] b) {
        char[] _16 = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<b.length;i++) {
            sb.append(_16[b[i]>>4&0xf])
                    .append(_16[b[i]&0xf]);
        }
        return sb.toString();
    }

    /**
     * 16进制转字符串
     * @param s
     * @return
     */
    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword);
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    /**
     * 字符串转化成为16进制字符串(无需Unicode编码)
     * @param s
     * @return
     */
    public static String strToHexString(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }

    /**
     * 字符串转换成为16进制(需Unicode编码，默认UTF-8)
     * @param str
     * @param charsetName
     * @return
     */
    public static String str2HexStr(String str, String charsetName) throws Exception {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = null;
        if(charsetName.equals("GB18030")){
            bs = str.getBytes("GB18030");
        }else if(charsetName.equals("GBK")){
            bs = str.getBytes("GBK");
        }else if(charsetName.equals("GB2312")){
            bs = str.getBytes("GB2312");
        }else{
            bs = str.getBytes("UTF-8");
        }
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            // sb.append(' ');
        }
        return sb.toString().trim();
    }

    /**
     * 模糊部分字符串
     * @param sourceString   源字符串
     * @param limitLength   限定长度 当字符串长度达到多少才会触发
     * @param reserveWordCount    保留字数
     * @return
     */
    public static String vaguePartString(String sourceString ,Integer limitLength, Integer reserveWordCount){
        if(sourceString==null || sourceString.length()<=limitLength){
            return sourceString;
        }
        StringBuilder stringBuilder = new StringBuilder(sourceString);
        StringBuilder replace = stringBuilder.replace(reserveWordCount, sourceString.length() - reserveWordCount, "***");
        return replace.toString();
    }

    //base64加密
    public static String setEncryptionBase64(String str) throws Exception{
        byte[] b = null;
        String s = null;
            b = str.getBytes("utf-8");

        if( b != null){
            s = new BASE64Encoder().encode(b);
        }
        return s;

    }

    //base64解密
    public static String getDecodeBase64(String str){
        byte[] b = null;
        String result = null;
        if(str != null){
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(str);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 对字符串进行逆序
     * @param contents
     * @param stepSize  步长，以多少个字符为单位
     * @return
     */
    public static String reverseOrder(String contents, Integer stepSize) throws Exception{
        int contentsLength = contents.length();
        if(contentsLength<=stepSize){
            return contents;
        }
        if(contentsLength%stepSize!=0){
            throw new Exception("reverse order fail !");
        }
        int total = contentsLength/stepSize;
        String newContents = "";
        for(int i=1; i<=total; i++){
            newContents += contents.substring(contentsLength-(i*stepSize),contentsLength-((i-1)*stepSize));
        }
        return newContents;
    }

    /**
     * 解析url地址
     * @param _rul
     * @return
     * @throws Exception
     */
    public static String parseURL(String _rul) throws Exception{
        URL url = new URL(_rul);
        System.out.println("URL 是 " + url.toString());
        System.out.println("协议是 " + url.getProtocol());
        System.out.println("文件名是 " + url.getFile());
        System.out.println("主机是 " + url.getHost());
        System.out.println("路径是 " + url.getPath());
        System.out.println("端口号是 " + url.getPort());
        return url.getPath();
    }

}
