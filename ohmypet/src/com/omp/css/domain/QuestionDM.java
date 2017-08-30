package com.omp.css.domain;

import java.util.Date;

public class QuestionDM {
	private int no;
	private String id; 
	private String title;
	private int answer_check;
	private String question_content;
	private Date question_date;
	private String category_val;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAnswer_check() {
		return answer_check;
	}
	public void setAnswer_check(char answer_check) {
		this.answer_check = answer_check;
	}
	public String getQuestion_content() {
		return question_content;
	}
	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}
	public Date getQuestion_date() {
		return question_date;
	}
	public void setQuestion_date(Date question_date) {
		this.question_date = question_date;
	}
	public String getCategory_val() {
		return category_val;
	}
	public void setCategory_val(String category_val) {
		this.category_val = category_val;
	}
}
