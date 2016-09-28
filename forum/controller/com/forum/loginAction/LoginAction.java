package com.forum.loginAction;

import com.forum.entityImp.CommonUser;
import com.forum.globle.BaseAction;
import com.forum.loginImp.CommonLoginService;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends BaseAction implements ModelDriven<CommonUser>{

	private static final long serialVersionUID = 1L;

	
	public CommonUser user = new CommonUser();
	
	public String loginRes;
	/**
	 * 处理普通登陆
	 */
	CommonLoginService loginService = new CommonLoginService();
	public String  doLogin(){
		//登陆成功
		this.loginRes = loginService.doLogin(user);
		if(this.loginRes.equalsIgnoreCase("SUCCESS")){
			//1.获取登陆者的信息
			user = (CommonUser) loginService.getUser();
			//2.保存sesssion信息
			this.httpSession.setAttribute("user", user);
			//页面跳转
			return "login_success";
			
		}else{
			//将信息放入sesion中，//临时方法
			this.httpSession.setAttribute("loginMessage", loginRes);
			return "login_error";			
		}
	}



	@Override
	public CommonUser getModel() {
		
		return (CommonUser) this.user;
	}
	
}
