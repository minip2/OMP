package com.omp.common.domain;

import java.util.Date;

public class CommentDM {
	private Date regDate;
	private String content;
	private String id;
	private int no;
	private int categoryGroup;
	
	public int getCategoryGroup() {
		return categoryGroup;
	}
	public void setCategoryGroup(int categoryGroup) {
		this.categoryGroup = categoryGroup;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
}
