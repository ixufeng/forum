<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <title>sign up</title>
    <base href="<%=basePath%>"/>
  	
    <link rel="stylesheet" type="text/css" href="/forum/css/register.css">
  	<jsp:include page="/WEB-INF/components/headIncludeFile.jsp"></jsp:include>
</head>
<body>
	 <jsp:include page="/WEB-INF/components/header.jsp"></jsp:include>
     <div class="container" id="message-container">
    	<div class="row row-offcanvas row-offcanvas-right">
            <div class="col-xs-12 col-sm-9" id="message-container-left">
            	<div class="panel panel-default">
            		<div class="panel panel-heading">
            			<center><strong>注册</strong></center>
            		</div>
            		<div class="panel panel-body">
            			 <form class="form-signin" method="post" action="register/registerHandle_doRegister">   
					        <label for="userName" class="sr-only">userName</label>
					        <span id="userName-remind"></span>
					        <input type="text" id="userName"  class="form-control" placeholder="用户名"  name="userName" required autofocus/>
					        <span id="userEmail-remind"></span>   
					        <label for="inputEmail" class="sr-only">Email address</label>
					        <input type="email" name="userEmail" id="inputEmail" class="form-control" placeholder="邮箱" required />
					        <span id="password-remind"></span>
					        <label for="password"  class="sr-only">Password</label>
					        <input type="password" id="password" name="passWord" class="form-control" placeholder="密码" required/>
					        <label for="repassword" class="sr-only">Password</label>
					        <span id="repassword-remind"></span>
					        <input type="password" id="repassword" name="passWord_confirm" class="form-control" placeholder="确认密码" required/>
					        <div id="code-reming"></div>
					        <input type="text" name="code" class="form-control" id="input-code" placeholder="验证码"/>
					        <div><img alt="验证码" id="image-code" src="/forum/imageCode"></div>
					        <button id="btn-submit" class="btn btn-lg btn-primary btn-block"  type="submit">Sign up</button>
					        <div class="progress" id="progress">
					        
					            <div id="progress-detail" class="progress-bar progress-bar-success" style="width: 5%"></div>
						
					     	 </div>
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
    <script type="text/javascript" src="/forum/js/register.js">
		
    </script>
    
</body>
</html>