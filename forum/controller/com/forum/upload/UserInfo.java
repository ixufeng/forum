package com.forum.upload;

import com.forum.globle.BaseAction;

/**
 * 查看用户的信息
 * @author xufeng
 *
 */
public class UserInfo extends BaseAction {


	private static final long serialVersionUID = 1L;
	
	@Override
	public String  execute(){
		
		if(this.httpSession.getAttribute("user")!=null){
			return SUCCESS;
		}else{
			
			return "unlogin";
		}
		
		
		
	}
	
}
