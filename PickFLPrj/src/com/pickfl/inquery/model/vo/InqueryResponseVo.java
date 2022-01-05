package com.pickfl.inquery.model.vo;

import java.sql.Timestamp;

public class InqueryResponseVo {
	int rNum;
	int qNum;
	int mNum;
	String adminId;
	String rContent;
	Timestamp rCreate;
	String rDelete;
	
	public InqueryResponseVo(int qNum, String rContent, String adminId, int memberNo) {
		this.qNum = qNum;
		this.rNum = qNum;
		this.rContent = rContent;
		this.adminId = adminId;
		this.mNum = memberNo;
	}

	

	public int getmNum() {
		return mNum;
	}

	public String getAdmin_id() {
		return adminId;
	}

	public Timestamp getrCreate() {
		return rCreate;
	}

	public void setrCreate(Timestamp rCreate) {
		this.rCreate = rCreate;
	}

	public String getrDelete() {
		return rDelete;
	}

	public void setrDelete(String rDelete) {
		this.rDelete = rDelete;
	}

	public int getrNum() {
		return rNum;
	}

	public int getqNum() {
		return qNum;
	}

	public String getrContent() {
		return rContent;
	}
}
