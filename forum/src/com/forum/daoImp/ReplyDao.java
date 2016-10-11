package com.forum.daoImp;



public class ReplyDao {

	private CommonQuery query = new CommonQuery();
	
	public void getNumsByPId(){
		
		
	}
	
	/**
	 * 获取社区所有人回复的数量
	 */
	public int getAllNums(){
		String hql = "select count(*) from CommonReply";
		Long obj = (Long)query.getObj(hql, null);
		int i = obj==null?0:obj.intValue();
		return i;
	}
	
	
}
