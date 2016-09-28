package com.forum.globle;


import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import com.opensymphony.xwork2.ActionSupport;
public class BaseAction extends ActionSupport implements ServletResponseAware, ServletRequestAware ,ServletContextAware  {


	protected HttpServletRequest httpRequest;
	protected ServletContext context;
	protected HttpSession httpSession;
	protected HttpServletResponse httpResponse;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		
		this.httpRequest = request;
		try {
			this.httpRequest.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.httpSession = this.httpRequest.getSession();
		
		
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		
		this.httpResponse = response;
		this.httpResponse.setCharacterEncoding("utf-8");
	}
	
	
}
