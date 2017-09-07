package com.omp.freeboard.domain;

import java.util.Date;

public class FreeBoardDM {
	
	private int no;
	private int recommend;
	private int viewNum;
	private String title;
	private String id;
	private String content;
	private Date regDate;
	private String filePath;
	private String name;
	private int categoryVal;
	
	public int getCategoryVal() {
		return categoryVal;
	}
	public void setCategoryVal(int categoryVal) {
		this.categoryVal = categoryVal;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getComment_bool() {
		return comment_bool;
	}
	public void setComment_bool(String comment_bool) {
		this.comment_bool = comment_bool;
	}
	public String getPublic_bool() {
		return public_bool;
	}
	public void setPublic_bool(String public_bool) {
		this.public_bool = public_bool;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	private String pw;
	private String comment_bool;
	private String public_bool;
	private String tag;
	
	
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public int getViewNum() {
		return viewNum;
	}
	public void setViewNum(int viewNum) {
		this.viewNum = viewNum;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategoryName() {
		return categoryVal;
	}
	public void setCategoryName(int categoryVal) {
		this.categoryVal = categoryVal;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return id;
	}
	public void setWriter(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
		
	}
	
