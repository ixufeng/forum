<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
    
    
<%
	String loginMessage = "";
	if(request.getSession().getAttribute("loginMessage")!=null){	
		loginMessage = request.getSession().getAttribute("loginMessage").toString();
		request.getSession().removeAttribute("loginMessage");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath %>"/>
	<title>论坛登陆</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="论谈登陆">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="/forum/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/forum/css/login.css">
    <script type="text/javascript" src="/forum/js/jquery.js"></script>
    <script type="text/javascript" src="/forum/js/bootstrap.js"></script>
</head>
<body>
	<div class="container">
		<center><h2>登陆</h2></center>
		<form class="form-signin" method="post" action="login/LoginAction_doLogin">
			<div id="login_message">
				<span><%=loginMessage %></span>
			</div>
			<input type="text" name="userName" class="form-control" required placeholder="用户名&nbsp;|&nbsp;邮箱"/>
			<input type="password" name="passWord" class="form-control" required placeholder="密码" />
			<a class="btn btn-link pull-right">忘记密码？</a>
			<a href="/forum/register/index" class="btn btn-link pull-right">账号注册»</a>
			<button type="submit" class="btn btn-lg btn-block btn-primary ">登陆</button>
		</form>
	</div>
	<div class="footer">
		this is footer;
	</div>
	
</body>
</html>