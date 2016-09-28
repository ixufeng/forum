package com.forum.entityImp;

import java.util.HashSet;
import java.util.Set;

import com.forum.entity.User;

public class CommonUser implements User {
	
	private int userId;
	private String userName;
	private String passWord;
	private String passWord_confirm;
	private String userEmail;
	private String userAvatar_sm;
	private String userAvatar_lg;
	private int userPoint;
	private String code;
	private boolean isActive; 
	private Set<CommonTopic> topics = new HashSet<CommonTopic>();
	private Set<CommonReply> replies = new  HashSet<CommonReply>();
	
	public CommonUser(){
		
	}
	
	
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getPassWord_confirm() {
		return passWord_confirm;
	}

	public void setPassWord_confirm(String passWord_confirm) {
		this.passWord_confirm = passWord_confirm;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAvatar_sm() {
		return userAvatar_sm;
	}

	public void setUserAvatar_sm(String userAvatar_sm) {
		this.userAvatar_sm = userAvatar_sm;
	}

	public String getUserAvatar_lg() {
		return userAvatar_lg;
	}

	public void setUserAvatar_lg(String userAvatar_lg) {
		this.userAvatar_lg = userAvatar_lg;
	}


	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Set<CommonTopic> getTopics() {
		return topics;
	}
	
	public void setTopics(Set<CommonTopic> topics) {
		this.topics = topics;
	}

	public Set<CommonReply> getReplies() {
		return replies;
	}

	public void setReplies(Set<CommonReply> replies) {
		this.replies = replies;
	}


	public int getUserPoint() {
		return userPoint;
	}


	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}



	
}
