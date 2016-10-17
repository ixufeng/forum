package com.forum.interceptor;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 拦截编码。统一"utf-8"
 * @author xufeng
 *
 */
public class CodeInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	/**
	 * 拦截体
	 */
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		ActionContext actionContext = arg0.getInvocationContext();
		
		HttpServletRequest request = (HttpServletRequest)actionContext.get(StrutsStatics.HTTP_REQUEST);
		System.out.println("beginEncoding...");

		
		//解决get乱码
		if(isAjax(request)){
			System.out.println("拦截ajax请求");
		}
		if(request.getMethod().compareToIgnoreCase("post")>0){
			
			request.setCharacterEncoding("utf-8");
		}else{
			//GET方法
			Iterator<?> iter = request.getParameterMap().values().iterator();
			while(iter.hasNext()){
				String[] parames = (String[])iter.next();
				for(int i=0;i<parames.length;i++){
					try{
						parames[i] = new String(parames[i].getBytes("iso8859-1"),"utf-8");
					}catch(Exception e){
						System.out.println("编码有误");
					}
				}
			}
		}
		
		return arg0.invoke();
	}
	
	private boolean isAjax(HttpServletRequest request){
		if(request.getHeader("X-Requested-width")!=null&&request.getHeader("X-Requested-width").equalsIgnoreCase("XMLHttpRequest")){
			return true;
		}
		return false;
	}

}
