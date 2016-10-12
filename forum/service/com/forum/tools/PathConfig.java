package com.forum.tools;

public class PathConfig {

	
		
		public static PathConfig PathConfig = new PathConfig();
		
		public static PathConfig getPathConfig(){
			
			return PathConfig;
		}
		private PathConfig(){
			
		}
		
		public  String  getWebRootPath(){
			
			
			String path = getClass().getResource("/").getPath();
			
			path = path.substring(0, path.length()-16);
			
			return path;	
		}
		
		// 上传头像的存储路径
		public final static String UPLOAD_AVATAR = PathConfig.getWebRootPath() + "img/avatar";

		
		
	
}
