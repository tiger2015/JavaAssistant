package com.javaassistant.model;

import java.io.Serializable;

public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String password;
	private String sex;
	private String email;
	private String imageUrl;// 图像
	private int isOnline=0;// 用户是否在线，0--离线,1--在线

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo(int id, String name, String password, String sex,
			String email, String imageUrl, int isOnline) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.imageUrl = imageUrl;
		this.isOnline = isOnline;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(int isOnline) {
		this.isOnline = isOnline;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
