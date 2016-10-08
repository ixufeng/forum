package com.forum.daoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.forum.dao.SessionFactoryInterface;

/**
 * hql的增删查改
 * @author xufeng
 *
 */
public class CommonQuery {

	/**
	 * 根据制定的条件来查找相关的节点
	 * @param hql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object> selectForList(String hql,Object[] params){
		Session session =MySqlSessionFactory.getSession();
		Query query = getQuery(hql,params,session);
		List<Object> tempList = query.list();
		
		MySqlSessionFactory.releaseResource(session);
		return tempList;
	}
	
	/**
	 * 执行更新语句,增删改0908
	 * @param hql
	 * @param params
	 * @return
	 */
	public int update(String hql,Object[] params){
		
		Session session =MySqlSessionFactory.getSession();
		
		Query query = getQuery(hql,params,session);		
		
		int num = query.executeUpdate();
		MySqlSessionFactory.releaseResource(session);
		return num;
	}
	
	/**
	 * 查询一个对象
	 * @param hql
	 * @param params
	 * @return
	 */
	public Object getObj(String hql,Object[] params){
		
		Session session =MySqlSessionFactory.getSession();	
		Query query = getQuery(hql,params,session);
		
		Object obj =  query.uniqueResult();
		MySqlSessionFactory.releaseResource(session);
		return obj;
	}
	
	
	/**
	 * 获取查询对象
	 * @param hql
	 * @param params
	 * @return
	 */
	public Query getQuery(String hql,Object[] params,Session session){

		
		Query query = session.createQuery(hql);			
		if(params!=null){
			for(int i =0;i<params.length;i++){				
				query.setParameter(i, params[i]);
			}
		}
		
		return query;
	}
}
