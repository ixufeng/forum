package com.forum.topicAction;

import com.forum.entityImp.CommonTopic;
import com.forum.globle.BaseAction;
import com.forum.topicService.GetTopicService;

public class Topic extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	
	private CommonTopic topic; 
	private int topicId;       //话题的id
	private String topicUrl;  //话题的地址
	private GetTopicService getTopicService = new GetTopicService();

	
	/**
	 * 默认打开话题的方式，id打开
	 */	
	
	public String openTopic(){
	
		this.topic = getTopicService.getTopicById(this.topicId);
		
		if(this.topic==null){
			//为获取到话题,肯能是话题删=删除或更改
			return "nullTopic";
		}else{
		
			return "topicdetail";
		}
		
	}
	
	public String test(){
		
		return "test";
	}

	
	public CommonTopic getTopic() {
		return topic;
	}

	public void setTopic(CommonTopic topic) {
		this.topic = topic;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopicUrl() {
		return topicUrl;
	}

	public void setTopicUrl(String topicUrl) {
		this.topicUrl = topicUrl;
	}

	
}
