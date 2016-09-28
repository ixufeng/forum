<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>   
    
 <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
     <div class="modal-content">
     
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel"><span class="glyphicon glyphicon-pencil"></span>评论</h4> 
      </div>
       <form>
	      <div   class="modal-body">	
	      	<div style="display:none" id="reply-alert" class="alert alert-success" role="alert">
     			<strong>well done!!</strong>
     			<span>good job</span>
     		</div>       
	        <div class="form-group">
	          <label for="message-text" class="control-label">Message:</label>
	          <input id="topicId" style="display:none"/>
	          <input id="mainTopicId" style="display:none"/>
	          <textarea class="form-control" id="message-text"></textarea>
	        </div>	       
	      </div>
	      <div class="modal-footer">
	        <button type="button" id="reply-box-close" class="btn btn-warning" data-dismiss="modal"><span class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;Close</button>
	        <s:if test="#session.user!=null">
	        	 <button type="button" onclick="sendReply();" class="btn btn-primary"><span class="glyphicon glyphicon-send"></span>&nbsp;&nbsp;Send message</button>	        	
	        </s:if>
	        <s:else>
	        	 <button type="button" onclick="" class="btn btn-primary"><span class="glyphicon glyphicon-send"></span>&nbsp;&nbsp;请先登录</button>	        		        	
	        </s:else>
	      </div>
      </form>
    </div>
  </div>
</div>