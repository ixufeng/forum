package com.forum.topicService;

import java.util.ArrayList;

import com.forum.daoImp.MessageDao;
import com.forum.daoImp.TopicSessionQuery;
import com.forum.daoImp.UserSessionQuery;
import com.forum.entityImp.CommonTopic;
import com.forum.entityImp.CommonUser;
import com.forum.entityImp.Message;
import com.forum.entityImp.MessageShow;
import com.forum.tools.TimeStamp;

/**
 * 产生新的消息
 * @author xufeng
 *
 */
public class NewMessage {

	private MessageDao messageDao = new MessageDao();
	private UserSessionQuery userQuery = new UserSessionQuery();
	
	/**
	 * 添加回复消息
	 * @param userId
	 * @param type
	 * @param url
	 * @param title
	 */
	public void addReplyMessage(int replyUserId,int topicId,int type,String url){
		
		//根据话题找出	
		CommonTopic topic = new TopicSessionQuery().getTopicById(topicId);
		CommonUser user = topic.getAuthor();
		
		Message message = new Message();
		message.setReplyUserId(replyUserId);
		message.setMessageType(type);
		message.setUserId(user.getUserId());	
		message.setTopicId(topicId);
		message.setMessageTitle(topic.getTitle());
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
	public void addAtMessage(int replyUserId,int commentId,int type,String url ,int topicId){
		//根据回复找出
		UserSessionQuery userQuery =  new UserSessionQuery();
		CommonUser user = userQuery.getUserByReplyId(commentId);
		CommonTopic topic = new TopicSessionQuery().getTopicById(topicId);
		Message message = new Message();
		message.setReplyUserId(replyUserId);
		message.setMessageType(type);
		message.setUserId(user.getUserId());	
		message.setTopicId(commentId);
		message.setMessageTitle(topic.getTitle());
		message.setMessageUrl(url);
		messageDao.addMessage(message);
		userQuery.release();
		
	}
	
	/**
	 * 根据用户id来获取新的消息
	 */   
	public ArrayList<MessageShow> getNewMessage(int userId){
		
		ArrayList<Message> list =  messageDao.getMessageByUserId(userId, 0);
		ArrayList<MessageShow> showList = new ArrayList<MessageShow>();
		
		//newMessage到showMessga的转换
		
		for(Message mes :list){
			MessageShow mshow = new MessageShow();
			CommonUser user = userQuery.getUserByReplyId(mes.getReplyUserId());
			mshow.setReplyUser(user);
			mshow.setTopicTitle(mes.getMessageTitle());
			mshow.setTime(TimeStamp.timeStampDate(mes.getCtime(), "yyyy-mm-dd"));
			mshow.setUrl(mes.getMessageUrl());
			mshow.setType(mes.getMessageType());
			showList.add(mshow);
		}
		
		return showList;
		
	}
	
	public int getNewMessageNums(int userId){
		
		return messageDao.getMessageByUserId(userId, 0).size();
	}
	
	
	/**
	 * 获取所有历史消息
	 * @param userId
	 * @return
	 */
	public  ArrayList<MessageShow> getOldMessage(int userId){
		
		ArrayList<Message> list  = messageDao.getMessageByUserId(userId, 1);
		ArrayList<MessageShow> showList = new ArrayList<MessageShow>();
		
		//newMessage到showMessga的转换	
		for(Message mes :list){
			MessageShow mshow = new MessageShow();
			CommonUser user = userQuery.getUserByReplyId(mes.getReplyUserId());
			mshow.setReplyUser(user);
			mshow.setMessageTitle(mes.getMessageTitle());
			mshow.setTime(TimeStamp.timeStampDate(mes.getCtime(), "yyyy-mm-dd"));
			mshow.setUrl(mes.getMessageUrl());
			mshow.setType(mes.getMessageType());
			showList.add(mshow);
		}
		
		return showList;
	}
	
	/**
	 * 读消息
	 */
	public int readMessage(int id){
		
		int i = messageDao.readMessage(id);
		
		return i;
	}
	
	/**
	 * 删除消息
	 * @param id
	 * @return
	 */
	public int delMessage(int id){
		
		int i = messageDao.delMessageById(id);
		return i;
	}
	
	
}
