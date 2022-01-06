package com.pickfl.member.model.vo;

import java.sql.Timestamp;

public class MemberVo {
	private int memberNo;
	private int gradeNo;
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String birth;
	private Timestamp joinDate;
	private String quitYN;
	private String role;
	private int orderPriceSum;
	public int getOrderPriceSum() {
		return orderPriceSum;
	}

	public void setOrderPriceSum(int orderPriceSum) {
		this.orderPriceSum = orderPriceSum;
	}
	private int point;
	private String gradeString = "잘못된 회원 등급";
	
	public MemberVo() {
		
	}

	public MemberVo(int memberNo, String id, String pwd, String name, String email) {
		super();
		this.memberNo = memberNo;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}
	
	public void changeGradeNo() {
		if(this.gradeNo == 999) {
			this.gradeString = "관리자";
		}
		if(this.gradeNo == 200) {
			this.gradeString = "VIP";
		}
		if(this.gradeNo == 100) {
			this.gradeString = "일반회원";
		}
	}
	
	public String getGradeString() {
		return gradeString;
	}

	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getGradeNo() {
		return gradeNo;
	}
	public void setGradeNo(int gradeNo) {
		this.gradeNo = gradeNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Timestamp getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}
	public String getQuitYN() {
		return quitYN;
	}
	public void setQuitYN(String quitYN) {
		this.quitYN = quitYN;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}
