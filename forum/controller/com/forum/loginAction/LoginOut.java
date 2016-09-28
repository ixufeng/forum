package com.forum.loginAction;

import com.forum.globle.BaseAction;

/**
 * 用户登出
 * @author xufeng
 *
 */
public class LoginOut extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute(){
		
		this.httpSession.removeAttribute("user");
		return SUCCESS;
	}
	

}
