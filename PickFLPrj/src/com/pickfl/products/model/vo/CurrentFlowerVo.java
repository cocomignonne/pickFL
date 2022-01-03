package com.pickfl.products.model.vo;

public class CurrentFlowerVo {
	private int memberNo;
	private int productNo;
	private String productName;
	private int orderNum;
	private int productPrice;
	
	public CurrentFlowerVo(int memberNo, int productNo, String productName, int orderNum, int productPrice) {
		this.memberNo = memberNo;
		this.productNo = productNo;
		this.productName = productName;
		this.orderNum = orderNum;
		this.productPrice = productPrice;
	}
	
	public CurrentFlowerVo(int productNo, String productName, int orderNum, int productPrice) {
		this.productNo = productNo;
		this.productName = productName;
		this.orderNum = orderNum;
		this.productPrice = productPrice;
	}

	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	} 
	
	

}
