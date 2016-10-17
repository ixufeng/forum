<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@ page import="com.forum.entityImp.CommonNode" %>
<%@ page import="com.forum.nodeService.*" %>

 <%
	NodeService nodeService = new NodeService();
 	request.setAttribute("nodeList", nodeService.getAllNodes()); 	
 %>
<div class="panel panel-default">
      <div class="panel-heading">热门节点</div>
      <div class="panel-body">
       	<s:iterator value="#request.nodeList" var="node">
       		<span class="badge">
       			<a href="/forum/topic/showTopic_node?nodeName=<s:property value='#node.name'/>">
       				<s:property value="#node.name"/>
       			</a>	
       		</span>
       	</s:iterator>  
      </div>
</div>