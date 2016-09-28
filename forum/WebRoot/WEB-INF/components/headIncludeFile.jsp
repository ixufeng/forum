<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <base href="<%=basePath%>"/>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/forum/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/forum/css/homePage.css"/>
    <link rel="stylesheet" type="text/css" href="/forum/css/offcanvas.css"/>
    <link rel="stylesheet" type="text/css" href="/forum/css/common.css">
    <script type="text/javascript" src="/forum/js/jquery.js"></script>  
    <script type="text/javascript" src="/forum/js/bootstrap.js"></script>
   	<script type="text/javascript" src="/forum/js/offcanvas.js"></script>
  	