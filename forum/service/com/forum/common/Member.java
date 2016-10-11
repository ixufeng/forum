package com.forum.common;

import com.forum.daoImp.UserSessionQuery;

public class Member {

	private UserSessionQuery query = new UserSessionQuery();
	/**
	 * 获取社区成员数量
	 */
	public Long getMemberNum(){
		
		return this.query.getMemberNum();
	}
}
