package registerAction;

import com.forum.entity.User;
import com.forum.globle.BaseAction;
import com.forum.registerImp.UserActiveService;

/**
 * 已经注册的用户通过邮箱激活
 * @author xufeng
 *
 */
public class UserActive extends BaseAction {

	private static final long serialVersionUID = 1L;
	//激活用户的用户名
	private String userName;
	//用户的凭证码
	private String certificateCode;
	
	public String  excute(){
		//先获取此用户
		User u = (User) this.httpSession.getAttribute("userName");
		if(u!=null){
			UserActiveService ac = new UserActiveService();
			
			if(ac.active(u, this.certificateCode)){
				return SUCCESS;
			}
			return ERROR;			
		}else{
			return ERROR; 
		}
	}

	
	
	public String getCertificateCode() {
		return certificateCode;
	}

	public void setCertificateCode(String certificateCode) {
		this.certificateCode = certificateCode;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
