<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ page import="com.forum.tools.TimeStamp" %>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/components/headIncludeFile.jsp"></jsp:include>
	<title>话题</title>
    <link rel="stylesheet" type="text/css" href="/forum/css/topic.css"/>
    <link rel="stylesheet" type="text/css" href="/forum/js/reply.js">
</head>
<body>
	<!-- 导航栏 -->
	<jsp:include page="/WEB-INF/components/header.jsp"></jsp:include>
	<!-- 页面主体 -->
	<div class="container" id="container">
		 <div class="row row-offcanvas row-offcanvas-right">

            <div class="col-xs-12 col-sm-9" id="message-container-left">
                <!-- 帖子的内容放在一个panel中 -->
                <div class="panel panel-default">
                	<div id="topoic-head" class="panel panel-heading">
                        <div class="topic-title-con">
                            <h4><s:property value="#request.topic.title"/></h4>
                            <span>&nbsp;&nbsp;作者：<s:property value="#request.topic.author.userName"/></span>
                           
                            <span>&nbsp;&nbsp;创作时间：<s:property value="#request.topic.cTime"/></span>
                            <span>&nbsp;&nbsp;访问量：<s:property value="#request.topic.supports"/></span>
                        </div>
                		<!-- <div class="topic-nav">this id nav</div> -->
                        <img src="<s:property value='#request.topic.author.userAvatar_lg'/>" class="img-topic-avator" />
                	</div>
                	<div id="topic-content"  class="panel panel-body">
                		<input class="hidden" id="mainTopic_id" value="<s:property value="#request.topic.topicId"/>">
                		<s:property value="#request.topic.content" escape="false"/>
                		<button onclick="initReplyBox(this);" class="btn btn-link pull-right" data-toggle="modal" data-target="#myModal">
                		  <span class="glyphicon glyphicon-pencil"></span>评论
                		</button>
                		
                	</div>
                	
                </div>
            	<!-- 回复的部分 -->
				<ul class="list-group">
					<s:iterator status = "st" value="#request.topic.replies" var="reply">
						<li class="list-group-item"><img class="img-circle pull-left"
							style="width: 50px; height: 50px; display: inline-block;"
							src="<s:property value='#reply.replyUser.userAvatar_lg'/>">
							<div class="reply-con">
								<div class="reply-title">
									<span class="label label-default"></span> 
									<span class="reply-time">&nbsp;&nbsp;<s:property value="#reply.replyUser.userName"/></span> 
									<span class="reply-time">&nbsp;&nbsp;iphone</span> 
									<span class="badge pull-right"><s:property value="#st.index+1"/>楼</span>
								</div>
								<div class="topic-rel">
									<span><s:property value="#reply.content"/></span>
									<input class="hidden" value="<s:property value='#reply.replyId'/>">
									<button onclick="initReplyBox(this,1);" class="btn  btn-xs btn-link pull-right"
										data-toggle="modal" data-target="#myModal">
										<span  class="glyphicon glyphicon-pencil"></span>回复
									</button>
								</div>

							</div>
						</li>
					</s:iterator>
				</ul>
			</div>
        	<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="message-container-right">          		
            	<jsp:include page="/WEB-INF/components/hotNodebox.jsp"></jsp:include>
            	<jsp:include page="/WEB-INF/components/newlyIncreasedNodebox.jsp"></jsp:include>
                <jsp:include page="/WEB-INF/components/hotTopicbox.jsp"></jsp:include>
               	<jsp:include page="/WEB-INF/components/forumStatebox.jsp"></jsp:include>              
            </div>     
      	</div>
      </div>
    <!-- 影藏的div -->
   <jsp:include page="/WEB-INF/components/replybox.jsp"></jsp:include>
    <script type="text/javascript" src="/forum/js/reply.js"></script>
</body>
</html>