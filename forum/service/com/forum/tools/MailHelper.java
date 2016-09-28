package com.forum.tools;

import com.forum.entity.User;
import com.forum.entityImp.CommonUser;
import com.xufeng.factory.MailFactory;

public class MailHelper {

	public void sendMialToUser(User user,String message){
		CommonUser commonUser = (CommonUser)user;
		
		MailFactory factory = new MailFactory("mail.xml");
		
		factory.getMailServer().sendMail(commonUser.getUserEmail(), "感谢注册论坛", message);
		
	}
}
