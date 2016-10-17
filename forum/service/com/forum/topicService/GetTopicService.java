package com.forum.topicService;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.forum.daoImp.MySqlSessionFactory;
import com.forum.daoImp.NodeDao;
import com.forum.daoImp.TopicSessionQuery;
import com.forum.entityImp.CommonNode;
import com.forum.entityImp.CommonTopic;
import com.forum.entityImp.TopicShow;
import com.forum.tools.TimePeriod;
import com.forum.tools.TimeStamp;

/**
 * 获取一定数量的帖子
 * @author xufeng
 *
 */
public class GetTopicService {

	
	private TopicSessionQuery query = new TopicSessionQuery();
	private NodeDao nodeDao = new NodeDao();
	
	/**
	 * 根据时间顺序来分页得到最新帖子 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public ArrayList<TopicShow> getShowTopicByTime(int pageIndex,int pageSize){
				
		int beginIndex = (pageIndex-1) * pageSize;
		TopicSessionQuery query =new  TopicSessionQuery();		
		String hql = "from CommonTopic order by ctime desc";
		List<Object> tempList = query.selectByPage(hql,null, beginIndex,pageSize);	
		return castTopic(tempList);
	}
	
	/**
	 * 方法的重载，查找某个节点下的话题
	 * @param pageIndex
	 * @param pageSize
	 * @param nodeName
	 * @return
	 */
	public ArrayList<TopicShow> getShowTopicByTime(int pageIndex,int pageSize,String nodeName){
		
		if(nodeName==null||"".equals(nodeName)){
			return null;
		}
		//先获取此节点
		CommonNode node = nodeDao.findNodeByName(nodeName);	
		if(node==null){
			
			return null;
		}
		Object[] params = new Object[]{node.getNodeId()};

		int beginIndex = (pageIndex-1) * pageSize;
		TopicSessionQuery query =new  TopicSessionQuery();		
		String hql = "from CommonTopic where nodeId = ? order by ctime desc";
		List<Object> tempList = query.selectByPage(hql,params, beginIndex,pageSize);	
		return castTopic(tempList);
	}
		
	
	/**
	 * 通过id来获取话题
	 */
	public CommonTopic getTopicById(int topicId){
		
		Session session  = 	MySqlSessionFactory.getSession();		
		CommonTopic topic = session.get(CommonTopic.class, topicId);
		MySqlSessionFactory.releaseResource(session);
		
		return topic;
	}
	
	/**
	 * 获取当天回复数量最多的帖子
	 * @param num
	 */
	public List<CommonTopic> getHotTpopic(int num){
		
		List<CommonTopic> list = new ArrayList<CommonTopic>();
		
		String hql = "from CommonTopic where cTime between ? and ? order by supports desc";
		//今天的0点
		long time1 = TimeStamp.getTodayBeginTime();
		//今天的24点
		long time2 = TimeStamp.getTadayEndTime();
		
		Long[] params = {time1,time2};
		if(this.query==null){
			this.query = new TopicSessionQuery();
		}
		
		List<Object> tempList = this.query.select(hql, params,num);
		
		
		for(int i =0;i<tempList.size();i++){
			list.add((CommonTopic) tempList.get(i));
		}
		
		return list;	
	}
	
	
	/**
	 * 获取最新的帖子
	 */
	public void getLastedTopic(int num){
		if(this.query==null){
			
		}
	}
	/**
	 * 获取社区的
	 * @return
	 */
	public Long getAllTopicsNum(){
		
		return query.getTopicsNum();
	}
	
	/**
	 * 查找用户所有发过的帖子
	 * @param userId
	 */
	public ArrayList<CommonTopic> getTopicsByUserId(int userId){
		ArrayList<CommonTopic> list = new ArrayList<CommonTopic>();
		if(this.query==null){
			this.query = new TopicSessionQuery();
		}
		String hql = "from CommonTopic where userId = ?";
		Object[] params = new Object[]{userId};
		List<Object> tempList = this.query.select(hql, params);
		
		for(Object obj:tempList){
			
			list.add((CommonTopic) obj);
		}
		return list;
	}
	
	
	/**
	 * CommonTopic转ShowTopic
	 */
	public ArrayList<TopicShow> castTopic(List<Object> tempList){
		
		ArrayList<TopicShow> listShow = new ArrayList<TopicShow>();
		for(int i =0;i<tempList.size();i++){
			TopicShow tempShow = new TopicShow();
			CommonNode tempNode = new CommonNode();
			CommonTopic tempTopic = new CommonTopic();					
			tempTopic = (CommonTopic)tempList.get(i);
			tempTopic.setSupports(tempTopic.getReplies().size());
			tempNode  = tempTopic.getNode();
			tempShow.setNode(tempNode);
			tempShow.setTopic(tempTopic);
			tempShow.setUser(tempTopic.getAuthor());
			try{
				tempShow.setTimePeriod(TimePeriod.getTimePeriod(tempTopic.getcTime()));
			}catch(Exception e){
				
			}
			
			listShow.add(tempShow);			
		}
		return listShow;
	}
}
