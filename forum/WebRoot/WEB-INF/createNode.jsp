<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.forum.nodeService.*" %>
<!DOCTYPE html>
<html>
	<head>
	<title>welcome</title>
	<link  rel="stylesheet" type="text/css" href="/forum/css/newTopic.css"/>
  	<jsp:include page="/WEB-INF/components/headIncludeFile.jsp"></jsp:include>	
</head>
<body>
	<jsp:include page="/WEB-INF/components/header.jsp"></jsp:include>
	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right ">
			<div id="col-left" class="col-xs-12 col-sm-9 out_con_right">
				<div id="home_panel" class="panel panel-default">
            		<div class="panel panel-heading">
            			<center><strong>节点创作</strong></center>
            		</div>
            		<div class="panel panel-body">
            		
            			<form class="form-group" method="post" action="/forum/topic/newNode_handle">
            				<div class="text-remind">
 								<span><strong>选择主题:&nbsp;&nbsp;</strong></span>           				
            					 <jsp:include page="/WEB-INF/components/themeOption.jsp"></jsp:include>
            				</div>
            				<div class="panel panel-primary" id="panel-node">
            					<div class="panel panel-heading">
            						<center><strong>编程之美</strong></center>           						
            					</div>
            					<div id="node-body" class="panel panel-body">
            						
            					</div>
            					<span class="font-light">&nbsp;&nbsp;&nbsp;&nbsp;这里显示</span>
            					<span id="theme-name"></span>
            					<span class="font-light">下所有的节点,你可以通过这里来防止创建重复的节点</span>
            				</div>
           					<div class="text-remind">
		    					<span class=""><span class="glyphicon glyphicon-text-width"></span><strong>节点名称</strong><span class="font-light">&nbsp;&nbsp;(标题要简介明了,例如java,python)</span></span>
		    					<span class="pull-right">20</span>  		 				
		    				</div>
		    				<input id="topicTitle" type="text" name="nodeName" placeholder="请输入节点名称" class="form-control">
		    				<div class="text-remind">
		    					<span class="glyphicon glyphicon-text-height"><strong>节点介绍</strong><span class="font-light">&nbsp;&nbsp;(让别人知道你的节点是关于什么的？)</span></span>
		    					<span class="pull-right">200</span>
		    				</div>    				
   							<textarea  id="content"  placeholder="请输入正文" rows="4" class="form-control" name="nodeIntro"></textarea>
           					<button class="btn btn-primary pull-right" type="submit">提交</button>
            			</form>
            		</div>
            		
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