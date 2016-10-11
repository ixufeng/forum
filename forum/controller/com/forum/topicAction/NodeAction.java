package com.forum.topicAction;

import java.util.ArrayList;

import com.forum.entityImp.CommonNode;
import com.forum.globle.BaseAction;
import com.forum.nodeService.NodeService;

public class NodeAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private NodeService node = new NodeService();
	private ArrayList<CommonNode> nodeList = new ArrayList<CommonNode>();
	
	/**
	 * 获取所有节点对象
	 * @return
	 */
	public String getAllNodes(){
		
		this.nodeList = node.getAllNodes();
		return "nodes";
	}
	
	
	

	public ArrayList<CommonNode> getNodeList() {
		return nodeList;
	}

	public void setNodeList(ArrayList<CommonNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	
	
	
}
