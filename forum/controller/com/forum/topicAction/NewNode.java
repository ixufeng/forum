package com.forum.topicAction;


import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import com.forum.entityImp.CommonNode;
import com.forum.entityImp.CommonUser;
import com.forum.globle.BaseAction;
import com.forum.nodeService.NodeService;

import net.sf.json.JSONObject;

/**
 * 创作新节点
 * @author xufeng
 *
 */
public class NewNode extends BaseAction {

	private static final long serialVersionUID = 1L;
	private NodeService node = new NodeService();
	private String nodeName;
	private String node_avatar;
	private int themeId = -1;
	private String nodeIntro;
	private String res;//新建节点的结果
	
	public  String handle(){
		//获取session中的user
		if(this.httpSession.getAttribute("user")!=null){
			CommonUser user = (CommonUser)this.httpSession.getAttribute("user");
			
			
			if(node.addNewNode(nodeName,nodeIntro,node_avatar,themeId)){
				
				res = "node created by" + user.getUserName() + "success";
				
				return "success";
			}else{
				res = "failure...";
				return "failure";
			}
		}

		
		return "failure";
	}
	
	public String newNode(){
		if(this.httpSession.getAttribute("user")!=null){
			
			
			return "login";
			
		}
		this.res = "请先登陆";
		
		return "login";
		
	}
	
	/**
	 * ajax获取node
	 * @return
	 */
	public String getNode(){
		
		
		if(this.themeId!=-1){
			
			ArrayList<CommonNode> list = node.getNodesByThemeId(themeId);
			StringBuffer json = new StringBuffer();
			json.append("[");
			for(int i = 0;i<list.size();i++){
				CommonNode node = list.get(i);
				json.append("{");
				json.append("\"id\":");
				
				json.append(node.getNodeId() + ",");
				json.append("\"name\":");
				json.append("\"" + node.getName() + "\"");
				
				if(i==list.size()-1){
					json.append("}");
				}else{
					json.append("},");
				}
				
			}
			json.append("]");
			
			
			
			try {
				this.httpResponse.getWriter().write(json.toString());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			
		}
		
		return null;
	}


	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getNode_avatar() {
		return node_avatar;
	}

	public void setNode_avatar(String node_avatar) {
		this.node_avatar = node_avatar;
	}



	public int getThemeId() {
		return themeId;
	}

	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}

	public String getNodeIntro() {
		return nodeIntro;
	}

	public void setNodeIntro(String nodeIntro) {
		this.nodeIntro = nodeIntro;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

}
