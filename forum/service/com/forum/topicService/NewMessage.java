package com.forum.topicService;

import java.util.ArrayList;

import com.forum.daoImp.MessageDao;
import com.forum.daoImp.TopicSessionQuery;
import com.forum.daoImp.UserSessionQuery;
import com.forum.entityImp.CommonUser;
import com.forum.entityImp.Message;

/**
 * 产生新的消息
 * @author xufeng
 *
 */
public class NewMessage {

	private MessageDao messageDao = new MessageDao();
	
	/**
	 * 添加回复消息
	 * @param userId
	 * @param type
	 * @param url
	 * @param title
	 */
	public void addReplyMessage(int topicId,int type,String url,String title){
		
		//根据话题找出	
		CommonUser user = new TopicSessionQuery().getTopicById(topicId).getAuthor();

		Message message = new Message();
		message.setMessageType(type);
		message.setUserId(user.getUserId());	
		message.setTopicId(topicId);
		message.setMessageTitle(title);
		message.setMessageUrl(url);
		messageDao.addMessage(message);
		
	}
	/**
	 * 添加@消息
	 * @param commentId
	 * @param type
	 * @param url
	 * @param title
	 */
	public void addAtMessage(int commentId,int type,String url ,String title){
		//根据回复找出
		UserSessionQuery userQuery =  new UserSessionQuery();
		CommonUser user = userQuery.getUserByReplyId(commentId);
		Message message = new Message();
		message.setMessageType(type);
		message.setUserId(user.getUserId());	
		message.setTopicId(commentId);
		message.setMessageTitle(title);
		message.setMessageUrl(url);
		messageDao.addMessage(message);
		userQuery.release();
		
	}
	
	/**
	 * 根据用户id来获取新的消息
	 */   
	public ArrayList<Message> getNewMessage(int userId){
		
		return  messageDao.getMessageByUserId(userId, 0);
		
	}
	
	public  ArrayList<Message> getOldMessage(int userId){
		
		return  messageDao.getMessageByUserId(userId, 1);
	}
	
}
