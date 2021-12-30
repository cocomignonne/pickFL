package com.pickfl.inquery.model.vo;

import java.sql.Timestamp;

public class InqueryVo {
	
	private int qNum;
	private Timestamp createDate;
	private String user;
	private String qTitle;
	private String qContent;
	private String qDeleted;
	private String qResponse;
	
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
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
	public String getqDeleted() {
		return qDeleted;
	}
	public void setqDeleted(String qDeleted) {
		this.qDeleted = qDeleted;
	}
	public String getqResponse() {
		return qResponse;
	}
	public void setqResponse(String qResponse) {
		this.qResponse = qResponse;
	}
	
	
}
