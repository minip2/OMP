package com.omp.dictionary.domain;

import java.util.Date;

public class DictionaryDM {
	private int dogVal;
	private int version;
	private String id;
	private Date modDate;
	private String detail;
	private String nick_name;
	

	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public int getDogVal() {
		return dogVal;
	}
	public void setDogVal(int dogVal) {
		this.dogVal = dogVal;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date mod_date) {
		this.modDate = mod_date;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

}
