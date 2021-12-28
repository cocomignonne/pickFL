package com.pickfl.inquery.model.vo;

import java.sql.Timestamp;

public class InqueryVo {
	
	private int qNum;
	private Timestamp createDate;
	private String qTitle;
	private String qContent;
	private char qDeleted;
	private char qResponse;
	
	public int getqNum() {
		return qNum;
	}
	public void setqNum(int qNum) {
		this.qNum = qNum;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	public String getqContent() {
		return qContent;
	}
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	public char getqDeleted() {
		return qDeleted;
	}
	public void setqDeleted(char qDeleted) {
		this.qDeleted = qDeleted;
	}
	public char getqResponse() {
		return qResponse;
	}
	public void setqResponse(char qResponse) {
		this.qResponse = qResponse;
	}
	
}
