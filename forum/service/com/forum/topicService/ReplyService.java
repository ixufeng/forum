package com.forum.topicService;

import org.hibernate.Session;
import com.forum.daoImp.MySqlSessionFactory;
import com.forum.entityImp.CommonReply;
import com.forum.entityImp.CommonTopic;
import com.forum.entityImp.CommonUser;
import com.forum.tools.TimeStamp;

/**
 * 回复帖子
 * @author xufeng
 *
 */
public class ReplyService {
	

	/**
	 *	回复一条帖子
	 * @param topicId
	 * @param userId
	 * @param reply
	 */
	public void doReply(int topicId,int userId,CommonReply reply){		
	
					
		Session session =MySqlSessionFactory.getSession();
		reply.setcTime(TimeStamp.getCTimeStamp());
		//获取评论人的信息
		CommonUser replyUser = session.get(CommonUser.class, userId);
		//获取回复帖子的信息
		CommonTopic topic = session.get(CommonTopic.class,topicId );
		
		reply.setReplyUser(replyUser);
		topic.setSupports(topic.getSupports()+1);
		topic.getReplies().add(reply);
		session.update(topic);
		
		MySqlSessionFactory.releaseResource(session);
		
	}
}
