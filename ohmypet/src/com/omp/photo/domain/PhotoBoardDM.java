package com.omp.photo.domain;

import java.util.Date;

public class PhotoBoardDM {
	private int no;
	private String id;
	private String title;
	private String content;
	private String file_path;
	private String file_sys_name;
	private String file_org_name;
	private int category_val;
	private int view_cnt;
	private int password;
	private int recommend_cnt;
	private Date reg_date;
	
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	
	public String getFile_sys_name() {
		return file_sys_name;
	}
	public void setFile_sys_name(String file_sys_name) {
		this.file_sys_name = file_sys_name;
	}
	public String getFile_org_name() {
		return file_org_name;
	}
	public void setFile_org_name(String file_org_name) {
		this.file_org_name = file_org_name;
	}
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public int getCategory_val() {
		return category_val;
	}
	public void setCategory_val(int category_val) {
		this.category_val = category_val;
	}

	public int getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	public int getRecommend_cnt() {
		return recommend_cnt;
	}
	public void setRecommend_cnt(int recommend_cnt) {
		this.recommend_cnt = recommend_cnt;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	
}
