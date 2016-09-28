package com.forum.daoImp;

import java.util.ArrayList;

import org.hibernate.Session;

import com.forum.entityImp.Message;

/**
 * 处理用户的信息
 * @author xufeng
 *
 */
public class MessageDao {

	private CommonQuery query = new CommonQuery();
	
	/**
	 * 通过用户的id来查找消息
	 */
	public ArrayList<Message> getMessageByUserId(int userId,int isRead){
		
		ArrayList<Message> MesList = new ArrayList<Message>();
		String hql = "from Message where userId = ? and isRead = ? ";
		
		Object[] params = new Object[]{userId,isRead};
		
		ArrayList<Object> list = (ArrayList<Object>) query.selectForList(hql, params);
		
		for(Object obj:list){
			
			MesList.add((Message) obj);
		}
		
		return MesList;
	}
	/**
	 * 添加一条消息
	 * @param msg
	 */
	public void addMessage(Message msg){
		
		Session session = MySqlSessionFactory.getSession();
		session.save(msg);		
		
		MySqlSessionFactory.releaseResource(session);
		
	}
	
	/**
	 * 删除一条消息
	 * @param msg
	 */
	public void delMessage(Message msg){
		
		Session session = MySqlSessionFactory.getSession();
		session.save(msg);				
		MySqlSessionFactory.releaseResource(session);
	}

	/**
	 *更具消息的id来删除消息
	 */
	public Message delMessageById(int id){
		Session session = MySqlSessionFactory.getSession();
		return session.get(Message.class, id);
		
	}
}
