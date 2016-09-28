<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <title>注册</title>
    <base href="<%=basePath%>"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="/forum/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="/forum/css/register.css">
    <script type="text/javascript" src="/forum/js/jquery.js"></script>
    <script type="text/javascript" src="/forum/js/bootstrap.js"></script>
</head>
<body>

    <div class="container">
      <form class="form-signin" method="post" action="register/registerHandle_doRegister">
        <center><h2>注册</h2></center>      
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
    <footer class="footer">
      <div class="container">
        <p class="text-muted">made by xufeng 2016 6 25</p>
      </div>
    </footer>
    <script type="text/javascript" src="/forum/js/register.js">
		
    </script>
    
</body>
</html>