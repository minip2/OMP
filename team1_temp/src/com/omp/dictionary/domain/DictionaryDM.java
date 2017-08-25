package com.omp.dictionary.domain;

import java.util.Date;

public class DictionaryDM {
	private int dogVal;
	private String version;
	private String id;
	private Date modDate;
	private String detail;
	
	public int getDogVal() {
		return dogVal;
	}
	public void setDogVal(int dogVal) {
		this.dogVal = dogVal;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
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
	public void setDetail(String content) {
		this.detail = detail;
	}
}
