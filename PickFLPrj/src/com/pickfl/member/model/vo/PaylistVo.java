package com.pickfl.member.model.vo;

import java.sql.Timestamp;

public class PaylistVo {
	int orderNo;
	String delivery;
	int price;
	int memberNo;
	int bouquetNo;
	int bqNum;
	int totalPrice;
	Timestamp orderDate;
	int orderDetailNo;
	String address;
	String getPhone;
	String getName;
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getBouquetNo() {
		return bouquetNo;
	}
	public void setBouquetNo(int bouquetNo) {
		this.bouquetNo = bouquetNo;
	}
	public int getBqNum() {
		return bqNum;
	}
	public void setBqNum(int bqNum) {
		this.bqNum = bqNum;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderDetailNo() {
		return orderDetailNo;
	}
	public void setOrderDetailNo(int orderDetailNo) {
		this.orderDetailNo = orderDetailNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGetPhone() {
		return getPhone;
	}
	public void setGetPhone(String getPhone) {
		this.getPhone = getPhone;
	}
	public String getGetName() {
		return getName;
	}
	public void setGetName(String getName) {
		this.getName = getName;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
