package com.javaassistant.model;

import java.io.Serializable;

/**
 * 知识点
 * 
 * @author Administrator
 * 
 */
public class Knowledge implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String subject;
	private String content;
	private float importance;
	private int type=0;
	private String imageUrl;

	public Knowledge() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Knowledge(int id, String subject, String content, float importance,
			int type, String imageUrl) {
		super();
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.importance = importance;
		this.type = type;
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getImportance() {
		return importance;
	}

	public void setImportance(float importance) {
		this.importance = importance;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
