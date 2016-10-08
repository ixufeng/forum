package com.forum.entityImp;

/**
 * 定义了消息页显示的对象
 * @author xufeng
 *
 */
public class MessageShow {

	private CommonUser replyUser; //消息的回复
	private String messageTitle;
	private String topicTitle;
	private String time;//存储转化后的时间
	private String url;
	private int type;
	public CommonUser getReplyUser() {
		return replyUser;
	}
	public void setReplyUser(CommonUser replyUser) {
		this.replyUser = replyUser;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getTopicTitle() {
		return topicTitle;
	}
	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	
}
