package com.forum.topicAction;

import javax.transaction.Synchronization;

import com.forum.entityImp.CommonTopic;
import com.forum.entityImp.CommonUser;
import com.forum.globle.BaseAction;
import com.forum.topicService.SendTopicService;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 实现用户发帖
 * @author xufeng
 *
 */
public class SendTopic extends BaseAction implements ModelDriven<CommonTopic>  {


	private static final long serialVersionUID = 1L;
	
	private CommonTopic topic = new CommonTopic();
	private int nodeId = -1;
	private String sendRes;
	
	/**
	 * 保存此帖子
	 */
	@Override
	public String execute() throws Exception {
		
		SendTopicService send = new SendTopicService();
		if(this.httpSession.getAttribute("user")!=null){
			
			CommonUser user = (CommonUser) this.httpSession.getAttribute("user");
			int id = user.getUserId();	
			if(this.nodeId ==-1){
				
				this.sendRes = "请选择节点";				
				return SUCCESS;				
			}
			
	
			
			Object obj = this.httpSession.getAttribute("topicImage");
			
			String params = obj==null?null:(String)obj;
			send.doSend(this.nodeId, topic, id,params);
			this.httpSession.removeAttribute("topicImage");
			this.sendRes = "success";
			
		}else{
			
			this.sendRes = "尚未登陆，请先登录";
			return SUCCESS;
		}
  
		return SUCCESS ;
	}

	@Override
	public CommonTopic getModel() {
		
		return this.topic;
	}

	public int getNodeId() {
		return nodeId;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public String getSendRes() {
		return sendRes;
	}

	public void setSendRes(String sendRes) {
		this.sendRes = sendRes;
	}


	
}
