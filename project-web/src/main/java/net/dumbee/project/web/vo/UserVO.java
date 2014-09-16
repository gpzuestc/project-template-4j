package net.dumbee.project.web.vo;

import java.io.Serializable;

public class UserVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3130527227156348876L;
	private Long uid;
	private String username;
	
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
