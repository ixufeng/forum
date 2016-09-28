package com.forum.entityImp;
/**
 * 标签库
 * @author xufeng
 *
 */
public class CommonMark {

	private int markId;    //标签名称
	private String markName; //标签名称
	private String color;   //标签颜色
	private long cTime; // 标签创建时间
	

	
	public int getMarkId() {
		return markId;
	}
	public void setMarkId(int markId) {
		this.markId = markId;
	}
	public String getMarkName() {
		return markName;
	}
	public void setMarkName(String markName) {
		this.markName = markName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public long getcTime() {
		return cTime;
	}
	public void setcTime(long cTime) {
		this.cTime = cTime;
	}
	
	
	
}
