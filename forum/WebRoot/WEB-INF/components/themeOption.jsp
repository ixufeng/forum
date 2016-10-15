<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page import="com.forum.nodeService.*" %>
<%@taglib uri="/struts-tags" prefix="s"%>


<%
	ThemeService theme = new ThemeService();
	request.setAttribute("themeList", theme.getAllTheme());
%>

<select style="height:30px; border-radius:5px; width:120px;" onchange="selectTheme(this)";  name="themeId">
	<option value="-1">--请选择--</option>
	<s:iterator value="#request.themeList" var="theme">
		<option value="<s:property value='#theme.themeId'/>"><s:property value="#theme.name"/></option>
	</s:iterator>
</select>


<script type="text/javascript" src="/forum/js/newNode.js"></script>