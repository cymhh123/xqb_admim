package com.mdzy.xqbadmin.common.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpTools {
	private static HttpClient client = null;

	static {
		client = new HttpClient(new MultiThreadedHttpConnectionManager());
		client.getHttpConnectionManager().getParams()
				.setConnectionTimeout(30000);
	}

	public static String get(String url) {
		System.err.println("请求url-->" + url);
		String strGetResponseBody = "";
		GetMethod get = new GetMethod(url);
		get.setFollowRedirects(true);

		try {
			int iGetResultCode = client.executeMethod(get);
			strGetResponseBody = get.getResponseBodyAsString();
			System.err.println("状态-->" + iGetResultCode);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			get.releaseConnection();
		}

		return strGetResponseBody;

	}
	
	public static String getSetHeader(String url,List<Map<String,String>> headerList) {
		System.err.println("请求url-->" + url);
		String strGetResponseBody = "";
		GetMethod get = new GetMethod(url);
		for(Map<String,String>m:headerList){
			get.setRequestHeader(m.get("headerName"), m.get("headerValue"));
		}
		get.setFollowRedirects(true);

		try {
			int iGetResultCode = client.executeMethod(get);
			strGetResponseBody = get.getResponseBodyAsString();

			System.err.println("状态-->" + iGetResultCode);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			get.releaseConnection();
		}

		return strGetResponseBody;

	}

	public static String executeGet(String url,List<Map<String,String>> headerList){
		System.err.println("请求url-->" + url);
		String strGetResponseBody = "";
		GetMethod get = new GetMethod(url);
		for(Map<String,String>m:headerList){
			get.setRequestHeader(m.get("headerName"), m.get("headerValue"));
		}
		get.setFollowRedirects(true);

		try {
			int iGetResultCode = client.executeMethod(get);
			strGetResponseBody = get.getResponseBodyAsString();

			System.err.println("状态-->" + iGetResultCode);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			get.releaseConnection();
		}

		return strGetResponseBody;
	}

	public static String post(String url, Map<String, String> map) {
		// TODO Auto-generated method stub
		String strPostResponseBody = "";
		PostMethod post = new PostMethod(url);

		// json
		try {
			StringRequestEntity entity = new StringRequestEntity(
					JSON.toJSONString(map), "application/json", "UTF-8");
			post.setRequestEntity(entity);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			int iPostResultCode = client.executeMethod(post);
			strPostResponseBody = post.getResponseBodyAsString();

			System.err.println("-->" + iPostResultCode);
			// System.err.println("===" + strPostResponseBody);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			post.releaseConnection();
		}
		return strPostResponseBody;
	}
	public static String executePost(String url, Map<String, String> map,List<Map<String,String>> headerList) {
		// TODO Auto-generated method stub
		String strPostResponseBody = "";
		PostMethod post = new PostMethod(url);
		for(Map<String,String>m:headerList){
			post.setRequestHeader(m.get("headerName"), m.get("headerValue"));
		}
		// json
		try {
			StringRequestEntity entity = new StringRequestEntity(
					JSON.toJSONString(map), "application/json", "UTF-8");
			post.setRequestEntity(entity);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			int iPostResultCode = client.executeMethod(post);
			strPostResponseBody = post.getResponseBodyAsString();

			System.err.println("-->" + iPostResultCode);
			// System.err.println("===" + strPostResponseBody);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			post.releaseConnection();
		}
		return strPostResponseBody;
	}
	public static int postCode(String url, Map<String, String> map) {
		// TODO Auto-generated method stub
		int iPostResultCode = 0;
		PostMethod post = new PostMethod(url);
		String strPostResponseBody = "";
		// json
		try {
			StringRequestEntity entity = new StringRequestEntity(
					JSON.toJSONString(map), "application/json", "UTF-8");
			post.setRequestEntity(entity);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			 iPostResultCode = client.executeMethod(post);
			 strPostResponseBody = post.getResponseBodyAsString();
			 System.err.println("-->" + iPostResultCode);
			 System.err.println("===" + strPostResponseBody);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			post.releaseConnection();
		}

		return iPostResultCode;

	}
	public static int DeleteCode(String url, List<Map<String, String>> headerList) {
		// TODO Auto-generated method stub
		int iPostResultCode = 0;
		DeleteMethod deMethod=new DeleteMethod(url);
		String strPostResponseBody = "";
		for(Map<String,String>m:headerList){
			deMethod.setRequestHeader(m.get("headerName"), m.get("headerValue"));
		}

		try {
			 iPostResultCode = client.executeMethod(deMethod);
			 strPostResponseBody = deMethod.getResponseBodyAsString();
			 System.err.println("-->" + iPostResultCode);
			 System.err.println("===" + strPostResponseBody);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			deMethod.releaseConnection();
		}

		return iPostResultCode;

	}
	
	public static String postRaw(String url,String raw)  {
		// TODO Auto-generated method stub
		String strPostResponseBody = "";
		PostMethod post = new PostMethod(url);
		post.setRequestBody(raw);

		try {
			int iPostResultCode = client.executeMethod(post);
			strPostResponseBody = post.getResponseBodyAsString();

			System.err.println("-->" + iPostResultCode);
			// System.err.println("===" + strPostResponseBody);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			post.releaseConnection();
		}

		return strPostResponseBody;

	}
	
	public static String postParam(String url,NameValuePair[] params){
		String strPostResponseBody = "";
		PostMethod post=new PostMethod(url);

		post.setRequestBody(params);
		
		try {
			int  iPostResultCode = client.executeMethod(post);
			
			strPostResponseBody = post.getResponseBodyAsString();
			
			System.err.println("-->" + iPostResultCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			post.releaseConnection();
		}

		
		return strPostResponseBody;
	}
	/**
	 * 删除环信账号
	 * @param args
	 */
	public static void main(String[] args) {
//		String url ="http://a1.easemob.com/liyanwei1007/beizhiyuan/users";;
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("username", "smith");
//		map.put("password", "8337728");
//		System.err.println(postCode(url, map));
		
		String tokenUrl="http://a1.easemob.com/mdzy/beizhiyuan/token";
		String delUrl="http://a1.easemob.com/mdzy/beizhiyuan/users/18035147802";
 	    Map<String,String>paramMap=new HashMap<String,String>();
       paramMap.put("grant_type", "client_credentials");
//      paramMap.put("client_id", Config.hxclient_id);
// 	  paramMap.put("client_secret", Config.hxclient_secret);
	    Map<String, Object>tokenMap=JsonTools.jsonStrToMap(post(tokenUrl,paramMap));
		System.out.println(JsonTools.toJson(tokenMap));
//		List<Map<String,String>>headerList=new ArrayList<Map<String,String>>();
//		Map<String,String>header=new HashMap<String, String>();
//          header.put("headerName", "Authorization");
//          header.put("headerValue", "Bearer "+tokenMap.get("access_token").toString());
//          headerList.add(header);
//          DeleteCode(delUrl,headerList);
//		String friendsUrl="http://a1.easemob.com/liyanwei1007/beizhiyuan/users/18234047278/contacts/users";
//		List<Map<String,String>>headerList=new ArrayList<Map<String,String>>();
//		Map<String,String>header=new HashMap<String, String>();
//		header.put("headerName", "Authorization");
//		header.put("headerValue", "Bearer "+tokenMap.get("access_token").toString());
//		headerList.add(header);
//		System.out.println(getSetHeader(friendsUrl,headerList));
          
         // /{org_name}/{app_name}/chatmessages
          String chatUrl="http://a1.easemob.com/mdzy/beizhiyuan/chatmessages?limit=1000";
          List<Map<String,String>>headerList=new ArrayList<Map<String,String>>();
          Map<String,String>header=new HashMap<String, String>();
          Map<String,String>header2=new HashMap<String, String>();
          header.put("headerName", "Authorization");
          header.put("headerValue", "Bearer "+tokenMap.get("access_token").toString());
          header2.put("headerName", "Content-Type");
          header2.put("headerValue", "application/json");
          headerList.add(header);
          String json=getSetHeader(chatUrl,headerList).toString();
         System.out.println(json );
	}
}
