<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.forum.nodeService.*"%>
<%@ page import="com.forum.common.*"%>
<%@ page import="com.forum.topicService.*"%>
    <%
    	//计算节点数量
    	NodeService node = new NodeService();
    	int nodeNum = node.getNodeNum();
    	//社区成员数量
    	Member member = new Member();
    	Long memberNum = member.getMemberNum();
    	//社区回复
    	ReplyService reply = new ReplyService();
    	int replyNum = reply.getReplyNum();
    %>
 <div class="panel panel-default">
      <div class="panel-heading">社区状况</div>
      <table class="table">
          <tr>
              <td>社区成员</td>
              <td><%=memberNum %></td>
          </tr>
          <tr>
              <td>
              	    社区节点
              </td>
              <td>
                  <%=nodeNum %>
              </td>
          </tr>
          <tr>
              <td>社区回复</td>
              <td><%=replyNum %></td>
          </tr>
      </table>
</div>