package com.forum.topicService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import com.forum.daoImp.UserSessionQuery;

/**
 * 文件上传1
 * @author xufeng
 *
 */
public class Upload {

	private int userId;
	
	private UserSessionQuery query = null;
	public Upload(int userId){
		
		this.userId = userId;
	}
	/**
	 * 上传单张图片
	 * @return
	 */
	public boolean uploadImage(File uploadFile ,String uploadFileFileName,String uploadFileContentType ,String realPath){
		
		uploadFileFileName = UUID.randomUUID().toString() + uploadFileFileName.substring(uploadFileFileName.lastIndexOf('.'));
		saveImgToData(uploadFileFileName);
		//控制图片类型
		if(uploadFileContentType.equals("image/gif") || uploadFileContentType.equals("image/jpeg") ||   
	                uploadFileContentType.equals("image/png") || uploadFileContentType.equals("image/bmp") ||   
	                uploadFileContentType.equals("image/x-icon") || uploadFileContentType.equals("image/pjpeg")) {	
            //判断文件是否为空,并且文件不能大于2M  
            if(uploadFile != null && uploadFile.length() < 2097152){    
                //根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。  
                File filePath = new File(new File(realPath), uploadFileFileName);    
                //判断路径是否存在    
                if(!filePath.getParentFile().exists())  
                {  
                    //如果不存在，则递归创建此路径   
                    filePath.getParentFile().mkdirs();  
                }  
                          
                //将文件保存到硬盘上,Struts2会帮我们自动删除临时文件  
                try {  
                    FileUtils.copyFile(uploadFile, filePath); 
                    return true;
                } catch (IOException e) {  
                 
                    return false;
                }   
            }
		}		
		return false;
	}
	
	/**
	 * 将图片信息保存到数据库
	 */
	private boolean saveImgToData(String fileName){
		
		if(this.query==null){
			
			this.query = new UserSessionQuery();			
		}
		
		this.query.updateUserAvatar(fileName, userId);
		return false;
	}
	
	/**
	 * 上传多张图片
	 */
	public void uploadImages(){
		
	}
}
