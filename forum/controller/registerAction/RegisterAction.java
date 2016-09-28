package registerAction;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.junit.Test;

import com.forum.entityImp.CommonUser;
import com.forum.globle.BaseAction;
import com.forum.register.Register;
import com.forum.registerImp.CommonRegister;
import com.forum.tools.MailHelper;
import com.forum.tools.URL;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends BaseAction implements ModelDriven<CommonUser>{

	private static final long serialVersionUID = 1L;
	
	private Register reg ; //注册服务对象
	
	private CommonUser commonUser = new CommonUser(); //注册用户对象

	@Test
	public String doRegister(){
		
		
		//验证码校验
		if(!this.httpSession.getAttribute("securityCode").equals(commonUser.getCode())){
			return "code_error";
		}
				
		
		this.reg = new CommonRegister();
		
		if(this.reg.register(this.commonUser)){
			
			//发送邮件
			new MailHelper().sendMialToUser(commonUser, "请点击点次链接来激活您的账号"+URL.url_active);
	 
			return "register_ok";
		}
			
		return "register_error";
		 
	}

	//一键注册
	public String doRegisterAuto(){
		
		return "cuccess";
	}

	/**
	 * 表单验证
	 */
	@Override
	public void validate() {
		
	}

	@SkipValidation
	@Override
	public CommonUser getModel() {
		
		return commonUser;
	}
	

}
