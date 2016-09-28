package com.forum.nodeService;

import java.util.ArrayList;
import java.util.List;
import com.forum.daoImp.DaoFactory;
import com.forum.daoImp.TopicSessionQuery;
import com.forum.entityImp.CommonNode;
import com.forum.tools.TimeStamp;

/**
 * node查询类
 * @author xufeng
 *
 */
public class NodeService {

	public List<CommonNode> findAllNodes(){
		List<CommonNode> list = new ArrayList<CommonNode>();		
		TopicSessionQuery query = DaoFactory.getInstance().getTopicQuery();
		String hql = "from CommonNode";				
		List<Object> tempList = query.select(hql, null);	
		System.out.println(tempList.get(0).toString());		
		for(int i =0;i<tempList.size();i++){			
			list.add((CommonNode) tempList.get(i));			
		}
		return list;
	}
	
	/**
	 * 按照时间的排序获取最新节点
	 * @param num
	 */
	public void getLastedNode(int num){
		
	}
	/**
	 * 获取当天热节点
	 */
	public void getHostedNode(){
		
		String hql = "from CommonNode order by supports desc";
		//今天的0点
		long time1 = TimeStamp.getTodayBeginTime();
		//今天的24点
		long time2 = TimeStamp.getTadayEndTime();
		
		Long[] params = {time1,time2};
	}
	/**
	 * 添加一个节点
	 * @param node
	 */
	public void addNode(int themeId,CommonNode node){
		
	}
	/**
	 * 删除指点的节点
	 * @param id
	 */
	public void delNode(int id){
		
	}
}



