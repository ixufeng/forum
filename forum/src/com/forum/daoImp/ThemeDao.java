package com.forum.daoImp;

import java.util.ArrayList;
import java.util.List;

import com.forum.entityImp.CommonTheme;

public class ThemeDao {
	
	
	private CommonQuery query = new CommonQuery();
	
	
	public ArrayList<CommonTheme> getAllTheme(){
		ArrayList<CommonTheme> list = new ArrayList<CommonTheme>();
		String hql = "from CommonTheme";
		List<Object> temp = query.selectForList(hql, null);
		
		if(temp!=null){
			for(Object th:temp){
				
				list.add((CommonTheme) th);
			}
		}
		return list;
	}
	
	/**
	 * 根据id来唯一获取主题
	 * @param id
	 * @return
	 */
	public CommonTheme getThemeById(int id){
		CommonTheme theme = new CommonTheme();
		String hql = "from CommonTheme where themeId = ?";
		Object[] params = new Object[]{id};
		Object obj = query.getObj(hql, params);
		if(obj!=null){
			
			theme = (CommonTheme) obj;
		}
		return theme;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public CommonTheme getThemeByName(String name){
		CommonTheme theme = new CommonTheme();
		String hql = "from CommonTheme where name = ?";
		Object[] params = new Object[]{name};
		Object obj = query.getObj(hql, params);
		if(obj!=null){
			
			theme = (CommonTheme) obj;
		}
		return theme;
	}

}
