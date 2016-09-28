<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
      <!-- 导航头 -->
       <div class="navbar-header">
         <button type="button" class="navbar-toggle collapsed" data-toggle="offcanvas" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="topic/showTopic.action">IdeaCode</a>
        </div>
        <!-- 将会被影藏的部分 -->
        <div id="navbar" class="navbar-collapse collapse">
         	<ul id="navbar-right">
         	  <s:if test="#session.user==null">
				 <li>
				 	<button class="btn btn-link" onclick="javascript:location.href='register.jsp'">注册</button>
				 </li>
              	<li>
              		<button class="btn btn-link" onclick="javascript:location.href='signin.jsp'">登陆</button>
              	</li>         	  	        	  	
         	  </s:if> 
         	  <s:else>
         	  	<li><a href="/forum/userInfo/showInfo.action">信息</a></li>
         	  	<li><a href="/forum/login/loginOut.action">登出</a>
         	  </s:else> 
            </ul>
            <div id="form-group" class="row">
                <div class="col-lg-6">
                     <div class="input-group">
                      <input type="text" class="form-control" placeholder="Search for...">
                      <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Go!</button>
                      </span>
                    </div>
                </div>
            </div>          
        </div>
              
      </div>
    </nav>
