package com.forum.entityImp;
import com.forum.entity.Reply;

/**
 * 回复类
 * @author xufeng
 *
 */
public class CommonReply implements Reply {
	
	private int replyId;   //回复id	
	private String content;//回复内容
	private long cTime;    //回复时间
	private CommonUser replyUser;  //回复人
	private CommonTopic topic;   //回复的话题

	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getcTime() {
		return cTime;
	}
	public void setcTime(long cTime) {
		this.cTime = cTime;
	}
	public CommonUser getReplyUser() {
		return replyUser;
	}
	public void setReplyUser(CommonUser replyUser) {
		this.replyUser = replyUser;
	}
	public CommonTopic getTopic() {
		return topic;
	}
	public void setTopic(CommonTopic topic) {
		this.topic = topic;
	}

	
}
