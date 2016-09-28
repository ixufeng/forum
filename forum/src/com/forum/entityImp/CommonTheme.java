package com.forum.entityImp;

import java.util.HashSet;
import java.util.Set;

import com.forum.entity.Theme;

public class CommonTheme  implements Theme{

	private int themeId;
	private String name;
	private long cTime;  //创建的时间戳
	private String introduce;
	private String avatar_sm;
	private String avatar_lg;
	private Set<CommonNode> nodes = new HashSet<CommonNode>();


	
	public CommonTheme() {
		
	}


	public CommonTheme(String name, String introduce) {
		super();
		this.name = name;
		this.introduce = introduce;
	}



	public int getThemeId() {
		return themeId;
	}

	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getcTime() {
		return cTime;
	}

	public void setcTime(long cTime) {
		this.cTime = cTime;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getAvatar_sm() {
		return avatar_sm;
	}

	public void setAvatar_sm(String avatar_sm) {
		this.avatar_sm = avatar_sm;
	}

	public String getAvatar_lg() {
		return avatar_lg;
	}

	public void setAvatar_lg(String avatar_lg) {
		this.avatar_lg = avatar_lg;
	}

	public Set<CommonNode> getNodes() {
		return nodes;
	}

	public void setNodes(Set<CommonNode> nodes) {
		this.nodes = nodes;
	}

}
