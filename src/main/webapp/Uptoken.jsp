<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.mdzy.xqbadmin.common.qiniu.*,org.json.JSONObject"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	response.setContentType("application/json");
	JSONObject json = new JSONObject();
	json.append("token", Uptoken.makeUptoken());
	response.getWriter().print(json.toString());
%>
