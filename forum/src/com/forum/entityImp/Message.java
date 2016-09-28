package com.forum.entityImp;

import com.forum.tools.TimeStamp;

/**
 * 用户消息
 * @author xufeng
 *
 */
public class Message {
	private int id;
	private int userId;  //这条消息指向的用户
	private int topicId;
	private String messageTitle; //消息头，用户通过title来预览消息
	private int messageType;    //消息的类型（系统消息，回复消息，评论消息）
	private String messageUrl; //用户可以通过此链接来查看消息
	private long ctime = TimeStamp.getCTimeStamp();  //消息产生的的时间
	private int isRead = 0;  //是否已读 0未读，1已读
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getMessageUrl() {
		return messageUrl;
	}
	public void setMessageUrl(String messageUrl) {
		this.messageUrl = messageUrl;
	}
	
	public long getCtime() {
		return ctime;
	}
	public void setCtime(long ctime) {
		this.ctime = ctime;
	}
	public int getMessageType() {
		return messageType;
	}
	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}
	public int getIsRead() {
		return isRead;
	}
	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	

}
