package com.forum.entityImp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.forum.entity.Topic;

/**
 * 普通话题
 * @author xufeng
 *
 */
public class CommonTopic implements Topic {

	private int topicId;
	private String title;
	private String content;
	private Long cTime;  //创建时间 
	private String url;//访问地址
	private long supports;//点击数
	private CommonNode node;	
	private CommonUser author;	
	private Set<CommonReply> replies = new HashSet<CommonReply>();
	private List<TopicImage> images = new ArrayList<TopicImage>();
	private int topicType = 0;  //帖子的类型，默认普普通帖子
	
	public CommonTopic() {
		
	}


	public CommonTopic(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
	public int getTopicId() {
		return topicId;
	}


	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getcTime() {
		return cTime;
	}
	public void setcTime(Long cTime) {
		this.cTime = cTime;
	}


	public long getSupports() {
		return supports;
	}


	public void setSupports(long supports) {
		this.supports = supports;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<CommonReply> getReplies() {
		
		return replies;
	}


	public void setReplies(Set<CommonReply> replies) {
		this.replies = replies;
	}


	public int getTopicType() {
		return topicType;
	}


	public void setTopicType(int topicType) {
		this.topicType = topicType;
	}


	public CommonNode getNode() {
		return node;
	}


	public void setNode(CommonNode node) {
		this.node = node;
	}


	public CommonUser getAuthor() {
		return author;
	}


	public void setAuthor(CommonUser author2) {
		
		this.author = author2;
	}


	public List<TopicImage> getImages() {
		return images;
	}


	public void setImages(List<TopicImage> images) {
		this.images = images;
	}


	
	
}
