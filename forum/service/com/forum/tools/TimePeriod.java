package com.forum.tools;

import org.junit.Test;

/**
 * 时间段类
 * @author xufeng
 *
 */
public class TimePeriod {
	
	
	private static final String[] timePeriods = {"分钟前","小时前","天前"};

	public static String getTimePeriod(long timeStamp){
		
		
		//获取时间段
		long timePeriod = TimeStamp.getCTimeStamp() - timeStamp ;
		
		if(timePeriod<3600){
			//一个小时之内
			return String.valueOf(Math.round(timePeriod/60.0)) + timePeriods[0];
		}
		
		if(timePeriod<3600*24){
			//一天之内
			return String.valueOf(Math.round(timePeriod/3600.0))+ timePeriods[1];
		}
		if(timePeriod<3600*24*30){
			//少于一个月的
			return String.valueOf(Math.round(timePeriod/(3600*24)))  + timePeriods[2];
		}
		if(timePeriod>3600*24*30){
			//大于一个月则返回具体时间
			return TimeStamp.timeStampDate(timeStamp, "yyyy-MM-dd");
		}
				
		return null;
	}
	
	@Test
	public void test(){
		System.out.println(getTimePeriod(1469934937));
	}

}
