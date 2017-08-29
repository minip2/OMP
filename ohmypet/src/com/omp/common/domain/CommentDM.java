package com.omp.common.domain;

import java.util.Date;

public class CommentDM {
	private Date regDate;
	private String content;
	private String id;
	private int no;
	private int groupVal;
	private String nickname;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getGroupVal() {
		return groupVal;
	}
	public void setGroupVal(int groupVal) {
		this.groupVal = groupVal;
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
