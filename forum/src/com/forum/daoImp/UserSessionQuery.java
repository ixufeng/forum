package com.forum.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.forum.dao.SessionFactoryInterface;
import com.forum.entityImp.CommonReply;
import com.forum.entityImp.CommonUser;
import com.forum.tools.FilePathConfig;

/**
 * 处理sql语句
 * @author xufeng
 *
 */
public class UserSessionQuery {
	
	
	private CommonQuery common = new CommonQuery();
	private Session session = MySqlSessionFactory.getSession();
	
	
	
	@SuppressWarnings("unchecked")
	public List<Object> select(String hql,String[] params){
		
		
		ArrayList<Object> list = new ArrayList<Object>();  
		Query query = session.createQuery(hql);
		
		if(params!=null){
			for(int i=0;i<params.length;i++){
				query.setParameter(i, params[i]);
			}
		}	
		list = (ArrayList<Object>) query.list();
		//release(session);
		return list;
	}
	
	
	
	
	/**
	 * 更新用户的头像
	 */
	public int updateUserAvatar(String fileName,int userId){
		String lg = FilePathConfig.userAvatar + "/" + fileName;
		System.out.println("dao曾获取的数据" + lg);
		String sm = FilePathConfig.userAvatar + "/sm_" + fileName;
		String hql = "update CommonUser set userAvatar_sm = ? ,userAvatar_lg=? where userId=?";
		Object[] obj = new Object[]{sm,lg,userId};		
		
		return this.common.update(hql, obj);	
	}
	
	/**
	 * 根据品论的id
	 * @param id
	 */
	public CommonUser getUserByReplyId(int id){
		Session session = MySqlSessionFactory.getSession();
		
		CommonReply reply = session.get(CommonReply.class, id);
		CommonUser user = reply.getReplyUser();	
		
		return user;

	}
	/**
	 * 修改积分
	 */
	public void addPoint(){
		
	}
	

	
	//释放资源，提交事务
	public void release(){

		MySqlSessionFactory.releaseResource(session);
		
	}
	
}
