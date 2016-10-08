package com.forum.messageAction;

import java.io.IOException;

import com.forum.entityImp.CommonUser;
import com.forum.globle.BaseAction;
import com.forum.topicService.NewMessage;

public class GetMessage extends BaseAction {

	
	private static final long serialVersionUID = 1L;
	private NewMessage message = new NewMessage();
	private int id;
	 
	
	@Override
	public String execute(){
		
		CommonUser user = (CommonUser)httpSession.getAttribute("user");
		if(user!=null){
			if(user.getUserId()==id){
				
				int size = message.getNewMessageNums(id);
				try {
					httpResponse.getWriter().write(size+"");
					
				} catch (IOException e) {
				
				};
				
				return null;
			}
		}	
		try {
			httpResponse.getWriter().write(0+"");
		} catch (IOException e) {
			
			e.printStackTrace();
		}		
		return null;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
