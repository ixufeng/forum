package com.forum.login;

import com.forum.entity.User;

/**
 * 
 * @author xufeng
 *	登陆接口
 */
public interface Login {

	//登陆
	public String  doLogin(User user);
	//等出
	public String doLoginOut(User user);
}
