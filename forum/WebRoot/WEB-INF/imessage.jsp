<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<title>imessage</title>
	<jsp:include page="/WEB-INF/components/headIncludeFile.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="css/imessage.css">
</head>
<body>
	<jsp:include page="/WEB-INF/components/header.jsp"></jsp:include>
	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">
			<div id="col-left" class="col-xs-12 col-sm-9">
				<ul class="list-group">
					<s:iterator value="#request.showList" var="showList">
						<!-- 回复消息 -->
						<s:if test="#showList.type==1">
							<li class="list-group-item" id="imessage-li">
								<img class="user-avatar-sm" src="<s:property value='#showList.replyUser.userAvatar_lg'/>"/>
								<div class="imessage-con">
									<s:property value="#showList.replyUser.userName"/>
									<span>在</span>
									<a href="<s:property value='#showList.url'/>">
										<strong>【<s:property value="#showList.topicTitle"/>】</strong>
									</a>
									<span>中评论了你</span>								
								</div>
								
								<div class="imessage-mes">									
									<span class="time-sm"><s:property value="#showList.time"/></span>
									<select class="visible-lg visible-md pull-right">
										<option>--操作--</option>	
										<option>删除</option>	
										<option>已读</option>	
										<option>忽略</option>	
									</select>
								</div>																
							</li>
						</s:if>
						<!-- @消息 -->
						<s:elseif test="#showList.type==3">
							<li class="list-group-item" id="imessage-li">
								<img class="user-avatar-sm" src="<s:property value='#showList.replyUser.userAvatar_lg'/>"/>
								<div class="imessage-con">
									<s:property value="#showList.replyUser.userName"/>
									<span>在</span>
									<a href="<s:property value='#showList.url'/>">
										<strong>【<s:property value="#showList.topicTitle"/>】</strong>
									</a>
									<span>中@了你</span>								
								</div>
								
								<div class="imessage-mes">									
									<span class="time-sm"><s:property value="#showList.time"/></span>
									<select class="visible-lg visible-md pull-right">
										<option>--操作--</option>	
										<option>删除</option>	
										<option>已读</option>	
										<option>忽略</option>	
									</select>
								</div>																
							</li>
						</s:elseif>
						<s:elseif test="#showList.type==2">
						
						
						</s:elseif>
						<!-- 系统消息 -->
						<s:elseif test="#showList.type==0">
						</s:elseif>
					</s:iterator>
				
					
					
				</ul>
			</div>
			<div  id="col-right" class="col-xs-6 col-sm-3 sidebar-offcanvas">
				
				<jsp:include page="/WEB-INF/components/userbox_login.jsp"></jsp:include>
				<select class="form-control">
					<option >消息筛选</option>
					<option value="1">未读消息</option>
					<option value="2">历史消息</option>
					<option value="">系统消息</option>
					<option value="">回复消息</option>
				</select>
                <jsp:include page="/WEB-INF/components/hotTopicbox.jsp"></jsp:include>
			</div>
		</div>
	</div>
</body>
</html>
