package com.omp.store.domain;

import java.util.Date;

public class BuyerDM {
	private int no;
	private String productId;
	private int buysAmount;
	private int totalPrice;
	private String buyNo;
	private Date buyDate;
	private String name;
	private String id;
	private String phonNumber;
	private String email;
	private String address;
	
	
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int tatalPrice) {
		this.totalPrice = tatalPrice;
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
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getBuysAmount() {
		return buysAmount;
	}
	public void setBuysAmount(int buysAmount) {
		this.buysAmount = buysAmount;
	}
	public String getBuyNo() {
		return buyNo;
	}
	public void setBuyNo(String buyNo) {
		this.buyNo = buyNo;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonNumber() {
		return phonNumber;
	}
	public void setPhonNumber(String phonNumber) {
		this.phonNumber = phonNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAdress(String adress) {
		this.address = adress;
	}
}
