package com.forum.nodeService;

import java.util.ArrayList;

import com.forum.daoImp.ThemeDao;
import com.forum.entityImp.CommonTheme;

/**
 * 
 * @author xufeng
 *
 */
public class ThemeService {

	private ThemeDao dao = new ThemeDao();
	
	public ArrayList<CommonTheme> getAllTheme(){
		
		return dao.getAllTheme();
	
	}
	
	public CommonTheme getThemeById(int id){
		
		return dao.getThemeById(id);
	}
}
