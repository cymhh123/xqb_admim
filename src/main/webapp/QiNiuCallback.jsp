<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.mdzy.xqbadmin.common.qiniu.*,org.json.JSONObject"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	String upload_ret = request.getParameter("upload_ret");
	JSONObject callback = new JSONObject(Base64Coder.decode(upload_ret));
	JSONObject json = new JSONObject();
	if (callback.has("error")) {
		json.put("state", callback.get("error"));
	} else {
		json.put("original", callback.get("name"));
		//TODO缩略图，thumb是在七牛上配置的模板名
		//json.put("url", callback.get("key")+"-thumb");
		json.put("url", callback.get("key"));
		json.put("state", "SUCCESS");
	}
	response.getWriter().print(json.toString());
%>
