<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/components/headIncludeFile.jsp"></jsp:include>
	<title>首页</title>
</head>
<body>
    <jsp:include page="/WEB-INF/components/header.jsp"></jsp:include>
      <div  class="container" id="message-container">
        <div class="row row-offcanvas row-offcanvas-right">
            <div class="col-xs-12 col-sm-9" id="message-container-left">  
            	<div id="home_panel" class="panel panel-default">
            		<div class="panel panel-heading">
            		
            		</div>
            		<div class="panel panel-body">
            		
            		</div>
            		
            	</div>      	  
               <ul id="message-ul">
	               <s:iterator value="#request.list" var="showTopic">
	               		 <li class="message-list">
	                        <img class="user-avatar" src="<s:property value='#showTopic.user.userAvatar_lg'/>">
	                        <div class="message-list-con">
	                        	<div>
	                        		<span class="label label-info"><s:property value="#showTopic.node.name"/></span>
		                            <a href='topic/topic_openTopic?topicId=<s:property value="#showTopic.topic.topicId"/>' class="topic-title">
		                            	<s:property value="#showTopic.topic.title"/></a>
		                            <span class="badge badge-info pull-right"><s:property value="#showTopic.topic.supports"/></span>
	                        	</div>	                            
	                            <div class="topic-rel">
	                                <a href="#"><s:property value="#showTopic.user.userName"/></a>
	                                <span class="topic-time">&nbsp;&nbsp;<s:property value="#showTopic.timePeriod"/></span>
	                                <input style="display:none" value="<s:property value='#showTopic.topic.topicId'/>"/>
	                                <button class="btn  btn-xs btn-link pull-right" ><span class="glyphicon glyphicon-thumbs-up"></span>赞</button>
	                                <button onclick="initReplyBox(this);" class="btn  btn-xs btn-link pull-right" data-toggle="modal" data-target="#myModal">
	                                	<span class="glyphicon glyphicon-pencil"></span>评论
	                                </button>
	                            </div>
	                        </div>
	                        
	                    </li>
	               </s:iterator>              
                </ul>              
               	<!-- 分页 -->
               <jsp:include page="/WEB-INF/components/pageIndex.jsp"></jsp:include>
            </div>
            
            <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="message-container-right">
                <!-- 用户登录后显示的信息 -->                
                <jsp:include page="/WEB-INF/components/userbox_login.jsp"></jsp:include>
                <jsp:include page="/WEB-INF/components/hotTopicbox.jsp"></jsp:include>
            </div>
        </div>
    </div>
  <jsp:include page="/WEB-INF/components/footer.jsp"></jsp:include>
    <!-- 影藏的评论窗口div -->
  <jsp:include page="/WEB-INF/components/replybox.jsp"></jsp:include>
  <script type="text/javascript" src="/forum/js/reply.js"></script>
</body>
</html>