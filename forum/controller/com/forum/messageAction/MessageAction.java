package com.forum.messageAction;

import java.util.ArrayList;

import com.forum.entityImp.CommonUser;
import com.forum.entityImp.Message;
import com.forum.entityImp.MessageShow;
import com.forum.globle.BaseAction;
import com.forum.topicService.NewMessage;

public class MessageAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<MessageShow> showList = new ArrayList<MessageShow>();//展示的MessageShow
	
	private NewMessage message = new NewMessage();
	/**
	 * 获取新的消息
	 * @return
	 */
	public String getNewMessage(){
		
		Object obj =  this.httpSession.getAttribute("user");
		CommonUser user = obj==null?null:(CommonUser)obj;
		if(user!=null){
			this.showList =  message.getNewMessage(user.getUserId());
			
		}
		return "message_info";
	}
	
	/**
	 * 查看历史消息
	 * @return
	 */
	public String getHistoryMessage(){
		Object obj =  this.httpSession.getAttribute("user");
		CommonUser user = obj==null?null:(CommonUser)obj;
		if(user!=null){
			this.showList =  message.getOldMessage(user.getUserId());
		}
		
		return "message_history";
	}
	
	/**
	 * 更新消息
	 * @return
	 */
	public void changeMessageState(){
		
	
	}
	
	/**
	 * 删除消息
	 */
	public void deleteMessage(){
		
	}

	public ArrayList<MessageShow> getShowList() {
		return showList;
	}

	public void setShowList(ArrayList<MessageShow> showList) {
		this.showList = showList;
	}
	

	

	
}
