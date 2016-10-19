package com.forum.common;

import com.forum.daoImp.UserDao;

public class Member {

	private UserDao query = new UserDao();
	/**
	 * 获取社区成员数量
	 */
	public Long getMemberNum(){
		
		return this.query.getMemberNum();
	}
}
