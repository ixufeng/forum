<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
	<title>welcome</title>
	
	<base href="<%=basePath%>"/>
  	<jsp:include page="/WEB-INF/components/headIncludeFile.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body>
	<jsp:include page="/WEB-INF/components/header.jsp"></jsp:include>
	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right ">
			<div id="col-left" class="col-xs-12 col-sm-9 out_con_right">
				<div class="row">
					<s:iterator value="#request.nodeList" var="node">
						<div class="col-xs-12 col-sm-4 col-md-3 node-item">
							<div class="inner_con">
								<span class="node-name">&nbsp;<s:property value="#node.name"/></span>
								<div class="node-intro">&nbsp;&nbsp;<s:property value="#node.introduce"/></div>
								<div class= "topic-num" type="button">
								   <span class="badge"><s:property value="#node.topics.size"/></span>
								</div>
								<div class="bottom">								
									<span class="val"><s:property value="#node.ctime"/></span>
									<span class="txt">&nbsp;BuildIn:&nbsp;</span>
								</div>
							</div>
						</div>
					</s:iterator>
				
				</div>
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