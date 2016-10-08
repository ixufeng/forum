package com.forum.daoImp;

import java.util.ArrayList;

import org.hibernate.Session;

import com.forum.entityImp.Message;
import com.forum.entityImp.MessageShow;

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
	 * 更新一条消息
	 */
	public int readMessage(int id ){
		
		String hql = "update Message set isRead = 1 where id = ?";
		Object[] params = new Object[]{id};	
		return query.update(hql, params);
		
		
	}

	/**
	 *根据消息的id来删除消息
	 */
	
	public int delMessageById(int id){
		
		String hql = "delete from Message where id = ?";
		Object[] params = new Object[]{id};
		return query.update(hql, params);
		
	}
	
	/**
	 * 分页获取消息
	 * @return
	 */
	public ArrayList<Message>getMessageByPage(){
		
		return null;
	}
	
	
	
}
