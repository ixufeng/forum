package com.forum.registerImp;



import org.hibernate.Session;

import com.forum.dao.SessionFactoryInterface;
import com.forum.daoImp.DaoFactory;
import com.forum.daoImp.MySqlSessionFactory;
import com.forum.entity.User;
import com.forum.entityImp.CommonUser;
import com.forum.register.Register;
import com.forum.tools.CheckUser;
import com.forum.tools.SecurityMD5;

/**
 * 注册类
 * @author xufeng
 *
 */
public class CommonRegister implements Register {

	SessionFactoryInterface factory = DaoFactory.getInstance().getMySqlSessionFactory();	
	
	/**
	 * 普通用户注册
	 */
	@Override
	public boolean register(User user) {
		
		
		CommonUser u = (CommonUser) user;
		//验证用户合法性
		if(!CheckUser.checkAll(u)){
			
			return false;
		}
		//md5加密
		u.setPassWord(SecurityMD5.encode(u.getPassWord()));
		//保存用户信息
		Session session = MySqlSessionFactory.getSession();
		int id = (Integer)session.save(user);		
		MySqlSessionFactory.releaseResource(session);
		
		if(id>0){
			
			return true;
		}

		return false;
	}
	

	
}
