package com.forum.topicService;

import org.hibernate.Session;
import org.junit.Test;

import com.forum.daoImp.MySqlSessionFactory;
import com.forum.entityImp.CommonNode;
import com.forum.entityImp.CommonTopic;
import com.forum.entityImp.CommonUser;
import com.forum.tools.TimeStamp;

/**
 * 发帖
 * @author xufeng
 *
 */
public class SendTopicService {

	
	/**
	 * 发表一个新帖
	 * @param nodeId
	 * @param topic
	 */	
	public void doSend(int nodeId,CommonTopic topic,int  authorId){

		Session session = MySqlSessionFactory.getSession();

		//1.寻找发表话题的节点		
		CommonNode node = session.get(CommonNode.class, nodeId);
		
		//2.设置话题的作者
		topic.setAuthor(session.get(CommonUser.class, authorId));
		//3.给话题添加发送时间
		topic.setcTime(TimeStamp.getCTimeStamp());
		//4将话题天界到此节点下
		node.getTopics().add(topic);		
		//5.保存
		session.update(node);
		
		MySqlSessionFactory.releaseResource(session);
	}
	@Test
	public void test(){
		CommonTopic  tt = new CommonTopic();
		tt.setTitle("测试话题");
		
		doSend(1,tt,1);
		
	}
	
}
