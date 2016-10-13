<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<title>welcome</title>
	
  	<jsp:include page="/WEB-INF/components/headIncludeFile.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
	<jsp:include page="/WEB-INF/components/header.jsp"></jsp:include>
	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right ">
			<div id="col-left" class="col-xs-12 col-sm-9 out_con_right">
				this is failure page
			</div>
			<div  id="col-right" class="col-xs-6 col-sm-3 sidebar-offcanvas">
				 <!-- 用户登录后显示的信息 -->                
                <jsp:include page="/WEB-INF/components/userbox_login.jsp"></jsp:include>
                <jsp:include page="/WEB-INF/components/hotTopicbox.jsp"></jsp:include>
			</div>
		</div>		
	</div>
</body>
</html>