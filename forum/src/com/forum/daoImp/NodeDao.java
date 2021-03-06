package com.forum.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.forum.entityImp.CommonNode;
import com.forum.entityImp.CommonTheme;

/**
 * 节点dao
 * @author xufeng
 *
 */
public class NodeDao {

	private CommonQuery query = new CommonQuery();
	
	public boolean addNode(CommonNode node,int themeId){
		
		Session session = query.getSession();
		CommonTheme theme = session.get(CommonTheme.class,themeId);
		if(theme!=null){
			if(node!=null){
				theme.getNodes().add(node);
				session.update(theme);
				query.release(session);
				return true;
			}
		}
		query.release(session);
		return false;
	
	}
	
	public void delNode(int nodeId){
		
	}
	
	public void updateNode(CommonNode node){
		
		
	}
	
	public CommonNode findNodeById(int nodeId){
		
		Session session = query.getSession();
		
		return session.get(CommonNode.class, nodeId);
	}
	/**
	 * 通过node名称来过去node
	 * @param name
	 * @return
	 */
	public CommonNode findNodeByName(String name){
		
		String hql = "from CommonNode where name = ?";
		Object[] params = new Object[]{name};
		
		Object obj = query.getObj(hql, params);
		
		return obj==null?null:(CommonNode)obj;
		
	}
	
	/**
	 * 查找社区所有的节点
	 * @return
	 */
	public ArrayList<CommonNode> getAllNodes(){
		ArrayList<CommonNode> list = new ArrayList<CommonNode>();
		String hql = "from CommonNode";
		
		List<Object> temp = query.selectForList(hql, null);
		if(temp!=null){
			for(Object obj:temp){
				
				list.add((CommonNode)obj);
			}
		}
		return list;
	}
	
	
	/**
	 * 查找某个主题下的所有节点
	 * @param themeId
	 * @return
	 */
	public ArrayList<CommonNode> getNodesByThemeId(int themeId){
		ArrayList<CommonNode> list = new ArrayList<CommonNode>();
		String hql  = "from CommonNode where themeId = ?";
		Object[] params = new Object[]{themeId};
		List<Object> temp = query.selectForList(hql, params);
		if(temp!=null){
			for(Object obj:temp){
				
				list.add((CommonNode) obj);
				
			}
		}
		return list;
	}
	
	
	
}
