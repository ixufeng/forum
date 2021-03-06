<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:if test="#session.user!=null">
	<div class="panel panel-default">
      <div class="panel-heading">      
   			<a href="#login_colla" data-toggle="collapse"><span class="flag pull-right glyphicon glyphicon-chevron-up "></span></a>
   			<strong>个人信息</strong>	
      </div>
      <div id="login_colla" class="panel-collapse collapse in">
	      <div class="panel-body">
	            <div class="message-right-rect" id="user-content">
	            	<a href="/forum/userInfo/showInfo.action">
	            		<img src="<s:property value='#session.user.userAvatar_lg'/>" class="img-circle img-size center-block img-responsive" id="user-self"/>
	            	</a>
	                
	                <input id="userId" class="hidden" value="<s:property value='#session.user.userId'/>"/>
	                <table class="table">
	                    <tr>

	                        <td><a href="message/message_getNewMessage" class="link">未读消息</a></td>
	                        <td><span id="newMessageNum">0</span></td>
	                    </tr>
	                    <tr>
	                    	<td><a href="topic/topic_openMyTopics" class="link">我的话题</a></td>
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
	            <div class="message-right-rect" id="create-node">
	                <button onclick="goto('/forum/topic/newNode_newNode')" class="btn btn-xs btn-warning">&nbsp;&nbsp;<span class="glyphicon glyphicon-pencil"></span>创作新节点</button>
	            </div>
	      </div>
      </div>
      <script type="text/javascript" src="/forum/js/getMessage.js"></script>
	</div>
</s:if>
<!-- 未登录 -->
<s:else>
<div class="panel panel-default">
	<div class="panel-heading">      
		<a href="#login_colla" data-toggle="collapse"><span class="flag pull-right glyphicon glyphicon-chevron-up "></span></a>
		<strong>IdeaCode</strong>	
    </div>
    <div id="login_colla" class="panel-collapse collapse in">
    	<div class="panel-body">
			<button class="form-control btn-primary" onclick="loginin();" href="#">登陆</button>
			<button class="form-control btn-default" onclick="loginup();" style="margin-top:5px;">注册</button>
		</div>
    </div>
	
</div>
</s:else>
