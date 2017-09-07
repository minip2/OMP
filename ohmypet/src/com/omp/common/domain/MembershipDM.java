package com.omp.common.domain;

import java.util.Date;

public class MembershipDM {
	private String id;
	private	String password;
	private String email;
	private String phon_number;
	private int gender;
	private int member_level;
	private Date sign_date;
	private int store_check;
	private String address;
	private String nick_name;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhon_number() {
		return phon_number;
	}
	public void setPhon_number(String phon_number) {
		this.phon_number = phon_number;
	}
	public int getMember_level() {
		return member_level;
	}
	public void setMember_level(int member_level) {
		this.member_level = member_level;
	}
	public Date getSign_date() {
		return sign_date;
	}
	public void setSign_date(Date sign_date) {
		this.sign_date = sign_date;
	}
	public int getStore_check() {
		return store_check;
	}
	public void setStore_check(int store_check) {
		this.store_check = store_check;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	
	
	

}
