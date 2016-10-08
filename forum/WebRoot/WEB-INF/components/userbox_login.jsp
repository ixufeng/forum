<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<div class="panel panel-default">
      <div class="panel-heading">      
   			<a href="#login_colla" data-toggle="collapse"><span class="flag pull-right glyphicon glyphicon-chevron-up "></span></a>
   			<strong>个人信息</strong>	
      </div>
      <div id="login_colla" class="panel-collapse collapse in">
	      <div class="panel-body">
	            <div class="message-right-rect" id="user-content">
	                <img src="<s:property value='#session.user.userAvatar_lg'/>" class="img-circle img-size center-block img-responsive" id="user-self"/>
	                <input id="userId" class="hidden" value="<s:property value='#session.user.userId'/>"/>
	                <table class="table">
	                    <tr>

	                        <td><a href="message/message_getNewMessage" class="link">未读消息</a></td>
	                        <td><span id="newMessageNum">0</span></td>
	                    </tr>
	                    <tr>
	                    	<td><a href="#" class="link">发表话题</a></td>
	                        <td><s:property value="#session.user.topics.size"/></td>
	                        
	                        
	                    </tr> 
	                    <tr>
	                    	<td><a href="#" class="link"><span class="glyphicon glyphicon-signal"></span>&nbsp;积分</a></td>
	                    	<td><s:property value="#session.user.userPoint"/></td>	                    	
	                    </tr>
	                </table> 
	            </div>
	            <div class="message-right-rect">
	                <a href="topic/newTopic" class="btn btn-default btn-link">&nbsp;&nbsp;<span class="glyphicon glyphicon-pencil"></span>创作新主题</a>
	            </div>
	      </div>
      </div>
      <script type="text/javascript" src="/forum/js/getMessage.js"></script>
</div>