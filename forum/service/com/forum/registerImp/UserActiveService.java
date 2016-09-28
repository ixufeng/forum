package com.forum.registerImp;

import org.hibernate.Session;
import org.junit.Test;

import com.forum.dao.SessionFactoryInterface;
import com.forum.daoImp.MySqlSessionFactory;
import com.forum.entity.User;
import com.forum.entityImp.CommonUser;

/**
 * 
 * @author xufeng
 * 激活用户注册服务类
 */

public class UserActiveService {
	
	SessionFactoryInterface facroty = new MySqlSessionFactory();
	
	
	@Test
	public boolean active(User user,String certificateCode){
		
		if(user.getClass().getName().equals("com.forum.entityImp.CommonUser")){
			//普通用户激活
			CommonUser u = (CommonUser)user;
			if(u.getPassWord().equals(certificateCode)){
				//验证成功，并激活
				u.setActive(true);
				Session session = MySqlSessionFactory.getSession();
				session.update(u);
				MySqlSessionFactory.releaseResource(session);
				return true;
			}else{
				return false;
			}
		}else{
			return true;
		}
	
	}
	
	
}
