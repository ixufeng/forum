package com.forum.upload;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.forum.entityImp.CommonUser;
import com.forum.globle.BaseAction;
import com.forum.topicService.Upload;


/**
 * 图片上传控制器
 * @author xufeng
 *
 */
public class ImageUpload extends BaseAction{

	private static final long serialVersionUID = 1L;

	private String id;   //每个文件的id
	private String name ;
	private String type ;
	private String fileContentType;
	private String fileFileName;
	private File file;
	private String lastModifiedDate;	
	private String size;
	
	
	public String avatar(){
		
		//检测用户的登陆信息是否过期
		if(this.httpSession.getAttribute("user")!=null){
		
			 CommonUser user = (CommonUser) (httpSession.getAttribute("user"));
			 
			 Upload upload = new Upload(user.getUserId());
			 
			 String realPath = ServletActionContext.getServletContext().getRealPath("/img/avatar");
			
			//保存到磁盘
			upload.uploadImage(file, fileFileName, fileContentType, realPath);
		
			//保存到数据库
			upload.saveImgToData(upload.getFileUniqueName());
		}

		return null;
	}

	/**
	 * 用户发帖的上传
	 * @return
	 */
	public String topic(){
		
		Object obj = this.httpSession.getAttribute("user");
		if(obj!=null){

				
			 CommonUser user = (CommonUser)obj;
			 
			 Upload upload = new Upload(user.getUserId());
			 
			 String realPath = ServletActionContext.getServletContext().getRealPath("/img/topic");
			
			 //保存到磁盘
			 upload.uploadImage(file, fileFileName, fileContentType, realPath);
			//将图片名称存储到session中，等待话题的上传
			 Object str = this.httpSession.getAttribute("topicImage");
			 
			if(str!=null){
				this.httpSession.setAttribute("topicImage", (String)str + "," + upload.getFileUniqueName());
			}else{
				this.httpSession.setAttribute("topicImage", upload.getFileUniqueName());
			}
			
					
		}

		return null;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}




	public String getFileFileName() {
		return fileFileName;
	}


	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}


	public String getFileContentType() {
		return fileContentType;
	}


	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}


	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	


	public String getLastModifiedDate() {
		return lastModifiedDate;
	}


	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


}
