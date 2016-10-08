package com.forum.tools;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.forum.daoImp.DaoFactory;
import com.forum.daoImp.UserSessionQuery;
import com.forum.entity.User;


/**
 * 
 * @author xufeng
 *	检查用户的信息
 */
public class CheckUser {

	
	
	//违法用户名或者防止重复
	public static String  checkUserName(String userName){
		
		if(userName.length()<2){
			return Message.nameShort;
		}else if(userName.length()>20){
			return Message.nameLong;
		}else if(isCoverIllegalCode(userName)) {
			return  Message.nameIllegal;
		}else if(isNameExist(userName)){
			return Message.nameExist;
		}else{
			return Message.SUCCESS;
		}
				
	}
	/**
	 * 验证邮箱的合法性
	 * @param email
	 * @return
	 */
	public static String checkEmail(String email){
        
        try{
                String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
                Pattern regex = Pattern.compile(check);
                Matcher matcher = regex.matcher(email); 
                if(!matcher.matches()){
                	return Message.emailIllegal;
                }
            }catch(Exception e){
                return Message.emailIllegal;
            }
        if(isEmailExist(email)){
        	
        	return Message.emailExist;
        }
        return Message.SUCCESS;
    }
	
	private static  boolean isNameExist(String name){
		
		String hql = "select id from CommonUser where userName=?";
		
		String[] params = {name};	
		
		UserSessionQuery  userQuery = DaoFactory.getInstance().getUserQuery();
		
		
		List<Object> list = userQuery.select(hql, params);
		userQuery.release();
		if(list.size()>0){
			return true;
		}
		return false;
	}

	public static boolean isEmailExist(String email){
		
		String hql = "select id from CommonUser where userEmail=? ";
		
		String params[] = {email};
		
		UserSessionQuery  userQuery = DaoFactory.getInstance().getUserQuery();
		List<Object> list = userQuery.select(hql, params);
		userQuery.release();
		if(list.size()>0){
			return true;
		}
		return false;
	}
	//一次性检查用户的合法性
	public static  boolean checkAll(User user){
		

		return true;
	}
	
	private static  boolean isCoverIllegalCode(String str){
				
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.find();
	}
	
}
