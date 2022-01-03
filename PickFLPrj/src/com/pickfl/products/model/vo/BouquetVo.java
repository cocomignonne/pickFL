package com.pickfl.products.model.vo;

public class BouquetVo {
	private int boutquetNo;
	private int memberNo;
	private String bouquetName;
	private String wrapColor;
	private int bouquetPrice;
	
	public BouquetVo(int memberNo, String bouquetName, String wrapColor, int bouquetPrice) {
		this.memberNo = memberNo;
		this.bouquetName = bouquetName;
		this.wrapColor = wrapColor;
		this.bouquetPrice = bouquetPrice;
	}
	public int getBoutquetNo() {
		return boutquetNo;
	}
	public void setBoutquetNo(int boutquetNo) {
		this.boutquetNo = boutquetNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getBouquetName() {
		return bouquetName;
	}
	public void setBouquetName(String bouquetName) {
		this.bouquetName = bouquetName;
	}
	public String getWrapColor() {
		return wrapColor;
	}
	public void setWrapColor(String wrapColor) {
		this.wrapColor = wrapColor;
	}
	public int getBouquetPrice() {
		return bouquetPrice;
	}
	public void setBouquetPrice(int bouquetPrice) {
		this.bouquetPrice = bouquetPrice;
	}
	
	

}
