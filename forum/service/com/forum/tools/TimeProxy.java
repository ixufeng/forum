package com.forum.tools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 时间代理类
 * @author Administrator
 *
 */
public class TimeProxy implements InvocationHandler {

	private Object obj;//代理对象

	private  TimeRecorder time;
	/**
	 * 绑定代理对象
	 * @return
	 */
	public Object bind(Object obj,TimeRecorder time){
		
		this.obj = obj;
		this.time = time;//协助对象
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
				obj.getClass().getInterfaces(), this);
	}
	
	//重写实现代理的方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
		//定义代理对象执行方法的返回结果
		Object result = null;
		
		
		try{
			long timeBegin = System.nanoTime();//获取开始时间
			result = method.invoke(obj, args);  //方法的反射执行
			long timeEnd = System.nanoTime();
			this.time.setTime((timeEnd-timeBegin)/1000);
			
			System.out.println("程序执行时间是" + (timeEnd - timeBegin) + "ns");
		}catch(Exception e){
			
			System.out.println("程序执行有异常");
		}
		return result;
	}
	
}
