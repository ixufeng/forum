<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

 <!-- 分页的工具条 -->
 <div class="divide-page-con">
 	 <ul id="pagination"  data = "<s:property value='#session.pageIndex'/>" data-all="<s:property value='#session.allTopicNum'/>" class="pagination">
 	 
 	
      <li>
	       <a aria-label="Previous">
	         <span aria-hidden="true">&laquo;</span>
	       </a>
      </li>
      <s:if test="#session.pageIndex<3">
   		  <li><a>1</a></li>
	 	  <li><a>2</a></li>
	 	  <li><a>3</a></li>
	 	  <li><a>4</a></li>
	      <li><a>5</a></li>
      </s:if>
      <s:else>
      	  <li><a><s:property value="#session.pageIndex-2"/></a></li>
	 	  <li><a><s:property value="#session.pageIndex-1"/></a></li>
      	  <li><a><s:property value="#session.pageIndex"/></a></li>
	 	  <li><a><s:property value="#session.pageIndex+1"/></a></li>
	 	  <li><a><s:property value="#session.pageIndex+2"/></a></li> 	  
      </s:else>
 	 
      <li>
        <a aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
	</ul>
 </div>
 <script type="text/javascript" src="/forum/js/paging.js"></script>
