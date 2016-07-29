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
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private String choice5;
	private String answer;
	private String analysis;
	private int type;// 题目类型 0--单项选择题，1--多项选择题，2---判断题，3---程序填空，4---读程序，写运行结果

	public Question() {
		super();
		// TODO Auto-generated constructor stub
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

    

	public String getChoice1() {
		return choice1;
	}



	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}



	public String getChoice2() {
		return choice2;
	}



	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}



	public String getChoice3() {
		return choice3;
	}



	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}



	public String getChoice4() {
		return choice4;
	}



	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}



	public String getChoice5() {
		return choice5;
	}



	public void setChoice5(String choice5) {
		this.choice5 = choice5;
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
