package com.forum.topicService;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import com.forum.daoImp.MySqlSessionFactory;
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

	
	TopicSessionQuery query = new TopicSessionQuery();
	/**
	 * 根据时间顺序来分页得到最新帖子 
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public ArrayList<TopicShow> getShowTopicByTime(int pageIndex,int pageSize){
		
		ArrayList<TopicShow> listShow = new ArrayList<TopicShow>();	

		int beginIndex = (pageIndex-1) * pageSize;
		
		TopicSessionQuery query =new  TopicSessionQuery();		
		String hql = "from CommonTopic order by ctime desc";
		List<Object> tempList = query.selectByPage(hql, beginIndex,pageSize);	
		
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
	
	
	
}
