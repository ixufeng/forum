package com.forum.entityImp;
/**
 * 用户信息类 ，是一些用户可以选择性填写的的信息
 * @author xufeng
 *
 */
public class UserInformation {
	
	private int userId;       //外键
	private char userSex;     //用户性别
	private String userWeb;  //用户自己的网站
	private String userQQ;  //用户的QQ
	private String userMSN; //用户的msn
	private String userIntroduce; //用户的自我介绍
	private String userAddress;   //用户的家乡
	private String userCom;      //用户公司
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public char getUserSex() {
		return userSex;
	}
	public void setUserSex(char userSex) {
		this.userSex = userSex;
	}
	public String getUserWeb() {
		return userWeb;
	}
	public void setUserWeb(String userWeb) {
		this.userWeb = userWeb;
	}
	public String getUserQQ() {
		return userQQ;
	}
	public void setUserQQ(String userQQ) {
		this.userQQ = userQQ;
	}
	public String getUserMSN() {
		return userMSN;
	}
	public void setUserMSN(String userMSN) {
		this.userMSN = userMSN;
	}
	public String getUserIntroduce() {
		return userIntroduce;
	}
	public void setUserIntroduce(String userIntroduce) {
		this.userIntroduce = userIntroduce;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserCom() {
		return userCom;
	}
	public void setUserCom(String userCom) {
		this.userCom = userCom;
	}
	
	
	
}
