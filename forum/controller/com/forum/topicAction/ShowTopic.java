package com.forum.topicAction;

import java.util.ArrayList;
import java.util.List;
import com.forum.entityImp.TopicShow;
import com.forum.globle.BaseAction;
import com.forum.topicService.GetTopicService;

/**
 * 会按照默认的方式来展示话题
 * @author xufeng
 *
 */
public class ShowTopic extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	private GetTopicService getTopic = new GetTopicService();
	
	private List<TopicShow> list = new ArrayList<TopicShow>();
	private int nodeId;
	private String nodeName = "热门";
	private int pageIndex = 1;//默认值
	private int pageSize = 10; //默认值
	
	/**
	 * 默认浏览方式
	 * @return
	 */
	@Override
	public String execute(){
		//获取话题
		this.list = getTopic.getShowTopicByTime(this.pageIndex,this.pageSize);		
		
		//将pageIndex存入session
		this.httpSession.setAttribute("pageIndex",pageIndex);
		//论坛话题的总页数
		if(this.httpSession.getAttribute("allTopicNum")==null){
			Long num = getTopic.getAllTopicsNum();
			if(num%pageSize!=0){
				num = num/pageSize+1;
			}else{
				num = num/pageSize;
			}
			this.httpSession.setAttribute("allTopicNum", num);
		}
		
		return SUCCESS;
	}
	
	/**
	 * 查找指定节点下的话题
	 */
	public String node(){
		
		this.list = getTopic.getShowTopicByTime(pageIndex, pageSize, nodeId);
		this.nodeName = getTopic.getNodeName();
		//将pageIndex存入session
		this.httpSession.setAttribute("pageIndex",pageIndex);
		//论坛话题的总页数
		if(this.httpSession.getAttribute("allTopicNum")==null){
			Long num = getTopic.getAllTopicsNum();
			if(num%pageSize!=0){
				num = num/pageSize+1;
			}else{
				num = num/pageSize;
			}
			this.httpSession.setAttribute("allTopicNum", num);
		}
		
		return "node_topic";
		
	}
	
	

	
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		 
		this.pageIndex = pageIndex;
		
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<TopicShow> getList() {
		return list;
	}

	public void setList(List<TopicShow> list) {
		this.list = list;
	}
	
	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}


	
	
	
}
