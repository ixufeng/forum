package com.forum.loginImp;

import java.util.List;

import com.forum.daoImp.DaoFactory;
import com.forum.daoImp.UserDao;
import com.forum.entity.User;
import com.forum.entityImp.CommonUser;
import com.forum.login.Login;
import com.forum.tools.Message;
import com.forum.tools.SecurityMD5;

public class CommonLoginService implements Login {

	
	private User user;
	/**
	 * 验证用户合法性
	 */
	@Override
	public String doLogin(User user) {
		
		CommonUser u = (CommonUser)user;
		//MD5
		u.setPassWord(SecurityMD5.encode(u.getPassWord()));
		//用户名登陆
		if(!u.getUserName().equals(null)){
			
			String hql = "from CommonUser where userName=? or userEmail=?";
			String[] params = {u.getUserName(),u.getUserName()};
			UserDao query = DaoFactory.getInstance().getUserQuery();
			List<Object> list = query.select(hql, params);
			
			if(list.size()>0){
				
				CommonUser selUser = (CommonUser)list.get(0);
				
				if(selUser.getPassWord().equals(u.getPassWord())){
					//登陆成功
					this.user = (User) list.get(0);
					
					return Message.SUCCESS;
				}else{
					//密码错误
					return Message.passError;
				}
			}else{
				return Message.nameNotExist;
			}
		}
		return Message.nameNotExist;

	}

	@Override
	public String doLoginOut(User user) {
		
		return null;
	}
	
	//返回当前查询的对象
	public User getUser(){
		
		return this.user;
		
	}


}
