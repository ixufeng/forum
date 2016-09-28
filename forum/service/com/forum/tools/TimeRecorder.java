package com.forum.tools;


import java.text.DecimalFormat;

import org.junit.Test;

public class TimeRecorder {

	
	private String name; //记录对象的名称
	private long time;   //记录时间的长度
	private String[] timeUnit = {"us","ms","s"};
	
	
	public TimeRecorder(){
		
	}
	
	public TimeRecorder(String name){
		this.name = name;		
	}
	
	public void setName(String name){
		this.name = name;
		
	}
	public String getName(){
		
		return this.name;
	}
	
	public long getTime(){
		
		return this.time;
	}
	public void setTime(long time){
		
		this.time = time;
	}
	/**
	 * 将获得的时间进行单位转换
	 * @return
	 */
	@Test
	public String getVisualTime(){
		String res = "";		
		double tempTime = this.time;
		long tt = this.time;
		int index = 0;		
		while(tt/1000>0){
			
			tempTime = tempTime/1000;
			tt = tt/1000;
			index++;
			if(index>=2){
				break;
			}
		}
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		res = df.format(tempTime) + timeUnit[index];

		return res;
	}
}
