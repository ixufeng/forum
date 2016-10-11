
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/components/headIncludeFile.jsp"></jsp:include>
	<title>创建新话题</title>
	<script type="text/javascript" src="/forum/js/showdown.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/forum/css/newTopic.css"> 
</head>
<body>
	<jsp:include page="/WEB-INF/components/header.jsp"></jsp:include>
    <div id="main-body" class="container">
    	<div class="row row-offcanvas row-offcanvas-right">
    		<div id="col-left" class="col-xs-12 col-sm-9">
    			<br>
    			<s:if test="#request.sendRes!=null">
    				<s:if test="#requst.sendRes.equals('success')">
    					<div class="alert alert-success" role="alert">
		    				<strong>TIPS：</strong>
		    				<span>发送成功</span>
    					</div>
    				</s:if>
    				<s:else>
    					<div class="alert alert-danger" role="alert">
		    				<strong>TIPS：</strong>
		    				<span><s:property value="#request.sendRes"/></span>
    					</div>
    				</s:else>
    			</s:if>
    			
    			<form class="form-grop"  method="post" action="topic/sendTopic">
    				<div class="text-remind">
    					<span class=""><span class="glyphicon glyphicon-text-width"></span>标题</span>
    					<span class="pull-right">60</span>
    				</div>
    		 				
    				<input id="topicTitle" type="text" name="title" placeholder="请输入标题,用简短的话来表述你想表达的内容" class="form-control">
    				<div class="text-remind">
    					<span class="glyphicon glyphicon-text-height">正文</span>
    					<span class="pull-right">2000</span>
    				</div>    				
    				<textarea  id="content"  placeholder="请输入正文" rows="8" class="form-control"></textarea>
    				<textarea id="sendcontent" class="hidden" name="content"></textarea>
    				<div>
    					<div class="dropup">
							<button class="btn  btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
							选择一个节点
							<span class="caret"></span>
							</button>
							
							<ul class="dropdown-menu" id="box-node" aria-labelledby="dropdownMenu1" style="height:200px;overflow:auto">														
								<s:iterator value="#request.list" id="node" >
									<li class="node">
										<input class="val_id" style="display:none" value="<s:property value='#node.nodeId'/>">
										<a><s:property value="#node.name"/></a>
									</li>
								</s:iterator>
							</ul>
						</div>
						<input type="text" id="chooseNodeId" name="nodeId" style="display:none">
    				</div>
    				<div class="text-remind">
    					<span class="glyphicon glyphicon-plane">热门主题</span>
    				</div>
    				<div>
    					<div id="preshow" class="btn btn-default"><span class="glyphicon glyphicon-eye-open"></span>&nbsp;&nbsp;预览主题</div>
    					<div id="sendtopic" class="btn btn-warning pull-right"><span class="glyphicon glyphicon-send"></span>&nbsp;&nbsp;发送 </div>
    					<button id="sendbutton" class="hidden" type="submit" ></button>
    				</div>
    				<div id="show_con" class="panel panel-success hidden">
    					<div class="panel-heading">
    						<span><strong>主题预览</strong></span>
    					</div>
    					<div class="panel-body">
    						<div id="show_content"></div>
    					</div>
    				</div>
    			</form>
    		</div>
    		<div id="col-right" class="col-xs-6 col-sm-3 sidebar-offcanvas">
    			<jsp:include page="/WEB-INF/components/NewTopicAttention.jsp"></jsp:include>
    			<jsp:include page="/WEB-INF/components/hotNodebox.jsp"></jsp:include>
    		</div>
    	</div>
    </div>
     <script type="text/javascript" src="/forum/js/newTopic.js"></script>
</body>
</html>
