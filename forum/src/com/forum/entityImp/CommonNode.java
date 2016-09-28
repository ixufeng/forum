package com.forum.entityImp;

import java.util.HashSet;

import java.util.Set;

public class CommonNode {
	
	private String  name; //node名称
	private int nodeId;     //nodeid
	private long ctime;  //创建时间戳
	private String introduce;
	private String avatar_sm; //图片
	private String avatar_lg; //大图
	private CommonTheme theme;
	private Set<CommonTopic> topics =  new HashSet<CommonTopic>(); //一对多

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNodeId() {
		return nodeId;
	}


	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}


	public long getCtime() {
		return ctime;
	}


	public void setCtime(long ctime) {
		this.ctime = ctime;
	}


	public String getIntroduce() {
		return introduce;
	}


	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}


	public String getAvatar_sm() {
		return avatar_sm;
	}



	public void setAvatar_sm(String avatar_sm) {
		this.avatar_sm = avatar_sm;
	}


	public String getAvatar_lg() {
		return avatar_lg;
	}


	public void setAvatar_lg(String avatar_lg) {
		this.avatar_lg = avatar_lg;
	}


	public Set<CommonTopic> getTopics() {
		return topics;
	}


	public void setTopics(Set<CommonTopic> topics) {
		this.topics = topics;
	}


	public CommonTheme getTheme() {
		return theme;
	}


	public void setTheme(CommonTheme theme) {
		this.theme = theme;
	}

	

}
