package com.forum.daoImp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.forum.entityImp.CommonTopic;

/**
 * 通过hql语句来查询相关的节点
 * @author xufeng
 *
 */
public class TopicSessionQuery {

	private CommonQuery query = new CommonQuery(); 
	/**
	 * 根据制定的条件来查找相关的节点
	 * @param hql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object> select(String hql,Object[] params){
		Session session  = MySqlSessionFactory.getSession();
		
		Query query = session.createQuery(hql);			
		if(params!=null){
			for(int i =0;i<params.length;i++){				
				query.setParameter(i, params[i]);
			}
		}
		List<Object> tempList = query.list();	
		MySqlSessionFactory.releaseResource(session);
		return tempList;
	}
	
	
	public List<Object> select(String hql,Object[] params,Integer num){
		
		Session session  = MySqlSessionFactory.getSession();
		Query query = new CommonQuery().getQuery(hql, params, session);
		if(num!=-1){
			query.setFirstResult(0);
			query.setMaxResults(10);
		}
		
		@SuppressWarnings("unchecked")
		List<Object> tempList = query.list();
		MySqlSessionFactory.releaseResource(session);
		
		return tempList;
		
	}
	
	/**
	 * 分页查找
	 * @param index
	 * @param size
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object> selectByPage(String hql,int index,int size){
		Session session  = MySqlSessionFactory.getSession();	
		Query query = session.createQuery(hql);
		query.setFirstResult(index);
		query.setMaxResults(size);
		List<Object> tempList = query.list();	
		MySqlSessionFactory.releaseResource(session);
		return tempList;
	}
	
	/**
	 * 根据 id来查找一个topic
	 */
	public CommonTopic getTopicById(int id){
		
		Session session  = MySqlSessionFactory.getSession();
		
		return session.get(CommonTopic.class, id);
		
	}
	/**
	 * 获取论坛中所有帖子的数量
	 * @return
	 */
	public Long getTopicsNum(){
		String hql = "select count(*) from CommonTopic";
		Object obj = query.getObj(hql, null);
		
		return (long)(obj==null?0 : obj);
	}
	
	
}
