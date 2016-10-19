package com.forum.nodeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.forum.daoImp.DaoFactory;
import com.forum.daoImp.NodeDao;
import com.forum.daoImp.TopicDao;
import com.forum.entityImp.CommonNode;
import com.forum.tools.TimeStamp;

import net.sf.json.JSONObject;

/**
 * node查询类
 * @author xufeng
 *
 */
public class NodeService {
	
	private NodeDao dao = new NodeDao();
	
	public List<CommonNode> findAllNodes(){
		List<CommonNode> list = new ArrayList<CommonNode>();		
		TopicDao query = DaoFactory.getInstance().getTopicQuery();
		String hql = "from CommonNode";				
		List<Object> tempList = query.select(hql, null);	
			
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
	 * 获取热节点
	 */
	public void getHostedNode(){
		
		String hql = "from CommonNode order by supports desc";
		
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
	/**
	 * 获取社区节点数量
	 * 
	 */  
	public int getNodeNum(){
			
		TopicDao query = DaoFactory.getInstance().getTopicQuery();
		String hql = "from CommonNode";	
		List<Object> tempList = new ArrayList<Object>();
		tempList = query.select(hql, null);
		return tempList.size();
	}
	
	/**
	 * 获取社区所有节点
	 */
	public ArrayList<CommonNode> getAllNodes(){
		
		ArrayList<CommonNode> list = new ArrayList<CommonNode>();
		TopicDao query = DaoFactory.getInstance().getTopicQuery();
		String hql = "from CommonNode";	
		List<Object> tempList = query.select(hql, null);
		if(tempList!=null){
			//转化
			for(Object obj:tempList){
				list.add((CommonNode) obj);
			}
		}
		
		return list;
	}
	
	public boolean addNewNode(CommonNode node,int themeId){
		
		node.setCtime(TimeStamp.getCTimeStamp());
		if(dao.addNode(node, themeId)){
			return true;
		}
		
		return false;
	}
	/**
	 * 添加一个节点
	 * @param nodeName
	 * @param nodeTro
	 * @param nodeAvatar
	 * @param themeId
	 * @return
	 */
	public boolean addNewNode(String nodeName,String nodeTro,String nodeAvatar,int themeId){
		
		
		CommonNode node = new CommonNode();
		node.setName(nodeName);
		node.setCtime(TimeStamp.getCTimeStamp());
		//node.setAvatar_lg(nodeAvatar);
		node.setIntroduce(nodeTro);
		if(dao.addNode(node, themeId)){
			
			return true;
		}
		return false;
	}
	
	
	/**
	 * 查找某个主题下的所有节点
	 * @param themeId
	 */
	
	public ArrayList<CommonNode> getNodesByThemeId(int themeId){
		
		 return dao.getNodesByThemeId(themeId);
	}
	
	
}



