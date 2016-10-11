package com.mdzy.xqbadmin.common.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 短信验证功能
 * @author wang
 */
public class SmsTools {
    private static String UTF8 = "utf-8";
    private static Boolean ISTEST = false;
    private static String HTTP_SSL_IP = "127.0.0.1";
    private static int HTTP_SSL_PORT = 0;
    private static String VERSION = "2014-06-30";//版本
    private static String REST_SERVER = "https://api.ucpaas.com";//REST服务
    //private static String ACCOUNTSID = "47192350b53c7006e2797f4eb3bfd184";//
    private static String ACCOUNTSID = "6a99b88d001e57dd8f7a47415310311e";//
   // private static String AUTHTOKEN = "fbc3d4db84232b65bf090ac51ba4de52";//
    private static String AUTHTOKEN = "abd3305007b29766466ebc54cc4e50d7";//
   // private static String APPID = "12e5fbc02ad141f4bf3272f087e0d5bf";//应用
    private static String APPID = "be458785e9d14c249c5a61d8f387bfeb";//应用
    //private static String TEMPLATEID = "11559";//模版
    private static String TEMPLATEID = "22351";//模版

    public static DefaultHttpClient getDefaultHttpClient() throws Exception {
        DefaultHttpClient httpclient = null;
        if (ISTEST) {
            try {
                SSLHttpClient chc = new SSLHttpClient();
                httpclient = chc.registerSSL(HTTP_SSL_IP, "TLS", HTTP_SSL_PORT,
                        "https");
                HttpParams hParams = new BasicHttpParams();
                hParams.setParameter("https.protocols", "SSLv3,SSLv2Hello");
                httpclient.setParams(hParams);
            } catch (Exception e) {

            }

        } else {
            httpclient = new DefaultHttpClient();
        }
        return httpclient;
    }

    public static String templateSMS(String to, String param) {
        String result = "";
        DefaultHttpClient httpclient = null;
        try {
            httpclient = getDefaultHttpClient();
            // 构造请求URL内容
            String timestamp = dateToStr(new Date(), "yyyyMMddHHmmss");// 时间戳
            String sig = ACCOUNTSID + AUTHTOKEN + timestamp;
            String signature = md5Digest(sig);
            String url = new StringBuffer(REST_SERVER).append("/").append(VERSION)
                    .append("/Accounts/").append(ACCOUNTSID)
                    .append("/Messages/templateSMS").append("?sig=")
                    .append(signature).toString();
            Map<String, String> map = new HashMap<String, String>();
            map.put("accountSid", ACCOUNTSID);
            map.put("authToken", AUTHTOKEN);
            map.put("appId", APPID);
            map.put("templateId", TEMPLATEID);
            map.put("to", to);
            map.put("param", param);
            String body = JsonTools.toJson(map);

            body = "{\"templateSMS\":" + body + "}";

            HttpResponse response = get("application/json", ACCOUNTSID,
                    AUTHTOKEN, timestamp, url, httpclient, body);
            // 获取响应实体信息
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                result = EntityUtils.toString(entity, "UTF-8");
            }
            // 确保HTTP响应内容全部被读出或者内容流被关闭
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            if (httpclient != null) {
                httpclient.getConnectionManager().shutdown();
            }
        }
        return result;
    }
    
    public static String templateSMS(String to, String param,String templateId) {
        String result = "";
        DefaultHttpClient httpclient = null;
        try {
            httpclient = getDefaultHttpClient();
            // 构造请求URL内容
            String timestamp = dateToStr(new Date(), "yyyyMMddHHmmss");// 时间戳
            String sig = ACCOUNTSID + AUTHTOKEN + timestamp;
            String signature = md5Digest(sig);
            String url = new StringBuffer(REST_SERVER).append("/").append(VERSION)
                    .append("/Accounts/").append(ACCOUNTSID)
                    .append("/Messages/templateSMS").append("?sig=")
                    .append(signature).toString();
            Map<String, String> map = new HashMap<String, String>();
            map.put("accountSid", ACCOUNTSID);
            map.put("authToken", AUTHTOKEN);
            map.put("appId", APPID);
            map.put("templateId", templateId);
            map.put("to", to);
            map.put("param", param);
            String body = JsonTools.toJson(map);

            body = "{\"templateSMS\":" + body + "}";

            HttpResponse response = get("application/json", ACCOUNTSID,
                    AUTHTOKEN, timestamp, url, httpclient, body);
            // 获取响应实体信息
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity, "UTF-8");
            }
            // 确保HTTP响应内容全部被读出或者内容流被关闭
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接
            if (httpclient != null) {
                httpclient.getConnectionManager().shutdown();
            }
        }
        return result;
    }

    private static HttpResponse get(String cType, String accountSid,
                                    String authToken, String timestamp, String url,
                                    DefaultHttpClient httpclient, String body) throws Exception {
        HttpPost httppost = new HttpPost(url);
        httppost.setHeader("Accept", cType);//
        httppost.setHeader("Content-Type", cType);
        String src = accountSid + ":" + timestamp;
        String auth = base64Encoder(src);
        httppost.setHeader("Authorization", auth);
        BasicHttpEntity requestBody = new BasicHttpEntity();
        requestBody
                .setContent(new ByteArrayInputStream(body.getBytes("UTF-8")));
        requestBody.setContentLength(body.getBytes("UTF-8").length);
        httppost.setEntity(requestBody);
        HttpResponse response = httpclient.execute(httppost);
        return response;
    }

    public static String dateToStr(Date date, String pattern) {
        if (date == null || date.equals(""))
            return null;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    public static String md5Digest(String src) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(src.getBytes(UTF8));
        return byte2HexStr(b);
    }

    public static String base64Encoder(String src) throws Exception {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(src.getBytes(UTF8));
    }

    public static String base64Decoder(String dest) throws Exception {
        BASE64Decoder decoder = new BASE64Decoder();
        return new String(decoder.decodeBuffer(dest), UTF8);
    }

    public static String byte2HexStr(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            String s = Integer.toHexString(b[i] & 0xFF);
            if (s.length() == 1) {
                sb.append("0");
            }
            sb.append(s.toUpperCase());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
       // System.out.println(SmsTools.templateSMS("18035147802", "1358"));
        System.out.println(SmsTools.templateSMS("18035147802","wqeqwe","22352"));
    }

}
