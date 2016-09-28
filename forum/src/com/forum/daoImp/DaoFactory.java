package com.forum.daoImp;

import com.forum.dao.SessionFactoryInterface;


//管理所有数据库操作类的引用
public class DaoFactory{


	private static DaoFactory daoFactory = new DaoFactory();
	
	
	public static DaoFactory getInstance(){
		
		return daoFactory;
		
	}

	
	/**
	 * 在获取的时候实例化
	 * @return
	 */
	public SessionFactoryInterface getMySqlSessionFactory() {

		return  new MySqlSessionFactory();

	}

	/**
	 * 在获取的时候实例化用户查讯类
	 * @return
	 */
	public UserSessionQuery getUserQuery() {

			return new UserSessionQuery();
	}
	
	public TopicSessionQuery getTopicQuery(){
		
		return  new TopicSessionQuery();
	}
	
	
	
}
