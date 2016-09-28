<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.forum.topicService.*" %>
 <%@taglib uri="/struts-tags" prefix="s" %>
 <%
 	//获取今日最热门的帖子，直接调用service层
 	GetTopicService service = new GetTopicService();
 	request.setAttribute("hotList", service.getHotTpopic(10));
 %>
 <div class="panel panel-default">
      <div class="panel-heading">
      	<a href="#hot_colla" data-toggle="collapse"><span class="flag pull-right glyphicon glyphicon-chevron-up "></span></a>
      	<strong>今日热议</strong>
      </div>
      <div id="hot_colla" class="panel-collapse collapse in">
	      <div class="panel-body">
	      	<s:iterator value="#request.hotList" var="topic">
	      		<div class="media">
	               <div class="media-left">
	                   <img src="<s:property value='#topic.author.userAvatar_lg'/>" class="img-rounded" style="width:30px; height:30px; ">
	               </div>
	               <div class="media-body">             		
	                   <a href='topic/topic_openTopic?topicId=<s:property value="#topic.topicId"/>'><s:property value="#topic.title"/></a>
	               </div>
	           </div>
	      	</s:iterator>         
	      </div>
	   </div>
</div>