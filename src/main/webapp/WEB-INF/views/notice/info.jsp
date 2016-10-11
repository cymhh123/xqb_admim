<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/18
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
    <title>内容</title>
    <link rel="stylesheet" type="text/css" href="${ctxStatic}/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="${ctxStatic}/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="${ctxStatic}/css/animate.min.css" />
    <link rel="stylesheet" type="text/css" href="${ctxStatic}/css/style.min.css" />
    <style>
        .content img{
            max-width: 100%;
        }
    </style>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInLeft">
    <div class="row">
        <div class="col-sm-12 text-center">
            <h3>${notice.title}</h3>
            <p>发布时间：<fmt:formatDate value="${notice.createDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></p>
        </div>
        <div class="content" class="col-sm-12" style="font-size: 14px;margin-top: 25px;padding:0 15px;">
            <p>${notice.content}</p>
        </div>
    </div>
</div>

<script type="text/javascript" src="${ctxStatic}/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/js/bootstrap.min.js"></script>

</body>
</html>
