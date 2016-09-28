package com.forum.daoImp;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.forum.dao.SessionFactoryInterface;
import com.forum.entityImp.CommonNode;
import com.forum.entityImp.CommonTheme;
import com.forum.tools.TimeStamp;


public class MySqlSessionFactory implements SessionFactoryInterface {

	
	private static org.hibernate.SessionFactory sessionFactory;
	
	
	
	static{
		//获取配置文件
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build(); 
		
		sessionFactory = new MetadataSources( serviceRegistry ).buildMetadata().buildSessionFactory();
		
	}

	
	public static Session getSession(){	

		Session session =  sessionFactory.openSession();
		session.beginTransaction();
		return session;
	}
	
	public static void releaseResource(Session session){
		
		if(session!=null){
			if(session.isOpen()){
				//提交事务
				session.getTransaction().commit();
				session.close();
				session=null;
			}
			
		}					
		
	}
	
	
	@Test
	public void test(){
		//创建一个主题 
		/*CommonTheme theme = new CommonTheme();
		theme.setcTime(TimeStamp.getCTimeStamp());
		theme.setName("编程之美");
		theme.setIntroduce("谈论编程的哲学");
		this.session = getSession();
		this.session.save(theme);
		this.releaseResource();*/
		//创建一个节点
	/*	this.session = getSession();
		CommonTheme th = this.session.get(CommonTheme.class, 1);
		CommonNode node = new CommonNode();
		node.setName("java");
		node.setCtime(TimeStamp.getCTimeStamp());
		node.setIntroduce("java讨论区");
		th.getNodes().add(node);
		this.session.update(th);
		this.releaseResource();*/
	}
	
}
