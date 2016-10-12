package com.forum.topicAction;

import java.io.IOException;

import com.forum.entityImp.CommonReply;
import com.forum.entityImp.CommonUser;
import com.forum.entityImp.MessageType;
import com.forum.globle.BaseAction;
import com.forum.tools.Message;
import com.forum.topicService.NewMessage;
import com.forum.topicService.ReplyService;

/**
 * 评论
 * @author xufeng
 *
 */
public class ReplyTopic extends BaseAction  {

	private static final long serialVersionUID = 1L;
	private ReplyService replyService;
	private int topicId;  //回复对象的Id,可能是topicId也可能是replyId
	private int mainTopicId = 0; //当回复别人的评论时，才会有值,且是topicId
	private String replyContent;
	//评论后的结果
	private String res  = Message.ERROR;

	public String doReply(){

		if(this.replyService==null){
			this.replyService = new ReplyService();
		}
		if(this.httpSession.getAttribute("user")==null){
			//尚未登陆
			this.res = Message.WITHOUTLOGIN;
		}
		//新建回复
		
		CommonReply reply = new CommonReply();
		reply.setContent(this.replyContent);
		
		//获取当前用户的id
		int userId = ((CommonUser)this.httpSession.getAttribute("user")).getUserId();
		
		//判断是回复主贴还是评论
		if(mainTopicId==0){
			//主贴
			this.replyService.doReply(topicId, userId, reply);
			//通知贴主的消息,除非是自己评论自己
			 
			NewMessage message = new NewMessage();		
			String url = "topic/topic_openTopic?topicId=" + topicId;
			message.addReplyMessage(userId,topicId, MessageType.reply, url);
		}else{//评论
			
			//在评论内容中添加 @标志 ，获取这个人的姓名
			
			reply.setContent("@" +replyContent);
			
			this.replyService.doReply(mainTopicId, userId, reply);
			//同时给被评论人发送消息
			NewMessage message = new NewMessage();
			String url = "topic/topic_openTopic?topicId=" + mainTopicId;
			//发送给发帖人
			message.addReplyMessage(userId,mainTopicId, MessageType.reply, url);
			//发送给被@的人
			message.addAtMessage(userId,topicId, MessageType.at, url, mainTopicId);
		}
		
		
		this.res = Message.SUCCESS;
		
		
		
		try {
			this.httpResponse.getWriter().write(this.res);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public int getMainTopicId() {
		return mainTopicId;
	}

	public void setMainTopicId(int mainTopicId) {
		this.mainTopicId = mainTopicId;
	}

}
