package com.omp.css.domain;

import java.util.Date;

public class AnswerDM {
	private int no;
	private String id; 
	private String title;
	private String answer_content;
	private Date answer_date;
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
	public String getAnswer_content() {
		return answer_content;
	}
	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}
	public Date getAnswer_date() {
		return answer_date;
	}
	public void setAnswer_date(Date answer_date) {
		this.answer_date = answer_date;
	}
	public String getCategory_val() {
		return category_val;
	}
	public void setCategory_val(String category_val) {
		this.category_val = category_val;
	}
}
