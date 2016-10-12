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
   
    <link rel="stylesheet" type="text/css" href="/forum/css/login.css">
   	<jsp:include page="/WEB-INF/components/headIncludeFile.jsp"></jsp:include>
</head>
<body>
	 <jsp:include page="/WEB-INF/components/header.jsp"></jsp:include>
     <div class="container" id="message-container">
    	<div class="row row-offcanvas row-offcanvas-right">
            <div class="col-xs-12 col-sm-9" id="message-container-left">
            	<div class="panel panel-default">
            		<div class="panel panel-heading">
            			<center><strong>登陆</strong></center>
            		</div>
            		<div class="panel panel-body">
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
            		
            	</div>   
            
            </div> 
            <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="message-container-right">
              <!-- 用户登录后显示的信息 -->                
              <jsp:include page="/WEB-INF/components/userbox_login.jsp"></jsp:include>
              <jsp:include page="/WEB-INF/components/hotTopicbox.jsp"></jsp:include>
            </div>
         </div>
    </div>
</body>
</html>