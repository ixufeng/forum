<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<title>Insert title here</title>
<jsp:include page="/WEB-INF/components/headIncludeFile.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="/forum/css/mytopic.css"/>
</head>
<body>
 	<jsp:include page="/WEB-INF/components/header.jsp"></jsp:include>
 	<div  class="container" id="message-container">
        <div class="row row-offcanvas row-offcanvas-right">
            <div class="col-xs-12 col-sm-9" id="message-container-left">
            	<ul class="list-group">
            		<li class="list-group-item">
            			<span class="badge">66</span>
            			
            		</li>
            	</ul>
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