package com.javaassistant.model;

import java.io.Serializable;

/**
 * 题目信息
 * 
 * @author Administrator
 * 
 */
public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String content;
	private String choice;
	private String answer;
	private String analysis;
	private int type;// 题目类型 0--单项选择题，1--多项选择题，2---判断题，3---程序填空，4---读程序，写运行结果

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int id, String content, String choice, String answer,
			String analysis, int type) {
		super();
		this.id = id;
		this.content = content;
		this.choice = choice;
		this.answer = answer;
		this.analysis = analysis;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
