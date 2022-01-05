package com.pickfl.order.model.vo;

import java.sql.Timestamp;
import java.util.List;

public class OrderVo {

  	private int orderNo;
    private int memberNo;
    private int bouquetNo;
    private String bouquetName;
    private int bouquetPrice;
    private int buyNumBQ;
    private String wrapColor;
	private String bouquetDetail;
    private int totalPNum;
	private int bouquetTotalPrice;
    private int orderPrice;
    private int usedPoint;
    private String deliveryState;
	private Timestamp orderDate;
	private List<OrderVo> orderVoList;
	private String gotName;
	private String gotPhone;
	private String address1;
	private String address2;
	private String address3;
	
	

	
	
	
	public String getWrapColor() {
		return wrapColor;
	}
	public void setWrapColor(String wrapColor) {
		this.wrapColor = wrapColor;
	}
	public String getGotName() {
		return gotName;
	}
	public void setGotName(String gotName) {
		this.gotName = gotName;
	}
	public String getGotPhone() {
		return gotPhone;
	}
	public void setGotPhone(String gotPhone) {
		this.gotPhone = gotPhone;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getBouquetDetail() {
		return bouquetDetail;
	}
	public void setBouquetDetail(String bouquetDetail) {
		this.bouquetDetail = bouquetDetail;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
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
	public String getBouquetName() {
		return bouquetName;
	}
	public void setBouquetName(String bouquetName) {
		this.bouquetName = bouquetName;
	}
	public int getBouquetPrice() {
		return bouquetPrice;
	}
	public void setBouquetPrice(int bouquetPrice) {
		this.bouquetPrice = bouquetPrice;
	}
	public int getBuyNumBQ() {
		return buyNumBQ;
	}
	public void setBuyNumBQ(int buyNumBQ) {
		this.buyNumBQ = buyNumBQ;
	}
	public int getTotalPNum() {
		return totalPNum;
	}
	public void setTotalPNum(int totalPNum) {
		this.totalPNum = totalPNum;
	}
	public int getBouquetTotalPrice() {
		return bouquetTotalPrice;
	}
	public void setBouquetTotalPrice(int bouquetTotalPrice) {
		this.bouquetTotalPrice = bouquetTotalPrice;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getUsedPoint() {
		return usedPoint;
	}
	public void setUsedPoint(int usedPoint) {
		this.usedPoint = usedPoint;
	}
	public String getDeliveryState() {
		return deliveryState;
	}
	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public List<OrderVo> getOrderVoList() {
		return orderVoList;
	}
	public void setOrderVoList(List<OrderVo> orderVoList) {
		this.orderVoList = orderVoList;
	}
    
	
}
