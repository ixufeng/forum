package com.forum.globle;
import java.io.ByteArrayInputStream;
import com.forum.tools.SecurityCode;
import com.forum.tools.SecurityImage;

 
public class SecurityCodeImageAction  extends BaseAction{
	
	private static final long serialVersionUID = 1496691731440581303L;
	//图片流
    private ByteArrayInputStream imageStream;
    
    
    
    
    @Override
    public String execute() throws Exception {
        
        //String securityCode = SecurityCode.getSecurityCode(4,SecurityCodeLevel.Hard, false).toLowerCase();
        
        //获取默认难度和长度的验证码
        String securityCode = SecurityCode.getSecurityCode();
        imageStream = SecurityImage.getImageAsInputStream(securityCode);
        //放入session中
      
        this.httpSession.setAttribute("securityCode",securityCode);
        return SUCCESS;
    }
    
    
    
    public ByteArrayInputStream getImageStream() {
        return imageStream;
    }
    public void setImageStream(ByteArrayInputStream imageStream) {
        this.imageStream = imageStream;
    }
   
}
