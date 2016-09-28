package com.forum.entityImp;

/**
 * 这是现实在页面中的topic .包括了主题，节点等一些信息，只作为展示时使用，而不单独存储
 * @author xufeng
 *
 */
public class TopicShow {

	private CommonNode node;
	private CommonTopic topic;
	private CommonUser user;
	private String timePeriod;
	
	public CommonUser getUser() {
		return user;
	}
	public void setUser(CommonUser user) {
		this.user = user;
	}
	public CommonNode getNode() {
		return node;
	}
	public void setNode(CommonNode node) {
		this.node = node;
	}
	public CommonTopic getTopic() {
		return topic;
	}
	public void setTopic(CommonTopic topic) {
		this.topic = topic;
	}
	public String getTimePeriod() {
		return timePeriod;
	}
	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}
	 
	
	
	
	
	
}
