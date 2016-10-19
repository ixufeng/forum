package com.forum.topicService;

import java.util.ArrayList;

import org.hibernate.Session;
import org.junit.Test;

import com.forum.daoImp.MySqlSessionFactory;
import com.forum.entityImp.CommonNode;
import com.forum.entityImp.CommonTopic;
import com.forum.entityImp.CommonUser;
import com.forum.entityImp.TopicImage;
import com.forum.tools.FilePathConfig;
import com.forum.tools.TimeStamp;

/**
 * 发帖
 * @author xufeng
 *
 */
public class SendTopicService {

	
	/**
	 * 发表新帖	
	 * @param nodeId
	 * @param topic
	 * @param authorId
	 * @param images
	 */
	public void doSend(int nodeId,CommonTopic topic,int  authorId,String images){
		
		ArrayList<TopicImage> list = new ArrayList<TopicImage>();
		
		if(images!=null){
			String src[] = images.split(",");
			System.out.println(src.length);
			for(String s:src){
				
				TopicImage img = new TopicImage();
				img.setImageSrc( FilePathConfig.topicImage+"/"+s);
				list.add(img);
			}
		}
		
		Session session = MySqlSessionFactory.getSession();

		//1.寻找发表话题的节点		
		CommonNode node = session.get(CommonNode.class, nodeId);
		
		//2.设置话题的作者
		topic.setAuthor(session.get(CommonUser.class, authorId));
		
		//3.给话题添加发送时间
		topic.setcTime(TimeStamp.getCTimeStamp());
		//添加话题的图片
		for(TopicImage img:list){
			
			topic.getImages().add(img);
		}
		
		//4将话题天界到此节点下
		node.getTopics().add(topic);		
		//5.保存
		session.update(node);
		
		MySqlSessionFactory.releaseResource(session);
	}
	
	
	
}
