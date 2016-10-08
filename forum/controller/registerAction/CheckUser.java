package registerAction;

import java.io.IOException;

import com.forum.globle.BaseAction;

public class CheckUser extends BaseAction {


	private static final long serialVersionUID = 1L;
	private String userName;
	private String userEmail;
	
	public String  checkName(){
		
		
		String  nameRes = com.forum.tools.CheckUser.checkUserName(this.userName);
		try {
			
			this.httpResponse.getWriter().write(nameRes);
		} catch (IOException e) {
						
			e.printStackTrace();
		}
	
		return null;
	}
	
	public String  checkEmail(){
		String emailRes = com.forum.tools.CheckUser.checkEmail(this.userEmail);
		try {
			this.httpResponse.getWriter().write(emailRes);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	
	
}
