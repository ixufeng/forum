package com.forum.topicAction;

import java.util.ArrayList;
import java.util.List;

import com.forum.entityImp.CommonNode;
import com.forum.globle.BaseAction;
import com.forum.nodeService.NodeService;

public class NewTopic extends BaseAction {

	private static final long serialVersionUID = 1L;
		
	//论坛的节点
	private List<CommonNode> list = new ArrayList<CommonNode> (); 
	
	@Override
	
	public String  execute(){
	
		NodeService service = new NodeService();
		this.list =  service.findAllNodes();	
		return SUCCESS;
	}

	
	
	public List<CommonNode> getList() {
		
		return list;
	}

	public void setList(List<CommonNode> list) {
		this.list = list;
	}
	
	
}
